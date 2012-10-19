package ch.silvanv.facebookfeed;

import ch.silvanv.common.BasePage;

import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.markup.html.pages.RedirectPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacebookFeedPage extends BasePage {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(FacebookFeedPage.class);

    public FacebookFeedPage(final PageParameters parameters) {

        // PostOnFacebookUrlModel model = new PostOnFacebookUrlModel();
        // model.setLink("http://www.piazza.ch/");
        // model.setPicture("http://www.piazza.ch/images/logo.png");
        // model.setName("Facebook Test Offer [name]");
        // model.setCaption("[caption]");
        // model.setDescription("[description test]");

        PostOfferOnFacebookUrlModel model = new PostOfferOnFacebookUrlModel(new Offer());

        // external link example
        ExternalLink fbfeed = new ExternalLink("postOfferToFacebook", model);
        add(fbfeed);

        // onClick example
        final Link<String> fbLink2 = new Link<String>("fbpost2", model) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                LOG.info("fbLink2 onClick");
                setResponsePage(new RedirectPage(this.getModel().getObject()));
            }
        };
        add(fbLink2);

        // popup example
        PopupSettings popupSettings = new PopupSettings("blank").setHeight(500).setWidth(500);

        Link<String> fbLink3 = new Link<String>("fbpost3", model) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                LOG.info("fbLink3 onClick");
                setResponsePage(new RedirectPage(this.getModel().getObject()));
            }
        };
        fbLink3.setPopupSettings(popupSettings);
        add(fbLink3);
    }
}
