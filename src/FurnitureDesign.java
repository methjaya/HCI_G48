import components.NonSelectableComboBoxModel;
import components.PlaceholderRenderer;
import components.RoundButton;
import utils.AvailableFurnitures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import utils.FurnitureItem;
import utils.Model;

import static utils.ModelManager.models;


public class FurnitureDesign {

    JFrame f;
    ButtonGroup furnitureTypeGroup;

    private RoundButton imageLabel;
    private JLabel imgLb1;
    RoundButton imageLabel2;
    JLabel imgLb2;
    FurnitureItem item1;
    FurnitureItem item2;
    FurnitureItem selectedItem;
    String[] options;
    String[] sizeOptions;

    boolean onlyAddItem = false;
    JComboBox<String> materialMenu;
    JComboBox<String> sizeMenu;


    FurnitureDesign(boolean onlyAddItem) {
        this.onlyAddItem = onlyAddItem;
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
        title = new JLabel("FURNITURE DESIGN CREATION");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 450, 40);


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

        furnitureTypeGroup = new ButtonGroup();

        //CHAIR RADIO BUTTON
        JRadioButton chairRadioBtn = new JRadioButton("    Chair");
        chairRadioBtn.setBounds(20, 60, 260, 30);
        chairRadioBtn.setFocusPainted(false);
        chairRadioBtn.setForeground(Color.gray);
        chairRadioBtn.setBackground(Color.white);
        chairRadioBtn.setFont(chairRadioBtn.getFont().deriveFont(Font.PLAIN));
        chairRadioBtn.setSelected(true);

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

        // Add radio buttons to the ButtonGroup
        furnitureTypeGroup.add(chairRadioBtn);
        furnitureTypeGroup.add(tableRadioBtn);
        furnitureTypeGroup.add(wardrobeRadioBtn);

        chairRadioBtn.addActionListener(e ->{
            updateFurnitureVariantDisplay("chair");
            imgLb2.setForeground(Color.black);
            imgLb1.setForeground(Color.black);
            f.repaint();
        } );

        //TABLE RADIO BUTTON ActionListener
        tableRadioBtn.addActionListener(e -> {
            updateFurnitureVariantDisplay("table");
            imgLb2.setForeground(Color.black);
            imgLb1.setForeground(Color.black);
            f.repaint();
        });

        //WARDROBE RADIO BUTTON ActionListener
        wardrobeRadioBtn.addActionListener(e ->{
            updateFurnitureVariantDisplay("wardrobe");
            imgLb2.setForeground(Color.black);
            imgLb1.setForeground(Color.black);
            f.repaint();
        } );



        //ITEM TYPE LABEL
        JLabel itemMaterialLb;
        itemMaterialLb = new JLabel("FURNITURE MATERIAL");
        itemMaterialLb.setFont(newFont);
        itemMaterialLb.setForeground(new Color(27, 26, 85));
        itemMaterialLb.setBounds(20, 190, 260, 40);

        options = new String[]{};
        materialMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(options));
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

        sizeOptions = new String[]{};
       sizeMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(sizeOptions));
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
        imageLabel = new RoundButton("assets/chairs/chair.jpg",150,113);
        imageLabel.setBounds(15, 20, 150, 113);
        //IMAGE LABEL 1
        imgLb1= new JLabel("Chair 1",SwingConstants.CENTER);
        imgLb1.setBounds(15,133,150,30);
        item1 = AvailableFurnitures.items.get(0);
        imageLabel.addActionListener(e -> {
            selectedItem = item1;
            updateMaterialAndDimensionOptions(selectedItem);
            System.out.println("Clicked on Image Label 1: " + item1.getName());
            imgLb1.setForeground(Color.GRAY);
            imgLb2.setForeground(Color.black);
            f.repaint();
        });


        //IMAGE 2
        imageLabel2 = new RoundButton("assets/chairs/chair2.jpg",150,113);
        imageLabel2.setBounds(195, 20, 150, 113);
        //IMAGE LABEL 2
        imgLb2= new JLabel("Chair 2",SwingConstants.CENTER);
        imgLb2.setBounds(195,133,150,30);
        item2 = AvailableFurnitures.items.get(1);
        imageLabel2.addActionListener(e -> {
            selectedItem = item2;
            updateMaterialAndDimensionOptions(selectedItem);
            System.out.println("Clicked on Image Label 1: " + item2.getName());
            imgLb2.setForeground(Color.GRAY);
            imgLb1.setForeground(Color.black);
            f.repaint();
        });

        System.out.println(item1.getName());
        System.out.println(item2.getName());

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
                new Room2D();
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
                if (validateSelections()) {
                    System.out.println("color "+selectedItem.getColors().get(materialMenu.getSelectedIndex()));
                    System.out.println("dimensions "+selectedItem.getDimensions().get(sizeMenu.getSelectedIndex()));
                    models.add(loadObjModel(selectedItem.getMdlPath(),selectedItem.getName(),selectedItem.getColors().get(materialMenu.getSelectedIndex())));
                    if(onlyAddItem){
                        f.dispose();
                    }else{
                        new Room();
                    }

                }
            }
        });


        //3D DESIGN Button
        JButton addItemBtn = new JButton("Add Item");
        addItemBtn.setBounds(430,520,140,40);
        addItemBtn.setBackground(new Color(51,58,115));
        addItemBtn.setForeground(Color.white);
        addItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                models.add(loadObjModel(selectedItem.getMdlPath(),selectedItem.getName(),selectedItem.getColors().get(materialMenu.getSelectedIndex())));
                f.dispose();
            }
        });

        if(onlyAddItem){
            Btn3D.setVisible(false);
            Btn2D.setVisible(false);
            addItemBtn.setVisible(true);
        }else{
            addItemBtn.setVisible(false);
            Btn3D.setVisible(true);
            Btn2D.setVisible(true);
        }

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
        panel.add(addItemBtn);


        f.add(panelTop);
        f.add(leftPanel);
        f.add(rightPanel);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }
    private void updateFurnitureVariantDisplay(String type) {

        List<FurnitureItem> filteredItems = AvailableFurnitures.items.stream()
                .filter(item -> item.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());

        System.out.println(filteredItems);

        if (!filteredItems.isEmpty()) {
            item1 = filteredItems.get(0);
            item2 = filteredItems.get(1);

            System.out.println(item1.getImgPath());

            imageLabel.setImage(item1.getImgPath());
            imgLb1.setText(item1.getName());
            imageLabel.repaint();
            imgLb1.repaint();

            imageLabel2.setImage(item2.getImgPath());
            imgLb2.setText(item2.getName());
            imageLabel2.repaint();
            imgLb2.repaint();


            f.repaint();


        }
    }

    private void updateMaterialAndDimensionOptions(FurnitureItem selectedItem) {
        // Assuming you have a method to convert Color to a String name
        String[] materialOptions = selectedItem.getColors().stream()
                .map(color -> {
                    if (color.equals(new Color(218, 160, 109))) { // Example RGB for Light Brown
                        return "Color: Light Brown";
                    } else if (color.equals(new Color(78, 54, 54))) { // Example RGB for Dark Brown
                        return "Color: Dark Brown";
                    } else {
                        return "Color: " + color.toString(); // Fallback to RGB string
                    }
                })
                .toArray(String[]::new);
        materialMenu.setModel(new DefaultComboBoxModel<>(materialOptions));

        // Update dimension options based on the selected item's dimensions with units
        String[] dimensionOptions = selectedItem.getDimensions().stream()
                .map(dimension -> dimension + " cm") // Add " cm" as the unit
                .toArray(String[]::new);
        sizeMenu.setModel(new DefaultComboBoxModel<>(dimensionOptions));
    }

    private boolean validateSelections() {
        if (selectedItem == null) {
            JOptionPane.showMessageDialog(f, "Please select a furniture item.", "Selection Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (selectedItem.getColors() == null) {
            JOptionPane.showMessageDialog(f, "Please select a furniture item.", "Selection Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Check if a material is selected and not the placeholder
        if (materialMenu.getSelectedIndex() == -1) { // Assuming the first option is the placeholder
            JOptionPane.showMessageDialog(f, "Please select a furniture material.", "Selection Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Check if a dimension is selected and not the placeholder
        if (sizeMenu.getSelectedIndex() == -1) { // Assuming the first option is the placeholder
            JOptionPane.showMessageDialog(f, "Please select a dimension.", "Selection Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // All validations passed
        return true;
    }

    private Model loadObjModel(String filePath, String name, Color color) {
        Model model = new Model(name,color);
        List<float[]> vertices = new ArrayList<>();
        List<int[]> faces = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                // Process vertices
                if (line.startsWith("v ")) {
                    String[] coordinates = line.split("\\s+");
                    float x = Float.parseFloat(coordinates[1]);
                    float y = Float.parseFloat(coordinates[2]);
                    float z = Float.parseFloat(coordinates[3]);
                    vertices.add(new float[]{x, y, z});
                }
                // Process faces
                else if (line.startsWith("f ")) {
                    String[] faceIndices = line.split("\\s+");
                    int[] indices = new int[faceIndices.length - 1];
                    for (int i = 1; i < faceIndices.length; i++) {
                        // OBJ indices are 1-based; convert them to 0-based.
                        indices[i - 1] = Integer.parseInt(faceIndices[i].split("/")[0]) - 1;
                    }
                    faces.add(indices);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        model.setVertices(vertices);
        model.setFaces(faces);
        return model;
    }
}
