package ch.silvanv.wicketbox.common;

import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class Feedback extends FeedbackPanel {
	private static final long serialVersionUID = 1L;

	public Feedback(String id) {
		this(id, null);
	}

	public Feedback(String id, IFeedbackMessageFilter filter) {
		super(id, filter);
		setOutputMarkupPlaceholderTag(true);
	}

	@Override
	protected void onConfigure() {
		if (anyMessage()) {
			setVisibilityAllowed(true);
		}
		else {
			setVisibilityAllowed(false);
		}
	}
}
