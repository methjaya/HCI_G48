import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;


public class RoomConfiguration {


    JFrame f;

    RoomConfiguration() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 800);

        //TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        //BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);

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


        //ROOM SIZE LABEL
        JLabel roomSizeLb;
        roomSizeLb = new JLabel("ROOM SIZE");
        roomSizeLb.setFont(newFont);
        roomSizeLb.setForeground(new Color(27, 26, 85));
        roomSizeLb.setBounds(50, 25, 200, 40);
        //TEXT FIELD LENGTH
        JPlaceholderTextField lenTf = new JPlaceholderTextField("Length", 10);
        lenTf.setBounds(50, 70, 300, 30);
        lenTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //TEXT FIELD WIDTH
        JPlaceholderTextField widthTf = new JPlaceholderTextField("Width", 10);
        widthTf.setBounds(50, 110, 300, 30);
        widthTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //TEXT FIELD HEIGHT
        JPlaceholderTextField heightTf = new JPlaceholderTextField("Height", 10);
        heightTf.setBounds(50, 150, 300, 30);
        heightTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //ROOM SHAPE LABEL
        JLabel roomShapeLb;
        roomShapeLb = new JLabel("ROOM SHAPE");
        roomShapeLb.setFont(newFont);
        roomShapeLb.setForeground(new Color(27, 26, 85));
        roomShapeLb.setBounds(50, 190, 200, 40);
        //RADIO BUTTON SQUARE
        JRadioButton sqrRadioBtn = new JRadioButton("    Square");
        sqrRadioBtn.setBounds(50, 235, 300, 30);
        sqrRadioBtn.setFocusPainted(false);
        sqrRadioBtn.setForeground(Color.gray);
        sqrRadioBtn.setBackground(Color.white);
        sqrRadioBtn.setFont(sqrRadioBtn.getFont().deriveFont(Font.PLAIN));
        //RADIO BUTTON RECTANGULAR
        JRadioButton rectRadioBtn = new JRadioButton("    Rectangular");
        rectRadioBtn.setBounds(50, 275, 300, 30);
        rectRadioBtn.setFocusPainted(false);
        rectRadioBtn.setForeground(Color.gray);
        rectRadioBtn.setBackground(Color.white);
        rectRadioBtn.setFont(rectRadioBtn.getFont().deriveFont(Font.PLAIN));

        //WALL COLOR LABEL
        JLabel wallColorLb;
        wallColorLb = new JLabel("WALL COLOR");
        wallColorLb.setFont(newFont);
        wallColorLb.setForeground(new Color(27, 26, 85));
        wallColorLb.setBounds(50, 315, 200, 40);

        JButton colorPickerButton = new JButton("Pick a Color");
        colorPickerButton.setBackground(Color.white);
        colorPickerButton.setBounds(50, 360, 250, 30);
        colorPickerButton.setForeground(Color.gray);
        colorPickerButton.setFont(colorPickerButton.getFont().deriveFont(Font.PLAIN));
        colorPickerButton.setFocusPainted(false);
        //COLOR PANEL
        JPanel colorDisplayPanel = new JPanel();
        colorDisplayPanel.setBounds(320,360,30,30);
        colorDisplayPanel.setBackground(Color.white);
        colorPickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the color chooser dialog when the button is clicked
                Color selectedColor = JColorChooser.showDialog(f, "Choose a Color", Color.WHITE);
                if (selectedColor != null) {
                    // Perform actions with the selected color (e.g., set background color of a component)
                    System.out.println(selectedColor);
                    colorDisplayPanel.setBackground(selectedColor);
                }
            }
        });

        //FLOOR MATERIAL
        JLabel floorMaterialLb;
        floorMaterialLb = new JLabel("FLOOR MATERIAL");
        floorMaterialLb.setFont(newFont);
        floorMaterialLb.setForeground(new Color(27, 26, 85));
        floorMaterialLb.setBounds(50, 400, 200, 40);

        JPanel materialColorDisplayPanel = new JPanel();
        JButton materialColorPickerButton = new JButton("Pick The Floor Color");
        String[] options = {"  Select Floor Material","  Option 1", "  Option 2", "  Option 3"};
        JComboBox<String> floorMaterialsMenu = new JComboBox<>(new NonSelectableComboBoxModel<>(options));
        floorMaterialsMenu.setRenderer(new PlaceholderRenderer("  Select Floor Material"));
        floorMaterialsMenu.setBounds(50, 450, 200, 30);
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
        orLb.setBounds(275,450,50,30);

        //FLOOR COLOR PICKER
        materialColorPickerButton.setBackground(Color.white);
        materialColorPickerButton.setBounds(50, 490, 250, 30);
        materialColorPickerButton.setForeground(Color.gray);
        materialColorPickerButton.setFont(materialColorPickerButton.getFont().deriveFont(Font.PLAIN));
        materialColorPickerButton.setFocusPainted(false);
        //COLOR PANEL
        materialColorDisplayPanel.setBounds(320,490,30,30);
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





        //GO BUTTON
        JButton goBtn = new JButton("GO >");
        goBtn.setBounds(165, 550, 70, 30);
        goBtn.setBackground(new Color(54, 48, 98));
        goBtn.setForeground(Color.white);
        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f.dispose();
                    // Open the home page window
                    new Profile();
                } catch (Exception err) {
//                        output.setText("Error");
                }

            }
        });



        panelTop.add(title);
        panelTop.add(backButton);
        centerPanel.add(goBtn);
        centerPanel.add(roomSizeLb);
        centerPanel.add(lenTf);
        centerPanel.add(widthTf);
        centerPanel.add(heightTf);
        centerPanel.add(roomShapeLb);
        centerPanel.add(sqrRadioBtn);
        centerPanel.add(rectRadioBtn);
        centerPanel.add(wallColorLb);
        centerPanel.add(colorPickerButton);
        centerPanel.add(colorDisplayPanel);
        centerPanel.add(floorMaterialLb);
        centerPanel.add(floorMaterialsMenu);
        centerPanel.add(orLb);
        centerPanel.add(materialColorPickerButton);
        centerPanel.add(materialColorDisplayPanel);
        f.add(panelTop);
        f.add(centerPanel);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static class RoundButton extends JButton {
        private BufferedImage image;
        int width = 0;
        int height = 0;

        public RoundButton(String imagePath, int width, int height) {
            this.height=height;
            this.width=width;
            try {
                this.image = ImageIO.read(new File(imagePath));
            } catch (IOException ex) {
                System.out.println("Error loading image: " + ex.getMessage());
            }
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setPreferredSize(new Dimension(width, height)); // Set the preferred size
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
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
    // Custom renderer to render the placeholder text differently
    static class PlaceholderRenderer extends DefaultListCellRenderer {
        private String placeholder;

        public PlaceholderRenderer(String placeholder) {
            this.placeholder = placeholder;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null && value.equals(placeholder)) {
                setForeground(Color.GRAY);
                setFont(getFont().deriveFont(Font.ITALIC));
            }
            return this;
        }
    }

    // Custom ComboBoxModel to prevent selection of placeholder item
    static class NonSelectableComboBoxModel<E> extends DefaultComboBoxModel<E> {
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


}