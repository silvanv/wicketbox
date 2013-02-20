package ch.silvanv.wicketbox;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import ch.silvanv.wicketbox.common.BasePage;

public class HomePage extends BasePage {

  private static final long serialVersionUID = 1L;

  public HomePage() {
    add(new Label("helloLabel1", Model.of("Hello World")));
    add(new Label("helloLabel2", Model.of("Stranger")));
  }
}
