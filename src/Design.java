
//import com.jogamp.opengl.*;
//import com.jogamp.opengl.awt.GLCanvas;
//import javax.swing.JFrame;
//
//import com.jogamp.opengl.util.FPSAnimator;
//
//public class Main implements GLEventListener {
//   static private float rpoly;
//    static  private float cameraX = 0.0f;
//    static private float cameraY = 0.0f;
//    static private float cameraZ = -1f;
//    static  private float cameraSpeed = 0.1f;
//
//
//
//    @Override
//    public void display( GLAutoDrawable drawable ) {
//
//        final GL2 gl = drawable.getGL().getGL2();
//        gl.glColor3f(1f,0f,0f); //applying red
//
//        // Clear The Screen And The Depth Buffer
//        gl.glClear( GL2.GL_COLOR_BUFFER_BIT |
//                GL2.GL_DEPTH_BUFFER_BIT );
//        gl.glLoadIdentity();
//
//        gl.glTranslatef(cameraX, cameraY, cameraZ);
//
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex3f(-0.08f, -0.09f, 0);
//        gl.glVertex3f(-0.08f, 0.16f, 0);
//        gl.glVertex3f(-0.06f, 0.16f, 0);
//        gl.glVertex3f(-0.06f, -0.09f, 0);
//        gl.glEnd();
//
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex3f(0.14f, -0.09f, 0);
//        gl.glVertex3f(0.16f, -0.09f, 0);
//        gl.glVertex3f(0.14f, 0.16f, 0);
//        gl.glVertex3f(0.16f, 0.16f, 0);
//        gl.glEnd();
//
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex3f(-0.08f, -0.16f, 0);
//        gl.glVertex3f(-0.24f, -0.25f, 0);
//        gl.glVertex3f(0.17f, -0.16f, 0);
//        gl.glVertex3f(0.06f, -0.27f, 0);
//        gl.glEnd();
//
//        gl.glFlush();
////
////        rpoly += 0.2f;  //assigning the angle
////
////        gl.glEnable( GL2.GL_LIGHTING );
////        gl.glEnable( GL2.GL_LIGHT0 );
////        gl.glEnable( GL2.GL_NORMALIZE );
////
////        // weak RED ambient
////        float[] ambientLight = { 0.1f, 0.f, 0.f,0f };
////        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);
////
////        // multicolor diffuse
////        float[] diffuseLight = { 1f,2f,1f,0.2f };
////        gl.glLightfv( GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0 );
//    }
//
//    @Override
//    public void dispose( GLAutoDrawable arg0 ) {
//        //method body
//    }
//
//    @Override
//    public void init( GLAutoDrawable arg0 ) {
//        // method body
//
//    }
//
//    @Override
//    public void reshape( GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4 ) {
//        // method body
//    }
//
//    public static void main(String[] args) {
//
//        //getting the capabilities object of GL2 profile
//        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
//        GLCapabilities capabilities = new GLCapabilities( profile);
//
//        // The canvas
//        final GLCanvas glcanvas = new GLCanvas( capabilities );
//        Main main = new Main();
//        glcanvas.addGLEventListener( main );
//        glcanvas.addKeyListener(new java.awt.event.KeyListener() {
//            @Override
//            public void keyTyped(java.awt.event.KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(java.awt.event.KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case com.jogamp.newt.event.KeyEvent.VK_W:
//                        cameraZ += cameraSpeed;
//                        System.out.println(cameraZ);
//                        break;
//
//                    case com.jogamp.newt.event.KeyEvent.VK_S:
//                        cameraZ -= cameraSpeed;
//                        System.out.println(cameraZ);
//                        break;
//                    case com.jogamp.newt.event.KeyEvent.VK_A:
//                        cameraX -= cameraSpeed;
//                        System.out.println(cameraX);
//                        break;
//                    case com.jogamp.newt.event.KeyEvent.VK_D:
//                        cameraX += cameraSpeed;
//                        System.out.println(cameraX);
//                        break;
//                }
//            }
//
//            @Override
//            public void keyReleased(java.awt.event.KeyEvent e) {
//
//            }
//
//        });
//
//        glcanvas.setSize( 800, 800 );
//
//        //creating frame
//        final JFrame frame = new JFrame (" 3D View ");
//
//        //adding canvas to it
//        frame.getContentPane().add( glcanvas );
//        frame.setSize( frame.getContentPane().getPreferredSize());
//        frame.setVisible( true );
//
//
//        //Instantiating and Initiating Animator
//        final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true );
//        animator.start();
//
//    } //end of main
//}





