import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        new Activity();
    }

    public static class Activity{
        JFrame f;
        Activity(){

            f=new JFrame();
            f.setSize(900,600);

            //LEFT PANEL
            JPanel panelLeft = new JPanel();
            panelLeft.setBounds(0,0,400,600);
            panelLeft.setBackground(new Color(54,48,98));
            panelLeft.setLayout(null);

            //Right PANEL
            JPanel panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setBounds(385,0,500,600);
            panel.setLayout(null);


            //TextField 1
            final JTextField  tfx = new JTextField();
            tfx.setBounds(135,220,270,40);

            //TextField 2
            final JTextField  tf2 = new JTextField();
            tf2.setBounds(135,315,270,40);

            JLabel title;
            title= new JLabel("LOGIN TO YOUR ACCOUNT");
            Font currentFont = title.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
            // Set the new font to the JLabel
            title.setFont(newFont);
            title.setForeground(new Color(27,26,85));
            title.setBounds(152,125,250,30);

            //Label 1
            JLabel lb;
            lb= new JLabel("Email");
            lb.setBounds(135,180,100,30);

            //Label 2
            JLabel lb2;
            lb2= new JLabel("Password");
            lb2.setBounds(135,275,100,30);

//            //Output
//            JLabel output;
//            output= new JLabel("Answer");
//            output.setBounds(210,325,100,30);

            panel.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent me) { }
                public void mouseReleased(MouseEvent me) { }
                public void mouseEntered(MouseEvent me) { }
                public void mouseExited(MouseEvent me) { }
                public void mouseClicked(MouseEvent me) {
                    int x = me.getX();
                    int y = me.getY();
                    tfx.setText("X:" + x + " Y:" + y);
                }
            });

            //Button 1
            JButton b = new JButton("Login");
            b.setBounds(190,385,140,40);
            b.setBackground(new Color(51,58,115));
            b.setForeground(Color.white);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        int n1 = Integer.parseInt(tfx.getText());
                        int n2 =  Integer.parseInt(tf2.getText());

//                        output.setText(Integer.toString (n1+n2));

                    }catch(Exception err){
//                        output.setText("Error");
                    }

                }
            });
            panel.add(title);
            panel.add(lb);
            panel.add(lb2);
//            panel.add(output);
            panel.add(tfx);
            panel.add(tf2);
            panel.add(b);
            f.add(panelLeft);
            f.add(panel);
            f.setLayout(null);
            f.setVisible(true);
        }
    }






















//    public static class Activity{
//        JFrame f;
//        Activity(){
//            f=new JFrame();
//            f.setSize(600,600);
//
//            //TextField 1
//            final JTextField  tf = new JTextField();
//            tf.setBounds(100,100,150,20);
//
//            //TextField 2
//            final JTextField  tf2 = new JTextField();
//            tf.setBounds(80,80,150,20);
//
//            //Button 1
//            JButton b = new JButton("Click Here");
//            b.setBounds(50,100,50,25);
//            b.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    tf.setText("Welcome to the PUSL3122 Module");
//                }
//            });
//
//            //Button 2
//            JButton b2 = new JButton("Click Here");
//            b2.setBounds(200,100,50,25);
//            b2.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    tf.setText("Welcome to the PUSL3122 Module");
//                }
//            });
//
//            //Label 1
//            JLabel lb;
//            lb= new JLabel("First lab session");
//            lb.setBounds(100,150,100,30);
//
//            f.addMouseListener(new MouseListener() {
//                public void mousePressed(MouseEvent me) { }
//                public void mouseReleased(MouseEvent me) { }
//                public void mouseEntered(MouseEvent me) { }
//                public void mouseExited(MouseEvent me) { }
//                public void mouseClicked(MouseEvent me) {
//                    int x = me.getX();
//                    int y = me.getY();
//                    tf.setText("X:" + x + " Y:" + y);
//                }
//            });
//            f.add(lb);
//            f.add(tf);
//            f.add(tf2);
//            f.add(b);
//            f.add(b2);
//            f.setLayout(null);
//            f.setVisible(true);
//
//
//
//        }
//    }
}