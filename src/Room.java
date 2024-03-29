import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Room extends JFrame implements GLEventListener, KeyListener {
    private float posX = 0.0f;
    private float posY = 0.0f;
    private float posZ = -44.0f; // Initial Z position

    private float angleX = 0.0f;
    private float angleY = 0.0f;
    private float angleZ = 0.0f;


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                posY += 0.5f;
                break;
            case KeyEvent.VK_S:
                posY -= 0.5f;
                break;
            case KeyEvent.VK_A:
                posX -= 0.5f;
                break;
            case KeyEvent.VK_D:
                posX += 0.5f;
                break;
            case KeyEvent.VK_Q:
                posZ += 0.5f;
                break;
            case KeyEvent.VK_E:
                posZ -= 0.5f;
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
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        canvas.addKeyListener(this);
        canvas.setFocusTraversalKeysEnabled(false); // Ensure keys are not used for focus traversal


        getContentPane().add(canvas);
        setVisible(true);

        // Load your .obj file
        loadObjModel("resources/Objects/chair.obj");
    }

    private void loadObjModel(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // Trim the line to remove leading/trailing whitespace
                if (line.startsWith("v ")) {
                    String[] coordinates = line.split("\\s+"); // Split by one or more whitespace characters
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
        gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST); // Enable depth test
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Cleanup code here
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        // Adjust based on position variables
        gl.glTranslatef(posX, posY, posZ);

        // Apply rotations
        gl.glRotatef(angleX, 1.0f, 0.0f, 0.0f); // Rotate around X axis
        gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f); // Rotate around Y axis
        gl.glRotatef(angleZ, 0.0f, 0.0f, 1.0f); // Rotate around Z axis

        gl.glScalef(0.01f, 0.01f, 0.01f);

        for (int[] face : faces) {
            gl.glBegin(GL2.GL_POLYGON);
            for (int vertexIndex : face) {
                float[] v = vertices.get(vertexIndex - 1);
                gl.glVertex3f(v[0], v[1], v[2]);
            }
            gl.glEnd();
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