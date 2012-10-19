package ch.silvanv.modal;

import ch.silvanv.common.BasePage;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;

public class ModalPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public ModalPage() {
        add(new ModalDialogPanel<String>("modalDialog1", "modalDialogTitle") {

            private static final long serialVersionUID = 1L;

            @Override
            public Component content(String id) {
                return new Label("contentPanel", "bla");
            }
        });
    }
}
