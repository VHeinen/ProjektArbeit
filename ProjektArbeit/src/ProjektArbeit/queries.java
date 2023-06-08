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
		String[] resultArr = database.getDataFromDatabase(classQuery, 1);
		return resultArr;
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
	
	public static String[] getPupilsFromPupil() throws NumberFormatException, ClassNotFoundException, SQLException {
		String query = "select count(id) from pupil";
		String[] countStr = database.getDataFromDatabase(query, 1);
		int count = Integer.parseInt(countStr[0]);
		String[] resultArr = new String[2];
		String[] returnArr = new String[count];
		for(int i = 0; i < count; i++) {
			String pupilQuery = "select firstName, lastName from pupil where id = '" + i + "'";
			resultArr = database.getDataFromDatabase(pupilQuery, 2);
			returnArr[i] = resultArr[0] + " " + resultArr[1];
		}
		return returnArr;
	}
}
