package org.vaadin.tokenfield;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.tokenfield.client.ui.TokenFieldServerRpc;

import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.ui.TextField;

public abstract class TokenTextFieldComponent extends TextField {

    private static final long serialVersionUID = 8382983756053298383L;
    
    protected TokenFieldTextField.InsertPosition insertPosition;
    
    private TokenFieldServerRpc rpc = new TokenFieldServerRpc() {
        public void deleteToken() {
            onDelete();
        }
    };
    
    public TokenTextFieldComponent(TokenFieldTextField.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        registerRpc(rpc);
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        target.addVariable(this, "del", false);
        if (insertPosition == TokenFieldTextField.InsertPosition.AFTER) {
            target.addAttribute("after", true);
        }
    }

    public void setTokenInsertPosition(TokenFieldTextField.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        requestRepaint();
    }

    abstract protected void onDelete();

}
