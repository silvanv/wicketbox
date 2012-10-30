package ch.silvanv;

import ch.silvanv.behaviour.BehaviourPage;
import ch.silvanv.facebookfeed.FacebookFeedPage;
import ch.silvanv.formpage.FormPage;
import ch.silvanv.modal.ModalPage;
import ch.silvanv.tabbedcontainer.TabbedPage;

import org.apache.wicket.protocol.http.WebApplication;

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
