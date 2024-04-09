import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import components.RoundButton;
import utils.Model;
import utils.ModelManager;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ModelManager.*;


public class Room extends JFrame implements GLEventListener, KeyListener {
    private GLU glu = new GLU();
    private float posX = 0.0f;
    private float posY = 0.0f;

    private float posZ = -1.0f; // Initial Z position


    private float angleX = 0.0f;
    private float angleY = 0.0f;
    private float angleZ = 0.0f;

    private float CameraAngleX = -9.700009f;
    private float CameraAngleY = -0.30000108f;

    private float camPosX = 0.0f;
    private float camPosY = 0.5f;
    private float camPosZ = -2.9999998f;

    private float camLookX = 0.0f;
    private float camLookY = -1.0f;
    private float camLookZ = -1.0f; // Looking along -Z initially

    private float camUpX = 0.0f;
    private float camUpY = 1.0f;
    private float camUpZ = 0.0f;

    private Texture floorTexture;
    JFrame f;
    GLCanvas canvas;
    JComboBox<Model> furnitureItemsMenu;


    @Override
    public void keyPressed(KeyEvent e) {
        if (selectedModelIndex < 0 || selectedModelIndex >= models.size()) return;
        Model selectedModel = models.get(selectedModelIndex);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                selectedModel.translate(0, 0, -2f); // Z-axis movement
                break;
            case KeyEvent.VK_S:
                selectedModel.translate(0, 0, 2f); // Z-axis movement
                break;
            case KeyEvent.VK_A:
                selectedModel.translate(-2f, 0, 0); // X-axis movement
                break;
            case KeyEvent.VK_D:
                selectedModel.translate(2f, 0, 0); // X-axis movement
                break;
            case KeyEvent.VK_1:
                selectedModel.translate(0, 1f, 0); // Y-axis movement (up/down)
                break;
            case KeyEvent.VK_2:
                selectedModel.translate(0, -1f, 0); // Y-axis movement (up/down)
                break;
            case KeyEvent.VK_Z:
                selectedModel.scale(1.1f); // Increase model size
                break;
            case KeyEvent.VK_X:
                selectedModel.scale(0.9f); // Decrease model size
                break;
//            case KeyEvent.VK_UP:
//                selectedModel.rotate(-5.0f, 0, 0); // Rotate model up
//                break;
//            case KeyEvent.VK_DOWN:
//                selectedModel.rotate(5.0f, 0, 0); // Rotate model down
//                break;
            case KeyEvent.VK_Q:
                selectedModel.rotate(0, -5.0f, 0); // Rotate model left
                break;
            case KeyEvent.VK_E:
                selectedModel.rotate(0, 5.0f, 0); // Rotate model right
                break;
            case KeyEvent.VK_UP: // Move camera forward
                camPosZ -= 0.1f;
                break;
            case KeyEvent.VK_DOWN: // Move camera backward
                camPosZ += 0.1f;
                break;
            case KeyEvent.VK_LEFT: // Move camera left
                camPosX -= 0.5f;
                break;
            case KeyEvent.VK_RIGHT: // Move camera right
                camPosX += 0.5f;
                break;
            case KeyEvent.VK_CONTROL: // Move camera up
                camPosY += 0.5f;
                break;
            case KeyEvent.VK_SHIFT: // Move camera down
                camPosY -= 0.5f;
                break;
        }
        canvas.repaint();
    }




    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    private List<float[]> vertices = new ArrayList<>();
    private List<int[]> faces = new ArrayList<>();

    public Room() {
        f = new JFrame();
        f.setTitle("3D Room");
        f.setSize(1100, 720);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null); // Using null layout for the frame

        //TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1100, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        //BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);

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
        title = new JLabel("3D VISUALIZATION");
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
        furnitureItemsLb.setBounds(25, 10, 250, 40);

        furnitureItemsMenu = new JComboBox<>();
        furnitureItemsMenu.setBounds(25, 50, 250, 30);
        furnitureItemsMenu.setBackground(Color.white);
        furnitureItemsMenu.setFont(new Font("Arial", Font.PLAIN, 12));
        furnitureItemsMenu.setForeground(Color.gray);
        furnitureItemsMenu.setBorder(BorderFactory.createEmptyBorder());
        for (Model model : models) {
            furnitureItemsMenu.addItem(model); // Assumes models have been added to the 'models' list
        }

        furnitureItemsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedModelIndex = furnitureItemsMenu.getSelectedIndex(); // Update the selected model index
            }
        });

        JButton addNewBtn = new JButton("Add New Item");
        addNewBtn.setBounds(25, 95, 130, 30);
        addNewBtn.setBackground(new Color(54, 48, 98));
        addNewBtn.setForeground(Color.white);
        addNewBtn.setFocusPainted(false);
        addNewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new FurnitureDesign(true);
            }
        });

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(190, 95, 80, 30);
        refreshBtn.setBackground(new Color(54, 48, 98));
        refreshBtn.setForeground(Color.white);
        refreshBtn.setFocusPainted(false);
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                furnitureItemsMenu.removeAllItems();
                for (Model model : models) {
                    furnitureItemsMenu.addItem(model); // Assumes models have been added to the 'models' list
                }
                canvas.repaint();
                f.repaint();
            }
        });

        //CONTROLS
        JLabel controlsLb;
        controlsLb = new JLabel("CONTROLS");
        controlsLb.setFont(newFont);
        controlsLb.setForeground(new Color(27, 26, 85));
        controlsLb.setBounds(25, 140, 250, 40);

        // ROTATE CAMERA
        JLabel rtCamLb = new JLabel("1", SwingConstants.CENTER);
        rtCamLb.setBounds(0, 0, 30, 30);
        JPanel rtCamPanel = new JPanel() {
            // Load the image to be drawn in this panel
            private ImageIcon imageIcon = new ImageIcon("assets/mouse.png");
            private Image image = imageIcon.getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                // Enable antialiasing for smoother edges
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                if (image != null) {
                    g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
                }
                g2d.dispose();

        };
        };

        rtCamPanel.setBounds(25, 190, 30, 30);
        rtCamPanel.setOpaque(false);
        rtCamPanel.add( rtCamLb);
        JLabel  rtCamTextLb = new JLabel("Rotate Camera");
        rtCamTextLb.setBounds(65, 190, 100, 30);

        // CAMERA FORWARD
        JLabel camFRWDLb = new JLabel("DWN", SwingConstants.CENTER);
        camFRWDLb.setFont(camFRWDLb.getFont().deriveFont(camFRWDLb.getFont().getSize() * 0.8f));
        camFRWDLb.setBounds(0, 0, 30, 30);
        JPanel  camFRWDPanel = new JPanel();
        camFRWDPanel.setBounds(160, 240, 30, 30); // Moved down by 100
        camFRWDPanel.setBackground(new Color(146, 144, 195, 100));
        camFRWDPanel.add(camFRWDLb);
        JLabel  camFRWDTextLb = new JLabel("Cam Backwards");
        camFRWDTextLb.setBounds(195, 240, 100, 30); // Moved down by 100

        // CAMERA BACK
        JLabel camBKLb = new JLabel("UP", SwingConstants.CENTER);
        camBKLb.setFont(camBKLb.getFont().deriveFont(camBKLb.getFont().getSize() * 0.8f));
        camBKLb.setBounds(0, 0, 30, 30);
        JPanel  camBKPanel = new JPanel();
        camBKPanel.setBounds(25, 240, 30, 30); // Moved down by 100
        camBKPanel.setBackground(new Color(146, 144, 195, 100));
        camBKPanel.add( camBKLb);
        JLabel  camBKTextLb = new JLabel("Close Cam");
        camBKTextLb.setBounds(65, 240, 100, 30); // Moved down by 100

        // SCALE UP
        JLabel scaleUpLb = new JLabel("Z", SwingConstants.CENTER);
        scaleUpLb.setBounds(0, 0, 30, 30);
        JPanel scaleUpPanel = new JPanel();
        scaleUpPanel.setBounds(25, 296, 30, 30); // Moved up by 5
        scaleUpPanel.setBackground(new Color(146, 144, 195, 100));
        scaleUpPanel.add(scaleUpLb);
        JLabel scaleUpTextLb = new JLabel("Scale Up", SwingConstants.CENTER);
        scaleUpTextLb.setBounds(65, 296, 50, 30); // Moved up by 5

        // SCALE DOWN
        JLabel scaleDwnLb = new JLabel("X", SwingConstants.CENTER);
        scaleDwnLb.setBounds(0, 0, 30, 30);
        JPanel scaleDwnPanel = new JPanel();
        scaleDwnPanel.setBounds(160, 296, 30, 30); // Moved up by 5
        scaleDwnPanel.setBackground(new Color(146, 144, 195, 100));
        scaleDwnPanel.add(scaleDwnLb);
        JLabel scaleDwnTextLb = new JLabel("Scale Down", SwingConstants.CENTER);
        scaleDwnTextLb.setBounds(195, 296, 80, 30); // Moved up by 5

        // ROTATE LEFT
        JLabel rotateLftLb = new JLabel("Q", SwingConstants.CENTER);
        rotateLftLb.setBounds(0, 0, 30, 30);
        JPanel rotateLftPanel = new JPanel();
        rotateLftPanel.setBounds(25, 350, 30, 30); // Moved up by 5
        rotateLftPanel.setBackground(new Color(146, 144, 195, 100));
        rotateLftPanel.add(rotateLftLb);
        JLabel rotateLftTextLb = new JLabel("Rotate Left", SwingConstants.CENTER);
        rotateLftTextLb.setBounds(60, 350, 80, 30); // Moved up by 5

// ROTATE RIGHT
        JLabel rotateRgtLb = new JLabel("E", SwingConstants.CENTER);
        rotateRgtLb.setBounds(0, 0, 30, 30);
        JPanel rotateRgtPanel = new JPanel();
        rotateRgtPanel.setBounds(160, 350, 30, 30); // Moved up by 5
        rotateRgtPanel.setBackground(new Color(146, 144, 195, 100));
        rotateRgtPanel.add(rotateRgtLb);
        JLabel rotateRgtTextLb = new JLabel("Rotate Right", SwingConstants.CENTER);
        rotateRgtTextLb.setBounds(195, 350, 80, 30); // Moved up by 5




        // Initialize JLabel and JPanel for MOVE UP
        JLabel mupLb = new JLabel("W", SwingConstants.CENTER);
        mupLb.setBounds(0, 0, 30, 30);
        JPanel moveUpPanel = new JPanel();
        moveUpPanel.setBounds(135, 430, 30, 30); // Moved up by 10
        moveUpPanel.setBackground(new Color(146, 144, 195, 100));
        moveUpPanel.add(mupLb);
        JLabel mupTextLb = new JLabel("Move Up", SwingConstants.CENTER);
        mupTextLb.setBounds(125, 400, 50, 30); // Moved up by 10

// Initialize JLabel and JPanel for MOVE DOWN
        JLabel mdnLb = new JLabel("S", SwingConstants.CENTER);
        mdnLb.setBounds(0, 0, 30, 30);
        JPanel moveDownPanel = new JPanel();
        moveDownPanel.setBounds(135, 480, 30, 30); // Moved up by 10
        moveDownPanel.setBackground(new Color(146, 144, 195, 100));
        moveDownPanel.add(mdnLb);
        JLabel mdwnTextLb = new JLabel("Move Down", SwingConstants.CENTER);
        mdwnTextLb.setBounds(110, 520, 80, 30); // Moved up by 10

// Initialize JLabel and JPanel for MOVE LEFT
        JLabel mlftnLb = new JLabel("A", SwingConstants.CENTER);
        mlftnLb.setBounds(0, 0, 30, 30);
        JPanel moveLeftPanel = new JPanel();
        moveLeftPanel.setBounds(85, 480, 30, 30); // Moved up by 10
        moveLeftPanel.setBackground(new Color(146, 144, 195, 100));
        moveLeftPanel.add(mlftnLb);
        JLabel mleftTextLb = new JLabel("Move Left", SwingConstants.CENTER);
        mleftTextLb.setBounds(5, 480, 80, 30); // Moved up by 10

// Initialize JLabel and JPanel for MOVE RIGHT
        JLabel mrgtnLb = new JLabel("D", SwingConstants.CENTER);
        mrgtnLb.setBounds(0, 0, 30, 30);
        JPanel moveRightPanel = new JPanel();
        moveRightPanel.setBounds(185, 480, 30, 30); // Moved up by 10
        moveRightPanel.setBackground(new Color(146, 144, 195, 100));
        moveRightPanel.add(mrgtnLb);
        JLabel mrgtTextLb = new JLabel("Move Right", SwingConstants.CENTER);
        mrgtTextLb.setBounds(215, 480, 80, 30); // Moved up by 10



        JButton fullScreenBtn = new JButton("Full-Screen View");
        fullScreenBtn.setBounds(20, 560, 130, 30); // Adjust position and size as needed
        fullScreenBtn.setBackground(new Color(54, 48, 98));
        fullScreenBtn.setForeground(Color.white);
        fullScreenBtn.setFocusPainted(false);

        fullScreenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame spaceFrame = new JFrame("3D Space");
                spaceFrame.setSize(800, 600);
                spaceFrame.setLocationRelativeTo(null);
                spaceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                GLProfile profile = GLProfile.get(GLProfile.GL2);
                GLCapabilities capabilities = new GLCapabilities(profile);
                capabilities.setSampleBuffers(true);
                capabilities.setNumSamples(8);

                GLCanvas newCanvas = new GLCanvas(capabilities);

                // Assuming Room.this refers to the current Room instance which implements GLEventListener
                newCanvas.addGLEventListener(Room.this);
                newCanvas.addKeyListener(Room.this); // Assuming Room class also implements KeyListener

                // Focus must be requestable for key events to be captured
                newCanvas.setFocusable(true);
                newCanvas.requestFocus();

                spaceFrame.getContentPane().add(newCanvas, BorderLayout.CENTER);
                spaceFrame.setVisible(true);

                // Important: Repaint the canvas to see the content
                newCanvas.display();
            }
        });




        // RIGHT PANEL
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBounds(300, 80, 800, 720);

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setSampleBuffers(true); // Request sample buffers
        capabilities.setNumSamples(8);

        canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        canvas.addKeyListener(this);
        canvas.setSize(800, 720);
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            private int lastX, lastY;

            @Override
            public void mouseMoved(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX() - lastX;
                int dy = e.getY() - lastY;

                // Update camera look direction based on mouse drag
                updateCameraLookDirection(dx, dy);

                lastX = e.getX();
                lastY = e.getY();

                canvas.display();
            }
        });

        canvas.setFocusTraversalKeysEnabled(false); // Ensure keys are not used for focus traversal


        rightPanel.add(canvas);

        leftPanel.add( refreshBtn);
        leftPanel.add(addNewBtn);
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
        leftPanel.add(rtCamPanel);
        leftPanel.add(rtCamTextLb);
        leftPanel.add(camFRWDPanel);
        leftPanel.add(camFRWDTextLb);
        leftPanel.add(camBKPanel);
        leftPanel.add(camBKTextLb);
        leftPanel.add(fullScreenBtn);


        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        f.add(panelTop);
        f.add(leftPanel);
        f.add(rightPanel);
        f.setVisible(true);

        canvas.requestFocusInWindow();

        // Load obj
//        loadObjModel("resources/Objects/chair.obj");

    }
    private void updateCameraLookDirection(int dx, int dy) {
        // Sensitivity factors for mouse movement
        float sensitivityX = 0.1f;
        float sensitivityY = 0.1f;

        CameraAngleY += dx * sensitivityX;
        CameraAngleX += dy * sensitivityY;
    }
    private void setupCamera(GL2 gl) {
        // Example distance
        float camDistance = 5.0f;
        float eyeX = camPosX + (float) Math.sin(Math.toRadians(CameraAngleY)) * camDistance;
        float eyeZ = camPosZ + (float) Math.cos(Math.toRadians(CameraAngleY)) * camDistance;
        float eyeY = camPosY + (float) Math.sin(Math.toRadians(-CameraAngleX)) * camDistance;

        glu.gluLookAt(eyeX, eyeY, eyeZ, camLookX, camLookY, camLookZ, camUpX, camUpY, camUpZ);
    }

//    private void loadObjModel(String filePath) {
//        try (Scanner scanner = new Scanner(new File(filePath))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine().trim();
//                if (line.startsWith("v ")) {
//                    String[] coordinates = line.split("\\s+");
//                    // Check if coordinates array has the expected length before parsing
//                    if (coordinates.length >= 4) {
//                        try {
//                            float x = Float.parseFloat(coordinates[1]);
//                            float y = Float.parseFloat(coordinates[2]);
//                            float z = Float.parseFloat(coordinates[3]);
//                            vertices.add(new float[]{x, y, z});
//                        } catch (NumberFormatException e) {
//                            System.err.println("Error parsing vertex: " + line);
//                            e.printStackTrace();
//                        }
//                    }
//                } else if (line.startsWith("f ")) {
//                    String[] faceIndices = line.split("\\s+");
//                    // Check if faceIndices array has the expected length before processing
//                    if (faceIndices.length > 1) {
//                        int[] indices = new int[faceIndices.length - 1];
//                        try {
//                            for (int i = 1; i < faceIndices.length; i++) {
//                                // Handle vertex/texture/normal indices (v/vt/vn) by splitting by "/"
//                                String[] parts = faceIndices[i].split("/");
//                                indices[i - 1] = Integer.parseInt(parts[0]);
//                            }
//                            faces.add(indices);
//                        } catch (NumberFormatException e) {
//                            System.err.println("Error parsing face: " + line);
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//            System.out.println("Loaded model with " + vertices.size() + " vertices and " + faces.size() + " faces.");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    private Model loadObjModel(String filePath,String name,Color color) {
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


    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_MULTISAMPLE);
        gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST); // Enable depth test

        // Enable lighting
        gl.glEnable(GL2.GL_LIGHTING);
        // Enable a light source
        gl.glEnable(GL2.GL_LIGHT0);



        try {
            // Load the texture for the floor
            floorTexture = TextureIO.newTexture(new File(ModelManager.floorMaterialPath), true);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Cleanup code here
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        // Reset transformations
        gl.glLoadIdentity();

        // Set up the camera (view transformation)
        setupCamera(gl);

        float constantAttenuation = 1.0f; // Constant factor
        float linearAttenuation = 0.05f; // Linear factor
        float quadraticAttenuation = 1.01f; // Quadratic factor

        gl.glLightf(GL2.GL_LIGHT0, GL2.GL_CONSTANT_ATTENUATION, constantAttenuation);
        gl.glLightf(GL2.GL_LIGHT0, GL2.GL_LINEAR_ATTENUATION, linearAttenuation);
        gl.glLightf(GL2.GL_LIGHT0, GL2.GL_QUADRATIC_ATTENUATION, quadraticAttenuation);

        float[] lightPos = {0.0f, 10.0f, 0.0f, 1.0f}; // Positional light
        float[] spotDirection = {0.0f, -1.0f, 0.0f}; // Pointing downward
        float spotCutoff = 8.0f; // Cutoff angle in degrees

        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightPos, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPOT_DIRECTION, spotDirection, 0);
        gl.glLightf(GL2.GL_LIGHT0, GL2.GL_SPOT_CUTOFF, spotCutoff);


        gl.glLightf(GL2.GL_LIGHT0, GL2.GL_SPOT_EXPONENT, 0.50f); // Focuses the spotlight


        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glColorMaterial(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE);

        // Render the floor without object transformations
        drawFloor(gl);


        // Push the current matrix onto the stack
        gl.glPushMatrix();

        // Apply transformations only to the object
        gl.glTranslatef(posX, posY, posZ);
        gl.glRotatef(angleX, 1.0f, 0.0f, 0.0f); // Rotate around X axis
        gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f); // Rotate around Y axis
        gl.glRotatef(angleZ, 0.0f, 0.0f, 1.0f); // Rotate around Z axis
        gl.glScalef(0.01f, 0.01f, 0.01f);


//        gl.glScalef(12.0f, 12.0f, 12.0f);
        gl.glNormal3f(0.0f, 1.0f, 0.0f);

        for (Model model : models) {
            float[] color = model.getColor();
            gl.glColor3f(color[0], color[1], color[2]);
            gl.glPushMatrix();

            // Apply model transformations
            gl.glTranslatef(model.getPosX(), model.getPosY(), model.getPosZ());
            gl.glRotatef(model.getRotX(), 1.0f, 0.0f, 0.0f);
            gl.glRotatef(model.getRotY(), 0.0f, 1.0f, 0.0f);
            gl.glRotatef(model.getRotZ(), 0.0f, 0.0f, 1.0f);
            gl.glScalef(model.getScale(), model.getScale(), model.getScale());

            // Render the model
            for (int[] face : model.getFaces()) {
                gl.glBegin(GL2.GL_POLYGON); // Or GL2.GL_TRIANGLES, depending on your model
                for (int vertexIndex : face) {
                    float[] v = model.getVertices().get(vertexIndex);
                    gl.glVertex3f(v[0], v[1], v[2]);
                }
                gl.glEnd();
            }

            gl.glPopMatrix();
        }

        // Pop the matrix off the stack
        gl.glPopMatrix();
    }

    private void drawFloor(GL2 gl) {
        if (floorTexture != null) {
            floorTexture.enable(gl);
            floorTexture.bind(gl);
        }
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);


        gl.glColor3f(1f, 1f, 1f);


        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        // Start drawing the floor quad
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-halfWidth, floorHeight, -halfDepth);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-halfWidth, floorHeight, halfDepth);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(halfWidth, floorHeight, halfDepth);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(halfWidth, floorHeight, -halfDepth);
        gl.glEnd();

        if (floorTexture != null) {
            floorTexture.disable(gl);
        }
    }


    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();

        if (height <= 0) height = 1; // avoid division by zero
        float aspect = (float) width / height;

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Apply perspective projection
        glu.gluPerspective(45.0, aspect, 0.1, 100.0);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}