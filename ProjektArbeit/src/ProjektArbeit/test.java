package ProjektArbeit;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	// - How to inserate in database - 
		
//		database.writeSubjectInDatabase(0, "LF1");
//		database.writeSubjectInDatabase(1, "Englisch");
//		database.writeSubjectInDatabase(2, "LF2");
//		database.writeSubjectInDatabase(3, "Lf3");
//		database.writeSubjectInDatabase(4, "Deutsch");
//		database.writeSubjectInDatabase(5, "Mathe");
//		database.writeSubjectInDatabase(6, "Reli");
//		database.writeSubjectInDatabase(7, "LF4");
//		database.writeSubjectInDatabase(8, "LF5");
//		database.writeSubjectInDatabase(9, "LF6");
//		database.writeSubjectInDatabase(10, "LF7");
//		database.writeSubjectInDatabase(11, "LF8");
//		database.writeSubjectInDatabase(12, "LF9");
//		database.writeSubjectInDatabase(13, "LF10");
//		database.writeSubjectInDatabase(14, "LF11");
//		database.writeSubjectInDatabase(15, "LF12");
//		database.writeSubjectInDatabase(16, "Sport");
//		database.writeSubjectInDatabase(17, "Erdkunde");
//		database.writeSubjectInDatabase(18, "Spanisch");
//		database.writeSubjectInDatabase(19, "Sozialkunde");
//		database.writeSubjectInDatabase(20, "Geschichte");
//		
//		database.writeSchoolclassInDatabase(0, "BSIT22a", 1);
//		database.writeSchoolclassInDatabase(1, "1a", 0);
//		database.writeSchoolclassInDatabase(1, "4c", 4);
//		database.writeSchoolclassInDatabase(3, "TestClass", 0);
//		
//		database.writeTeacherInDatabase(0, "Test", "Test", 0, 0, 0);
//		database.writeTeacherInDatabase(1, "Tara", "Thom", 0, 2, 3);
//		database.writeTeacherInDatabase(2, "Tom", "Tree", 5, 2, 0);
//		database.writeTeacherInDatabase(3, "Ken", "Kankeki", 1, 2, 0);
//		database.writeTeacherInDatabase(4, "Hans", "Baum", 5, 3, 10);
//		database.writeTeacherInDatabase(5, "Peter", "Müller", 10, 8, 3);
//		database.writeTeacherInDatabase(6, "Johanna", "Tee", 4, 8, 20);
//		database.writeTeacherInDatabase(7, "Beate", "Klaus", 20, 19, 1);
//		database.writeTeacherInDatabase(8, "Angelika", "Raute", 1, 2, 3);
//		database.writeTeacherInDatabase(9, "Florian", "Edgar", 1, 4, 7);
//		database.writeTeacherInDatabase(10, "Jürgen", "Blub", 12, 13, 15);
//		
//		database.writePupilInDatabase(0, "Test", "Test", 0);
//		database.writePupilInDatabase(1, "Hans", "Olaf", 2);
//		database.writePupilInDatabase(2, "Irene", "Plam", 0);
//		database.writePupilInDatabase(3, "Harald", "Wurst", 2);
//		database.writePupilInDatabase(4, "Java", "Itzz", 1);
//		database.writePupilInDatabase(5, "Jason", "Wald", 1);
//		database.writePupilInDatabase(6, "Franz", "Erhardt", 3);
//		database.writePupilInDatabase(7, "Jessica", "Nutella", 3);
//		database.writePupilInDatabase(8, "Petra", "Potsdamm", 1);
//		database.writePupilInDatabase(9, "Günther", "Udo", 1);
//		database.writePupilInDatabase(10, "Popo", "Lala", 3);
//		database.writePupilInDatabase(11, "Olaf", "Snowman", 2);
//		database.writePupilInDatabase(12, "Que", "Nyguen", 1);
//		database.writePupilInDatabase(13, "Exe", "NotFound", 2);
//		database.writePupilInDatabase(14, "Saskia", "Schwarz", 3);
//		database.writePupilInDatabase(15, "Jonas", "Johann", 1);
//		database.writePupilInDatabase(16, "Karsten", "Key", 2);
//		database.writePupilInDatabase(17, "Lilly", "Lama", 3);
//		database.writePupilInDatabase(18, "Bernhard", "Bob", 1);
//		database.writePupilInDatabase(19, "Willy", "Braun", 3);
//		database.writePupilInDatabase(20, "Lara", "Udo", 1);
//		database.writePupilInDatabase(21, "Anna", "Blatt", 2);
//		database.writePupilInDatabase(22, "Gutfried", "Hye", 2);
//		database.writePupilInDatabase(23, "Zorro", "Zahn", 3);
//		database.writePupilInDatabase(24, "Yuuki", "Hanabi", 1);
//		database.writePupilInDatabase(25, "Bernd", "Hard", 2);	
//		
//		database.writeGradeInDatabase(0, 6, 2.0f, "Test", Date.valueOf("2025-05-20"), 0, 0, 0);
//		database.writeGradeInDatabase(1, 6, 2.0f, "Test", Date.valueOf("2025-05-20"), 0, 0, 0);
//		database.writeGradeInDatabase(2, 6, 2.0f, "Test", Date.valueOf("2023-05-08"), 12, 4, 3);
//		database.writeGradeInDatabase(3, 1, 20.0f, "Klassenarbeit", Date.valueOf("2023-05-25"), 7, 6, 1);
//		database.writeGradeInDatabase(4, 3, 4.0f, "Präsi", Date.valueOf("2023-02-24"), 1, 2, 6);
//		database.writeGradeInDatabase(5, 4, 8.0f, "Test", Date.valueOf("2023-03-12"), 8, 8, 8);
//		database.writeGradeInDatabase(6, 2, 15.0f, "Aufgaben Abgabe", Date.valueOf("2023-01-04"), 20, 10, 4);
//		
//		database.writePupilManagementInDatabase(0, "01test", "test", 0);
//		database.writePupilManagementInDatabase(1, "01HansOlaf", "xyz123", 1);
//		database.writePupilManagementInDatabase(2, "01IrenePalm", "123456789", 2);
//		database.writePupilManagementInDatabase(3, "01HaraldWurst", "wuurst", 3);
//		database.writePupilManagementInDatabase(4, "01JavaItzz", "123", 4);
//		database.writePupilManagementInDatabase(5, "01JasonWald", "jw4ld", 5);
//		
//		database.writeTeacherManagementInDatabase(0, "00test", "test", 0);
//		database.writeTeacherManagementInDatabase(1, "00TaraThom", "Ibims1Teacher", 1);
//		database.writeTeacherManagementInDatabase(2, "00TomTree", "Baum123", 2);
//		database.writeTeacherManagementInDatabase(3, "00KenKaneki", "Toka", 3);
//		database.writeTeacherManagementInDatabase(4, "00HansBaum", "hans", 3);
		
		
		
		// - How to get data from database -
	
//		String[] resultArr = database.getDataFromDatabase("select * from pupil where id = 4", 4);
//		for (String elements : resultArr) {
//			System.out.println(elements);
//		}
//		
//		String queryy = "select * from teacher where id = 0 and lastName = 'Test'";
//		String[] test = database.getDataFromDatabase(queryy, 6);
//		
//		String[] testi = database.getDataFromDatabase(queries.getAllDataFromPupilByID(1), 4);
//		String[] testt = database.getDataFromDatabase(queries.getAllDataFromPupilByFirstName("Test"), 4);
//		String queryyy = "select count(id) from pupil";
//		String[] testtt = database.getDataFromDatabase(queryyy, 1);
//		
//		
//		for (String elements : test) {
//			System.out.println(elements);
//		}
		
		
		
		
		//  - How to change Data from database -
		
//		String tableName = "pupil";
//		String columnName = "firstName";
//		int id = 22;
//		String change = "Gutfried";
//		
//		database.changeDataInDatabaseByTableNameAndColumnName(tableName, columnName, id, change);
		
		
		
		// - How to create pdf -
		
//		Document document = pdf.document;
//		Page page = pdf.page;
//		page = pdf.setTitleForPDF(page);
//		
//		document = pdf.createTableForPDFBytableName(document, "pupil");
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		document = pdf.createTableForPDFBytableName(document, "subject");
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		String query;
//		
//		query = "select pupil.firstName, pupil.lastName, subject.name, grade.type, grade.grade, grade.date from grade "
//				+ "inner join pupil on grade.pupilID = pupil.id "
//				+ "inner join subject on grade.subjectID = subject.id "
//				+ "where pupil.id = 1";
//		document = pdf.createTableForPDFByQueryForAllData(document, query, 6);
		
//		query = "select * from pupil where id = 1";
//		document = pdf.createTableForPDFByQueryForAllData(document, query, 4);
//		
//		query = "select * from grade inner join pupil where grade.pupilID = pupil.id and pupil.id = " + 1;
//		document = pdf.createTableForPDFByQuery(document, query, 8);
//		
//		query = "select * from grade inner join pupil where grade.pupilID = pupil.ID and pupil.id = " + 1;
//		document = pdf.createTableForPDFByQuery(document, query, 8);
//	
//		 query = "select id from pupil where id = 5";
//		document = pdf.createTableForPDFByQuery(document, page, query, 1);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		 query = "select id, firstName from pupil where id = 5";
//		document = pdf.createTableForPDFByQuery(document, page, query, 2);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		
//		 query = "select id, firstName, lastName from pupil where id = 5";
//		document = pdf.createTableForPDFByQuery(document, query, 3);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		document = pdf.createWhitespaceForNewTables(document);
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		query = "select id, firstName, lastName, classID from pupil where id = 5";
//		document = pdf.createTableForPDFByQuery(document, query, 4);
//		
//		document = pdf.createWhitespaceForNewTables(document);	
//		
//		
//		query = "select id, grade, weighting, type, date from grade where id = 2";
//		document = pdf.createTableForPDFByQuery(document, query, 5);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		query = "select id, grade, weighting, type, date, pupilID from grade where id = 2";
//		document = pdf.createTableForPDFByQuery(document, query, 6);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		query = "select id, grade, weighting, type, date, pupilID, teacherID from grade where id = 2";
//		document = pdf.createTableForPDFByQuery(document, query, 7);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		query = "select id, grade, weighting, type, date, pupilID, teacherID, subjectID from grade where id = 2";
//		document = pdf.createTableForPDFByQuery(document, query, 8);
//		
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		
//		document = pdf.createTableForPDFBytableName(document, "teacher");
//		document = pdf.createWhitespaceForNewTables(document);
//		
//		
//		query = "select * from pupil where id = " + 2;
//		document = pdf.createTableForPDFByQuery(document, query, database.getAmountOfColumnsByTableName("pupil"));
//		
//		query = "select id from subject";
//		document = pdf.createTableForPDFByQuery(document, query, 1);
//		
//		query = "select * from grade where pupilID = " + 2;
//		document = pdf.createTableForPDFByQuery(document, query, 8);
//		
//		pdf.saveDocument(document, "Notenübersicht.pdf");
		
		
		
		
	}

}
