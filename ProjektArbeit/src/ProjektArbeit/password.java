package ProjektArbeit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class password {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		JFrame passwordWindow = new JFrame();
		passwordWindow.setTitle("Notenübersicht");
		JPanel pane = new JPanel();
		Box vert = Box.createVerticalBox();
		Box hor1 = Box.createHorizontalBox();
		Box hor2 = Box.createHorizontalBox();
		passwordWindow.setSize(500, 200);
		JLabel topLabel = new JLabel("Gib deinen Nutzernamen und dein Passwort ein: ");
		vert.add(topLabel);
		JLabel passwordLabel = new JLabel("Nutzername: ");
		JPasswordField username = new JPasswordField("beschisseneskackpasswort");
		hor1.add(passwordLabel); 
		hor1.add(username);
		JLabel passwordLabel2 = new JLabel("Passwort:      ");
		JPasswordField password = new JPasswordField("beschisseneskackpasswort");
		hor2.add(passwordLabel2); 
		hor2.add(password);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				String usernameEntry = charToString(username.getPassword());
				String passwordEntry = charToString(password.getPassword());
				
				try {
					String[] resultArr = database.getDataFromDatabase("select username, password from teachermanagement where password = passwordEntry and username = usernameEntry", 2);
					if(resultArr[0] != null && resultArr[1] != null) {
						swing.main(args);
						passwordWindow.dispose();
					}
					System.out.println("Username oder Passwort falsch");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		vert.add(hor1);
		vert.add(hor2);
		vert.add(button);
		pane.add(vert);
		passwordWindow.add(pane);
		passwordWindow.setVisible(true);
	}
	
	public static String charToString(char[] c) {
		String s = "";
		for (char element : c) {
			s = s + String.valueOf(element);
		}
		return s;
	}
}
