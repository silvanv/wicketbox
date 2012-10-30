/**
 * Copyright (c) 2012 by Tamedia AG, Switzerland.
 *            All rights reserved.
 */
package ch.silvanv.modal;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * Modal dialog panel.
 * 
 * @param <T>
 *            type
 * @author silvan
 */
public abstract class ModalDialogPanel<T> extends GenericPanel<T> {

    private static final long serialVersionUID = 1L;

    /**
     * Create the modal panel.
     * 
     * @param id
     *            Id
     * @param labelKey
     *            An string resource key for the dialog label
     */
    public ModalDialogPanel(final String id, String labelKey) {
        this(id, null, labelKey);
    }

    /**
     * Create the modal dialog panel.
     * 
     * @param id
     *            Id
     * @param model
     *            The model
     * @param labelKey
     *            An string resource key for the dialog label
     */
    public ModalDialogPanel(final String id, IModel<T> model, String labelKey) {
        super(id, model);
        setRenderBodyOnly(true);
        
        MarkupContainer modalDialog = new MarkupContainer("modalDialog") {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onInitialize() {
                super.onInitialize();
                setMarkupId(id);
            }
        };

        // TODO introduce the onCancel method

        // TODO optionally make an ajax link with a corresponding onSubmit method
        modalDialog.add(new AbstractLink("modalSubmit") {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("data-submit", "submit-" + id);
            }
        });

        modalDialog.add(new Label("modalLabel", labelKey));
        modalDialog.add(content("contentPanel"));

        add(modalDialog);
    }

    /**
     * Content factory.
     * 
     * @param id
     *            The id for the new panel
     * @return The content
     */
    public abstract Component content(String id);
    
	@Override
	public void renderHead(IHeaderResponse response) 
	{
		response.render(new JavaScriptUrlReferenceHeaderItem("js/bootstrap.js", "bootstrap", false, "UTF-8", null));
	}
}
