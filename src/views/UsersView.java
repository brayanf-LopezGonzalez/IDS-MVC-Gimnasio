package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.UsersController;
import models.User;
import models.UsersModel;

public class UsersView {

	public UsersView() {
		
	}
	
	
	public void index(List usuarios)
	{
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Login"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		//this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		int x = 100;
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			User usuario = (User) iterator.next();
			
			JLabel user = new JLabel(usuario.name);
			user.setForeground(new Color(0, 0, 0)); 
			user.setBounds(50, x, 210, 26);
			user.setHorizontalAlignment(JLabel.CENTER);
			panel.add(user);
			
			JButton delete = new JButton("Eliminar");
			delete.setBounds(250,x, 200,40);
			delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					UsersModel um = new UsersModel();
					um.remove(0);
					
					ventana.dispose();
					
					UsersController us = new UsersController();
					us.index();
				}
				
			});
			panel.add(delete);
			
			x+= 35;
			
		}
		
		 
		
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}

}
