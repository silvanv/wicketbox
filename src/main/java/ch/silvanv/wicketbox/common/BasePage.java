package ch.silvanv.wicketbox.common;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import ch.silvanv.wicketbox.behaviour.BehaviourPage;
import ch.silvanv.wicketbox.facebookfeed.FacebookFeedPage;
import ch.silvanv.wicketbox.formpage.FormPage;
import ch.silvanv.wicketbox.modal.ModalPage;
import ch.silvanv.wicketbox.tabbedcontainer.TabbedPage;

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
