package ProjektArbeit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
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
	
	public static boolean 	teacher;
	public static int		userID;

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
		JPasswordField username = new JPasswordField("");
		hor1.add(passwordLabel); 
		hor1.add(username);
		JLabel passwordLabel2 = new JLabel("Passwort:      ");
		JPasswordField password = new JPasswordField("");
		hor2.add(passwordLabel2); 
		hor2.add(password);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				String usernameEntry;
				String passwordEntry;
				
				usernameEntry = charToString(username.getPassword());
				passwordEntry = charToString(password.getPassword());
				
				String teacherQuery = "select userName, passwort, teacherID from teachermanagement where passwort = '" + passwordEntry + "' and userName = '" + usernameEntry + "'";
				String pupilQuery = "select userName, passwort, pupilID from pupilmanagement where passwort = '" + passwordEntry + "' and userName = '" + usernameEntry + "'";
				
				try {
					String[] teacherArr = database.getDataFromDatabase(teacherQuery, 3);
					String[] pupilArr = database.getDataFromDatabase(pupilQuery, 3);
					if(teacherArr[0] != null && teacherArr[1] != null) {
						teacher = true;
						userID = Integer.parseInt(teacherArr[2]);
						swing.main(args, teacher, userID);
						passwordWindow.dispose();
					}
					else if(pupilArr[0] != null && pupilArr[1] != null) {
						teacher = false;
						userID = Integer.parseInt(pupilArr[2]);
						pupil.main(args, teacher, userID);
						passwordWindow.dispose();
					}
					else {
						teacher = false;
						System.out.println("Username oder Passwort falsch");
					}
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