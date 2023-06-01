package ProjektArbeit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class database {
	
	  static String myDriver = "com.mysql.cj.jdbc.Driver";
      static String url = "jdbc:mysql://localhost:3306/Projektarbeit";
      static String user = "root"; 
      static String pw = "test"; 

      
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
	
	
	
	public static int getAmountOfIDsByTableName(String tablename) throws ClassNotFoundException, SQLException {
			
			String query = "select count(id) from " + tablename;
		
			String[] amount = database.getDataFromDatabase(query, 1);
			
			int length = Integer.parseInt(amount[0]);
			
			return length;
			
		}
	
	
	public static int getAmountOfColumnsByTableName(String tablename) {
		
		if (tablename == "pupil")
			return 4;
		
		if (tablename == "teacher")
			return 6;
		
		if (tablename == "subject")
			return 2;
		
		if (tablename == "schoolclass")
			return 3;
		
		if (tablename == "grade")
			return 8;
		
		if (tablename == "pupilmanagement" || tablename == "teachermanagement")
			return 4;
		
		return -1;
		
	}
	
	public static String[] getcolumnNamesByTableName(String tablename) {
	
	
		
		if (tablename == "pupil") {
			String[] columnNames = {"id", "firstName", "lastName", "classID"};
			return columnNames;
		}
		
		if (tablename == "teacher"){
			String[] columnNames = {"id", "fistName", "lastName", "firstSubject", "secondSubject", "thirdSubject"};
			return columnNames;
		}
		
		if (tablename == "subject"){
			String[] columnNames = {"id", "name"};
			return columnNames;
		}
		
		if (tablename == "schoolclass"){
			String[] columnNames = {"id", "name", "level"};
			return columnNames;
		}
		
		if (tablename == "grade"){
			String[] columnNames = {"id", "grade", "weighting", "type", "date", "peopleID", "teacherID", "subjectID"};
			return columnNames;
		}
		
		if (tablename == "pupilmanagement"){
			String[] columnNames = {"id", "userName", "passwort", "pupilID"};
			return columnNames;
		}
		
		if (tablename == "teachermanagement"){
			String[] columnNames = {"id", "userName", "passwort", "teacherID"};
			return columnNames;
		}
		
		return null;
		
	}
	
	
	
	public static Connection connectToDatabase(String myDriver, String url, String user, String pw) throws ClassNotFoundException, SQLException {

	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(url, user, pw);
	      
	      return conn;    

	}
}
