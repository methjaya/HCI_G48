package components;

import javax.swing.*;
import java.awt.*;

public  class PlaceholderRenderer extends DefaultListCellRenderer {
    private String placeholder;

    public PlaceholderRenderer(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value != null && value.equals(placeholder)) {
            setForeground(Color.GRAY);
            setFont(getFont().deriveFont(Font.ITALIC));
        }
        return this;
    }
}
