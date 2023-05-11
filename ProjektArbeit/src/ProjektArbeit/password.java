package ProjektArbeit;

import java.awt.Color;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class password {

	public static void main(String[] args) {
		
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
		hor1.add(passwordLabel); hor1.add(username);
		JLabel passwordLabel2 = new JLabel("Passwort:      ");
		JPasswordField password = new JPasswordField("beschisseneskackpasswort");
		hor2.add(passwordLabel2); hor2.add(password);
		
		vert.add(hor1);
		vert.add(hor2);
		pane.add(vert);
		passwordWindow.add(pane);
		passwordWindow.setVisible(true);

	}

}
