package ch.silvanv.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;

public class ModalDialogLink extends AjaxLink<Void> {

    private static final long serialVersionUID = 1L;

    public ModalDialogLink(String id, ModalDialog<?> dialog) {
        super(id);
        add(new OpenModalDialogBehaviour(dialog.getId()));
    }

    @Override
    public void onClick(AjaxRequestTarget target) {
    }
}
