package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.HomeController;
import models.AuthModel;

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
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setContentPane(panelPrincipal);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblLogin = new JLabel("Panel de administracion");
        lblLogin.setFont(new Font("Anton", Font.BOLD, 23));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(lblLogin, gbc);

        JLabel lblUsername = new JLabel("Correo electronico:");
        lblUsername.setFont(new Font("Anton", Font.BOLD, 17));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(lblUsername, gbc);

        textField = new JTextField();
        textField.setFont(new Font("Anton", Font.BOLD, 15));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipady = 10;
        formPanel.add(textField, gbc);
        gbc.ipady = 0;

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Anton", Font.CENTER_BASELINE, 17));
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        formPanel.add(lblPassword, gbc);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Anton", Font.BOLD, 16));
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipady = 10;
        formPanel.add(passwordField, gbc);
        gbc.ipady = 0;

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        optionsPanel.setOpaque(false);
        
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(optionsPanel, gbc);

        iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setFont(new Font("Anton", Font.CENTER_BASELINE, 18));
        gbc.gridy = 6;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(iniciarSesion, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        
        iniciarSesion.addActionListener(new ActionListener() {
        	@Override
public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordField.getPassword());
				Boolean flag1 = false, flag2 = false;
				
				
				if( passText.equals("") ) {
					
				}else {
					flag1 = true;
				}
				
				
				if(textField.getText().equals("")) {
					
				}else {
					flag2 = true;
				}
				
				
				if(flag1 && flag2) {
					
					AuthModel am = new AuthModel();
					boolean is_login = am.login(textField.getText(), passText);
					
					if(is_login) {
						JOptionPane.showMessageDialog(null, "Bienvenido.");
						
						frame.dispose();
						HomeController hc = new HomeController();
						
						hc.home();
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
			}
        });
        
        
			
			
        
        

        JPanel panelBotonRegistro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotonRegistro.setBackground(Color.black);;
        panelBotonRegistro.setOpaque(false);
        
        crearCuenta = new JButton("Registrarse");
        crearCuenta.setFont(new Font("Anton", Font.PLAIN, 18));
        crearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AuthView.this.registro();
				
			}
		});
        panelBotonRegistro.add(crearCuenta);

        
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(panelBotonRegistro, gbc);

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
        
    }
	
	public void registro() {
		frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Registro de administradores");
	    frame.setMinimumSize(new Dimension(900, 600));
	    frame.setPreferredSize(new Dimension(1158, 694));
	    frame.setMaximumSize(new Dimension(1920, 1080));
	    
	    panelPrincipal = new JPanel(new BorderLayout(10, 10));
	    panelPrincipal.setBackground(Color.WHITE);
	    panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    frame.setContentPane(panelPrincipal);

	    JPanel formPanel = new JPanel(new GridBagLayout());
	    formPanel.setOpaque(false);
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10, 10, 10, 10);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    JLabel lblRegistro = new JLabel("Registro de administrador");
	    lblRegistro.setFont(new Font("Anton", Font.BOLD, 23));
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    formPanel.add(lblRegistro, gbc);

	    // Campos del formulario (correo, contraseña, confirmar contraseña)
	    JLabel lblEmail = new JLabel("Correo electrónico:");
	    lblEmail.setFont(new Font("Anton", Font.BOLD, 17));
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    formPanel.add(lblEmail, gbc);

	    JTextField emailField = new JTextField();
	    emailField.setFont(new Font("Anton", Font.BOLD, 15));
	    gbc.gridy = 2;
	    gbc.gridwidth = 2;
	    gbc.ipady = 10;
	    formPanel.add(emailField, gbc);
	    gbc.ipady = 0;

	    JLabel lblPassword = new JLabel("Contraseña:");
	    lblPassword.setFont(new Font("Anton", Font.CENTER_BASELINE, 17));
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    formPanel.add(lblPassword, gbc);

	    JPasswordField passwordField = new JPasswordField();
	    passwordField.setFont(new Font("Anton", Font.BOLD, 16));
	    gbc.gridy = 4;
	    gbc.gridwidth = 2;
	    gbc.ipady = 10;
	    formPanel.add(passwordField, gbc);
	    gbc.ipady = 0;

	    JLabel lblConfirmPassword = new JLabel("Confirmar contraseña:");
	    lblConfirmPassword.setFont(new Font("Anton", Font.CENTER_BASELINE, 17));
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    formPanel.add(lblConfirmPassword, gbc);

	    JPasswordField confirmPasswordField = new JPasswordField();
	    confirmPasswordField.setFont(new Font("Anton", Font.BOLD, 16));
	    gbc.gridy = 6;
	    gbc.gridwidth = 2;
	    gbc.ipady = 10;
	    formPanel.add(confirmPasswordField, gbc);
	    gbc.ipady = 0;

	    // Panel para los botones (Registrarse y Cancelar)
	    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 15, 0));
	    buttonPanel.setOpaque(false);
	    
	    JButton btnRegistrar = new JButton("Registrarse");
	    btnRegistrar.setFont(new Font("Anton", Font.CENTER_BASELINE, 18));
	    btnRegistrar.setPreferredSize(new Dimension(150, 50));
	    
	    JButton btnCancelar = new JButton("Cancelar");
	    btnCancelar.setFont(new Font("Anton", Font.CENTER_BASELINE, 18));
	    btnCancelar.setPreferredSize(new Dimension(150, 50));
	    
	    buttonPanel.add(btnRegistrar);
	    buttonPanel.add(btnCancelar);
	    
	    gbc.gridy = 7;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.CENTER;
	    formPanel.add(buttonPanel, gbc);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    // Acción del botón Registrar
	    btnRegistrar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String email = emailField.getText();
	            String password = new String(passwordField.getPassword());
	            String confirmPassword = new String(confirmPasswordField.getPassword());
	            
	            if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            
	            if(!password.equals(confirmPassword)) {
	                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            
	            // Aquí iría la lógica para registrar al usuario
	            JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });
	    

	    btnCancelar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	frame.dispose();
	        	AuthView.this.login();
	        }
	    });

	    JPanel imagePanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            try {
	                BufferedImage img = ImageIO.read(new File("images/si.png"));
	                Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	                g.drawImage(scaledImg, 0, 0, this);
	            } catch (IOException ex) {
	                ex.printStackTrace();
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
	}

    public void forgot() { 
        // Método original
    }
}
