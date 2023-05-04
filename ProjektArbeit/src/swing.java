package ProjektArbeit;

import java.awt.Color;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Graphics;

public class swing {  
	
	private static JFrame unserFenster;
	private static JLabel label;
	
	public static void main(String[] args) {  
		unserFenster = new JFrame();
		unserFenster.setTitle("Notenübersicht");
		unserFenster.setSize(600, 800);
		JPanel pane = new JPanel();
	    unserFenster.add(pane);
		unserFenster.setVisible(true);
	}
}
