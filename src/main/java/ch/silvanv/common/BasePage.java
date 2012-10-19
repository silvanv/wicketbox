package ch.silvanv.common;

import ch.silvanv.behaviour.BehaviourPage;
import ch.silvanv.facebookfeed.FacebookFeedPage;
import ch.silvanv.formpage.FormPage;
import ch.silvanv.modal.ModalPage;
import ch.silvanv.tabbedcontainer.TabbedPage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public abstract class BasePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public BasePage() {
        add(new BookmarkablePageLink<Void>("tabbedPageLink", TabbedPage.class));
        add(new BookmarkablePageLink<Void>("formPageLink", FormPage.class));
        add(new BookmarkablePageLink<Void>("facebookFeedPageLink", FacebookFeedPage.class));
        add(new BookmarkablePageLink<Void>("behaviourPageLink", BehaviourPage.class));
        add(new BookmarkablePageLink<Void>("modalPageLink", ModalPage.class));
    }
}
