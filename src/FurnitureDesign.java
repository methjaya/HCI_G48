import components.NonSelectableComboBoxModel;
import components.PlaceholderRenderer;
import components.RoundButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class FurnitureDesign {

    JFrame f;

    FurnitureDesign() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 720);

        //TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        //BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);

        //USER IMAGE
        RoundButton userImage = new RoundButton("assets/user.png",35,35);
        userImage.setBounds(870, 20, 40, 40);

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


        //LEFT PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(146, 144, 195,100));
        leftPanel.setBounds(90, 150, 300, 400);
        leftPanel.setLayout(null);


        //ITEM TYPE LABEL
        JLabel itemTypeLb;
        itemTypeLb = new JLabel("FURNITURE TYPE");
        itemTypeLb.setFont(newFont);
        itemTypeLb.setForeground(new Color(27, 26, 85));
        itemTypeLb.setBounds(20, 20, 260, 40);

        //CHAIR RADIO BUTTON
        JRadioButton chairRadioBtn = new JRadioButton("    Chair");
        chairRadioBtn.setBounds(20, 60, 260, 30);
        chairRadioBtn.setFocusPainted(false);
        chairRadioBtn.setForeground(Color.gray);
        chairRadioBtn.setBackground(Color.white);
        chairRadioBtn.setFont(chairRadioBtn.getFont().deriveFont(Font.PLAIN));
        //TABLE RADIO BUTTON
        JRadioButton tableRadioBtn = new JRadioButton("    Table");
        tableRadioBtn.setBounds(20, 100, 260, 30);
        tableRadioBtn.setFocusPainted(false);
        tableRadioBtn.setForeground(Color.gray);
        tableRadioBtn.setBackground(Color.white);
        tableRadioBtn.setFont(tableRadioBtn.getFont().deriveFont(Font.PLAIN));
        //WARDROBE RADIO BUTTON
        JRadioButton wardrobeRadioBtn = new JRadioButton("    Wardrobe");
        wardrobeRadioBtn.setBounds(20, 140, 260, 30);
        wardrobeRadioBtn.setFocusPainted(false);
        wardrobeRadioBtn.setForeground(Color.gray);
        wardrobeRadioBtn.setBackground(Color.white);
        wardrobeRadioBtn.setFont(wardrobeRadioBtn.getFont().deriveFont(Font.PLAIN));

        //ITEM TYPE LABEL
        JLabel itemMaterialLb;
        itemMaterialLb = new JLabel("FURNITURE MATERIAL");
        itemMaterialLb.setFont(newFont);
        itemMaterialLb.setForeground(new Color(27, 26, 85));
        itemMaterialLb.setBounds(20, 190, 260, 40);

        String[] options = {"  Select Floor Material","  Option 1", "  Option 2", "  Option 3"};
        JComboBox<String> materialMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(options));
        materialMenu.setRenderer(new PlaceholderRenderer("  Select Floor Material"));
        materialMenu.setBounds(20, 230, 260, 30);
        materialMenu.setBackground(Color.white);
        materialMenu.setFont(materialMenu.getFont().deriveFont(Font.PLAIN));
        materialMenu.setForeground(Color.gray);
        materialMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        materialMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the dropdown
                String selectedOption = (String) materialMenu.getSelectedItem();

                // Check if the selected item is not the placeholder text
                if (!selectedOption.equals("  Select Floor Material")) {
                    System.out.println("Selected option: " + selectedOption);
                }

            }

        });


        //ITEM TYPE LABEL
        JLabel itemSizeLb;
        itemSizeLb = new JLabel("DIMENSIONS");
        itemSizeLb.setFont(newFont);
        itemSizeLb.setForeground(new Color(27, 26, 85));
        itemSizeLb.setBounds(20, 280, 260, 40);

        String[] sizeOptions = {"  Select Floor Material","  Option 1", "  Option 2", "  Option 3"};
        JComboBox<String> sizeMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(sizeOptions));
        sizeMenu.setRenderer(new PlaceholderRenderer("  Select Floor Material"));
        sizeMenu.setBounds(20, 330, 260, 30);
        sizeMenu.setBackground(Color.white);
        sizeMenu.setFont(materialMenu.getFont().deriveFont(Font.PLAIN));
        sizeMenu.setForeground(Color.gray);
        sizeMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        sizeMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the dropdown
                String selectedOption = (String) sizeMenu.getSelectedItem();

                // Check if the selected item is not the placeholder text
                if (!selectedOption.equals("  Select Floor Material")) {
                    System.out.println("Selected option: " + selectedOption);
                }

            }

        });

        //RIGHT PANEL
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(146, 144, 195,100));
        rightPanel.setBounds(490, 150, 400, 400);
        rightPanel.setLayout(null);


        //ITEM VARIANTS LABEL
        JLabel itemVariantsLb;
        itemVariantsLb = new JLabel("FURNITURE VARIANTS");
        itemVariantsLb.setFont(newFont);
        itemVariantsLb.setForeground(new Color(27, 26, 85));
        itemVariantsLb.setBounds(20, 20, 260, 40);

        //RIGHT INNER PANEL
        JPanel rightInnerPanel = new JPanel(new GridLayout(10, 1));
        rightInnerPanel.setBounds(20, 70, 360, 310);
        rightInnerPanel.setOpaque(false);
        rightInnerPanel.setLayout(null);

        //IMAGE 1
        RoundButton imageLabel = new RoundButton("assets/chair.jpg",150,113);
        imageLabel.setBounds(15, 20, 150, 113);
        //IMAGE LABEL 1
        JLabel imgLb1;
        imgLb1= new JLabel("Chair 1",SwingConstants.CENTER);
        imgLb1.setBounds(15,133,150,30);

        //IMAGE 2
        RoundButton imageLabel2 = new RoundButton("assets/chair_2.jpg",150,113);
        imageLabel2.setBounds(195, 20, 150, 113);
        //IMAGE LABEL 2
        JLabel imgLb2;
        imgLb2= new JLabel("Chair 2",SwingConstants.CENTER);
        imgLb2.setBounds(195,133,150,30);

        //BOTTOM PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 80, 1000, 640);
        panel.setLayout(null);

        //2D DESIGN Button
        JButton Btn3D = new JButton("2D Design  >");
        Btn3D.setBounds(350,520,140,40);
        Btn3D.setBackground(new Color(51,58,115));
        Btn3D.setForeground(Color.white);
        Btn3D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                f.dispose();
                // Open the home page window
//                    new Profile();
                new Room();
            }
        });

        //3D DESIGN Button
        JButton Btn2D = new JButton("3D Design  >");
        Btn2D.setBounds(510,520,140,40);
        Btn2D.setBackground(new Color(51,58,115));
        Btn2D.setForeground(Color.white);
        Btn2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                f.dispose();
                // Open the home page window
//                    new Profile();
                new Room();
            }
        });


        //ADDING UI COMPONENTS
        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        leftPanel.add(itemTypeLb);
        leftPanel.add(chairRadioBtn);
        leftPanel.add(tableRadioBtn);
        leftPanel.add(wardrobeRadioBtn);
        leftPanel.add(itemMaterialLb);
        leftPanel.add(materialMenu);
        leftPanel.add(itemSizeLb);
        leftPanel.add(sizeMenu);
        rightPanel.add(itemVariantsLb);
        rightPanel.add(rightInnerPanel);
        rightInnerPanel.add(imageLabel);
        rightInnerPanel.add(imgLb1);
        rightInnerPanel.add(imageLabel2);
        rightInnerPanel.add(imgLb2);
        panel.add(Btn2D);
        panel.add(Btn3D);


        f.add(panelTop);
        f.add(leftPanel);
        f.add(rightPanel);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }


}
