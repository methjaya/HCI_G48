import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPalette {

    JFrame f;
    ColorPalette() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(1000, 720);
        f.setLocationRelativeTo(null);

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
        title = new JLabel("OUR PALETTE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);


        //ITEM TYPE LABEL
        JLabel title2;
        title2 = new JLabel("AVAILABLE COLOR PALETTES",SwingConstants.CENTER);
        title2.setFont(newFont);
        title2.setForeground(new Color(27, 26, 85));
        title2.setBounds(360, 25, 280, 40);

        //BOTTOM PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 80, 1000, 640);
        panel.setLayout(null);

        // Load the image from file
        ImageIcon icon = new ImageIcon("assets/color palette.jpg");
        // Create a JLabel with the image icon
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);
        imageLabel.setBounds(100, 80 , 800, 419);



        //ADDING UI COMPONENTS
        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);

        panel.add(title2);
        panel.add(imageLabel);


        f.add(panelTop);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }
}