import components.RoundButton;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard {

    JFrame f;

    Dashboard() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 700);

        //TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);
        f.setLocationRelativeTo(null);

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
        title = new JLabel("ROOM CONFIGURATION");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        //BOTTOM PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 80, 1000, 720);
        panel.setLayout(null);

        //CENTER PANEL
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(146, 144, 195,100));
        centerPanel.setBounds(300, 120, 400, 600);
        centerPanel.setLayout(null);


        //ROOM CONFIG BUTTON
        JButton roomConfigBtn = new JButton("Room Configuration");
        roomConfigBtn.setBounds(165, 110, 200, 45);
        roomConfigBtn.setBackground(new Color(54, 48, 98));
        roomConfigBtn.setForeground(Color.white);
        roomConfigBtn.setFont(roomConfigBtn.getFont().deriveFont(roomConfigBtn.getFont().getSize() * 1.3f));
        roomConfigBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new RoomConfiguration();

            }
        });

        //CUSTOMER DESIGNS BUTTON
        JButton custDesignsBtn = new JButton("Browse Customer Designs");
        custDesignsBtn.setBounds(165, 260, 260, 45);
        custDesignsBtn.setBackground(new Color(54, 48, 98));
        custDesignsBtn.setForeground(Color.white);
        custDesignsBtn.setFont(custDesignsBtn.getFont().deriveFont(custDesignsBtn.getFont().getSize() * 1.3f));
        custDesignsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f.dispose();
                    // Open the home page window
                    new BrowseCustomerDesign();
                } catch (Exception err) {
                    //output.setText("Error");
                }

            }
        });

        //INSTRUCTIONS BUTTON
        JButton instructionsBtn = new JButton("Instructions");
        instructionsBtn.setBounds(165, 410, 200, 45);
        instructionsBtn.setBackground(new Color(54, 48, 98));
        instructionsBtn.setForeground(Color.white);
        instructionsBtn.setFont(instructionsBtn.getFont().deriveFont(instructionsBtn.getFont().getSize() * 1.3f));
        instructionsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f.dispose();
                    // Open the home page window
                    new Instructions();
                } catch (Exception err) {
                    //output.setText("Error");
                }

            }
        });

        //ROOM CONFIG BUTTON
        JButton browseItemsBtn = new JButton("Browse Furniture");
        browseItemsBtn.setBounds(585, 110, 200, 45);
        browseItemsBtn.setBackground(new Color(54, 48, 98));
        browseItemsBtn.setForeground(Color.white);
        browseItemsBtn.setFont(browseItemsBtn.getFont().deriveFont(browseItemsBtn.getFont().getSize() * 1.3f));
        browseItemsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new BrowseItems();
            }
        });

        //CUSTOMER DESIGNS BUTTON
        JButton clrPaletteBtn = new JButton("Color Palette");
        clrPaletteBtn.setBounds(585, 260, 200, 45);
        clrPaletteBtn.setBackground(new Color(54, 48, 98));
        clrPaletteBtn.setForeground(Color.white);
        clrPaletteBtn.setFont(clrPaletteBtn.getFont().deriveFont(clrPaletteBtn.getFont().getSize() * 1.3f));
        clrPaletteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new ColorPalette();
            }
        });

        //INSTRUCTIONS BUTTON
        JButton addYourOwnBtn = new JButton("Add Furniture");
        addYourOwnBtn.setBounds(585, 410, 200, 45);
        addYourOwnBtn.setBackground(new Color(54, 48, 98));
        addYourOwnBtn.setForeground(Color.white);
        addYourOwnBtn.setFont(addYourOwnBtn.getFont().deriveFont(addYourOwnBtn.getFont().getSize() * 1.3f));
        addYourOwnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new AddFurniture();

            }
        });


        //ADDING UI COMPONENTS
        panelTop.add(title);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        panel.add(roomConfigBtn);
        panel.add(custDesignsBtn);
        panel.add(instructionsBtn);
        panel.add(browseItemsBtn);
        panel.add(clrPaletteBtn);
        panel.add(addYourOwnBtn);


        f.add(panelTop);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }

}
