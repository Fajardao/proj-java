import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuGestor {

    private static List<Utilizadores> users;
    private static Scanner scanner2 = new Scanner(System.in);

    public static void menuGestor(List<Utilizadores> listUsers, Utilizadores atualUser) {

        users = listUsers;

        boolean loop = true;

        while (loop) {

            Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Validar utilizadores");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();

            switch (opcao) {
                case 1:
                    validarUsers();
                    break;
                case 0:
                    System.out.println("Logout");
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            System.out.println("Prima enter para continuar");
            scanner2.nextLine();
            scanner2.nextLine();

        }

    }

    private static void validarUsers() {

        int i = 1;

        List <String> notActive = new ArrayList<String>();

        System.out.println("\nLista de utilizadores não ativos");
        System.out.println("Selecione o utilizador que pretende validar\n");

        for (Utilizadores user : users) {
            if (user.getAtivo() == false) {
                System.out.println(i++ + " - " + user.getNome());
                notActive.add(user.getNome());
            }
        }
        System.out.println("0 - Voltar\n");

        int escolhido = scanner2.nextInt();

        if (escolhido < 0 || escolhido > notActive.size()) {
            System.out.println("Opção inválida");
            return;
        }
        else {
            if (escolhido == 0) {
                return;
            }
            else {
                for (Utilizadores user : users) {
                    if (user.getNome().equals(notActive.get(escolhido - 1))) {
                        user.setAtivo();
                        break;
                    }
                }
            }
        }




    }
}
