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
		window = new JFrame();
		window.setTitle("Notenübersicht");
		window.setSize(1080, 1920);
		JPanel pane = new JPanel();
		Box vert = Box.createVerticalBox();
		Box headlinesBox = Box.createHorizontalBox();
		Box examBox = Box.createHorizontalBox();
		Box epoBox = Box.createHorizontalBox();
		Box otherBox = Box.createHorizontalBox();
		Box footerBox = Box.createHorizontalBox();
		JLabel exam = new JLabel("Klassenarbeit");
		examBox.add(exam);
		JLabel examGrade = new JLabel("Note");
		headlinesBox.add(examGrade);
	    JTextField examGradeInputField = new JTextField("", 15);
        examGradeInputField.setForeground(Color.BLUE);
	    examBox.add(examGradeInputField);
		JLabel examWeighting = new JLabel("Gewichtung");
		headlinesBox.add(examWeighting);
	    JTextField examWeightingInputField = new JTextField("", 15);
        examWeightingInputField.setForeground(Color.BLUE);
	    examBox.add(examWeightingInputField);
		JLabel examComment = new JLabel("Kommentar");
		headlinesBox.add(examComment);
	    JTextField examCommentInputField = new JTextField("", 15);
        examCommentInputField.setForeground(Color.BLUE);
	    examBox.add(examCommentInputField);
        JButton buttonExams = new JButton("Klassenarbeit speichern");
        buttonExams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.out.println("Text = " + examGradeInputField.getText()
            		  					 + " " + examWeightingInputField.getText()
            		  					 + " " +examCommentInputField.getText());
            }
          });
        footerBox.add(buttonExams);
		JLabel Epo = new JLabel("Epochalnote");
		epoBox.add(Epo);
	    JTextField EpoGradeInputField = new JTextField("", 15);
        EpoGradeInputField.setForeground(Color.BLUE);
	    epoBox.add(EpoGradeInputField);
	    JTextField EpoWeightingInputField = new JTextField("", 15);
        EpoWeightingInputField.setForeground(Color.BLUE);
	    epoBox.add(EpoWeightingInputField);
	    JTextField EpoCommentInputField = new JTextField("", 15);
        EpoCommentInputField.setForeground(Color.BLUE);
	    epoBox.add(EpoCommentInputField);
        JButton buttonEpos = new JButton("Klassenarbeit speichern");
		JLabel Other = new JLabel("Klassenarbeit");
		otherBox.add(Other);
	    JTextField OtherGradeInputField = new JTextField("", 15);
        OtherGradeInputField.setForeground(Color.BLUE);
	    otherBox.add(OtherGradeInputField);
	    JTextField OtherWeightingInputField = new JTextField("", 15);
        OtherWeightingInputField.setForeground(Color.BLUE);
	    otherBox.add(OtherWeightingInputField);
	    JTextField OtherCommentInputField = new JTextField("", 15);
        OtherCommentInputField.setForeground(Color.BLUE);
	    otherBox.add(OtherCommentInputField);
        JButton buttonOthers = new JButton("Klassenarbeit speichern");
        vert.add(headlinesBox);
        vert.add(examBox);
        vert.add(epoBox);
        vert.add(otherBox);
        vert.add(footerBox);
        pane.add(vert);
	    window.add(pane);
		window.setVisible(true);
	}
}
