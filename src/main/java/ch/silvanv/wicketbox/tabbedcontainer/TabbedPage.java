package ch.silvanv.wicketbox.tabbedcontainer;

import ch.silvanv.wicketbox.Task;
import ch.silvanv.wicketbox.common.BasePage;
import ch.silvanv.wicketbox.common.Feedback;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class TabbedPage extends BasePage {
	private static final long serialVersionUID = 1L;

	public TabbedPage() {
		List<ITab> tabs = new ArrayList<ITab>();
		tabs.add(new AbstractTab(new Model<String>("first tab")) {
			private static final long serialVersionUID = 1L;

			public Panel getPanel(String panelId) {
				return new TabPanel1(panelId);
			}
		});

		tabs.add(new AbstractTab(new Model<String>("second tab")) {
			private static final long serialVersionUID = 1L;

			public Panel getPanel(String panelId) {
				return new TabPanel2(panelId);
			}
		});

		add(new TabContainer("tabContainer", tabs));
	}

	// private static class TabContainer extends TabbedPanel<ITab> {
	private static class TabContainer extends AjaxTabbedPanel<ITab> {
		private static final long serialVersionUID = 1L;

		public TabContainer(String id, List<ITab> tabs) {
			super(id, tabs);
		}

		// @Override
		// protected String getSelectedTabCssClass() {
		// return "active";
		// }
	}

	private static class TabPanel1 extends Panel {
		private static final long serialVersionUID = 1L;

		public TabPanel1(String id) {
			super(id);
		}
	}

	private static class TabPanel2 extends Panel {
		private static final long serialVersionUID = 1L;

		public TabPanel2(String id) {
			super(id);

			final Feedback feedbackPanel = new Feedback("feedback");
			add(feedbackPanel);

			add(new Label("label", Model.of("bla")));

			Form<Task> form = new Form<Task>("form");

			form.add(new AjaxButton("submit") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
					feedbackPanel.info("the form was submitted!");
					target.add(feedbackPanel);
				}
			});

			add(form);
		}
	}
}
