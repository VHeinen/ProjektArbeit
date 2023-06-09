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

public class swing {  
	
	private static JFrame window;
	private static JLabel label;
	private static String currentGrade;
	private static String schoolClass;
	private static String subject;
	private static String pupil;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//JFrame erstellen, Button+Logik inklusive
		buildJFrame(true, 2);
	}
	
	public static JFrame buildJFrame(boolean teacher, int userID) throws ClassNotFoundException, SQLException {
		
		//JFrame aufbauen
		window = new JFrame();
		window.setTitle("Notenübersicht");
		window.setSize(1080, 1920);
		JPanel pane = new JPanel();
		JLabel currentGradeLabel = new JLabel();
		JLabel puffer1 = new JLabel(" "); 
		JLabel puffer2 = new JLabel(" "); 
		JLabel puffer3 = new JLabel(" "); 
		JLabel puffer4 = new JLabel(" ");
		JLabel grades = new JLabel("");
		
		//Boxen zur Anordnung erstellen
		Box vert = Box.createVerticalBox();
		Box dropdownClassBox = Box.createHorizontalBox();
		Box dropdownSubjectBox = Box.createHorizontalBox();
		Box dropdownStudentsBox = Box.createHorizontalBox();
		Box examBox = Box.createHorizontalBox();
		Box epoBox = Box.createHorizontalBox();
		Box otherBox = Box.createHorizontalBox();
		Box footerBox = Box.createHorizontalBox();
		Box statisticsButtonsBox = Box.createHorizontalBox();
		
		//Dropdownmenu Klassen
		String[] choicesClasses = queries.getNamesFromSchoolClass();
		JLabel dropdownClassLabel = new JLabel("Wähle eine Klasse ");
		dropdownClassBox.add(dropdownClassLabel);
		final JComboBox<String> dropdownClassCB = new JComboBox<String>(choicesClasses);
		dropdownClassBox.add(dropdownClassCB);
		dropdownClassCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DropDownClass wurde gewählt");
				initSchoolClass(dropdownClassCB);
				//TODO Notenart an Klasse fest machen -> Dropdown Menu 1+ bis 6 ODER eingabefenster Integer
			}
		});
		
		//Dropdownmenu Fächer
		String[] choicesSubject = queries.getSubjectNamesByTeacherID(userID);
		JLabel dropdownSubjectLabel = new JLabel("Wähle ein Fach aus ");
		dropdownSubjectBox.add(dropdownSubjectLabel);
		final JComboBox<String> dropdownSubjectCB = new JComboBox<String>(choicesSubject);
		dropdownSubjectBox.add(dropdownSubjectCB);
		dropdownSubjectCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DropDownSubject wurde gewählt");
				initSubject(dropdownSubjectCB);
			}
		});
		
		
		//Dropdownmenu Schüler
		String[] choicesStudents = queries.getPupilsFromPupil();
		JLabel dropdownStudentsLabel = new JLabel("Wähle einen Schüler aus");
		dropdownStudentsBox.add(dropdownStudentsLabel);
		final JComboBox<String> dropdownStudentsCB = new JComboBox<String>(choicesStudents);
		dropdownStudentsBox.add(dropdownStudentsCB);
		dropdownStudentsCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DropDownStudents wurde gewählt");
				initStudent(dropdownStudentsCB);
//				currentGrade = calculateCurrentGrade(pupil);
				currentGradeLabel.setText(currentGrade);
			}
		});
		
		//Überschriftenabschnitt
		JLabel headlines = new JLabel("Note                                                                                                             Kommentar                                                                                                                ");
		
		//Klassenarbeitsabschnitt
		JLabel exam = new JLabel("Klassenarbeit:  ");
		examBox.add(exam);
		JTextField examGradeInputField = new JTextField("", 15);
		examGradeInputField.setForeground(Color.BLUE);
		examBox.add(examGradeInputField);
//		JTextField examWeightingInputField = new JTextField("", 15);
//		examWeightingInputField.setForeground(Color.BLUE);
//		examBox.add(examWeightingInputField);
		JTextField examCommentInputField = new JTextField("", 15);
		examCommentInputField.setForeground(Color.BLUE);
		examBox.add(examCommentInputField);
		
		//Klassenarbeitsbutton
		JButton buttonExams = new JButton("Klassenarbeit speichern");
		buttonExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradeToken = examGradeInputField.getText();
//				float weightingToken = Float.parseFloat(examWeightingInputField.getText());
				String commentToken = examCommentInputField.getText();
				try {
					dbInsertGrade(gradeToken, commentToken, "Klassenarbeit");
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	//weightingToken entfernt
//				currentGrade = calculateCurrentGrade(pupil);
				currentGradeLabel.setText(currentGrade);
			}
		});
		footerBox.add(buttonExams);
		
		//Epochalnotenabschnitt
		JLabel Epo = new JLabel("Epochalnote:    ");
		epoBox.add(Epo);
		JTextField epoGradeInputField = new JTextField("", 15);
		epoGradeInputField.setForeground(Color.BLUE);
		epoBox.add(epoGradeInputField);
//		JTextField epoWeightingInputField = new JTextField("", 15);
//		epoWeightingInputField.setForeground(Color.BLUE);
//		epoBox.add(epoWeightingInputField);
		JTextField epoCommentInputField = new JTextField("", 15);
		epoCommentInputField.setForeground(Color.BLUE);
		epoBox.add(epoCommentInputField);
		
		//Epochalnotenbutton
		JButton buttonEpos = new JButton("Epochalnote speichern");
		buttonEpos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradeToken = epoGradeInputField.getText();
//				float weightingToken = Float.parseFloat(epoWeightingInputField.getText());
				String commentToken = epoCommentInputField.getText();
				try {
					dbInsertGrade(gradeToken, commentToken, "Epochalnote");
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	//weightingToken entfernt
//				currentGrade = calculateCurrentGrade(pupil);
				currentGradeLabel.setText(currentGrade);
			}
		});
		footerBox.add(buttonEpos);
		
		//Andere Note Abschnitt
		JLabel other = new JLabel("andere Note:    ");
		otherBox.add(other);
		JTextField otherGradeInputField = new JTextField("", 15);
		otherGradeInputField.setForeground(Color.BLUE);
		otherBox.add(otherGradeInputField);
//		JTextField otherWeightingInputField = new JTextField("", 15);
//		otherWeightingInputField.setForeground(Color.BLUE);
//		otherBox.add(otherWeightingInputField);
		JTextField otherCommentInputField = new JTextField("", 15);
		otherCommentInputField.setForeground(Color.BLUE);
		otherBox.add(otherCommentInputField);
		
		//Andere Note Button
		JButton buttonOthers = new JButton("andere Note speichern");
		buttonOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradeToken = epoGradeInputField.getText();
//				float weightingToken = Float.parseFloat(epoWeightingInputField.getText());
				String commentToken = epoCommentInputField.getText();
				try {
					dbInsertGrade(gradeToken, commentToken, commentToken);
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	//weightingToken entfernt
//				currentGrade = calculateCurrentGrade(pupil);
				currentGradeLabel.setText(currentGrade);
			}
		});
		footerBox.add(buttonOthers);
		
		JButton buttonShowGrades = new JButton("alle Noten anzeigen");
		buttonShowGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder html = new StringBuilder("<html><body>");

                ArrayList<String> gradeList = new ArrayList<>();
				try {
					gradeList = queries.getGradeTypeDateTeacherSubjectByPupilId(Integer.parseInt(queries.getIdFromPupilByName(getPupilName())[0]));
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
		
		//TODO: Zeugnis Ausgabe Button
		JButton buttonPrintCertificate = new JButton("Zeugnis ausgeben");
		buttonPrintCertificate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: selecte alle Infos aus der Datenbank anhand von pupil und erstelle eine hübsche PDF-Datei 
			}
		});
		statisticsButtonsBox.add(buttonPrintCertificate);
		
		//Boxen anordnen
		vert.add(dropdownClassBox);
		vert.add(dropdownSubjectBox);
		vert.add(dropdownStudentsBox);
		vert.add(puffer1);
		vert.add(headlines);
		vert.add(examBox);
		vert.add(epoBox);
		vert.add(otherBox);
		vert.add(puffer2);
		vert.add(footerBox);
		vert.add(puffer3);
		vert.add(currentGradeLabel);
		vert.add(puffer4);
		vert.add(statisticsButtonsBox);
		vert.add(grades);
		pane.add(vert);
		
		//JFrame fertigmachen
		window.add(pane);
		window.setVisible(true);
		
		return(window);
	}
	
//	public static String calculateCurrentGrade(String pupil) {
//		int gradeCount = 5;
//		double grade = 0.0; double gradeToken;
//		int weighting, length;
//		for(int i = 0; i < gradeCount; i++) {
//			gradeToken = 12;
//			weighting = 20;
//			grade = grade + gradeToken * weighting;
//		}
//		grade = grade / 100;
//		String ret = pupil + " aus der " + schoolClass + " hat derzeit " + grade + " Punkte in " + subject;
//		return(ret);
//	}
	
	public static void initStudent(JComboBox dropdownStudentsCB) {
		pupil = (String)dropdownStudentsCB.getSelectedItem();
	}
	
	public static void initSubject(JComboBox dropdownSubjectCB) {
		subject = (String)dropdownSubjectCB.getSelectedItem();
	}
	
	public static void initSchoolClass(JComboBox dropdownClassesCB) {
		schoolClass = (String)dropdownClassesCB.getSelectedItem();
	}
	
	public static void dbInsertGrade(String grade, String comment, String type) throws ClassNotFoundException, SQLException {	//float weighting entfernt
		Date date = new Date(System.currentTimeMillis());
		String query = "select count(id) from grade";
		String[] countStr = database.getDataFromDatabase(query, 1);
		int id = Integer.parseInt(countStr[0]);
		int pupilID = Integer.parseInt(queries.getIdFromPupilByName(getPupilName())[0]);
		int subjectID = Integer.parseInt(queries.getIdFromSubjectByName(subject)[0]);
		database.writeGradeInDatabase(id, Integer.parseInt(grade), 1.0f,  type, date, pupilID, password.userID, subjectID);
	}
	
	public static String[] getPupilName() {
	    String[] nameParts = pupil.split(" ");
	    return nameParts;
	}

	
}
