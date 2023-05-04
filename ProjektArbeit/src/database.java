package ProjektArbeit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {

	    
	
	public static void writeInDatabse(String pupil, String grade, String type, float weighting, String subject, String comment ) {
		
		  String myDriver = "com.mysql.cj.jdbc.Driver";
	      String url = "jdbc:mysql://localhost:3306/Projektarbeit";
	      String user = "root"; 
	      String pw = "test"; 
	      String sql;
		
		try
	      {
	        Connection conn = connection(myDriver, url, user, pw);


	        System.out.println("Inserting records into the table...");


	        sql = "insert into daten (pupil, grade, type, weighting, subject, comment) " + "values (?, ?, ?, ?, ?, ?)";
	        
	        
	        PreparedStatement preparedStm = conn.prepareStatement(sql);

	        preparedStm.setString(2, pupil);
	        preparedStm.setString(3, grade);
	        preparedStm.setString(4, type);
	        preparedStm.setFloat(5, weighting);
	        preparedStm.setString(6, subject);
	        preparedStm.setString(7, comment);
	        // 1-6 oder 2-7?


	        preparedStm.execute();

	        System.out.println("--Records inserted--");

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
