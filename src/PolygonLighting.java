//import com.jogamp.opengl.*;
//import com.jogamp.opengl.awt.GLCanvas;
//
//import javax.swing.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        final GLProfile gp = GLProfile.get(GLProfile.GL2);
//        GLCapabilities cap = new GLCapabilities(gp);
//
//        final GLCanvas gc = new GLCanvas(cap);
//
//        Square sq = new Square();
//
//        gc.addGLEventListener(sq);
//        gc.setSize(400, 400); // give the canvas size
//
//        final JFrame frame = new JFrame("OpenGL using Java - Line");
//
//        frame.add(gc);
//        frame.setSize(500,400); // set the visibility of the frame
//        frame.setVisible(true);
//    }
//
//    public static class Square implements GLEventListener {
//
//        @Override
//        public void init(GLAutoDrawable glAutoDrawable) {
//
//        }
//
//        @Override
//        public void dispose(GLAutoDrawable glAutoDrawable) {
//
//        }
//
//        @Override
//        public void display(GLAutoDrawable glAutoDrawable) {
//            final GL2 gl = glAutoDrawable.getGL().getGL2();

////Drawing top edge
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4, 0.4);
//            gl.glVertex2d(0.4, 0.4);
//            gl.glEnd();
////Drawing bottom edge
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4,-0.4);
//            gl.glVertex2d(0.4, -0.4);
//            gl.glEnd();
////Drawing right edge
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4, 0.4);
//            gl.glVertex2d(-0.4, -0.4);
//            gl.glEnd();
////Drawing left edge
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(0.4, 0.4);
//            gl.glVertex2d(0.4, -0.4);
//            gl.glEnd();

//
//
//
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4, 0.3);
//            gl.glVertex2d(0.4, 0.3);
//            gl.glEnd();
//
//
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4, 0.3);
//            gl.glVertex2d(0.0, 0.6);
//            gl.glEnd();
//
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(0.0, 0.6);
//            gl.glVertex2d(0.4, 0.3);
//            gl.glEnd();
//
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4, 0.3);
//            gl.glVertex2d(-0.4, -0.3);
//            gl.glEnd();
//
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(-0.4, -0.3);
//            gl.glVertex2d(0.4, -0.3);
//            gl.glEnd();
//
//            gl.glBegin( GL2.GL_LINES );
//            gl.glVertex2d(0.4, -0.3);
//            gl.glVertex2d(0.4, 0.3);
//            gl.glEnd();
//        }

//        @Override
//        public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
//
//        }
//    }
//}


//import com.jogamp.opengl.*;
//import com.jogamp.opengl.awt.GLCanvas;
//import javax.swing.*;
//
//public class Main {
//    public static void main(String[] args) {
//        final GLProfile gp = GLProfile.get(GLProfile.GL2);
//        GLCapabilities cap = new GLCapabilities(gp);
//        final GLCanvas gc = new GLCanvas(cap);
//
//        Chair chair = new Chair();
//
//        gc.addGLEventListener(chair);
//        gc.setSize(800, 600); // Set the canvas size
//
//        final JFrame frame = new JFrame("OpenGL using Java - Chair");
//
//        frame.add(gc);
//        frame.setSize(800, 600); // Set the visibility of the frame
//        frame.setVisible(true);
//    }
//
//    public static class Chair implements GLEventListener {
//        @Override
//        public void init(GLAutoDrawable glAutoDrawable) {}
//
//        @Override
//        public void dispose(GLAutoDrawable glAutoDrawable) {}
//
//        @Override
//        public void display(GLAutoDrawable glAutoDrawable) {
//            final GL2 gl = glAutoDrawable.getGL().getGL2();
//            gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
//            gl.glLoadIdentity();
//
//            // Draw chair
//            gl.glBegin(GL2.GL_QUADS);
//            // Seat
//            gl.glVertex3d(-0.4, -0.3, 0.4);
//            gl.glVertex3d(0.4, -0.3, 0.4);
//            gl.glVertex3d(0.4, -0.3, -0.4);
//            gl.glVertex3d(-0.4, -0.3, -0.4);
//
//            // Backrest
//            gl.glVertex3d(-0.4, -0.3, -0.4);
//            gl.glVertex3d(0.4, -0.3, -0.4);
//            gl.glVertex3d(0.2, 0.5, -0.2);
//            gl.glVertex3d(-0.2, 0.5, -0.2);
//
//            // Front legs
//            gl.glVertex3d(-0.4, -0.3, 0.4);
//            gl.glVertex3d(-0.2, -0.3, 0.4);
//            gl.glVertex3d(-0.2, -1.0, 0.2);
//            gl.glVertex3d(-0.4, -1.0, 0.2);
//
//            gl.glVertex3d(0.4, -0.3, 0.4);
//            gl.glVertex3d(0.2, -0.3, 0.4);
//            gl.glVertex3d(0.2, -1.0, 0.2);
//            gl.glVertex3d(0.4, -1.0, 0.2);
//
//            // Back legs
//            gl.glVertex3d(-0.4, -0.3, -0.4);
//            gl.glVertex3d(-0.2, -0.3, -0.4);
//            gl.glVertex3d(-0.2, -1.0, -0.2);
//            gl.glVertex3d(-0.4, -1.0, -0.2);
//
//            gl.glVertex3d(0.4, -0.3, -0.4);
//            gl.glVertex3d(0.2, -0.3, -0.4);
//            gl.glVertex3d(0.2, -1.0, -0.2);
//            gl.glVertex3d(0.4, -1.0, -0.2);
//            gl.glEnd();
//        }
//
//        @Override
//        public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {}
//    }
//}





//import com.jogamp.opengl.*;
//import com.jogamp.opengl.awt.GLCanvas;
//import com.jogamp.opengl.glu.GLU;
//
//import javax.swing.*;
////import javax.media.opengl.GL2;
////import javax.media.opengl.GLAutoDrawable;
////import javax.media.opengl.GLCapabilities;
////import javax.media.opengl.GLEventListener;
////import javax.media.opengl.GLProfile;
////import javax.media.opengl.awt.GLCanvas;
////import javax.media.opengl.glu.GLU;
////import javax.swing.JFrame;
//
//public class Rhombus implements GLEventListener{
//    private GLU glu = new GLU();
//    @Override
//    public void display(GLAutoDrawable drawable) {
//        final GL2 gl = drawable.getGL().getGL2();
//        gl.glTranslatef(0f, 0f, -2.5f);
//        //drawing edge1.....
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(-0.75f,0f,0);
//        gl.glVertex3f(0f,-0.75f, 0);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(-0.75f,0f,3f);// 3 units into the window
//        gl.glVertex3f(0f,-0.75f,3f);
//        gl.glEnd();
//        //top
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(-0.75f,0f,0);
//        gl.glVertex3f(-0.75f,0f,3f);
//        gl.glEnd();
//        //bottom
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0f,-0.75f, 0);
//        gl.glVertex3f(0f,-0.75f,3f);
//        gl.glEnd();
//        //edge 2....
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0f,-0.75f, 0);
//        gl.glVertex3f(0.75f,0f, 0);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0f,-0.75f, 3f);
//        gl.glVertex3f(0.75f,0f, 3f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0f,-0.75f, 0);
//        gl.glVertex3f(0f,-0.75f, 3f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0.75f,0f, 0);
//        gl.glVertex3f(0.75f,0f, 3f);
//        gl.glEnd();
//        //Edge 3.............
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f( 0.0f,0.75f,0);
//        gl.glVertex3f(-0.75f,0f,0);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f( 0.0f,0.75f,3f);
//        gl.glVertex3f(-0.75f,0f,3f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f( 0.0f,0.75f,0);
//        gl.glVertex3f( 0.0f,0.75f,3f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(-0.75f,0f,0);
//        gl.glVertex3f(-0.75f,0f,3f);
//        gl.glEnd();
//        //final edge
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0.75f,0f, 0);
//        gl.glVertex3f( 0.0f,0.75f,0);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0.75f,0f,3f);
//        gl.glVertex3f( 0.0f,0.75f,3f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0.75f,0f, 0);
//        gl.glVertex3f(0.75f,0f,3f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f( 0.0f,0.75f,0);
//        gl.glVertex3f( 0.0f,0.75f,3f);
//        gl.glEnd();
//    }
//    @Override
//    public void dispose(GLAutoDrawable arg0) {
//        //method body
//    }
//    @Override
//    public void init(GLAutoDrawable arg0) {
//        // method body
//    }
//    @Override
//    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//        // TODO Auto-generated method stub final
//        GL2 gl = drawable.getGL().getGL2();
//        if(height <=0)
//            height =1;
//        final float h = (float) width / (float) height;
//        gl.glViewport(3, 6, width, height);
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity();
//        glu.gluPerspective(45.0f, h, 1.0, 20.0);
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity();
//    }
//    public static void main(String[] args) {
//        //getting the capabilities object of GL2 profile
//        final GLProfile profile = GLProfile.get(GLProfile.GL2);
//        GLCapabilities capabilities = new GLCapabilities(profile);
//        // The canvas
//        final GLCanvas glcanvas = new GLCanvas(capabilities);
//        Rhombus b = new Rhombus();
//        glcanvas.addGLEventListener(b);
//        glcanvas.setSize(400, 400);
//        //creating frame
//        final JFrame frame = new JFrame (" Rhombus 3d");
//        //adding canvas to it
//        frame.getContentPane().add(glcanvas);
//        frame.setSize(frame.getContentPane().getPreferredSize());
//        frame.setVisible(true);
//    }//end of main
//}//end of classimport javax.media.opengl.GL2;


//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.DisplayMode;
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
//import java.awt.Point;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//import com.jogamp.opengl.*;
//import com.jogamp.opengl.awt.GLCanvas;
//import com.jogamp.opengl.glu.GLU;
//
//import javax.swing.AbstractAction;
//import javax.swing.ActionMap;
//import javax.swing.InputMap;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.KeyStroke;
//
//import com.jogamp.opengl.util.FPSAnimator;
//
///**
// * @author Beta
// *
// */
//public class Render implements GLEventListener{
//
//    private static GraphicsEnvironment graphicsEnviorment;
//    private static boolean isFullScreen = false;
//    public static DisplayMode dm, dm_old;
//    private static Dimension xgraphic;
//    private static Point point = new Point(0, 0);
//
//    private GLU glu = new GLU();
//
//    private float rquad=0.0f, rtri =0.0f;
//
//    @Override
//    public void display(GLAutoDrawable drawable) {
//        // TODO Auto-generated method stub
//        final GL2 gl = drawable.getGL().getGL2();
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);     // Clear The Screen And The Depth Buffer
//        gl.glLoadIdentity();                       // Reset The View
//
//        gl.glTranslatef(-1.5f,0.0f,-6.0f);                 // Move Left 1.5 Units And Into The Screen 6.0
//
//        gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);//(NEW!)
//
//        gl.glBegin(GL2.GL_TRIANGLES);                      // Drawing Using Triangl.gles
//        /*
//         * Front
//         */
//        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
//        gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Front)
//        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
//        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Left Of Triangle (Front)
//        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
//        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Right Of Triangle (Front)
//        /*
//         * Right
//         */
//        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
//        gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Right)
//        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
//        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Left Of Triangle (Right)
//        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
//        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Right Of Triangle (Right)
//        /*
//         * Left
//         */
//        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
//        gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Back)
//        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
//        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Left Of Triangle (Back)
//        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
//        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Right Of Triangle (Back)
//        /*
//         *
//         */
//        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
//        gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Left)
//        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
//        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Left Of Triangle (Left)
//        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
//        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Right Of Triangle (Left)
//
//        gl.glEnd(); // Done Drawing The Pyramid
//
//        /**
//         * Cube
//         */
//
//        gl.glLoadIdentity();
//        gl.glTranslatef(1.5f, 0.0f, -7.0f); // Move Right And Into The Screen
//
//        gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f); // Rotate The Cube On X, Y & Z
//
//        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
//
//        gl.glColor3f(0.0f, 1.0f, 0.0f); // Set The Color To Green
//        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
//        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
//        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
//        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)
//
//        gl.glColor3f(1.0f, 0.5f, 0.0f); // Set The Color To Orange
//        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad (Bottom)
//        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad (Bottom)
//        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Bottom)
//        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Bottom)
//
//        gl.glColor3f(1.0f, 0.0f, 0.0f); // Set The Color To Red
//        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
//        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
//        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad (Front)
//        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad (Front)
//
//        gl.glColor3f(1.0f, 1.0f, 0.0f); // Set The Color To Yellow
//        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Back)
//        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Back)
//        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Back)
//        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Back)
//
//        gl.glColor3f(0.0f, 0.0f, 1.0f); // Set The Color To Blue
//        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
//        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Left)
//        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Left)
//        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad (Left)
//
//        gl.glColor3f(1.0f, 0.0f, 1.0f); // Set The Color To Violet
//        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Right)
//        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Right)
//        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad (Right)
//        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Right)
//        gl.glEnd(); // Done Drawing The Quad
//        gl.glFlush();
//        rtri +=0.2f;
//        rquad -=0.15f;
//    }
//
//    @Override
//    public void dispose(GLAutoDrawable drawable) {
//        // TODO Auto-generated method stub
//
//
//    }
//
//    @Override
//    public void init(GLAutoDrawable drawable) {
//
//        final GL2 gl = drawable.getGL().getGL2();
//        gl.glShadeModel(GL2.GL_SMOOTH);
//        gl.glClearColor(0f, 0f, 0f, 0f);
//        gl.glClearDepth(1.0f);
//        gl.glEnable(GL2.GL_DEPTH_TEST);
//        gl.glDepthFunc(GL2.GL_LEQUAL);
//        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
//    }
//
//    @Override
//    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
//                        int height) {
//        // TODO Auto-generated method stub
//        final GL2 gl = drawable.getGL().getGL2();
//
//        if(height <=0)
//            height =1;
//        final float h = (float) width / (float) height;
//        gl.glViewport(0, 0, width, height);
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity();
//        glu.gluPerspective(45.0f, h, 1.0, 20.0);
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity();
//    }
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        // setUp open GL version 2
//        final GLProfile profile = GLProfile.get(GLProfile.GL2);
//        GLCapabilities capabilities = new GLCapabilities(profile);
//
//        // The canvas
//        final GLCanvas glcanvas = new GLCanvas(capabilities);
//        Render r = new Render();
//        glcanvas.addGLEventListener(r);
//        glcanvas.setSize(400, 400);
//
//        final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true );
//
//        final JFrame frame = new JFrame ("nehe: Lesson 5");
//
//        frame.getContentPane().add(glcanvas);
//
//        //Shutdown
//        frame.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent e){
//                if(animator.isStarted())
//                    animator.stop();
//                System.exit(0);
//            }
//        });
//
//        frame.setSize(frame.getContentPane().getPreferredSize());
//        /**
//         * Centers the screen on start up
//         *
//         */
//        graphicsEnviorment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//
//        GraphicsDevice[] devices = graphicsEnviorment.getScreenDevices();
//
//        dm_old = devices[0].getDisplayMode();
//        dm = dm_old;
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//        int windowX = Math.max(0, (screenSize.width - frame.getWidth()) / 2);
//        int windowY = Math.max(0, (screenSize.height - frame.getHeight()) / 2);
//
//        frame.setLocation(windowX, windowY);
//        /**
//         *
//         */
//        frame.setVisible(true);
//        /*
//         * Time to add Button Control
//         */
//        JPanel p = new JPanel();
//        p.setPreferredSize(new Dimension(0,0));
//        frame.add(p, BorderLayout.SOUTH);
//
//        keyBindings(p, frame, r);
//        animator.start();
//    }
//
//    private static void keyBindings(JPanel p, final JFrame frame, final Render r) {
//
//        ActionMap actionMap = p.getActionMap();
//        InputMap inputMap = p.getInputMap();
//
//        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
//        actionMap.put("F1", new AbstractAction(){
//
//            /**
//             *
//             */
//            private static final long serialVersionUID = -6576101918414437189L;
//
//            @Override
//            public void actionPerformed(ActionEvent drawable) {
//                // TODO Auto-generated method stub
//                fullScreen(frame);
//            }});
//    }
//
//    protected static void fullScreen(JFrame f) {
//        // TODO Auto-generated method stub
//        if(!isFullScreen){
//            f.dispose();
//            f.setUndecorated(true);
//            f.setVisible(true);
//            f.setResizable(false);
//            xgraphic = f.getSize();
//            point = f.getLocation();
//            f.setLocation(0, 0);
//            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            f.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
//            isFullScreen=true;
//        }else{
//            f.dispose();
//            f.setUndecorated(false);
//            f.setResizable(true);
//            f.setLocation(point);
//            f.setSize(xgraphic);
//            f.setVisible(true);
//
//            isFullScreen =false;
//        }
//    }
//
//
//}
















//import com.jogamp.opengl.*;
//import com.jogamp.opengl.awt.GLCanvas;
//import com.jogamp.opengl.glu.GLU;
////
////import javax.swing.*;
////
////public class Rhombus implements GLEventListener {
////    private GLU glu = new GLU();
////    private float rotationAngle = 0.0f; // Rotation angle for the chair
////
////    @Override
////    public void display(GLAutoDrawable drawable) {
////        final GL2 gl = drawable.getGL().getGL2();
////        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
////        gl.glLoadIdentity();
////
////        // Apply rotation
////        gl.glRotatef(rotationAngle, 0.0f, 1.0f, 0.0f); // Rotate around the y-axis
////
////        // Draw the chair
////        drawChair(gl);
////
////        // Increment rotation angle for animation
////        rotationAngle += 0.5f;
////    }
////
////    private void drawChair(GL2 gl) {
////        // Draw chair components here
////
////        // Draw seat
////// Draw chair seat
////        gl.glBegin(GL2.GL_QUADS);
////        gl.glVertex3f(-1.0f, -0.2f, 0f);  // Front left
////        gl.glVertex3f(1.0f, -0.2f, 0f);   // Front right
////        gl.glVertex3f(1.0f, -0.2f, 2f);   // Back right
////        gl.glVertex3f(-1.0f, -0.2f, 2f);  // Back left
////        gl.glEnd();
////
////// Draw chair backrest
////        gl.glBegin(GL2.GL_QUADS);
////        gl.glVertex3f(-1.0f, -0.2f, 2f);  // Bottom left
////        gl.glVertex3f(1.0f, -0.2f, 2f);   // Bottom right
////        gl.glVertex3f(1.0f, 2.0f, 2f);    // Top right
////        gl.glVertex3f(-1.0f, 2.0f, 2f);   // Top left
////        gl.glEnd();
////
////// Draw chair legs
////        gl.glBegin(GL2.GL_QUADS);
////        gl.glVertex3f(-0.8f, -0.2f, 0f);  // Front left
////        gl.glVertex3f(-0.6f, -0.2f, 0f);  // Front right
////        gl.glVertex3f(-0.6f, -1.0f, 0f);  // Back right
////        gl.glVertex3f(-0.8f, -1.0f, 0f);  // Back left
////        gl.glEnd();
////
////        gl.glBegin(GL2.GL_QUADS);
////        gl.glVertex3f(0.8f, -0.2f, 0f);   // Front right
////        gl.glVertex3f(0.6f, -0.2f, 0f);   // Front left
////        gl.glVertex3f(0.6f, -1.0f, 0f);   // Back left
////        gl.glVertex3f(0.8f, -1.0f, 0f);   // Back right
////        gl.glEnd();
////
////        gl.glBegin(GL2.GL_QUADS);
////        gl.glVertex3f(-0.8f, -0.2f, 2f);  // Front left
////        gl.glVertex3f(-0.6f, -0.2f, 2f);  // Front right
////        gl.glVertex3f(-0.6f, -1.0f, 2f);  // Back right
////        gl.glVertex3f(-0.8f, -1.0f, 2f);  // Back left
////        gl.glEnd();
////
////        gl.glBegin(GL2.GL_QUADS);
////        gl.glVertex3f(0.8f, -0.2f, 2f);   // Front right
////        gl.glVertex3f(0.6f, -0.2f, 2f);   // Front left
////        gl.glVertex3f(0.6f, -1.0f, 2f);   // Back left
////        gl.glVertex3f(0.8f, -1.0f, 2f);   // Back right
////        gl.glEnd();
////    }
////
////    // Other overridden methods (init, reshape, dispose)...
////
////    @Override
////    public void dispose(GLAutoDrawable drawable) {
////        // Cleanup resources
////    }
////
////    @Override
////    public void init(GLAutoDrawable drawable) {
////        // Initialization code
////    }
////
////    @Override
////    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
////        // Reshape code
////    }
////
////    public static void main(String[] args) {
////        final GLProfile profile = GLProfile.get(GLProfile.GL2);
////        GLCapabilities capabilities = new GLCapabilities(profile);
////        final GLCanvas glcanvas = new GLCanvas(capabilities);
////        Rhombus chair = new Rhombus();
////        glcanvas.addGLEventListener(chair);
////        glcanvas.setSize(800, 600);
////        final JFrame frame = new JFrame("3D Chair");
////        frame.getContentPane().add(glcanvas);
////        frame.setSize(frame.getContentPane().getPreferredSize());
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setVisible(true);
////    }
////}
//
//
//
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class PolygonLighting implements GLEventListener {
   static private float rpoly;
    static  private float cameraX = 0.0f;
    static private float cameraY = 0.0f;
    static private float cameraZ = -1f;
    static  private float cameraSpeed = 0.1f;



    @Override
    public void display( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(1f,0f,0f); //applying red

        // Clear The Screen And The Depth Buffer
        gl.glClear( GL2.GL_COLOR_BUFFER_BIT |
                GL2.GL_DEPTH_BUFFER_BIT );
        gl.glLoadIdentity();
        gl.glTranslatef(cameraX, cameraY, cameraZ);

        gl.glBegin( GL2.GL_POLYGON );



        gl.glVertex3f( 0f,0.5f,0f );
        gl.glVertex3f( -0.5f,0.2f,0f );
        gl.glVertex3f( -0.5f,-0.2f,0f );
        gl.glVertex3f( 0f,-0.5f,0f );
        gl.glVertex3f( 0f,0.5f,0f );
        gl.glVertex3f( 0.5f,0.2f,0f );
        gl.glVertex3f( 0.5f,-0.2f,0f );
        gl.glVertex3f( 0f,-0.5f,0f );

        gl.glEnd();

        gl.glFlush();

        rpoly += 0.2f;  //assigning the angle

        gl.glEnable( GL2.GL_LIGHTING );
        gl.glEnable( GL2.GL_LIGHT0 );
        gl.glEnable( GL2.GL_NORMALIZE );

        // weak RED ambient
        float[] ambientLight = { 0.1f, 0.f, 0.f,0f };
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);

        // multicolor diffuse
        float[] diffuseLight = { 1f,2f,1f,0.2f };
        gl.glLightfv( GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0 );
    }

    @Override
    public void dispose( GLAutoDrawable arg0 ) {
        //method body
    }

    @Override
    public void init( GLAutoDrawable arg0 ) {
        // method body

    }

    @Override
    public void reshape( GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4 ) {
        // method body
    }

    public static void main(String[] args) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        PolygonLighting polygonlighting = new PolygonLighting();
        glcanvas.addGLEventListener( polygonlighting );
        glcanvas.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                switch (e.getKeyCode()) {
                    case com.jogamp.newt.event.KeyEvent.VK_W:
                        cameraZ += cameraSpeed;
                        System.out.println(cameraZ);
                        break;

                    case com.jogamp.newt.event.KeyEvent.VK_S:
                        cameraZ -= cameraSpeed;
                        System.out.println(cameraZ);
                        break;
                    case com.jogamp.newt.event.KeyEvent.VK_A:
                        cameraX -= cameraSpeed;
                        System.out.println(cameraX);
                        break;
                    case com.jogamp.newt.event.KeyEvent.VK_D:
                        cameraX += cameraSpeed;
                        System.out.println(cameraX);
                        break;
                }
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {

            }

        });
        glcanvas.setSize( 400, 400 );

        //creating frame
        final JFrame frame = new JFrame (" Polygon lighting ");

        //adding canvas to it
        frame.getContentPane().add( glcanvas );
        frame.setSize( frame.getContentPane().getPreferredSize());
        frame.setVisible( true );


        //Instantiating and Initiating Animator
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true );
        animator.start();

    } //end of main



}





