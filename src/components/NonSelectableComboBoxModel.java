package components;

import javax.swing.*;

// Custom ComboBoxModel to prevent selection of placeholder item
public class NonSelectableComboBoxModel<E> extends DefaultComboBoxModel<E> {
    public NonSelectableComboBoxModel(E[] items) {
        super(items);
    }

    @Override
    public void setSelectedItem(Object anObject) {
        if (!"  Select Floor Material".equals(anObject)) {
            super.setSelectedItem(anObject);
        }
    }
}