package ProjektArbeit;

import java.awt.Color;
import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;

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
		JLabel puffer3 = new JLabel(" ");
		JLabel puffer4 = new JLabel("      ");
		JLabel puffer5 = new JLabel("                                                          ");
		JLabel grades = new JLabel("                                                                                                                                                                                                                                                                                   ");
		
		//Boxen zur Anordnung erstellen
		Box vert = Box.createVerticalBox();
		Box pufferBox = Box.createHorizontalBox();
		Box statisticsButtonsBox = Box.createHorizontalBox();
		
		
		JLabel labelpupilName = new JLabel("Hallo, " + getPupilName(userID)[0] + " " + getPupilName(userID)[1] + ":");
		
		JButton buttonCreatePDF = new JButton("PDF erzeugen");
		String currentUsername = getPupilName(userID)[0] + " " + getPupilName(userID)[1];
		buttonCreatePDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = pdf.document;
				Page page = pdf.page;
				page = pdf.setTitleForPDF(page);
				page = pdf.writeNameOfCurrentUserInPDF(page, currentUsername);
				String query = "select pupil.firstName, pupil.lastName, subject.name, grade.type, grade.grade, grade.date from grade "
								+ "inner join pupil on grade.pupilID = pupil.id "
								+ "inner join subject on grade.subjectID = subject.id "
								+ "where pupil.id = " + userID;
										
				try {
					document = pdf.createTableForPDFByQueryForAllData(document, query, 6);					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				pdf.saveDocument(document, "Notenübersicht.pdf");
			}
		});
		buttonCreatePDF.setVisible(false);
		statisticsButtonsBox.add(buttonCreatePDF);
		
		JButton buttonShowGrades = new JButton("alle Noten anzeigen");
		buttonShowGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder html = new StringBuilder("<html><body>");
                ArrayList<String> gradeList = new ArrayList<>();
				try {
					gradeList = queries.getGradeTypeDateTeacherSubjectByPupilId(userID);
					buttonCreatePDF.setVisible(true);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
                
							
                for (String grade : gradeList) {
                    html.append(grade).append("<br>");
                }
                html.append("</body></html>");
                grades.setText(html.toString());
            }
        });
		statisticsButtonsBox.add(buttonShowGrades);
		
		statisticsButtonsBox.add(puffer4);
		
		pufferBox.add(labelpupilName);
		pufferBox.add(puffer5);
		
		//Boxen anordnen
		vert.add(puffer1);
		vert.add(pufferBox);
		vert.add(puffer3);
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
