import components.JPlaceholderTextField;
import components.NonSelectableComboBoxModel;
import components.PlaceholderRenderer;
import components.RoundButton;
import utils.ModelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomConfiguration {

    JFrame f;
    Color selectedColor;
    JComboBox<String> floorMaterialsMenu;
    RoomConfiguration() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null);

        // TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        // BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Dashboard();
            }
        });

        // USER IMAGE
        RoundButton userImage = new RoundButton("assets/user.png",35,35);
        userImage.setBounds(870, 20, 40, 40);
        userImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Profile();
            }
        });

        // USER NAME LABEL
        JLabel usernameLb;
        usernameLb= new JLabel("John");
        usernameLb.setBounds(920,25,50,30);
        usernameLb.setFont(usernameLb.getFont().deriveFont(usernameLb.getFont().getSize() * 1.2f));
        usernameLb.setForeground(Color.white);

        // TITLE
        JLabel title;
        title = new JLabel("ROOM CONFIGURATION");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        // BOTTOM PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 80, 1000, 720);
        panel.setLayout(null);

        // CENTER PANEL
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(146, 144, 195,100));
        centerPanel.setBounds(300, 120, 400, 600);
        centerPanel.setLayout(null);

        // ROOM SIZE LABEL
        JLabel roomSizeLb;
        roomSizeLb = new JLabel("ROOM SIZE");
        roomSizeLb.setFont(newFont);
        roomSizeLb.setForeground(new Color(27, 26, 85));
        roomSizeLb.setBounds(50, 55, 200, 40);

        // TEXT FIELD LENGTH
        JPlaceholderTextField lenTf = new JPlaceholderTextField("Length (Meters)", 10);
        lenTf.setBounds(50, 100, 300, 30);
        lenTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        // TEXT FIELD WIDTH
        JPlaceholderTextField widthTf = new JPlaceholderTextField("Width (Meters)", 10);
        widthTf.setBounds(50, 140, 300, 30);
        widthTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        // TEXT FIELD HEIGHT
        JPlaceholderTextField heightTf = new JPlaceholderTextField("Height (Meters)", 10);
        heightTf.setBounds(50, 180, 300, 30);
        heightTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());



        // WALL COLOR LABEL
        JLabel wallColorLb;
        wallColorLb = new JLabel("WALL COLOR");
        wallColorLb.setFont(newFont);
        wallColorLb.setForeground(new Color(27, 26, 85));
        wallColorLb.setBounds(50, 240, 200, 40);

        JButton colorPickerButton = new JButton("Pick a Color");
        colorPickerButton.setBackground(Color.white);
        colorPickerButton.setBounds(50, 285, 250, 30);
        colorPickerButton.setForeground(Color.gray);
        colorPickerButton.setFont(colorPickerButton.getFont().deriveFont(Font.PLAIN));
        colorPickerButton.setFocusPainted(false);

        JPanel colorDisplayPanel = new JPanel();
        colorDisplayPanel.setBounds(320, 285, 30, 30);
        colorDisplayPanel.setBackground(Color.white);

        colorPickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColor = JColorChooser.showDialog(f, "Choose a Color", Color.WHITE);
                if (selectedColor != null) {
                    colorDisplayPanel.setBackground(selectedColor);
                }
            }
        });

        //FLOOR MATERIAL
        JLabel floorMaterialLb;
        floorMaterialLb = new JLabel("FLOOR MATERIAL");
        floorMaterialLb.setFont(newFont);
        floorMaterialLb.setForeground(new Color(27, 26, 85));
        floorMaterialLb.setBounds(50, 350, 200, 40);

        JPanel materialColorDisplayPanel = new JPanel();
        JButton materialColorPickerButton = new JButton("Pick The Floor Color");
        String[] options = {"  Select Floor Material","  Dark Wooden Floor", "  Light Wooden Floor"};
        floorMaterialsMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(options));
        floorMaterialsMenu.setRenderer(new PlaceholderRenderer("  Select Floor Material"));
        floorMaterialsMenu.setBounds(50, 390, 200, 30);
        floorMaterialsMenu.setBackground(Color.white);
        floorMaterialsMenu.setFont(floorMaterialsMenu.getFont().deriveFont(Font.PLAIN));
        floorMaterialsMenu.setForeground(Color.gray);
        floorMaterialsMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        floorMaterialsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the dropdown
                String selectedOption = (String) floorMaterialsMenu.getSelectedItem();

                // Check if the selected item is not the placeholder text
                if (!selectedOption.equals("  Select Floor Material")) {
                    System.out.println("Selected option: " + selectedOption);

                    floorMaterialsMenu.setFont(floorMaterialsMenu.getFont().deriveFont(Font.BOLD));
                    floorMaterialsMenu.setForeground(Color.black);

                    materialColorPickerButton.setFont(materialColorPickerButton.getFont().deriveFont(Font.PLAIN));
                    materialColorPickerButton.setForeground(Color.lightGray);
                    materialColorDisplayPanel.setBackground(Color.white);
                }

            }

        });

        //OR LABEL
        JLabel orLb;
        orLb= new JLabel("OR");
        orLb.setBounds(275,390,50,30);

        //FLOOR COLOR PICKER
        materialColorPickerButton.setBackground(Color.white);
        materialColorPickerButton.setBounds(50, 440, 250, 30);
        materialColorPickerButton.setForeground(Color.gray);
        materialColorPickerButton.setFont(materialColorPickerButton.getFont().deriveFont(Font.PLAIN));
        materialColorPickerButton.setFocusPainted(false);
        //COLOR PANEL
        materialColorDisplayPanel.setBounds(320,440,30,30);
        materialColorDisplayPanel.setBackground(Color.white);
        materialColorPickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the color chooser dialog when the button is clicked
                Color selectedColor = JColorChooser.showDialog(f, "Choose a Color", Color.WHITE);
                if (selectedColor != null) {
                    // Perform actions with the selected color (e.g., set background color of a component)
                    materialColorPickerButton.setFont(materialColorPickerButton.getFont().deriveFont(Font.BOLD));
                    materialColorPickerButton.setForeground(Color.black);

                    floorMaterialsMenu.setFont(floorMaterialsMenu.getFont().deriveFont(Font.PLAIN));
                    floorMaterialsMenu.setForeground(Color.lightGray);

                    System.out.println(selectedColor);
                    materialColorDisplayPanel.setBackground(selectedColor);
                }
            }
        });

        JButton goBtn = new JButton("GO >");
        goBtn.setBounds(165, 520, 70, 30);
        goBtn.setBackground(new Color(54, 48, 98));
        goBtn.setForeground(Color.white);
        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields(lenTf.getText(), widthTf.getText(), heightTf.getText())) {

                    ModelManager.halfWidth = Float.parseFloat(widthTf.getText()) / 10;
                    ModelManager.halfDepth = Float.parseFloat(lenTf.getText()) / 10;
                    String selectedOption = (String) floorMaterialsMenu.getSelectedItem();

                    if(selectedOption.equals("  Dark Wooden Floor")){
                        ModelManager.floorMaterialPath = "resources/dark floor.jpg";
                    }else{
                        ModelManager.floorMaterialPath = "resources/light floor.jpg";
                    }
                    f.dispose();
                    new FurnitureDesign(false);
                }
            }
        });

        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        centerPanel.add(goBtn);
        centerPanel.add(roomSizeLb);
        centerPanel.add(lenTf);
        centerPanel.add(widthTf);
        centerPanel.add(heightTf);
        centerPanel.add(wallColorLb);
        centerPanel.add(colorPickerButton);
        centerPanel.add(colorDisplayPanel);
        centerPanel.add(floorMaterialLb);
        centerPanel.add(materialColorDisplayPanel);
        centerPanel.add(materialColorPickerButton);
        centerPanel.add(floorMaterialsMenu);
        centerPanel.add(orLb);
        f.add(panelTop);
        f.add(centerPanel);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }

    private boolean validateFields(String length, String width, String height) {
        if (length.isEmpty() || width.isEmpty() || height.isEmpty()) {
            JOptionPane.showMessageDialog(f, "Please fill in all room size fields");
            return false;
        }

        String selectedOption = (String) floorMaterialsMenu.getSelectedItem();

        if (selectedOption.equals("  Select Floor Material")){
            JOptionPane.showMessageDialog(f, "Please select a floor material or color");
            return false;
        }


        try {
            double len = Double.parseDouble(length);
            double wid = Double.parseDouble(width);
            double hei = Double.parseDouble(height);

            if (len <= 0 || wid <= 0 || hei <= 0) {
                JOptionPane.showMessageDialog(f, "Room dimensions should be positive numbers");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(f, "Room dimensions should be numerical");
            return false;
        }


        return true;
    }
}
