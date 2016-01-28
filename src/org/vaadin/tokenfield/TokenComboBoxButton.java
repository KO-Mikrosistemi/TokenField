package org.vaadin.tokenfield;

import org.vaadin.tokenfield.client.ui.TokenFieldServerRpc;

import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.ui.ComboBox;

public abstract class TokenComboBoxButton extends ComboBox {

    private static final long serialVersionUID = 8382983756053298383L;

    protected TokenFieldButton.InsertPosition insertPosition;

    private TokenFieldServerRpc rpc = new TokenFieldServerRpc() {
        public void deleteToken() {
            onDelete();
        }
    };

    public TokenComboBoxButton(TokenFieldButton.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        registerRpc(rpc);
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        target.addVariable(this, "del", false);
        if (insertPosition == TokenFieldButton.InsertPosition.AFTER) {
            target.addAttribute("after", true);
        }
    }

    public void setTokenInsertPosition(TokenFieldButton.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        requestRepaint();
    }

    abstract protected void onDelete();

}
