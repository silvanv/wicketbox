/**
 * Copyright (c) 2012 by Tamedia AG, Switzerland.
 *            All rights reserved.
 */
package ch.silvanv.facebookfeed;

/**
 * TODO : Description
 * 
 * @author roi
 */
public class PostOfferOnFacebookUrlModel extends PostOnFacebookUrlModel {

    private static final long serialVersionUID = 1L;

    private final Offer offer;
    private transient String url;

    /**
     * @param app_id
     */
    public PostOfferOnFacebookUrlModel(Offer offer) {
        // TODO validate
        // Validate.notNull(offer, "offer must not be null");
        this.offer = offer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String load() {
        if (url == null) {
            setName(offer.getTitle());
            setCaption("");
            setDescription(offer.getDescription());
            // TODO missing fields from offer
            setLink("http://www.piazza.ch/");
            setPicture("http://www.piazza.ch/images/logo.png");

            url = super.load();
        }
        return url;
    }
}
