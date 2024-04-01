package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JPlaceholderTextField extends JTextField implements FocusListener {
    private String placeholder;
    private int padding;
    private boolean clicked;
    private Font placeholderFont;

    public JPlaceholderTextField(String placeholder, int padding) {
        this.placeholder = placeholder;
        this.padding = padding;
        addFocusListener(this);
        placeholderFont = getFont().deriveFont(Font.PLAIN); // Create a bold version of the current font
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        FontMetrics metrics = g2d.getFontMetrics(placeholderFont); // Use placeholderFont for measuring text
        int textWidth = metrics.stringWidth(placeholder);
        int textHeight = metrics.getHeight();

        int x, y;

        if (!clicked && getText().isEmpty()) {
            // Draw the placeholder text at the start if not clicked and text field is empty
            x = padding;
        } else {
            // Draw the placeholder text at the end if clicked or text field is not empty
            x = getWidth() - textWidth - padding;
        }

        y = (getHeight() - textHeight) / 2 + metrics.getAscent();

        // Enable anti-aliasing for smooth rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GRAY);
        g2d.setFont(placeholderFont); // Set the font to placeholderFont (bold)
        g2d.drawString(placeholder, x, y);
    }

    @Override
    public void focusGained(FocusEvent e) {
        clicked = true;
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        clicked = false;
        repaint();
    }

    @Override
    public Insets getInsets() {
        Insets insets = super.getInsets();
        insets.left += padding;
        insets.right += padding;
        return insets;
    }
}
