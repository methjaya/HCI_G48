package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RoundButton extends JButton {
    private BufferedImage image;
    int width = 0;
    int height = 0;

    public RoundButton(String imagePath, int width, int height) {
        this.height = height;
        this.width = width;
        loadImage(imagePath);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(width, height)); // Set the preferred size
    }

    private void loadImage(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            System.out.println("Error loading image: " + ex.getMessage());
            this.image = null; // Clear image on failure
        }
    }

    public void setImage(String imagePath) {
        loadImage(imagePath);
        repaint(); // Repaint to update the image
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) { // Check if image is loaded
            Graphics2D g2d = (Graphics2D) g.create();
            int imgWidth = image.getWidth();
            int imgHeight = image.getHeight();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw white rounded rectangle
            g2d.setColor(Color.WHITE);
            int arc = Math.min(width, height);
            g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc));

            // Draw image at the center
            int x = (width - imgWidth) / 2;
            int y = (height - imgHeight) / 2;
            g2d.drawImage(image, x, y, this);

            g2d.dispose();
        }
    }
}

