import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
//        new Activity();
        new ModelSave();
//        new FurnitureDesign();
    }

    public static class Activity{
        JFrame f;
        Activity(){

            f=new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(900,600);
            f.setLocationRelativeTo(null);

            //LEFT PANEL
            JPanel panelLeft = new JPanel();
            panelLeft.setBounds(0,0,400,600);
            panelLeft.setBackground(new Color(54,48,98));
            panelLeft.setLayout(null);

            // Load and display image
            ImageIcon imageIcon = new ImageIcon("assets/logo.png"); // Modify with your image path
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(70, 140, imageIcon.getIconWidth(), imageIcon.getIconHeight());

            panelLeft.add(imageLabel);

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

            //Button 1
            JButton b = new JButton("Login");
            b.setBounds(190,385,140,40);
            b.setBackground(new Color(51,58,115));
            b.setForeground(Color.white);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new Dashboard();
                }
            });

            panel.add(title);
            panel.add(lb);
            panel.add(lb2);
            panel.add(tfx);
            panel.add(tf2);
            panel.add(b);
            f.add(panelLeft);
            f.add(panel);
            f.setLayout(null);
            f.setVisible(true);
        }
    }

}
