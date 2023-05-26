package ProjektArbeit;

public class queries {

	
	public static String getAllDataFromPupilByID(int ID) {
		String query = "select * from pupil where id = " + ID;
		
		return query;
	}
	
	public static String getAllDataFromPupilByFirstName(String firstName) {
		String query = "select * from pupil where firstName = '" + firstName + "'";
	
		return query;
	}
	
}
