package com.ami.tech.fl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class AdminHome extends JFrame {

  JPanel backgroundPanel;
  JButton button1, button2, button3;

  AdminHome() {
    super("Admin");
    setSize(1200, 700);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    backgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon(
            "../Resources/images/admin_back.jpg"
          ); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };



button1=new JButton(getName(), null)










    backgroundPanel.setLayout(null);
      add(backgroundPanel);
    
  }

  public static void main(String args[]) {
    new AdminHome().setVisible(true);
  }
}
