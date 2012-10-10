package ch.silvanv.behaviour;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;

public class AlertBehaviour extends AbstractDefaultAjaxBehavior {
	private static final long serialVersionUID = 1L;

	// TODO why it does not work
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
	protected void respond(AjaxRequestTarget target) {
	}
}
