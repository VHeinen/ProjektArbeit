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

public class swing {  
	
	private static JFrame window;
	private static JLabel label;
	
	public static void main(String[] args) {
		//JFrame erstellen, Button+Logik inklusive
		window = buildJFrame();
	}
	
	public static JFrame buildJFrame() {
		
		//JFrame aufbauen
		window = new JFrame();
		window.setTitle("Notenübersicht");
		window.setSize(1080, 1920);
		
		//JPanel erstellen
		JPanel pane = new JPanel();
		
		//Boxen zur Anordnung erstellen
		Box vert = Box.createVerticalBox();
		Box headlinesBox = Box.createHorizontalBox();
		Box examBox = Box.createHorizontalBox();
		Box epoBox = Box.createHorizontalBox();
		Box otherBox = Box.createHorizontalBox();
		Box footerBox = Box.createHorizontalBox();
		
		//Klassenarbeitsabschnitt
		JLabel exam = new JLabel("Klassenarbeit:  ");
		examBox.add(exam);
		JLabel examGrade = new JLabel("                             Note                   ");
		headlinesBox.add(examGrade);
		JTextField examGradeInputField = new JTextField("", 15);
		examGradeInputField.setForeground(Color.BLUE);
		examBox.add(examGradeInputField);
		JLabel examWeighting = new JLabel("              Gewichtung                      ");
		headlinesBox.add(examWeighting);
		JTextField examWeightingInputField = new JTextField("", 15);
		examWeightingInputField.setForeground(Color.BLUE);
		examBox.add(examWeightingInputField);
		JLabel examComment = new JLabel("           Kommentar");
		headlinesBox.add(examComment);
		JTextField examCommentInputField = new JTextField("", 15);
		examCommentInputField.setForeground(Color.BLUE);
		examBox.add(examCommentInputField);
		
		//Klassenarbeitsbutton
		JButton buttonExams = new JButton("Klassenarbeit speichern");
		buttonExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradeToken = examGradeInputField.getText();
				float weightingToken = Float.parseFloat(examWeightingInputField.getText());
				String commentToken = examCommentInputField.getText();
				//TODO: DB Update Tokens
			}
		});
		footerBox.add(buttonExams);
		
		//Epochalnotenabschnitt
		JLabel Epo = new JLabel("Epochalnote:    ");
		epoBox.add(Epo);
		JTextField epoGradeInputField = new JTextField("", 15);
		epoGradeInputField.setForeground(Color.BLUE);
		epoBox.add(epoGradeInputField);
		JTextField epoWeightingInputField = new JTextField("", 15);
		epoWeightingInputField.setForeground(Color.BLUE);
		epoBox.add(epoWeightingInputField);
		JTextField epoCommentInputField = new JTextField("", 15);
		epoCommentInputField.setForeground(Color.BLUE);
		epoBox.add(epoCommentInputField);
		
		//Epochalnotenbutton
		JButton buttonEpos = new JButton("Epochalnote speichern");
		buttonEpos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradeToken = epoGradeInputField.getText();
				float weightingToken = Float.parseFloat(epoWeightingInputField.getText());
				String commentToken = epoCommentInputField.getText();
				//TODO: DB Update Tokens
			}
		});
		footerBox.add(buttonEpos);
		
		//Andere Note Abschnitt
		JLabel other = new JLabel("andere Note:    ");
		otherBox.add(other);
		JTextField otherGradeInputField = new JTextField("", 15);
		otherGradeInputField.setForeground(Color.BLUE);
		otherBox.add(otherGradeInputField);
		JTextField otherWeightingInputField = new JTextField("", 15);
		otherWeightingInputField.setForeground(Color.BLUE);
		otherBox.add(otherWeightingInputField);
		JTextField otherCommentInputField = new JTextField("", 15);
		otherCommentInputField.setForeground(Color.BLUE);
		otherBox.add(otherCommentInputField);
		
		//Andere Note Button
		JButton buttonOthers = new JButton("andere Note speichern");
		buttonOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradeToken = epoGradeInputField.getText();
				float weightingToken = Float.parseFloat(epoWeightingInputField.getText());
				String commentToken = epoCommentInputField.getText();
				//TODO: DB Update Tokens
			}
		});
		footerBox.add(buttonOthers);
		
		//Boxen anordnen
		vert.add(headlinesBox);
		vert.add(examBox);
		vert.add(epoBox);
		vert.add(otherBox);
		vert.add(footerBox);
		pane.add(vert);
		
		//JFrame fertigmachen
		window.add(pane);
		window.setVisible(true);
		
		return(window);
	}
}
