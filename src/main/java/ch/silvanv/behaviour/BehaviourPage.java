package ch.silvanv.behaviour;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

import ch.silvanv.common.Feedback;

public class BehaviourPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public BehaviourPage() {
    	
    	final Feedback feedback = new Feedback("feedback");
    	add(feedback);
    	
    	add(new AjaxLink<Void>("link") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				feedback.info("click 1");
				target.add(feedback);
			}
    	});

    	add(new AjaxLink<Void>("link2") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				feedback.info("click 2");
				target.add(feedback);
			}
			
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
    	});
    	
    	add(new AjaxLink<Void>("link3") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				feedback.info("click 3");
				target.add(feedback);
			}
    	}.add(new AlertBehaviour()));
    }
}
