import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuGestor{

    private static List<Utilizadores> users = new ArrayList<>();
    private static List<Farmaceutico> farmaceuticos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Componente> componentes = new ArrayList<>();
    private static List<Encomenda> encomendas = new ArrayList<>();


    private static Utilizadores user;

    private static Scanner scanner2 = new Scanner(System.in);

    public static void menuGestor(Utilizadores atualUser, List<Utilizadores> users, List<Farmaceutico> farmaceuticos, List<Cliente> clientes, List<Medicamento> medicamentos, List<Componente> componentes,  List<Encomenda> encomendas) {

        MenuGestor.users = users;
        MenuGestor.farmaceuticos = farmaceuticos;
        MenuGestor.clientes = clientes;
        MenuGestor.medicamentos = medicamentos;
        MenuGestor.componentes = componentes;
        MenuGestor.encomendas = encomendas;

        System.out.println("Lista de utilizadores");
        for (Utilizadores utilizador : clientes) {
            System.out.println(utilizador);
        }
        System.out.println("-----------------");

        user = atualUser;

        boolean loop = true;

        while (loop) {

            // Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Validar utilizadores");
            System.out.println("2 - Confirmar encomendas");
            System.out.println("3 - Ver dados pessoais");
            System.out.println("4 - Alterar dados pessoais");
            System.out.println("5 - Adicionar gestor");
            System.out.println("6 - Adicionar farmacêutico");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();
            scanner2.nextLine();

            switch (opcao) {
                case 1:
                    validarUsers();
                    break;
                case 2:
                    System.out.println("Confirmar encomendas");
                    confirmarEncomendas();
                    break;
                case 3:
                    System.out.println("Ver dados pessoais");
                    System.out.println(atualUser);
                    break;
                case 4:
                    System.out.println("Alterar dados pessoais");
                    editarDadosPessoais();
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

    private static void confirmarEncomendas() {

        int i = 1;


        System.out.println("\nLista de encomendas por confirmar");
        System.out.println("Selecione a encomenda que pretende confirmar\n");

        for (Encomenda encomenda : encomendas) {
            if (encomenda.getConfirmado() == false) {
                System.out.println(i++ + " - " + encomenda);
            }
        }
        System.out.println("0 - Voltar\n");

        int escolhido = scanner2.nextInt();

        if (escolhido < 0 || escolhido > encomendas.size()) {
            System.out.println("Opção inválida");
            return;
        } else {
            if (escolhido == 0) {
                return;
            } else {
                for (Encomenda encomenda :encomendas) {

                    if (encomenda.equals(encomendas.get(escolhido - 1))) {
                        System.out.println("Insira o nome do farmacêutico");
                        encomenda.setFarmaceutico(selectFarmaceutico());
                        encomenda.confirmarEncomenda();
                        System.out.println("Encomenda confirmada com sucesso");
                        break;
                    }
                }
            }
        }
    }

    private static Farmaceutico selectFarmaceutico() {

        int i = 1;


        System.out.println("\nLista de farmacêuticos");
        System.out.println("Selecione o farmacêutico que pretende\n");

        for (Farmaceutico farmaceutico : farmaceuticos) {
            System.out.println(i++ + " - " + farmaceutico.getNome());
        }
        System.out.println("0 - Voltar\n");

        int escolhido = scanner2.nextInt();

        if (escolhido < 0 || escolhido > farmaceuticos.size()) {
            System.out.println("Opção inválida");
            return null;
        } else {
            if (escolhido == 0) {
                return null;
            } else {
                for (Farmaceutico farmaceutico : farmaceuticos) {

                    if (farmaceutico.equals(farmaceuticos.get(escolhido - 1))) {
                        return farmaceutico;
                    }
                }
            }
        }
        return null;
    }

    private static void editarDadosPessoais() {

        System.out.println("O que pretende alterar?");

        System.out.println("1 - Nome");
        System.out.println("2 - Password");
        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Nome");
                System.out.println("Novo nome: ");
                String novoNome = scanner2.nextLine();
                user.setNome(novoNome);
                break;
            case 2:
                System.out.println("Password");
                System.out.println("Nova password: ");
                String novaPassword = scanner2.nextLine();
                System.out.println("Confirme a password");
                String confirmacao = scanner2.nextLine();
                if (!novaPassword.equals(confirmacao)) {
                    System.out.println("As passwords não coincidem");
                    break;
                } else {
                    System.out.println("Password alterada com sucesso");
                    user.setPassword(novaPassword);
                }
                break;
            case 0:
                System.out.println("Voltar");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void validarUsers() {

        int i = 1;

        List<String> notActive = new ArrayList<String>();

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
        } else {
            if (escolhido == 0) {
                return;
            } else {
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

        if (Utilizadores.verificaUnicidade(login, email)) {
            Utilizadores novoGestor = new Utilizadores(login, password, nome, true, email, "gestor");

            users.add(novoGestor);

            System.out.println("Gestor adicionado com sucesso");
        }
        else {
            System.out.println("Login ou email já existente");
        }

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
        scanner2.nextLine();

        System.out.println("Morada: ");
        String morada = scanner2.nextLine();

        System.out.println("Telefone: ");
        int telefone = scanner2.nextInt();
        scanner2.nextLine();

        if (Utilizadores.verificaUnicidade(login, email)) {
            if (Utilizadores.verifyNifTel(nif, telefone)) {
                Farmaceutico novoFarmaceutico = new Farmaceutico(login, password, nome, true, email, "farmaceutico", nif, morada, telefone);
                farmaceuticos.add(novoFarmaceutico);
                System.out.println("Farmacêutico adicionado com sucesso");
            }
            else {
                System.out.println("NIF ou telefone já existente");
            }
        }
        else {
            System.out.println("Login ou email já existente");
        }


    }
}
