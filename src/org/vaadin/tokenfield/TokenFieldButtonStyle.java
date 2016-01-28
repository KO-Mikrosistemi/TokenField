package org.vaadin.tokenfield;

public enum TokenFieldButtonStyle {
	FOR_ATTACHMENT("attachment-tf-btn"), FOR_RECIPIENTS("recipient-tf-btn"), FOR_LABELS("label-tf-btn"), CLOSABLE(
			"closable"), TOKENFIELD_REMOVE_BUTTON("tf-remove-btn"), TOKENFIELD_BUTTON("tf-btn");

	private String styleName;

	private TokenFieldButtonStyle(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleName() {
		return styleName;
	}
}
