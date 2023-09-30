package com.ami.tech.fl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AdminHome extends JFrame implements ActionListener{

  JPanel backgroundPanel, detailPanel, panel1;
  JLabel imgLabel, nameLabel, designationLabel, userLabel;
  JLabel disname, disdesignatin, disuser;
  JButton button1, button2, button3, backButton, logoutButton;

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
    backgroundPanel.setLayout(null);

    panel1 = new JPanel();
    panel1.setBounds(0, 0, 1500, 40);
    panel1.setBackground(Color.DARK_GRAY);

    ImageIcon i7 = new ImageIcon("../Resources/images/back.png");
    Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);

    backButton = new JButton("Back", new ImageIcon(i8));
    backButton.setBounds(5, 2, 100, 30);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    backButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i1 = new ImageIcon("../Resources/images/create_account.png");
    Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button1 = new JButton("Create new Account", new ImageIcon(i2));
    button1.setBounds(40, 90, 300, 50);
    button1.setBackground(Color.GREEN);
    button1.setForeground(Color.WHITE);
    button1.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i3 = new ImageIcon("../Resources/images/admin_remove.png");
    Image i4 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button2 = new JButton("Remove Account", new ImageIcon(i4));
    button2.setBounds(40, 170, 300, 50);
    button2.setBackground(Color.RED);
    button2.setForeground(Color.WHITE);
    button2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i5 = new ImageIcon("../Resources/images/admin_accd.jpg");
    Image i6 = i5.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button3 = new JButton("Account Details", new ImageIcon(i6));
    button3.setBounds(40, 240, 300, 50);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    button3.setFont(new Font("Times New Roman", Font.PLAIN, 18));

       ImageIcon i9 = new ImageIcon("../Resources/images/logout.jpg");
    Image i10 = i9.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    logoutButton = new JButton("Log out", new ImageIcon(i10));
    logoutButton.setBounds(1000, 2, 175, 30);
    logoutButton.setBackground(Color.RED);
    logoutButton.setForeground(Color.WHITE);
    logoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));



    detailPanel = new JPanel();
    detailPanel.setBounds(500, 90, 600, 300);
    detailPanel.setBackground(Color.lightGray);
    detailPanel.setLayout(new BorderLayout());



    ImageIcon i11=new ImageIcon("../Resources/images/admin_img.jpg");
    Image i12=i11.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    // ImageIcon i13=new ImageIcon(i12);
      imgLabel= new JLabel(new ImageIcon(i12));
      imgLabel.setBounds(800, 65, 50, 50);

      nameLabel=new JLabel("Name : ");
      nameLabel.setBounds(550, 125, 100, 
      30);
      nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

      designationLabel=new JLabel("Designation : ");
      designationLabel.setBounds(550, 175, 100, 20);
      designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

       userLabel=new JLabel("User : ");
      userLabel.setBounds(550, 225, 100, 20);
      userLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

      disname=new JLabel("");
      disname.setBounds(700,125,200,30);
      disname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      disname.setBackground(Color.WHITE);
      disname.setOpaque(true);



      disdesignatin=new JLabel("");
      disdesignatin.setBounds(700, 175, 200, 30);
      disdesignatin.setFont(new Font("Times New Roman", Font.BOLD, 16));
      disdesignatin.setBackground(Color.WHITE);
      disdesignatin.setOpaque(true);


      disuser=new JLabel("Admin");
      disuser.setBounds(700, 225 , 200, 30);
      disuser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
      disuser.setBackground(Color.WHITE);
      
      disuser.setOpaque(true);

   logoutButton.addActionListener(this);
    add(backButton);
    add(logoutButton);
     add(panel1);
    add(button1);
    add(button2);
    add(button3);

    add(imgLabel);
    add(nameLabel);
     add(designationLabel);
    add(userLabel);
    add(disname);
    add(disdesignatin);
    add(disuser);

    add(detailPanel);
   
    add(backgroundPanel);
    
  }
public void actionPerformed(ActionEvent actionEvent){
  if(actionEvent.getSource()==logoutButton){
    
  }
}
  public static void main(String args[]) {
    new AdminHome().setVisible(true);
  }
}
