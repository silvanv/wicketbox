package ch.silvanv;

import ch.silvanv.behaviour.BehaviourPage;
import ch.silvanv.facebookfeed.FacebookFeedPage;
import ch.silvanv.formpage.FormPage;
import ch.silvanv.tabbedcontainer.TabbedPage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        add(new BookmarkablePageLink<Void>("tabbedPageLink", TabbedPage.class));
        add(new BookmarkablePageLink<Void>("formPageLink", FormPage.class));
        add(new BookmarkablePageLink<Void>("facebookFeedPageLink", FacebookFeedPage.class));
        add(new BookmarkablePageLink<Void>("behaviourPageLink", BehaviourPage.class));
    }
}
