import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BrowseItems {

    JFrame f;

    BrowseItems() {
        f = new JFrame("Browse Items");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 720);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.WHITE);

        //TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        //BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Dashboard();
            }
        });

        //USER IMAGE
        RoundButton userImage = new RoundButton("assets/user.png",35,35);
        userImage.setBounds(870, 20, 40, 40);
        userImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Profile();
            }
        });

        //USER NAME LABEL
        JLabel usernameLb;
        usernameLb= new JLabel("John");
        usernameLb.setBounds(920,25,50,30);
        usernameLb.setFont(usernameLb.getFont().deriveFont(usernameLb.getFont().getSize() * 1.3f));
        usernameLb.setForeground(Color.white);

        //TITLE
        JLabel title;
        title = new JLabel("BROWSE FURNITURE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        //SUB HEADING
        JLabel subHeading;
        subHeading = new JLabel("AVAILABLE FURNITURE",SwingConstants.CENTER);
        subHeading.setFont(title.getFont().deriveFont(currentFont.getSize() * 1.5f));
        subHeading.setForeground(new Color(54, 48, 98));
        subHeading.setBounds(365, 100, 250, 40);

        //CENTER PANEL
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 720);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(subHeading);

        //INNER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setBounds(145,160,700,700);
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.WHITE);


        // Variables to adjust the layout
        int panelWidth = 490, panelHeight = 490;
        int rows = 3, cols = 5;
        int gap = 40;

        // Calculate the width and height for each image
        int totalGapWidth = (cols - 1) * gap;
        int totalGapHeight = (rows - 1) * gap;
        int imageWidth = (panelWidth - totalGapWidth) / cols;
        int imageHeight = (panelHeight - totalGapHeight) / rows;

        // Adjust for the aspect ratio
        double aspectRatio = 764.0 / 980.0;
        imageWidth = (int)(imageHeight * aspectRatio);


        int x = 0, y = 0;

        for (int i = 0; i < rows * cols; i++) {
            if (i % cols == 0 && i > 0) {
                x = 0;
                y += imageHeight + gap;
            } else if (i > 0) {
                x += imageWidth + gap;
            }

            // Create and add the image label
            JLabel imageLabel = new JLabel();
            ImageIcon icon = new ImageIcon(new File("assets/browse items/image" + (i + 1) + ".png").getAbsolutePath());
            Image image = icon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
            imageLabel.setBounds(x, y, imageWidth, imageHeight);
            panelCenter.add(imageLabel);
        }

        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);


        f.add(panelTop);
        f.add(panelCenter);
        f.setSize(1000, 720);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BrowseItems::new);
    }
}


