package com.ami.tech.fl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

  JPanel backgroundPanel, mainPanel;
  JLabel imgLabel, userNameLabel, passwordLabel;
  JTextField textField;
  JPasswordField passwordField;
  JButton loginButton, createButton;
  JTextArea textArea;

  Login() {
    setTitle("Login");
    setSize(1200, 700);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    backgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon(
            "../Resources/images/login_back.jpg"
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

    // mainPanel= new JPanel(){
    //       @Override
    //       protected void paintComponent(Graphics g) {
    //         super.paintComponent(g);

    //         // Load your image
    //         ImageIcon imageIcon = new ImageIcon(
    //           "../Resources/images/login_back.jpg"
    //         ); // Replace with your image path

    //         // Draw the image as the background
    //         g.drawImage(
    //           imageIcon.getImage(),
    //           250,
    //           150,
    //             800,
    //           500,
    //           this
    //         );
    //       }
    //     };

    ImageIcon img = new ImageIcon("../Resources/images/login_user.png");
    Image img1 = img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    ImageIcon img2 = new ImageIcon(img1);

    imgLabel = new JLabel(img2);
    imgLabel.setBounds(550, 150, 50, 50);

    userNameLabel = new JLabel("Enter ID or Account Number here :");
    userNameLabel.setBounds(400, 220, 400, 40);
    userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

    textField = new JTextField("Enter Text Here");
    textField.setBackground(Color.LIGHT_GRAY);
    textField.setBounds(400, 270, 400, 35);
    textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    textField.addFocusListener(
      new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
          if (textField.getText().equals("Enter Text Here")) {
            textField.setText("");
            textField.setForeground(Color.BLACK); // Set text color to the default color
          }
        }

        @Override
        public void focusLost(FocusEvent e) {
          if (textField.getText().isEmpty()) {
            textField.setText("");
            textField.setForeground(Color.BLACK); // Set text color to the placeholder color
          }
        }
      }
    );

    passwordLabel = new JLabel("Enter Password");
    passwordLabel.setBounds(400, 315, 400, 40);
    passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
    passwordField = new JPasswordField();
    passwordField.setBounds(400, 365, 400, 35);
    passwordField.setBackground(Color.LIGHT_GRAY);

    // textArea=new JTextArea();
    // textArea.setBounds(400,410,400,30);

    loginButton = new JButton("LOGIN");
    loginButton.setBounds(500, 450, 200, 50);
    loginButton.setBackground(Color.BLUE);
    loginButton.setForeground(Color.WHITE);

    createButton = new JButton("Create Account");
    createButton.setBounds(500, 510, 200, 50);
    createButton.setBackground(Color.GREEN);
    createButton.setForeground(Color.WHITE);

    loginButton.addActionListener(this);

    add(userNameLabel);
    add(textField);
    add(passwordLabel);
    add(passwordField);
    // add(textArea);
    add(loginButton);
    add(createButton);
    add(imgLabel); // backgroundPanel.add(mainPanel);
    add(backgroundPanel);
    // add(imgLabel);

  }

  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == loginButton) {
      System.out.println(textField.getText());
      System.out.println(passwordField.getText());
    }
  }

  public static void main(String[] args) {
    new Login().setVisible(true);
  }
}
