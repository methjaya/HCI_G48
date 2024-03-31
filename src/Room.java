import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P:
                System.out.println("CameraAngleX" + CameraAngleX);
                System.out.println("CameraAngleY" + CameraAngleY);
                System.out.println("camPosX" + camPosX);
                System.out.println("camPosY" + camPosY);
                System.out.println("camPosZ" + camPosZ);
                System.out.println("camLookX" + camLookX);
                System.out.println("camLookY" + camLookY);
                System.out.println("camLookZ" + camLookZ);
                System.out.println("camUpX" + camUpX);
                System.out.println("camUpY" + camUpY);
                System.out.println("camUpZ" + camUpZ);
                System.out.println("---------------------------------------------------------------------------");

                break;
            case KeyEvent.VK_W:
                posY += 0.01f;
                break;
            case KeyEvent.VK_S:
                posY -= 0.01f;
                break;
            case KeyEvent.VK_A:
                posX -= 0.01f;
                break;
            case KeyEvent.VK_D:
                posX += 0.01f;
                break;
            case KeyEvent.VK_Q:
                posZ += 0.1f;
                break;
            case KeyEvent.VK_E:
                posZ -= 0.1f;
                break;
            case KeyEvent.VK_LEFT:
                angleY -= 5.0f;
                break;
            case KeyEvent.VK_RIGHT:
                angleY += 5.0f;
                break;
            case KeyEvent.VK_UP:
                angleX -= 5.0f;
                break;
            case KeyEvent.VK_DOWN:
                angleX += 5.0f;
                break;
            case KeyEvent.VK_R:
                angleZ += 5.0f;
                break;
            case KeyEvent.VK_F:
                angleZ -= 5.0f;
                break;
            // Camera movement controls
            case KeyEvent.VK_I: // Move camera forward
                camPosZ -= 0.1f;
                break;
            case KeyEvent.VK_K: // Move camera backward
                camPosZ += 0.1f;
                break;
            case KeyEvent.VK_J: // Move camera left
                camPosX -= 0.5f;
                break;
            case KeyEvent.VK_L: // Move camera right
                camPosX += 0.5f;
                break;
            case KeyEvent.VK_U: // Move camera up
                camPosY += 0.5f;
                break;
            case KeyEvent.VK_O: // Move camera down
                camPosY -= 0.5f;
                break;
            case KeyEvent.VK_NUMPAD8: // Look up
                camLookY += 0.5f;
                break;
            case KeyEvent.VK_NUMPAD2: // Look down
                camLookY -= 0.5f;
                break;
            case KeyEvent.VK_NUMPAD4: // Look left
                camLookX -= 0.5f;
                break;
            case KeyEvent.VK_NUMPAD6: // Look right
                camLookX += 0.5f;
                break;
            case KeyEvent.VK_NUMPAD9: // Look closer (decrease Z)
                camLookZ -= 0.5f;
                break;
            case KeyEvent.VK_NUMPAD3: // Look further (increase Z)
                camLookZ += 0.5f;
                break;
            case KeyEvent.VK_NUMPAD7: // Tilt camera left
                camUpX -= 0.1f;
                break;
            case KeyEvent.VK_NUMPAD1: // Tilt camera right
                camUpX += 0.1f;
                break;
            case KeyEvent.VK_N: // Tilt camera left
                camUpY -= 0.1f;
                break;
            case KeyEvent.VK_M: // Tilt camera right
                camUpZ += 0.1f;
                break;
        }
        // Request repaint
        ((GLCanvas) getContentPane().getComponent(0)).display();
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
        setTitle("OBJ Model Viewer");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setSampleBuffers(true); // Request sample buffers
        capabilities.setNumSamples(8);

        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        canvas.addKeyListener(this);
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


        getContentPane().add(canvas);
        setVisible(true);

        // Load obj
        loadObjModel("resources/Objects/chair.obj");
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

    private void loadObjModel(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("v ")) {
                    String[] coordinates = line.split("\\s+");
                    // Check if coordinates array has the expected length before parsing
                    if (coordinates.length >= 4) {
                        try {
                            float x = Float.parseFloat(coordinates[1]);
                            float y = Float.parseFloat(coordinates[2]);
                            float z = Float.parseFloat(coordinates[3]);
                            vertices.add(new float[]{x, y, z});
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing vertex: " + line);
                            e.printStackTrace();
                        }
                    }
                } else if (line.startsWith("f ")) {
                    String[] faceIndices = line.split("\\s+");
                    // Check if faceIndices array has the expected length before processing
                    if (faceIndices.length > 1) {
                        int[] indices = new int[faceIndices.length - 1];
                        try {
                            for (int i = 1; i < faceIndices.length; i++) {
                                // Handle vertex/texture/normal indices (v/vt/vn) by splitting by "/"
                                String[] parts = faceIndices[i].split("/");
                                indices[i - 1] = Integer.parseInt(parts[0]);
                            }
                            faces.add(indices);
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing face: " + line);
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("Loaded model with " + vertices.size() + " vertices and " + faces.size() + " faces.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_MULTISAMPLE);
        gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST); // Enable depth test

        // Enable lighting
        gl.glEnable(GL2.GL_LIGHTING);
        // Enable a light source (GL_LIGHT0 as an example)
        gl.glEnable(GL2.GL_LIGHT0);


        try {
            // Load the texture for the floor
            floorTexture = TextureIO.newTexture(new File("resources/dark floor.jpg"), true);

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

        float constantAttenuation = 1.0f; // Constant factor (usually 1)
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

//        gl.glColor3f(0.5f, 0.5f, 0.5f);
        // Render the floor without object transformations
        drawFloor(gl);

        float red = 218 / 255.0f;
        float green = 160 / 255.0f;
        float blue = 109 / 255.0f;

        gl.glColor3f(red, green, blue);

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

        for (int[] face : faces) {
            gl.glBegin(GL2.GL_POLYGON);
//            gl.glColor3f(1f, 0f, 0f);
            for (int vertexIndex : face) {
                float[] v = vertices.get(vertexIndex - 1);
                gl.glVertex3f(v[0], v[1], v[2]);
            }
            gl.glEnd();
        }

        // Pop the matrix off the stack
        gl.glPopMatrix();
    }

//    private void setupCamera(GL2 gl) {
//        glu.gluLookAt(camPosX, camPosY, camPosZ,
//                camLookX, camLookY, camLookZ,
//                camUpX, camUpY, camUpZ);
//    }




    private void drawFloor(GL2 gl) {
        if (floorTexture != null) {
            floorTexture.enable(gl);
            floorTexture.bind(gl);
        }
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);


        gl.glColor3f(1f, 1f, 1f);


        float halfWidth = 1f ;
        float halfDepth =  1f ;
        float floorHeight = -0.11f;
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