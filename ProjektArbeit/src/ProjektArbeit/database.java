package ProjektArbeit;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class database {
	
    private static String myDriver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/Projektarbeit";
    private static String user = "root";
    private static String pw = "test";
    private static Connection conn; // Add this line to store the connection

      
  	public static Connection connectToDatabase(String myDriver, String url, String user, String pw) throws ClassNotFoundException, SQLException {

  		Class.forName(myDriver);
  	    conn = DriverManager.getConnection(url, user, pw);
  	    return conn;   

	}
  	
	public static void closeConnection() {
	    try {
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
      
	public static void writePupilInDatabase(int id, String firstName, String lastName, int classID) {
		
		String sql;
		sql = "insert into pupil (id, firstName, lastName, classID) " + "values (?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, firstName);
	        preparedStm.setString(3, lastName);
	        preparedStm.setInt(4, classID);
	        
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
	}
	
	public static void writeTeacherInDatabase(int id, String firstName, String lastName, int firstSubjectID, int secondSubjectID, int thirdSubjectID) {
		
		
		String sql;
		sql = "insert into teacher (id, firstName, lastName, firstSubjectID, secondSubjectID, thirdSubjectID) " + "values (?, ?, ?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, firstName);
	        preparedStm.setString(3, lastName);
	        preparedStm.setInt(4, firstSubjectID);
	        preparedStm.setInt(5, secondSubjectID);
	        preparedStm.setInt(6, thirdSubjectID);
	        
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
	}
	
	public static void writeSchoolclassInDatabase(int id, String name, int level) {
		
		
		String sql;
		sql = "insert into schoolclass (id, name, level) " + "values (?, ?, ?)";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, name);
	        preparedStm.setInt(3, level);
	        
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
	}
	
	public static void writeGradeInDatabase(int id, int grade, float weighting, String type, Date date, int pupilID, int teacherID, int subjectID) {
		
		
		String sql;
		sql = "insert into grade (id, grade, weighting, type, date, pupilID, teacherID, subjectID) " + "values (?, ?, ?, ?, ?, ?, ?, ? )";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setInt(2, grade);
	        preparedStm.setFloat(3, weighting);
	        preparedStm.setString(4, type);
	        preparedStm.setDate(5, date);
	        preparedStm.setInt(6, pupilID);
	        preparedStm.setInt(7, teacherID);
	        preparedStm.setInt(8, subjectID);
	        
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }	
	}
	
	public static void writeSubjectInDatabase(int id, String name) {
		
		String sql;
		sql = "insert into subject (id, name) " + "values (?, ?)";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, name);
	        
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
	}
	
	
	public static void writePupilManagementInDatabase(int id, String userName, String passwort, int pupilID) {
		
		String sql;
		sql = "insert into pupilmanagement (id, userName, passwort, pupilID) " + "values (?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);
	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, userName);
	        preparedStm.setString(3, passwort);
	        preparedStm.setInt(4, pupilID);
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
	}
	
	
	public static void writeTeacherManagementInDatabase(int id, String userName, String passwort, int teacherID) {
		
		String sql;
		sql = "insert into teachermanagement (id, userName, passwort, teacherID) " + "values (?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connectToDatabase(myDriver, url, user, pw);
	        PreparedStatement preparedStm = conn.prepareStatement(sql);
        
	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, userName);
	        preparedStm.setString(3, passwort);
	        preparedStm.setInt(4, teacherID);
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
		
	}
	
	
	
	public static String[] getDataFromDatabase(String query, int length) throws ClassNotFoundException, SQLException {
		
		
		Connection conn = connectToDatabase(myDriver, url, user, pw);	
		Statement stm = conn.createStatement();
		ResultSet resultS = stm.executeQuery(query);
		
		String[] resultArray = new String[length];
		  			
		while (resultS.next()) { 
			for (int i = 1; i <= length; i++) {
				resultArray[i-1] = resultS.getString(i);
			}
		}
			                              
		resultS.close();
		stm.close();
		
		return resultArray;
	}
	
	public static String[][] getAllDataFromDatabase(String query, int length) throws ClassNotFoundException, SQLException {
	    Connection conn = connectToDatabase(myDriver, url, user, pw);
	    Statement stm = conn.createStatement();
	    ResultSet resultS = stm.executeQuery(query);

	    ArrayList<String[]> resultList = new ArrayList<>();

	    while (resultS.next()) {
	        String[] row = new String[length];
	        for (int i = 1; i <= length; i++) {
	            row[i - 1] = resultS.getString(i);
	        }
	        resultList.add(row);
	    }

	    resultS.close();
	    stm.close();

	    // Convert ArrayList to 2D array
	    String[][] resultArray = new String[resultList.size()][length];
	    for (int i = 0; i < resultList.size(); i++) {
	        resultArray[i] = resultList.get(i);
	    }

	    return resultArray;
	}

	
	public static int getAmountOfIDsByTableName(String tablename) throws ClassNotFoundException, SQLException {
			
			String query = "select count(id) from " + tablename;
		
			String[] amount = database.getDataFromDatabase(query, 1);
			
			int length = Integer.parseInt(amount[0]);
			
			return length;
			
		}
	
	
	public static int getAmountOfColumnsByTableName(String tablename) {
		
		if (tablename.equals("pupil"))
			return 4;
		
		if (tablename.equals("teacher"))
			return 6;
		
		if (tablename.equals("subject"))
			return 2;
		
		if (tablename.equals("schoolclass"))
			return 3;
		
		if (tablename.equals("grade"))
			return 8;
		
		if (tablename.equals("pupilmanagement") || tablename.equals("teachermanagement"))
			return 4;
		
		return -1;
		
	}
	
	public static String[] getColumnNamesByTableName(String tablename) {
	
	
		
		if (tablename.equals("pupil")) {
			String[] columnNames = {"id", "firstName", "lastName", "classID"};
			return columnNames;
		}
		
		if (tablename.equals("teacher")){
			String[] columnNames = {"id", "fistName", "lastName", "firstSubject", "secondSubject", "thirdSubject"};
			return columnNames;
		}
		
		if (tablename.equals("subject")){
			String[] columnNames = {"id", "name"};
			return columnNames;
		}
		
		if (tablename.equals("schoolclass")){
			String[] columnNames = {"id", "name", "level"};
			return columnNames;
		}
		
		if (tablename.equals("grade")){
			String[] columnNames = {"id", "grade", "weighting", "type", "date", "peopleID", "teacherID", "subjectID"};
			return columnNames;
		}
		
		if (tablename.equals("pupilmanagement")){
			String[] columnNames = {"id", "userName", "passwort", "pupilID"};
			return columnNames;
		}
		
		if (tablename.equals("teachermanagement")){
			String[] columnNames = {"id", "userName", "passwort", "teacherID"};
			return columnNames;
		}
		
		return null;
		
	}
	
	
	
	
	public static void changeDataInDatabaseByTableNameAndColumnName(String tableName, String columnName, int id, String change) throws ClassNotFoundException, SQLException {
		
		String query = "update " + tableName + " set " + columnName  + " = ? where id = ?";
		
		Connection conn = connectToDatabase(myDriver, url, user, pw);
        PreparedStatement preparedStm = conn.prepareStatement(query);
		
        
       	preparedStm.setString(1, change);
        preparedStm.setInt(2, id);
		
        preparedStm.executeUpdate();
        conn.close();
        
	}
	
	
	public static void changeDataInDatabaseByTableNameAndColumnName(String tableName, String columnName, int id, int change) throws ClassNotFoundException, SQLException {
		
		String query = "update " + tableName + " set " + columnName  + " = ? where id = ?";
		
		Connection conn = connectToDatabase(myDriver, url, user, pw);
        PreparedStatement preparedStm = conn.prepareStatement(query);
		
        
       	preparedStm.setInt(1, change);
        preparedStm.setInt(2, id);
		
        preparedStm.executeUpdate();
        conn.close();
        
	}
	
	
	public static void changeDataInDatabaseByTableNameAndColumnName(String tableName, String columnName, int id, float change) throws ClassNotFoundException, SQLException {
		
		String query = "update " + tableName + " set " + columnName  + " = ? where id = ?";
		
		Connection conn = connectToDatabase(myDriver, url, user, pw);
        PreparedStatement preparedStm = conn.prepareStatement(query);
		
        
       	preparedStm.setFloat(1, change);
        preparedStm.setInt(2, id);
		
        preparedStm.executeUpdate();
        conn.close();
        
	}
	
	
		public static void changeDataInDatabaseByTableNameAndColumnName(String tableName, String columnName, int id, Date change) throws ClassNotFoundException, SQLException {
		
		String query = "update " + tableName + " set " + columnName  + " = ? where id = ?";
		
		Connection conn = connectToDatabase(myDriver, url, user, pw);
        PreparedStatement preparedStm = conn.prepareStatement(query);
		
        
       	preparedStm.setDate(1, change);
        preparedStm.setInt(2, id);
		
        preparedStm.executeUpdate();
        conn.close();
        
	}
}