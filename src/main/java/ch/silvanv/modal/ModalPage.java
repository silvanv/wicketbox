package ch.silvanv.modal;

import ch.silvanv.Task;
import ch.silvanv.common.BasePage;
import ch.silvanv.common.Feedback;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public class ModalPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public ModalPage() {

        ModalDialog<String> dialog1 = new ModalDialog<String>("modalDialog1", "modalDialogTitle") {

            private static final long serialVersionUID = 1L;

            @Override
            public Component content(String id) {
                return new Label("contentPanel", "Dialog Content 1");
            }

            @Override
            protected boolean onSubmit() {
                return true;
            }
        };

        add(dialog1);
        add(new ModalDialogLink("modalDialogLink1", dialog1));

        // //////////////////

        ModalDialog<String> dialog2 = new ModalDialog<String>("modalDialog2", "modalDialogTitle") {

            private static final long serialVersionUID = 1L;

            @Override
            public Component content(String id) {
                return new FormPanel(id);
            }

            @Override
            protected boolean onSubmit() {
                // feedback.info("Form data [form]: " + getModelObject());
                // setModel(new CompoundPropertyModel<Task>(new Task("the task name1")));

                return true;
            }
        };

        add(dialog2);
        add(new ModalDialogLink("modalDialogLink2", dialog2));
    }

    private static class FormPanel extends Panel {

        private static final long serialVersionUID = 1L;

        public FormPanel(String id) {
            super(id);

            final Feedback feedback = new Feedback("feedback");
            add(feedback);

            final Form<Task> form = new Form<Task>("form", new CompoundPropertyModel<Task>(new Task("the task name"))) {

                private static final long serialVersionUID = 1L;

                @Override
                public void onSubmit() {
                    feedback.info("Form data [form]: " + getModelObject());
                    setModel(new CompoundPropertyModel<Task>(new Task("the task name1")));
                }

            };
            form.add(new TextField<String>("name"));
            form.add(new TextField<String>("desc"));
            // form.add(new Button("submit"));
            add(form);
        }
    }

}
