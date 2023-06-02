package ProjektArbeit;

import java.sql.SQLException;

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
		String classQuery = "select name from schoolclass";
		String[] resultArr = database.getDataFromDatabase(classQuery, 2);
		return resultArr;
	}
	
	public static String[] getSubjectNamesByTeacherID(int userID) throws ClassNotFoundException, SQLException {
		String classQuery = "select firstSubjectID, secondSubjectID, thirdSubjectID from teacher  id = '" + userID + "'";
		String[] resultArr = database.getDataFromDatabase(classQuery, 3);
		classQuery = "select name from subject where id = '" + resultArr[0] + "' or id = '" + resultArr[1] + "' or id = '" + resultArr[2] + "'";
		resultArr = database.getDataFromDatabase(classQuery, 3);
		return resultArr;
	}
	
	public static String[] getPupilsFromPupilByClassID(String schoolClass) throws NumberFormatException, ClassNotFoundException, SQLException {
		String classQuery = "select id from schoolclass where name = '" + schoolClass + "'";
		int id = Integer.parseInt(database.getDataFromDatabase(classQuery, 1)[0]);
		String pupilQuery = "select firstName, lastName from pupil where classID = " + id;
		String[] resultArr = database.getDataFromDatabase(classQuery, 100);
		String[] returnArr = new String[50];
		int j = 0;
		for(int i = 0; i < 100; i++) {
			returnArr[i] = resultArr[j] + resultArr[j+1];
			j += 2;
		}
		return returnArr;
	}
}