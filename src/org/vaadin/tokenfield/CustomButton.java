package org.vaadin.tokenfield;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

public class CustomButton extends HorizontalLayout{
	private Button openButton = null;
	private Button closeButton = null;
	
	public static final String CUSTOM_BUTTON = "×";
	public static final String CUSTOM_BUTTON_BIG = "\u2716";
	public static final String CUSTOM_BUTTON_SMALL = "\u00D7";
	
	public CustomButton() {
		super();
		this.setStyleName("tokenfield-button");
		//this.setSpacing(true);
		this.openButton = new Button();
		this.closeButton = new Button();
		addToLayout();
	}
	
	private void addToLayout(){
		//HorizontalLayout hl = new HorizontalLayout();
		//hl.setSpacing(true);
		//addComponent(hl);
		
		addComponent(this.openButton);
		this.closeButton.setWidth(20, Unit.PIXELS);
		addComponent(this.closeButton);
	}

	public Button getOpenButton() {
		return openButton;
	}

	public void setOpenButton(Button openButton) {
		this.openButton = openButton;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(Button closeButton) {
		this.closeButton = closeButton;
	}
}
