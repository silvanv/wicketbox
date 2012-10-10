/**
 * Copyright (c) 2012 by Tamedia AG, Switzerland.
 *            All rights reserved.
 */
package ch.silvanv.facebookfeed;

import org.apache.wicket.model.LoadableDetachableModel;

/**
 * TODO : Description
 * 
 * @author roi
 */
public class PostOnFacebookUrlModel extends LoadableDetachableModel<String> {

    private static final long serialVersionUID = 1L;

    private static String BASE_FB = "http://www.facebook.com/dialog/feed";
    private static String BASE_APP_ID = "318567394908551";

    private String redirect_uri = "http://www.facebook.com";
    private String link;
    private String picture;
    private String name;
    private String caption;
    private String description;

    /**
     * {@inheritDoc}
     */
    @Override
    protected String load() {
        return buildUrl();
    }

    // TODO fix null and sep
    // /////////////////////////////////////////////////7
    private String buildUrl() {
        StringBuilder b = new StringBuilder();
        b.append(BASE_FB + "?");
        b.append("app_id=" + BASE_APP_ID + "&");
        b.append("link=" + link + "&");
        b.append("picture=" + picture + "&");
        b.append("name=" + name + "&");
        b.append("caption=" + caption + "&");
        b.append("description=" + description + "&");
        b.append("redirect_uri=" + redirect_uri);
        return b.toString();
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }
}
