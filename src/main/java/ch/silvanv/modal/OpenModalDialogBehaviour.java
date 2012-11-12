package ch.silvanv.modal;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;

public class OpenModalDialogBehaviour extends AjaxEventBehavior {

    private static final long serialVersionUID = 1L;

    private String dialogId;

    public OpenModalDialogBehaviour(String dialogId) {
        this(dialogId, "click");
    }

    public OpenModalDialogBehaviour(String dialogId, String event) {
        super(event);
        this.dialogId = dialogId;
    }

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
        super.updateAjaxAttributes(attributes);
        AjaxCallListener ajaxCallListener = new AjaxCallListener();
        ajaxCallListener.onBefore("$('#" + dialogId + "').modal('show')");
        attributes.getAjaxCallListeners().add(ajaxCallListener);
    }

    @Override
    protected void onEvent(AjaxRequestTarget target) {
    }
}
