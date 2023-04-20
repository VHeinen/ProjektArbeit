import java.io.*;
import java.util.Scanner;


public class List_Adressverwaltung {

    public static void main(String[] args) throws IOException {


        FileReader reader = new FileReader("C:\\Users\\VHeinen\\Test_File_Java\\Test.txt");


        Scanner sc = new Scanner(System.in);

        String[] list = new String[9];

        System.out.println("Wie lautet Ihr Vorname?");
        list[0] = sc.next();

        System.out.println("Wie lautet Ihr Nachname?");
        list[1] = sc.next();

        System.out.println("Wie lautet Ihre Adresse? 'Straße, Hausnummer'");
        list[2] = sc.next();
        list[3] = sc.next();

        System.out.println("Wie lautet Ihre Postleitzahl?");
        list[4] = sc.next();

        System.out.println("Wie lautet Ihr Wohnort?");
        list[5] = sc.next();

        System.out.println("Wie lautet Ihre E-Mail?");
        list[6] = sc.next();

        System.out.println("Wie lautet Ihre Telefonnummer? 'Vorwahl, Rufnummer'");
        list[7] = sc.next();
        list[8] = sc.next();

        System.out.println("\n --Ihre Daten wurden erfolgreich gespeichert-- \n");



        try {
            FileWriter writer = new FileWriter("C:\\Users\\VHeinen\\Test_File_Java\\Test.txt", true);



        for (int i = 0; i < list.length; i++){
            writer.write(list[i] + " \n");
        }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
