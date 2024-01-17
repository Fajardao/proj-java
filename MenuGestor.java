import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuGestor {

    private static List<Utilizadores> users;
    private static List<Farmaceutico> farmaceuticos;
    private static List<Cliente> clientes;
    private static Scanner scanner2 = new Scanner(System.in);

    public static void menuGestor(List<Utilizadores> listUsers, Utilizadores atualUser, List<Farmaceutico> listFarmaceuticos, List<Cliente> listClientes) {

        users = listUsers;
        farmaceuticos = listFarmaceuticos;
        clientes = listClientes;

        boolean loop = true;

        while (loop) {

            //Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Validar utilizadores");
            System.out.println("5 - Adicionar gestor");
            System.out.println("6 - Adicionar farmacêutico");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();
            scanner2.nextLine();

            switch (opcao) {
                case 1:
                    validarUsers();
                    break;
                case 5:
                    adicionarGestor();
                    break;
                case 6:
                    adicionarFarmaceutico();
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

        }

    }

    private static void validarUsers() {

        int i = 1;

        List <String> notActive = new ArrayList<String>();

        System.out.println("\nLista de utilizadores não ativos");
        System.out.println("Selecione o utilizador que pretende validar\n");

        for (Cliente user : clientes) {
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
                for (Cliente user : clientes) {
                    
                    if (user.getNome().equals(notActive.get(escolhido - 1))) {
                        user.setAtivo();
                        break;
                    }
                }
            }
        }
    }

    private static void adicionarGestor() {

        System.out.println("Nome: ");
        String nome = scanner2.nextLine();

        System.out.println("Email: ");
        String email = scanner2.nextLine();

        System.out.println("Password: ");
        String password = scanner2.nextLine();

        System.out.println("Login: ");
        String login = scanner2.nextLine();

        Utilizadores novoGestor = new Utilizadores(login, password, nome, true, email, "gestor");

        users.add(novoGestor);

    }

    private static void adicionarFarmaceutico() {

        System.out.println("Nome: ");
        String nome = scanner2.nextLine();

        System.out.println("Email: ");
        String email = scanner2.nextLine();

        System.out.println("Password: ");
        String password = scanner2.nextLine();

        System.out.println("Login: ");
        String login = scanner2.nextLine();

        System.out.println("NIF: ");
        int nif = scanner2.nextInt();

        System.out.println("Morada: ");
        String morada = scanner2.nextLine();
        
        System.out.println("Telefone: ");
        int telefone = scanner2.nextInt();

        Farmaceutico novoFarmaceutico = new Farmaceutico(login, password, nome, true, email, "farmaceutico", nif, morada, telefone);

        farmaceuticos.add(novoFarmaceutico);

    }
}
