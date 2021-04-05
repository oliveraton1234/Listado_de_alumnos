package gui;

import javax.swing.*;
import java.awt.*;

public class acercadeDialogo extends JDialog {
    private JLabel lblImg;
    private JLabel lblTxt;
    private JLabel lblContanto;
    public acercadeDialogo(JFrame parent){

        super(parent, true);
        super.setTitle("Acerca de");

        super.getContentPane().setBackground(Color.black);

        lblImg = new JLabel(new ImageIcon("Logo.gif"));
        lblTxt = new JLabel("Somos ....");
        super.add(lblTxt, BorderLayout.EAST);

        lblImg.setBounds(110,0,10,50);




        lblContanto = new JLabel("Contacto");
        super.add(lblContanto, BorderLayout.SOUTH);
        super.add(lblImg);


        super.setSize(500, 500);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());
    }
}
