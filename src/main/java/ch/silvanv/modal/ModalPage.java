package ch.silvanv.modal;

import ch.silvanv.common.BasePage;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;

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

        ModalDialog<String> dialog2 = new ModalDialog<String>("modalDialog2", "modalDialogTitle") {

            private static final long serialVersionUID = 1L;

            @Override
            public Component content(String id) {
                return new Label("contentPanel", "Dialog Content 2");
            }

            @Override
            protected boolean onSubmit() {
                return false;
            }
        };

        add(dialog2);
        add(new ModalDialogLink("modalDialogLink2", dialog2));
    }
}
