package ch.silvanv;

import ch.silvanv.behaviour.BehaviourPage;
import ch.silvanv.facebookfeed.FacebookFeedPage;
import ch.silvanv.formpage.FormPage;
import ch.silvanv.modal.ModalPage;
import ch.silvanv.tabbedcontainer.TabbedPage;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see ch.silvanv.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
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
    }
}
