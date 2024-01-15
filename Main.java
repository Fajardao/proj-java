import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop == true) {

            clearScreen();

            System.out.println("XOXOXOXOXOXOXOXOXOXOXOXOX");
            System.out.println("O                       O");
            System.out.println("X       1 - Login       X");
            System.out.println("O      2 - Registar     O");
            System.out.println("X       3 - Sair        X");
            System.out.println("O                       O");
            System.out.println("XOXOXOXOXOXOXOXOXOXOXOXOX");

            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            System.out.println("Opção escolhida: " + opcao);

            switch (opcao) {
                case 1:
                    System.out.println("Login");
                    login();
                    break;
                case 2:
                    System.out.println("Registar");
                    break;
                case 3:
                    System.out.println("A terminar...");
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

        scanner.close();

    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nE-mail: ");
        String email = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();


    }

    public static void registar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUsername: ");
        String username = scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        System.out.println("Confirmar password: ");
        String passwordConfirm = scanner.nextLine();

        if (password.equals(passwordConfirm)) {
            System.out.println("Passwords iguais");
        } else {
            System.out.println("Passwords diferentes");
        }

        Utilizadores user = new Utilizadores(username, password, nome, true, email, "user");

        teste

    }
}
