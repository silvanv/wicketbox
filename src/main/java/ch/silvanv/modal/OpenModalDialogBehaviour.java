package ch.silvanv.modal;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;

public class OpenModalDialogBehaviour extends AjaxEventBehavior {

	private String dialogId;
	
    public OpenModalDialogBehaviour(String dialogId) {
        this(dialogId, "click");
    }

    public OpenModalDialogBehaviour(String dialogId, String event) {
        super(event);
        this.dialogId = dialogId;
    }

    private static final long serialVersionUID = 1L;

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
        super.updateAjaxAttributes(attributes);

        IAjaxCallListener listener = new AjaxCallListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public CharSequence getBeforeHandler(Component c) {
                return "$('#" + dialogId + "').modal('show')";
            }
        };
        attributes.getAjaxCallListeners().add(listener);

        // AjaxCallListener ajaxCallListener = new AjaxCallListener();
        // ajaxCallListener.onBefore("alert('click2 ajax callback')");
        // attributes.getAjaxCallListeners().add(ajaxCallListener);
    }

    @Override
    protected void onEvent(AjaxRequestTarget target) {
    }
}
