package ch.silvanv.modal;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import ch.silvanv.Task;
import ch.silvanv.common.BasePage;
import ch.silvanv.common.Feedback;

public class ModalPage extends BasePage {
	private static final long serialVersionUID = 1L;

	private final Feedback feedback;

	public ModalPage() {
		feedback = new Feedback("feedback", new ComponentFeedbackMessageFilter(this));
		add(feedback);

		final ModalDialog<String> dialog1 = new ModalDialog<String>("modalDialog1", Model.of("Dialog Content 1"), Model.of("modalDialogTitle")) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component content(String id) {
				return new Label("contentPanel", getModel());
			}
		};

		add(dialog1);
		add(new ModalDialogLink("modalDialogLink1", dialog1));

		// //////////////////

		final ModalDialog<Task> dialog2 = new ModalDialog<Task>("modalDialog2", new CompoundPropertyModel<Task>(new Task()), Model.of("modalDialogTitle")) {
			private static final long serialVersionUID = 1L;

			@Override
			public Component content(String id) {
				return new FormPanel(id, getModel());
			}

			// overwritten to refresh feedback
			@Override
			protected boolean onSubmit(AjaxRequestTarget target, Form<Task> form) {
				target.add(feedback);
				return super.onSubmit(target, form);
			}
		};

		add(dialog2);
		add(new ModalDialogLink("modalDialogLink2", dialog2));
	}

	private class FormPanel extends GenericPanel<Task> {
		private static final long serialVersionUID = 1L;

		public FormPanel(String id, IModel<Task> model) {
			super(id, model);

			final Form<Task> form = new Form<Task>("form", getModel()) {

				private static final long serialVersionUID = 1L;

				@Override
				public void onSubmit() {
					if ("aaa".equals(getModelObject().getDesc())) {
						error("aaa not allowed");
					} else {
						ModalPage.this.info("Form data [form]: " + getModelObject());
						setModelObject(new Task());
					}
				}

			};
			form.add(new TextField<String>("name").setRequired(true));
			form.add(new TextField<String>("desc").setRequired(true));
			add(form);

			final Feedback modalFeedback = new Feedback("modalFeedback", new ContainerFeedbackMessageFilter(form));
			form.add(modalFeedback);
		}
	}
}
