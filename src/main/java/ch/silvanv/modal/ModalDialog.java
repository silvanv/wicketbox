/**
 * Copyright (c) 2012 by Tamedia AG, Switzerland.
 *            All rights reserved.
 */
package ch.silvanv.modal;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * Modal dialog panel.
 * 
 * @param <T>
 *            type
 * @author silvan
 */
public abstract class ModalDialog<T> extends GenericPanel<T> {

    private static final long serialVersionUID = 1L;

    /**
     * Create the modal panel.
     * 
     * @param id
     *            Id
     * @param labelKey
     *            An string resource key for the dialog label
     */
    public ModalDialog(final String id, String label) {
        this(id, null, label);
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
    public ModalDialog(final String id, IModel<T> model, String label) {
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

        // close event
        modalDialog.add(new AjaxEventBehavior("hidden") {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onEvent(AjaxRequestTarget target) {
                onClose();
            }
        });

        // submit event
        modalDialog.add(new AjaxLink<Void>("modalSubmit") {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target) {
                if (onSubmit()) {
                    target.appendJavaScript("$('#" + ModalDialog.this.getId() + "').modal('hide')");
                }
            }
        });

        modalDialog.add(new Label("modalLabel", label));
        modalDialog.add(content("contentPanel"));

        add(modalDialog);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(new JavaScriptUrlReferenceHeaderItem("js/bootstrap.js", "bootstrap", false, "UTF-8", null));
    }

    protected void onClose() {
    }

    protected boolean onSubmit() {
        return true;
    }

    /**
     * Content factory.
     * 
     * @param id
     *            The id for the new panel
     * @return The content
     */
    public abstract Component content(String id);
}
