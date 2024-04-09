import components.JPlaceholderTextField;
import components.NonSelectableComboBoxModel;
import components.PlaceholderRenderer;
import components.RoundButton;
import utils.ModelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class AddFurniture {

    JFrame f;
    Color selectedColor;
    JComboBox<String> typeMenu;

    private java.util.List<JTextField> dimensionFields;
    JPanel dimensionsPanel;
    AddFurniture() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 720);
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
        title = new JLabel("ADD FURNITURE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f);
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
        centerPanel.setBounds(120, 160, 760, 435);
        centerPanel.setLayout(null);

        // FURNITURE NAME LABEL
        JLabel nameLb = new JLabel("FURNITURE NAME");
        nameLb.setFont(newFont);
        nameLb.setForeground(new Color(27, 26, 85));
        nameLb.setBounds(50, 25, 200, 40);

        // NAME TEXT FIELD
        JPlaceholderTextField nameTf = new JPlaceholderTextField("Name", 10);
        nameTf.setBounds(50, 70, 300, 30);
        nameTf.setBorder(BorderFactory.createEmptyBorder());

        // FURNITURE TYPE LABEL
        JLabel typeLb = new JLabel("FURNITURE TYPE");
        typeLb.setFont(newFont);
        typeLb.setForeground(new Color(27, 26, 85));
        typeLb.setBounds(50, 110, 200, 40);

        String[] options = {"  Select Furniture Type", "  Chair", "  Table", "  Wardrobe"};
        JComboBox<String> typeMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(options));
        typeMenu.setRenderer(new PlaceholderRenderer("  Select Floor Material"));
        typeMenu.setBounds(50, 150, 300, 30);
        typeMenu.setBackground(Color.white);
        typeMenu.setFont(typeMenu.getFont().deriveFont(Font.PLAIN));
        typeMenu.setForeground(Color.gray);
        typeMenu.setBorder(BorderFactory.createEmptyBorder());

        // IMAGE PATH LABEL
        JLabel imgePathLb = new JLabel("IMAGE PATH");
        imgePathLb.setFont(newFont);
        imgePathLb.setForeground(new Color(27, 26, 85));
        imgePathLb.setBounds(50, 190, 200, 40);

        // SELECT IMAGE BUTTON
        JButton imgPathBtn = new JButton("SELECT IMAGE");
        imgPathBtn.setBounds(50, 230, 200, 30);
        imgPathBtn.setBackground(new Color(54, 48, 98));
        imgPathBtn.setForeground(Color.white);
        imgPathBtn.setFocusPainted(false);

        // IMAGE NAME LABEL
        JLabel imgeNameLb = new JLabel("image.jpg");
        imgeNameLb.setForeground(Color.DARK_GRAY);
        imgeNameLb.setBounds(275, 225, 200, 40);
        imgPathBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                int result = fileChooser.showOpenDialog(f);

                // Check if the user selected a file
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    // Update the image name label with the name of the selected file
                    imgeNameLb.setText(selectedFile.getName());
                    f.repaint();
                }
            }
        });

        // MODEL PATH LABEL
        JLabel modelPathLb = new JLabel("MODEL PATH");
        modelPathLb.setFont(newFont);
        modelPathLb.setForeground(new Color(27, 26, 85));
        modelPathLb.setBounds(50, 270, 200, 40);

        // SELECT MODEL BUTTON
        JButton modelPathLbBtn = new JButton("SELECT MODEL");
        modelPathLbBtn.setBounds(50, 310, 200, 30);
        modelPathLbBtn.setBackground(new Color(54, 48, 98));
        modelPathLbBtn.setForeground(Color.white);
        modelPathLbBtn.setFocusPainted(false);

        // MODEL NAME LABEL
        JLabel modelNameLb = new JLabel("chair.obj");
        modelNameLb.setForeground(Color.DARK_GRAY);
        modelNameLb.setBounds(275, 305, 200, 40);

        modelPathLbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                int result = fileChooser.showOpenDialog(f);

                // Check if the user selected a file
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    // Update the model name label with the name of the selected file
                    modelNameLb.setText(selectedFile.getName());
                    f.repaint();
                }
            }
        });

        // FURNITURE COLOR LABEL
        JLabel ColorLb = new JLabel("FURNITURE COLOR");
        ColorLb.setFont(newFont);
        ColorLb.setForeground(new Color(27, 26, 85));
        ColorLb.setBounds(390, 25, 200, 40);

        // PICK A COLOR BUTTON
        JButton colorPickerButton = new JButton("Pick a Color");
        colorPickerButton.setBackground(Color.white);
        colorPickerButton.setBounds(390, 65, 250, 30);
        colorPickerButton.setForeground(Color.gray);
        colorPickerButton.setFont(colorPickerButton.getFont().deriveFont(Font.PLAIN));
        colorPickerButton.setFocusPainted(false);

        // COLOR DISPLAY PANELS
        JPanel colorDisplayPanel1 = new JPanel();
        colorDisplayPanel1.setBounds(390, 110, 30, 30);
        colorDisplayPanel1.setBackground(Color.white);

        JPanel colorDisplayPanel2 = new JPanel();
        colorDisplayPanel2.setBounds(430, 110, 30, 30);
        colorDisplayPanel2.setBackground(Color.white);

        JPanel colorDisplayPanel3 = new JPanel();
        colorDisplayPanel3.setBounds(470, 110, 30, 30);
        colorDisplayPanel3.setBackground(Color.white);

        JPanel colorDisplayPanel4 = new JPanel();
        colorDisplayPanel4.setBounds(510, 110, 30, 30);
        colorDisplayPanel4.setBackground(Color.white);

        colorDisplayPanel1.setVisible(false);
        colorDisplayPanel2.setVisible(false);
        colorDisplayPanel3.setVisible(false);
        colorDisplayPanel4.setVisible(false);

        java.util.List<Color> selectedColors = new java.util.ArrayList<>();

        colorPickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the color chooser dialog
                Color color = JColorChooser.showDialog(f, "Choose a Color", Color.WHITE);
                if (color != null) {
                    // Add the selected color to the list
                    selectedColors.add(color);

                    if (selectedColors.size() >= 1) {
                        colorDisplayPanel1.setBackground(selectedColors.get(0));
                        colorDisplayPanel1.setVisible(true);
                        f.repaint();
                    }
                    if (selectedColors.size() >= 2) {
                        colorDisplayPanel2.setBackground(selectedColors.get(1));
                        colorDisplayPanel2.setVisible(true);
                        f.repaint();
                    }
                    if (selectedColors.size() >= 3) {
                        colorDisplayPanel3.setBackground(selectedColors.get(2));
                        colorDisplayPanel3.setVisible(true);
                        f.repaint();
                    }
                    if (selectedColors.size() >= 4) {
                        colorDisplayPanel4.setBackground(selectedColors.get(3));
                        colorDisplayPanel4.setVisible(true);
                        f.repaint();
                    }
                }
            }
        });

        dimensionFields = new ArrayList<>();

        // Initialize the dimensions panel
        dimensionsPanel = new JPanel();
        dimensionsPanel.setLayout(new BoxLayout(dimensionsPanel, BoxLayout.Y_AXIS));
        dimensionsPanel.setBackground(Color.LIGHT_GRAY);

        // Dimensions label
        JLabel dimensionsLabel = new JLabel("DIMENSIONS (LxWxH)");
        dimensionsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dimensionsLabel.setBounds(390, 155, 250, 30);
        dimensionsLabel.setFont(newFont);
        dimensionsLabel.setForeground(new Color(27, 26, 85));

        // Add Dimension button
        JButton addDimensionButton = new JButton("Add Dimension");
        addDimensionButton.setBounds(390, 200, 150, 25);
        addDimensionButton.addActionListener(e -> addDimensionField());

        // Remove Dimension button
        JButton removeDimensionButton = new JButton("Remove Dimension");
        removeDimensionButton.setBounds(550, 200, 150, 25);
        removeDimensionButton.addActionListener(e -> removeDimensionField());

        // Add initial dimension field
        addDimensionField();

        // Add components to the panel
        centerPanel.add(dimensionsLabel);
        centerPanel.add(addDimensionButton);
        centerPanel.add(removeDimensionButton);
        centerPanel.add(dimensionsPanel);


        dimensionsPanel.setBounds(390, 235, 300, 100);


//         GO BUTTON
        JButton goBtn = new JButton("SAVE");
        goBtn.setBounds(340, 370, 80, 30);
        goBtn.setBackground(new Color(54, 48, 98));
        goBtn.setForeground(Color.white);
        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Furniture item added successfully!");
            }
        });


        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        centerPanel.add(goBtn);
        centerPanel.add(nameLb);
        centerPanel.add(nameTf);
        centerPanel.add(ColorLb);
        centerPanel.add(colorPickerButton);
        centerPanel.add(colorDisplayPanel1);
        centerPanel.add(colorDisplayPanel2);
        centerPanel.add(colorDisplayPanel3);
        centerPanel.add(colorDisplayPanel4);
        centerPanel.add(typeLb);
        centerPanel.add(typeMenu);
        centerPanel.add(imgePathLb);
        centerPanel.add(imgPathBtn);
        centerPanel.add(imgeNameLb);
        centerPanel.add(modelNameLb);
        centerPanel.add(modelPathLbBtn);
        centerPanel.add(modelPathLb);
        f.add(panelTop);
        f.add(centerPanel);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }
    private void addDimensionField() {
        JTextField dimensionField = new JPlaceholderTextField("Enter dimension", 10);
        dimensionFields.add(dimensionField);
        dimensionsPanel.add(dimensionField);
        dimensionsPanel.revalidate();
    }

    private void removeDimensionField() {
        if (!dimensionFields.isEmpty()) {
            JTextField fieldToRemove = dimensionFields.remove(dimensionFields.size() - 1);
            dimensionsPanel.remove(fieldToRemove);
            dimensionsPanel.revalidate();
            dimensionsPanel.repaint();
        }
    }
}
