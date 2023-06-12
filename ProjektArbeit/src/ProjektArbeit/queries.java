package ProjektArbeit;

import java.sql.SQLException;
import java.util.ArrayList;

public class queries {

	
	public static String getAllDataFromPupilByID(int ID) {
		String query = "select * from pupil where id = " + ID;
		
		return query;
	}
	
	public static String getAllDataFromPupilByFirstName(String firstName) {
		String query = "select * from pupil where firstName = '" + firstName + "'";
	
		return query;
	}
	
	public static String[] getNamesFromSchoolClass() throws ClassNotFoundException, SQLException {
		String query = "select count(id) from schoolclass";
		String[] countStr = database.getDataFromDatabase(query, 1);
		int count = Integer.parseInt(countStr[0]);
		String[] returnArr = new String[count];
		String[] resultArr = new String[1];
		for(int i = 0; i < count; i++) {
			query = "select name from schoolclass" + " where id = '" + i + "'";
			resultArr = database.getDataFromDatabase(query, 1);
			returnArr[i] = resultArr[0];
		}
		return returnArr;
	}
	
	public static String[] getSubjectNamesByTeacherID(int userID) throws ClassNotFoundException, SQLException {
		String classQuery = "select firstSubjectID, secondSubjectID, thirdSubjectID from teacher where id = '" + userID + "'";
		String[] resultArr = database.getDataFromDatabase(classQuery, 3);
		classQuery = "select name from subject where id = '" + resultArr[0] + "'";
		String[]resultArr1 = database.getDataFromDatabase(classQuery, 1);
		classQuery = "select name from subject where id = '" + resultArr[1] + "'";
		String[]resultArr2 = database.getDataFromDatabase(classQuery, 1);
		classQuery = "select name from subject where id = '" + resultArr[2] + "'";
		String[]resultArr3 = database.getDataFromDatabase(classQuery, 1);
		resultArr[0] = resultArr1[0];
		resultArr[1] = resultArr2[0];
		resultArr[2] = resultArr3[0];
		return resultArr;
	}
	
	public static String[] getIdFromPupilByName(String[] nameParts) throws ClassNotFoundException, SQLException {
		String query = "select id from pupil where firstName = '" + nameParts[0] + "' and lastName = '" + nameParts[1] + "'";
		String[] resultArr = database.getDataFromDatabase(query, 1);
		return resultArr;
	}
	
	public static String[] getPupilsFromPupil() throws NumberFormatException, ClassNotFoundException, SQLException {
		String query = "select count(id) from pupil";
		String[] countStr = database.getDataFromDatabase(query, 1);
		int count = Integer.parseInt(countStr[0]);
		String[] resultArr = new String[2];
		String[] returnArr = new String[count];
		for(int i = 0; i < count; i++) {
			query = "select firstName, lastName from pupil where id = '" + i + "'";
			resultArr = database.getDataFromDatabase(query, 2);
			returnArr[i] = resultArr[0] + " " + resultArr[1];
		}
		return returnArr;
	}
	
	public static ArrayList<String> getGradeTypeDateTeacherSubjectByPupilId(int pupilID) throws ClassNotFoundException, SQLException {
	    ArrayList<String> gradeList = new ArrayList<>();
	    String query = "SELECT id, grade, type, date, teacherID, subjectID FROM grade WHERE pupilID = '" + pupilID + "' ORDER BY id ASC";
	    String[][] resultArr = database.getAllDataFromDatabase(query, 6);
	    
	    if (resultArr != null && resultArr.length > 0) {
	        for (String[] row : resultArr) {
	            if (row[0] != null) {
	                gradeList.add("Note: " + row[1] + " - Notenart: " + row[2] + " - Datum: " + row[3] + " - Lehrer: " + getTeacherNameFromTeacherByID(Integer.parseInt(row[4])) + " - Fach: " + getSubjectNameFromSubjectByID(Integer.parseInt(row[5])));
	            }
	        }
	    }
	    
	    return gradeList;
	}

	public static String getTeacherNameFromTeacherByID(int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT lastName FROM teacher WHERE id = '" + id + "'";
		return database.getDataFromDatabase(query, 1)[0];
	}
	
	public static String getSubjectNameFromSubjectByID(int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT name FROM subject WHERE id = '" + id + "'";
		return database.getDataFromDatabase(query, 1)[0];
	}
	
	public static String[] getIdFromSubjectByName(String name) throws ClassNotFoundException, SQLException {
		String query = "select id from subject where name = '" + name + "'";
		String[] resultArr = database.getDataFromDatabase(query, 1);
		return resultArr;
	}
	
	public static String[] getNameFromPupilByID(int userID) throws ClassNotFoundException, SQLException {
		String query = "SELECT firstName, lastName FROM pupil WHERE id = '" + userID + "'";
		return(database.getDataFromDatabase(query, 2));
	}
	
}
