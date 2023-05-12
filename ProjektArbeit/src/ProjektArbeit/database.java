package ProjektArbeit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

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
	        Connection conn = connection(myDriver, url, user, pw);

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
		sql = "insert into teacher (id, fristName, lastName, firstSubjectID, ) " + "values (?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connection(myDriver, url, user, pw);

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
	        Connection conn = connection(myDriver, url, user, pw);

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
	        Connection conn = connection(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setInt(2, grade);
	        preparedStm.setFloat(3, weighting);
	        preparedStm.setString(4, type);
	        preparedStm.setDate(5, (java.sql.Date) date);
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
		sql = "insert into subjcet (id, name) " + "values (?, ?)";
		
		try
	      {
	        Connection conn = connection(myDriver, url, user, pw);

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
		sql = "insert into subjcet (id, userName, passwort, teacherID) " + "values (?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connection(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, userName);
	        preparedStm.setString(2, passwort);
	        preparedStm.setInt(1, pupilID);
	       
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
		sql = "insert into subjcet (id, userName, passwort, teacherID) " + "values (?, ?, ?, ?)";
		
		try
	      {
	        Connection conn = connection(myDriver, url, user, pw);

	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        
	        preparedStm.setInt(1, id);
	        preparedStm.setString(2, userName);
	        preparedStm.setString(2, passwort);
	        preparedStm.setInt(1, teacherID);
	       
	        preparedStm.execute();
	        conn.close();

	      }

	      catch(Exception e)
	      {
	        e.printStackTrace();
	        System.out.println(e);
	      }
		
	}
	
	
	
		  public static Connection connection(String myDriver, String url, String user, String pw) throws ClassNotFoundException, SQLException {

	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(url, user, pw);

	      System.out.println("--Database Connected--");

	      return conn;

	    

	}

	    

}
