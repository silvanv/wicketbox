package ch.silvanv.wicketbox.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;

public class ModalDialogLink extends AjaxLink<Void> {
  private static final long serialVersionUID = 1L;

  public ModalDialogLink(String id, ModalDialog<?> dialog) {
    super(id);
    add(new OpenModalDialogBehavior(dialog));
  }

  @Override
  public void onClick(AjaxRequestTarget target) {
  }
}
