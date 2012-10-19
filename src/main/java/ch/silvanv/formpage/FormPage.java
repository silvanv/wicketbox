package ch.silvanv.formpage;

import ch.silvanv.Task;
import ch.silvanv.common.BasePage;
import ch.silvanv.common.Feedback;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class FormPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public FormPage() {
        add(new FormPanel("formPanel"));
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
            form.add(new Button("submit"));
            add(form);

            // //////////////////////////////////////////////////////7

            final IModel<Task> t2 = Model.of(new Task("the task name"));
            final Form<Task> form2 = new Form<Task>("form2", t2) {

                private static final long serialVersionUID = 1L;

                @Override
                public void onSubmit() {
                    feedback.info("Form data [form]: " + getModelObject());

                    // change model don't work because the fields have a reference to the first model
                    // setModel(Model.of(new Task("hhhhh")));

                    setModelObject(new Task("zzzz"));

                    // getModel().setObject(new Task("yyy"));

                    // t2.getObject().setName("xxxxxxxx");
                    // t2.getObject().setDesc("xxxxxxxx");
                }
            };
            form2.add(new TextField<String>("name2", new PropertyModel<String>(form2.getModel(), "name")));
            form2.add(new TextField<String>("desc2", new PropertyModel<String>(form2.getModel(), "desc")));
            form2.add(new Button("submit2"));
            add(form2);
        }
    }
}
