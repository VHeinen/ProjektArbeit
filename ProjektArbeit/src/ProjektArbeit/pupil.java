package ProjektArbeit;

import java.awt.Color;
import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class pupil {  
	
	private static JFrame window;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//JFrame erstellen
		buildJFrame(false, password.userID);
	}
	
	public static JFrame buildJFrame(boolean teacher, int userID) throws ClassNotFoundException, SQLException {
		
		//JFrame aufbauen
		window = new JFrame();
		window.setTitle("Notenübersicht - Schüler");
		window.setSize(1080, 1920);
		JPanel pane = new JPanel();
		JLabel puffer1 = new JLabel("                                                                                                                                                                                                                                                                                  ");
		JLabel puffer2 = new JLabel(" "); 
		JLabel grades = new JLabel("                                                                                                                                                                                                                                                                                   ");
		
		//Boxen zur Anordnung erstellen
		Box vert = Box.createVerticalBox();
		Box statisticsButtonsBox = Box.createHorizontalBox();
		
		JButton buttonShowGrades = new JButton("alle Noten von " + getPupilName(userID)[0] + " " + getPupilName(userID)[1] + " anzeigen");
		buttonShowGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder html = new StringBuilder("<html><body>");

                ArrayList<String> gradeList = new ArrayList<>();
				try {
					gradeList = queries.getGradeTypeDateTeacherSubjectByPupilId(userID);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
                
                // Generate HTML string dynamically based on grades
                for (String grade : gradeList) {
                    html.append(grade).append("<br>");
                }
                html.append("</body></html>");
                grades.setText(html.toString());
            }
        });
		statisticsButtonsBox.add(buttonShowGrades);
		
		//Boxen anordnen
		vert.add(puffer1);
		vert.add(statisticsButtonsBox);
		vert.add(puffer2);
		vert.add(grades);
		pane.add(vert);
		
		//JFrame fertigmachen
		window.add(pane);
		window.setVisible(true);
		
		return(window);
	}	
	
	public static String[] getPupilName(int userID) throws ClassNotFoundException, SQLException {
	    return(queries.getNameFromPupilByID(userID));
	}
}
