package ch.silvanv.modal;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * Modal dialog panel.
 * 
 * @param <T>
 *          model type
 * @author silvan
 */
public abstract class ModalDialog<T> extends GenericPanel<T> {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the modal dialog panel.
	 * 
	 * @param id
	 *          Id
	 * @param model
	 *          The model
	 * @param label
	 *          An string model for the dialog label
	 */
	public ModalDialog(final String id, IModel<T> model, IModel<String> label) {
		super(id, model);
		// setRenderBodyOnly(true);
		setOutputMarkupId(true);

		MarkupContainer modalDialog = new MarkupContainer("modalDialog") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setMarkupId(id);
			}
		};
		modalDialog.add(new Label("modalLabel", label));

		final Form<T> form = new Form<T>("modalForm", model);
		modalDialog.add(form);

		// content
		form.add(content("contentPanel"));

		// submit button
		modalDialog.add(new AjaxSubmitLink("modalSubmit", form) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				ModalDialog.this.onError(target, (Form<T>) form);
				target.add(form);
			}

			@SuppressWarnings("unchecked")
			@Override
			protected void onAfterSubmit(AjaxRequestTarget target, Form<?> form) {
				if (ModalDialog.this.onSubmit(target, (Form<T>) form) && !form.hasError()) {
					target.appendJavaScript(modalHideCommand());

					// TODO always refresh the whole parent?
					// target.add(ModalDialog.this.getParent());
				} else {
					onError(target, form);
				}
			}
		});

		// close event
		modalDialog.add(new AjaxEventBehavior("hidden") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				onClose();
				target.add(ModalDialog.this);
			}
		});

		add(modalDialog);
	}

	/**
	 * Javascript to hide this modal dialog.
	 * 
	 * @return The script
	 */
	protected String modalHideCommand() {
		return "$('#" + ModalDialog.this.getId() + "').modal('hide')";
	}

	/**
	 * Javascript to show this modal dialog.
	 * 
	 * @return The script
	 */
	protected String modalShowCommand() {
		return "$('#" + ModalDialog.this.getId() + "').modal('show')";
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(new JavaScriptUrlReferenceHeaderItem("js/bootstrap.js", "bootstrap", false, "UTF-8", null));
	}

	/**
	 * Called when the modal dialog was closed. Can be overwritten if needed.
	 */
	protected void onClose() {
	}

	/**
	 * Called on an error. Can be overwritten if needed.
	 * 
	 * @param target
	 *          ajax target
	 * @param form
	 *          the modal dialog form
	 */
	protected void onError(AjaxRequestTarget target, Form<T> form) {
	}

	/**
	 * Called on successful submit. Can be overwritten if needed.
	 * 
	 * @param target
	 *          ajax target
	 * @param form
	 *          the modal dialog form
	 * @return True if the submit was successful
	 */
	protected boolean onSubmit(AjaxRequestTarget target, Form<T> form) {
		return true;
	}

	/**
	 * Content factory. Must be overwritten by the implementation.
	 * 
	 * @param id
	 *          The id for the new component
	 * @return The content
	 */
	public abstract Component content(String id);
}
