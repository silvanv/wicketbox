package ch.silvanv.wicketbox;

import org.apache.wicket.protocol.http.WebApplication;

import ch.silvanv.wicketbox.behaviour.BehaviourPage;
import ch.silvanv.wicketbox.facebookfeed.FacebookFeedPage;
import ch.silvanv.wicketbox.formpage.FormPage;
import ch.silvanv.wicketbox.modal.ModalPage;
import ch.silvanv.wicketbox.tabbedcontainer.TabbedPage;

/**
 * Wicketbox sample application.
 */
public class WicketboxApplication extends WebApplication {
  @Override
  public Class<HomePage> getHomePage() {
    return HomePage.class;
  }

  @Override
  public void init() {
    super.init();

    // mount points
    mountPage("TabbedPage", TabbedPage.class);
    mountPage("FormPage", FormPage.class);
    mountPage("FacebookFeedPage", FacebookFeedPage.class);
    mountPage("BehaviourPage", BehaviourPage.class);
    mountPage("ModalPage", ModalPage.class);

    // configuration
    getMarkupSettings().setStripWicketTags(true);
  }
}
