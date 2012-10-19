package ch.silvanv.behaviour;

import ch.silvanv.common.BasePage;
import ch.silvanv.common.Feedback;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.ajax.markup.html.AjaxLink;

public class BehaviourPage extends BasePage {

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
                        return "alert('click ajax callback')";
                    }
                };
                attributes.getAjaxCallListeners().add(listener);
            }
        });

        AjaxLink<Void> link = new AjaxLink<Void>("link3") {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target) {
                feedback.info("click 3");
                target.add(feedback);
            }
        };
        link.add(new AlertBehaviour());
        add(link);
    }
}
