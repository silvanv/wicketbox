package ch.silvanv.wicketbox.modal;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;

/**
 * Behavior to open a modal dialog.
 * 
 * @author silvan
 */
public class OpenModalDialogBehavior extends AjaxEventBehavior {
	private static final long serialVersionUID = 1L;

	private ModalDialog<?> dialog;

	/**
	 * Create the open modal dialog behavior for a click event.
	 * 
	 * @param dialog
	 *          The modal dialog
	 */
	public OpenModalDialogBehavior(ModalDialog<?> dialog) {
		this(dialog, "click");
	}

	/**
	 * Create the open modal dialog behavior.
	 * 
	 * @param dialog
	 *          The modal dialog
	 * @param event
	 *          At which event the modal dialog opens
	 */
	public OpenModalDialogBehavior(ModalDialog<?> dialog, String event) {
		super(event);
		this.dialog = dialog;
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		final AjaxCallListener ajaxCallListener = new AjaxCallListener();
		ajaxCallListener.onBefore(dialog.modalShowCommand());
		attributes.getAjaxCallListeners().add(ajaxCallListener);
	}

	@Override
	protected void onEvent(AjaxRequestTarget target) {
	}
}
