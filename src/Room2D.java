import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;



class Room2D extends JFrame implements GLEventListener {

    private GLU glu = new GLU();
    private List<FurnitureItem> furnitureItems = new ArrayList<>();
    private FurnitureItem selectedItem = null;

    public Room2D() {
        JFrame f = new JFrame();
        f.setTitle("2D Room");
        f.setSize(1100, 720);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        //TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1100, 80);
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
        userImage.setBounds(970, 20, 40, 40);
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
        usernameLb.setBounds(1020,25,50,30);
        usernameLb.setFont(usernameLb.getFont().deriveFont(usernameLb.getFont().getSize() * 1.3f));
        usernameLb.setForeground(Color.white);

        //TITLE
        JLabel title;
        title = new JLabel("2D VISUALIZATION");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        // LEFT PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 80, 300, 720);
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.WHITE);

        //FURNITURE ITEMS MENU
        JLabel furnitureItemsLb;
        furnitureItemsLb = new JLabel("SELECT FURNITURE ITEM");
        furnitureItemsLb.setFont(newFont);
        furnitureItemsLb.setForeground(new Color(27, 26, 85));
        furnitureItemsLb.setBounds(25, 30, 250, 40);


        JComboBox<FurnitureItem> furnitureItemsMenu = new JComboBox<>();
        furnitureItemsMenu.setBounds(25, 70, 250, 30);
        furnitureItemsMenu.setBackground(Color.white);
        furnitureItemsMenu.setFont(new Font("Arial", Font.PLAIN, 12));
        furnitureItemsMenu.setForeground(Color.gray);
        furnitureItemsMenu.setBorder(BorderFactory.createEmptyBorder());

        furnitureItemsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the selectedItem to the one selected in the dropdown
                selectedItem = (FurnitureItem) furnitureItemsMenu.getSelectedItem();
            }
        });

        //CONTROLS
        JLabel controlsLb;
        controlsLb = new JLabel("CONTROLS");
        controlsLb.setFont(newFont);
        controlsLb.setForeground(new Color(27, 26, 85));
        controlsLb.setBounds(25, 140, 250, 40);

        // ADD CHAIR
        JLabel addChairLb = new JLabel("1", SwingConstants.CENTER);
        addChairLb.setBounds(0, 0, 30, 30);
        JPanel  addChairPanel = new JPanel();
        addChairPanel.setBounds(25, 190, 30, 30); // Moved down by 100
        addChairPanel.setBackground(new Color(146, 144, 195, 100));
        addChairPanel.add( addChairLb);
        JLabel  addChairTextLb = new JLabel("Add Chair");
        addChairTextLb.setBounds(65, 190, 100, 30); // Moved down by 100

        // ADD TABLE
        JLabel addTableLb = new JLabel("2", SwingConstants.CENTER);
        addTableLb.setBounds(0, 0, 30, 30);
        JPanel  addTablePanel = new JPanel();
        addTablePanel.setBounds(170, 190, 30, 30); // Moved down by 100
        addTablePanel.setBackground(new Color(146, 144, 195, 100));
        addTablePanel.add(addTableLb);
        JLabel  addTableTextLb = new JLabel("Add Table");
        addTableTextLb.setBounds(210, 190, 100, 30); // Moved down by 100

        // ADD WARDROBE
        JLabel addWardrobeLb = new JLabel("3", SwingConstants.CENTER);
        addWardrobeLb.setBounds(0, 0, 30, 30);
        JPanel  addWardrobePanel = new JPanel();
        addWardrobePanel.setBounds(25, 240, 30, 30); // Moved down by 100
        addWardrobePanel.setBackground(new Color(146, 144, 195, 100));
        addWardrobePanel.add( addWardrobeLb);
        JLabel  addWardrobeTextLb = new JLabel("Add Wardrobe");
        addWardrobeTextLb.setBounds(65, 240, 100, 30); // Moved down by 100

        // SCALE UP
        JLabel scaleUpLb = new JLabel("Z", SwingConstants.CENTER);
        scaleUpLb.setBounds(0, 0, 30, 30);
        JPanel scaleUpPanel = new JPanel();
        scaleUpPanel.setBounds(25, 305, 30, 30); // Moved down by 5
        scaleUpPanel.setBackground(new Color(146, 144, 195, 100));
        scaleUpPanel.add(scaleUpLb);
        JLabel scaleUpTextLb = new JLabel("Scale Up", SwingConstants.CENTER);
        scaleUpTextLb.setBounds(65, 305, 50, 30); // Moved down by 5

        // SCALE DOWN
        JLabel scaleDwnLb = new JLabel("X", SwingConstants.CENTER);
        scaleDwnLb.setBounds(0, 0, 30, 30);
        JPanel scaleDwnPanel = new JPanel();
        scaleDwnPanel.setBounds(160, 305, 30, 30); // Moved down by 5
        scaleDwnPanel.setBackground(new Color(146, 144, 195, 100));
        scaleDwnPanel.add(scaleDwnLb);
        JLabel scaleDwnTextLb = new JLabel("Scale Down", SwingConstants.CENTER);
        scaleDwnTextLb.setBounds(195, 305, 80, 30); // Moved down by 5

        // ROTATE LEFT
        JLabel rotateLftLb = new JLabel("Q", SwingConstants.CENTER);
        rotateLftLb.setBounds(0, 0, 30, 30);
        JPanel rotateLftPanel = new JPanel();
        rotateLftPanel.setBounds(25, 355, 30, 30); // Moved down by 5
        rotateLftPanel.setBackground(new Color(146, 144, 195, 100));
        rotateLftPanel.add(rotateLftLb);
        JLabel rotateLftTextLb = new JLabel("Rotate Left", SwingConstants.CENTER);
        rotateLftTextLb.setBounds(60, 355, 80, 30); // Moved down by 5

        // ROTATE RIGHT
        JLabel rotateRgtLb = new JLabel("E", SwingConstants.CENTER);
        rotateRgtLb.setBounds(0, 0, 30, 30);
        JPanel rotateRgtPanel = new JPanel();
        rotateRgtPanel.setBounds(160, 355, 30, 30); // Moved down by 5
        rotateRgtPanel.setBackground(new Color(146, 144, 195, 100));
        rotateRgtPanel.add(rotateRgtLb);
        JLabel rotateRgtTextLb = new JLabel("Rotate Right", SwingConstants.CENTER);
        rotateRgtTextLb.setBounds(195, 355, 80, 30); // Moved down by 5



        //MOVE UP
        JLabel mupLb = new JLabel("W", SwingConstants.CENTER);
        mupLb.setBounds(0, 0, 30, 30);
        JPanel moveUpPanel = new JPanel();
        moveUpPanel.setBounds(135, 440, 30, 30); // Moved down by 20
        moveUpPanel.setBackground(new Color(146, 144, 195, 100));
        moveUpPanel.add(mupLb);
        JLabel mupTextLb = new JLabel("Move Up", SwingConstants.CENTER);
        mupTextLb.setBounds(125, 410, 50, 30); // Moved down by 20

        //MOVE DOWN
        JLabel mdnLb = new JLabel("S", SwingConstants.CENTER);
        mdnLb.setBounds(0, 0, 30, 30);
        JPanel moveDownPanel = new JPanel();
        moveDownPanel.setBounds(135, 490, 30, 30); // Moved down by 20
        moveDownPanel.setBackground(new Color(146, 144, 195, 100));
        moveDownPanel.add(mdnLb);
        JLabel mdwnTextLb = new JLabel("Move Down", SwingConstants.CENTER);
        mdwnTextLb.setBounds(110, 530, 80, 30); // Moved down by 20

        // MOVE LEFT
        JLabel mlftnLb = new JLabel("A", SwingConstants.CENTER);
        mlftnLb.setBounds(0, 0, 30, 30);
        JPanel moveLeftPanel = new JPanel();
        moveLeftPanel.setBounds(85, 490, 30, 30); // Moved down by 20
        moveLeftPanel.setBackground(new Color(146, 144, 195, 100));
        moveLeftPanel.add(mlftnLb);
        JLabel mleftTextLb = new JLabel("Move Left", SwingConstants.CENTER);
        mleftTextLb.setBounds(5, 490, 80, 30); // Moved down by 20

        // MOVE RIGHT
        JLabel mrgtnLb = new JLabel("D", SwingConstants.CENTER);
        mrgtnLb.setBounds(0, 0, 30, 30);
        JPanel moveRightPanel = new JPanel();
        moveRightPanel.setBounds(185, 490, 30, 30); // Moved down by 20
        moveRightPanel.setBackground(new Color(146, 144, 195, 100));
        moveRightPanel.add(mrgtnLb);
        JLabel mrgtTextLb = new JLabel("Move Right", SwingConstants.CENTER);
        mrgtTextLb.setBounds(215, 490, 80, 30); // Moved down by 20





        // RIGHT PANEL
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBounds(300, 80, 800, 720);

        // GLCanvas for the 2D view
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        capabilities.setSampleBuffers(true);
        capabilities.setNumSamples(4);

        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        canvas.setSize(800, 720);

        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1: // Add chair
                        FurnitureItem chair = new FurnitureItem(0.0f, 0.0f, "chair");
                        furnitureItems.add(chair);
                        furnitureItemsMenu.addItem(chair);
                        selectedItem = chair;
                        break;
                    case KeyEvent.VK_2: // Add table
                        FurnitureItem table = new FurnitureItem(0.1f, 0.1f, "table");
                        furnitureItems.add(table);
                        furnitureItemsMenu.addItem(table);
                        selectedItem = table;
                        break;
                    case KeyEvent.VK_3: // Add wardrobe
                        FurnitureItem wardrobe = new FurnitureItem(-0.1f, -0.1f, "wardrobe");
                        furnitureItems.add(wardrobe);
                        furnitureItemsMenu.addItem(wardrobe);
                        selectedItem = wardrobe;
                        break;
                }
//                furnitureItemsMenu.setSelectedItem(null); // Reset selection or set to the newly added item
                canvas.repaint();
            }
        });

        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (selectedItem != null) { // Only move if an item is selected
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_A:
                            selectedItem.posX -= 0.02f;
                            break;
                        case KeyEvent.VK_D:
                            selectedItem.posX += 0.02f;
                            break;
                        case KeyEvent.VK_W:
                            selectedItem.posY += 0.02f;
                            break;
                        case KeyEvent.VK_S:
                            selectedItem.posY -= 0.02f;
                            break;
                        case KeyEvent.VK_Z:
                            selectedItem.scale(1.1f); // Scale up
                            break;
                        case KeyEvent.VK_X:
                            selectedItem.scale(0.9f); // Scale down
                            break;
                        case KeyEvent.VK_E:
                            selectedItem.rotate(5); // Rotate right
                            break;
                        case KeyEvent.VK_Q:
                            selectedItem.rotate(-5); // Rotate left
                            break;
                    }
                    canvas.repaint();
                }
            }
        });

        rightPanel.add(canvas);

        leftPanel.add(furnitureItemsLb);
        leftPanel.add(furnitureItemsMenu);
        leftPanel.add(controlsLb);
        leftPanel.add(moveUpPanel);
        leftPanel.add(moveDownPanel);
        leftPanel.add(moveLeftPanel);
        leftPanel.add(moveRightPanel);
        leftPanel.add(mupTextLb);
        leftPanel.add(mdwnTextLb);
        leftPanel.add(mleftTextLb);
        leftPanel.add(mrgtTextLb);
        leftPanel.add(scaleUpPanel);
        leftPanel.add(scaleUpTextLb);
        leftPanel.add(scaleDwnTextLb);
        leftPanel.add(scaleDwnPanel);
        leftPanel.add(rotateLftPanel);
        leftPanel.add(rotateLftTextLb);
        leftPanel.add(rotateRgtPanel);
        leftPanel.add(rotateRgtTextLb);
        leftPanel.add(addChairPanel);
        leftPanel.add(addChairTextLb);
        leftPanel.add(addTableTextLb);
        leftPanel.add(addTablePanel);
        leftPanel.add(addWardrobeTextLb);
        leftPanel.add(addWardrobePanel);


        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        f.add(panelTop);
        f.add(leftPanel);
        f.add(rightPanel);
        f.setVisible(true);

        canvas.requestFocusInWindow();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        // Enable multisampling
        gl.glEnable(GL2.GL_MULTISAMPLE);
        gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-1.0, 1.0, -1.0, 1.0);

        for (FurnitureItem item : furnitureItems) {
            drawItem(gl, item);
        }
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    private void drawItem(GL2 gl, FurnitureItem item) {
        gl.glPushMatrix();
        gl.glTranslatef(item.posX, item.posY, 0);
        gl.glScalef(item.scale, item.scale, 1.0f);
        gl.glRotatef(item.angle, 0.0f, 0.0f, 1.0f);

        switch (item.type) {
            case "chair":
                drawChair(gl,item.posX,item.posY);
                break;
            case "table":
                drawTable(gl,item.posX,item.posY);
                break;
            case "wardrobe":
                drawWardrobe(gl,item.posX,item.posY);
                break;
        }

        gl.glPopMatrix();
    }

    private void drawChair(GL2 gl, float posX, float posY) {
        gl.glPushMatrix();
        gl.glTranslatef(posX, posY, 0);

        gl.glScalef(0.05f, 0.05f, 0.05f);

        // SEAT
        gl.glColor3f(0.5f, 0.35f, 0.05f); // Brown color for the seat
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(1f, 1f);
        gl.glVertex2f(1f, -3f);
        gl.glVertex2f(-2f, -2f);
        gl.glVertex2f(-2f, 0f);
        gl.glEnd();

        gl.glColor3f(0.5f, 0.35f, 0.05f); // Brown color for the seat
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-3.5f, 1f);
        gl.glVertex2f(-3, 1f);
        gl.glVertex2f(-3f, -3f);
        gl.glVertex2f(-3.5f, -3f);
        gl.glEnd();

        gl.glColor3f(0.5f, 0.35f, 0.05f); // Brown color for the seat
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-3f, 0.25f);
        gl.glVertex2f(-2, -0.25f);
        gl.glVertex2f(-2f, -0.5f);
        gl.glVertex2f(-3f, 0f);
        gl.glEnd();

        gl.glColor3f(0.5f, 0.35f, 0.05f); // Brown color for the seat
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-3f, -0.75f);
        gl.glVertex2f(-2, -0.75f);
        gl.glVertex2f(-2f, -1f);
        gl.glVertex2f(-3f, -1f);
        gl.glEnd();

        gl.glColor3f(0.5f, 0.35f, 0.05f); // Brown color for the seat
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-3f, -1.75f);
        gl.glVertex2f(-2, -1.50f);
        gl.glVertex2f(-2f, -1.75f);
        gl.glVertex2f(-3f, -2f);
        gl.glEnd();

        gl.glPopMatrix();
    }
    private void drawTable(GL2 gl, float posX, float posY) {
        gl.glPushMatrix();
        gl.glTranslatef(posX, posY, 0);

        float tableLength = 1.0f;
        float tableWidth = 0.6f;

        // Draw the table rectangle
        gl.glColor3f(0.3607843137f, 0.2509803922f, 0.2f); // Brown color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-tableWidth / 2, -tableLength / 2);
        gl.glVertex2f(tableWidth / 2, -tableLength / 2);
        gl.glVertex2f(tableWidth / 2, tableLength / 2);
        gl.glVertex2f(-tableWidth / 2, tableLength / 2);
        gl.glEnd();

        gl.glPopMatrix();
    }




    private void drawWardrobe(GL2 gl, float posX, float posY) {
        gl.glPushMatrix();
        gl.glTranslatef(posX, posY, 0);

        float wardrobeWidth = 0.75f;
        float wardrobeDepth = 0.3f;
        float doorWidth = wardrobeWidth / 2;

        // Draw the top of the wardrobe
        gl.glColor3f(0.4f, 0.2f, 0.0f); // Brown color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-wardrobeWidth / 2, -wardrobeDepth / 2);
        gl.glVertex2f(wardrobeWidth / 2, -wardrobeDepth / 2);
        gl.glVertex2f(wardrobeWidth / 2, wardrobeDepth / 2);
        gl.glVertex2f(-wardrobeWidth / 2, wardrobeDepth / 2);
        gl.glEnd();


        gl.glColor3f(0.5f, 0.25f, 0.0f); // Slightly lighter color
        // Left door
        gl.glBegin(GL2.GL_LINE_LOOP);
        gl.glVertex2f(-wardrobeWidth / 2, -wardrobeDepth / 2);
        gl.glVertex2f(-wardrobeWidth / 2 + doorWidth, -wardrobeDepth / 2);
        gl.glVertex2f(-wardrobeWidth / 2 + doorWidth, wardrobeDepth / 2);
        gl.glVertex2f(-wardrobeWidth / 2, wardrobeDepth / 2);
        gl.glEnd();

        // Right door
        gl.glBegin(GL2.GL_LINE_LOOP);
        gl.glVertex2f(0, -wardrobeDepth / 2);
        gl.glVertex2f(wardrobeWidth / 2, -wardrobeDepth / 2);
        gl.glVertex2f(wardrobeWidth / 2, wardrobeDepth / 2);
        gl.glVertex2f(0, wardrobeDepth / 2);
        gl.glEnd();
    }}

class FurnitureItem {
    float posX, posY;
    String type;

    String name;
    float scale = 1.0f;
    float angle = 0.0f; // Angle in degrees
    static int chairCount = 0, tableCount = 0, wardrobeCount = 0;

    // Constructor
    FurnitureItem(float posX, float posY, String type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
        this.name = getNextName(type);
    }

    void scale(float factor) {
        scale *= factor;
    }

    void rotate(float angleDelta) {
        angle += angleDelta;
    }

    private String getNextName(String baseType) {
        switch (baseType) {
            case "chair":
                return baseType + " " + (++chairCount);
            case "table":
                return baseType + " " + (++tableCount);
            case "wardrobe":
                return baseType + " " + (++wardrobeCount);
            default:
                return baseType;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}


