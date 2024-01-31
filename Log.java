import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Log {

    public static void log(String msg) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(msg + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateInfoSys(Utilizadores user) {

        int numInfoSys = getNumInfoSys();

        try {
            FileWriter writer = new FileWriter("info_sistema.dat");
            writer.write((numInfoSys + 1) + " " + user.getNome());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int getNumInfoSys() {
        try {
            File myFile = new File("info_sistema.dat");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // Dividir a linha em partes usando espaço como delimitador
                String[] parts = data.split(" ");

                // Converter a primeira parte em um número
                int number = Integer.parseInt(parts[0]);

                return number;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void verLog() {

        System.out.println(" - - - LOG - - - ");

        try {
            File myFile = new File("log.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(" - - - - - - - - ");
    }

    
}
