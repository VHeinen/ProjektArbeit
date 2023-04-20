import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class Adressverwaltung {
    public static void main(String[] args) throws IOException {

      Scanner sc = new Scanner(System.in);


      // txt Variablen

      String home_path = System.getProperty("user.home");
      String file_name = "Adressverwaltung.txt";
      String path = home_path + File.separator + file_name;

      // System.out.println(path);



      String firstNameQuestion = "Wie lautet Ihr Vorname?";
      String firstNameOutput = "Der Vorname '";

      String surenameQuestion = "Wie lautet Ihr Nachname?";
      String surenameOutput = "Der Nachname '";

      String addressQuestion = "Wie lautet Ihre Adresse? 'Straße, Hausnummer'";
      String adressOutput = "Die Adresse '";

      String zipCodeQuestion = "Wie lautet Ihre Postleitzahl?";
      String zipCodeOutput = "Die PLZ '";

      String townQuestion = "Wie lautet Ihr Wohnort?";
      String townOutput = "Der Wohnort '";

      String emailQuestion = "Wie lautet Ihre E-Mail?";
      String emailOutput = "Die E-Mail '";

      String phoneQuestion = "Wie lautet Ihre Telefonnummer? 'Vorwahl, Rufnummer'";
      String phoneOutput = "Die Telefonnummer '";

      String outputEnding = "' wurde registriert.\n";


      // MySQL Variablen

      String myDriver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/adressverwaltung";
      String user = "root";
      String pw = "test";
      String sql;


      // Erfassung der Daten

      System.out.println(firstNameQuestion);
      String firstName = sc.next();
      System.out.println(firstNameOutput + firstName + outputEnding);

      System.out.println(surenameQuestion);
      String surename = sc.next();
      System.out.println(surenameOutput + surename + outputEnding);

      System.out.println(addressQuestion);
      String street = sc.next();
      String houseNumber = sc.next();
      System.out.println(adressOutput + street + " " + houseNumber + outputEnding);

      System.out.println(zipCodeQuestion);
      String zipCode = sc.next();
      System.out.println(zipCodeOutput + zipCode + outputEnding);

      System.out.println(townQuestion);
      String town = sc.next();
      System.out.println(townOutput + town + outputEnding);

      System.out.println(emailQuestion);
      String email = sc.next();
      System.out.println(emailOutput + email + outputEnding);

      System.out.println(phoneQuestion);
      String areaCode = sc.next();
      String number = sc.next();
      System.out.println(phoneOutput + areaCode + " " + number + outputEnding);



      System.out.println("--Your data has been saved successfully--");




      // Daten in txt Datei schreiben

     // writeInTxt(path, firstName, surename, street, houseNumber, zipCode, town, email, areaCode, number);



      // Daten in MySQL Datenbank schreiben

      try
      {
        Connection conn = connection(myDriver, url, user, pw);


        System.out.println("Inserting records into the table...");



        sql = "insert into daten (vorname, nachname, strasse, hausnummer, plz, ort, email, vorwahl, rufnummer) " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStm = conn.prepareStatement(sql);

        preparedStm.setString(1, firstName);
        preparedStm.setString(2, surename);
        preparedStm.setString(3, street);
        preparedStm.setString(4, houseNumber);
        preparedStm.setString(5, zipCode);
        preparedStm.setString(6, town);
        preparedStm.setString(7, email);
        preparedStm.setString(8, areaCode);
        preparedStm.setString(9, number);


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

    // connection to Database
    public static Connection connection(String myDriver, String url, String user, String pw) throws ClassNotFoundException, SQLException {

      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(url, user, pw);

      System.out.println("--Database Connected--");

      return conn;

    }

    // write in txt
    public static void writeInTxt(String path, String firstName, String surename, String street, String houseNumber, String zipCode, String town, String email, String areaCode, String number) throws FileNotFoundException {

      //FileReader reader = new FileReader(path);

      try {
        FileWriter writer = new FileWriter(path, true);


        writer.write( " " + "Vorname: " + firstName + "\n Nachname: " + surename + "\n Adresse: " + street  + " " + houseNumber + "\n PLZ: " + zipCode + "\n Wohnort: " + town + "\n E-Mail: " + email + "\n Telefon: " + areaCode + " " + number);
        writer.write("\n--------------------------------------------------\n");

        writer.close();

      } catch (IOException e) {
        e.printStackTrace();
      }

    }



}
