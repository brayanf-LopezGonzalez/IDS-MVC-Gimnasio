package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthView {
		
	    private JFrame frame;
	    private JPanel panelPrincipal;
	    private JTextField textField;
	    private JPasswordField passwordField;
	    private JCheckBox chckbxMantenerSesion;
	    private JButton iniciarSesion;
	    private JButton crearCuenta;
	    
	    
	
	public AuthView() {
		
	}
	
	public void login() {
		frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login y registro de administradores");
        frame.setMinimumSize(new Dimension(900, 600));
        frame.setPreferredSize(new Dimension(1158, 694));
        frame.setMaximumSize(new Dimension(1920, 1080));
        
        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(162, 235, 251));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setContentPane(panelPrincipal);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblLogin = new JLabel("Inicio de sesion");
        lblLogin.setFont(new Font("Gill Sans MT", Font.BOLD, 23));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(lblLogin, gbc);

        JLabel lblUsername = new JLabel("Usuario o correo electronico:");
        lblUsername.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(lblUsername, gbc);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipady = 10;
        formPanel.add(textField, gbc);
        gbc.ipady = 0;

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        formPanel.add(lblPassword, gbc);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipady = 10;
        formPanel.add(passwordField, gbc);
        gbc.ipady = 0;

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        optionsPanel.setOpaque(false);
        
        chckbxMantenerSesion = new JCheckBox("Mantener sesión iniciada");
        chckbxMantenerSesion.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
        chckbxMantenerSesion.setOpaque(false);
        optionsPanel.add(chckbxMantenerSesion);
        
        JLabel lblNewLabel = new JLabel("¿Olvido su contraseña?");
        lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
        optionsPanel.add(lblNewLabel);
        
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(optionsPanel, gbc);

        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
        gbc.gridy = 6;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(iniciarSesion, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;

        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        registerPanel.setOpaque(false);
        
        JLabel lblO = new JLabel("¿Aun no tiene cuenta?");
        lblO.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
        registerPanel.add(lblO);
        
        crearCuenta = new JButton("Crear cuenta");
        crearCuenta.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
        registerPanel.add(crearCuenta);
        
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(registerPanel, gbc);

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage img = ImageIO.read(new File("images/si.png"));

                    Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                    g.drawImage(scaledImg, 0, 0, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        
        panelPrincipal.add(formPanel, BorderLayout.WEST);
        panelPrincipal.add(imagePanel, BorderLayout.CENTER);
        
        formPanel.setPreferredSize(new Dimension(400, 600));
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
        
		
		
		
//        frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(100, 100, 1158, 694);
//        
//        panelPrincipal = new JPanel();
//        panelPrincipal.setBackground(new Color(162, 235, 251));
//        panelPrincipal.setLayout(null);
//        frame.setContentPane(panelPrincipal);
//
//        JLabel lblLogin = new JLabel("Inicio de sesion");
//        lblLogin.setFont(new Font("Gill Sans MT", Font.BOLD, 23));
//        lblLogin.setBounds(44, 49, 187, 41);
//        panelPrincipal.add(lblLogin);
//
//        JLabel lblUsername = new JLabel("Usuario o correo electronico:");
//        lblUsername.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
//        lblUsername.setBounds(44, 138, 247, 29);
//        panelPrincipal.add(lblUsername);
//
//        textField = new JTextField();
//        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
//        textField.setBounds(44, 172, 354, 41);
//        panelPrincipal.add(textField);
//
//        JLabel lblPassword = new JLabel("Contraseña:");
//        lblPassword.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
//        lblPassword.setBounds(44, 244, 176, 29);
//        panelPrincipal.add(lblPassword);
//
//        passwordField = new JPasswordField();
//        passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
//        passwordField.setBounds(44, 283, 354, 41);
//        panelPrincipal.add(passwordField);
//
//        chckbxMantenerSesion = new JCheckBox("Mantener sesión iniciada");
//        chckbxMantenerSesion.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
//        chckbxMantenerSesion.setBounds(44, 340, 163, 21);
//        chckbxMantenerSesion.setOpaque(false);
//        panelPrincipal.add(chckbxMantenerSesion);
//
//        iniciarSesion = new JButton("Iniciar sesión");
//        iniciarSesion.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
//        iniciarSesion.setBounds(104, 401, 225, 54);
//        panelPrincipal.add(iniciarSesion);
//
//        JLabel lblNewLabel = new JLabel("¿Olvido su contraseña?");
//        lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
//        lblNewLabel.setBounds(256, 336, 143, 29);
//        panelPrincipal.add(lblNewLabel);
//
//        JLabel lblO = new JLabel("¿Aun no tiene cuenta?");
//        lblO.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
//        lblO.setBounds(153, 477, 143, 29);
//        panelPrincipal.add(lblO);
//
//        crearCuenta = new JButton("Crear cuenta");
//        crearCuenta.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
//        crearCuenta.setBounds(125, 506, 187, 41);
//        panelPrincipal.add(crearCuenta);
//
//        JPanel panel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                try {
//                    BufferedImage img = ImageIO.read(new File("images/si.png"));
//                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        panel.setBounds(437, 10, 697, 615);
//        panelPrincipal.add(panel);
//
//        frame.setVisible(true);
        
    }

    public void forgot() { 
        // Método original
    }
}
