package ch.silvanv.wicketbox.behaviour;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;

public class AlertBehaviour extends AjaxEventBehavior {
  public AlertBehaviour() {
    super("click");
  }

  public AlertBehaviour(String event) {
    super(event);
  }

  private static final long serialVersionUID = 1L;

  @Override
  protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
    super.updateAjaxAttributes(attributes);

    IAjaxCallListener listener = new AjaxCallListener() {

      private static final long serialVersionUID = 1L;

      @Override
      public CharSequence getBeforeHandler(Component c) {
        return "alert('click2 ajax callback')";
      }
    };
    attributes.getAjaxCallListeners().add(listener);
  }

  @Override
  protected void onEvent(AjaxRequestTarget target) {
  }
}
