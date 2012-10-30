package ch.silvanv.modal;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;

import ch.silvanv.common.BasePage;

public class ModalPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public ModalPage() {
    	
    	ModalDialogPanel<String> dialog1 = new ModalDialogPanel<String>("modalDialog1", "modalDialogTitle") {
            private static final long serialVersionUID = 1L;

            @Override
            public Component content(String id) {
                return new Label("contentPanel", "Dialog Content 1");
            }
        };
        
        // why must the link setup first?
        add(new ModalDialogLink("modalDialogLink1", dialog1));
        add(dialog1);
        
    	ModalDialogPanel<String> dialog2 = new ModalDialogPanel<String>("modalDialog2", "modalDialogTitle") {
            private static final long serialVersionUID = 1L;

            @Override
            public Component content(String id) {
                return new Label("contentPanel", "Dialog Content 2");
            }
        };
    	
        add(dialog2);
        add(new ModalDialogLink("modalDialogLink2", dialog2));
    }
}
