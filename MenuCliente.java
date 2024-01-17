import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuCliente {

    private static Scanner scanner2 = new Scanner(System.in);

    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Componente> componentes = new ArrayList<>();
    private static List<Encomenda> encomendas = new ArrayList<>();

    private static Cliente user;

    public static void menuCliente(Cliente atualUser, List<Medicamento> medicamentos, List<Componente> componentes,
            List<Encomenda> encomendas) {

        boolean loop = true;

        MenuCliente.medicamentos = medicamentos;
        MenuCliente.componentes = componentes;
        MenuCliente.encomendas = encomendas;

        user = atualUser;

        while (loop) {

            // Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Fazer encomenda");
            System.out.println("2 - Ver encomendas");
            System.out.println("3 - Ver dados pessoais");
            System.out.println("4 - Alterar dados pessoais");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();

            switch (opcao) {
                case 1:
                    fazerEncomenda();
                    break;
                case 2:
                    System.out.println("Ver encomendas");
                    break;
                case 3:
                    System.out.println("Ver dados pessoais");
                    System.out.println(atualUser);
                    break;
                case 4:
                    System.out.println("Alterar dados pessoais");
                    editarDadosPessoais();
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

    private static void editarDadosPessoais() {

        System.out.println("O que pretende alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Password");
        System.out.println("3 - Morada");
        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Nome");

                String novoNome = scanner2.nextLine();
                user.setNome(novoNome);
                break;
            case 2:
                System.out.println("Password");
                String novaPassword = scanner2.nextLine();
                System.out.println("Confirme a password");
                String confirmacaoPassword = scanner2.nextLine();

                if (novaPassword.equals(confirmacaoPassword)) {
                    user.setPassword(novaPassword);
                    System.out.println("Password alterada com sucesso");
                } else {
                    System.out.println("As passwords não coincidem");
                }
                break;
            case 3:
                System.out.println("Morada");
                String novaMorada = scanner2.nextLine();
                user.setMorada(novaMorada);
                break;
            case 0:
                System.out.println("Voltar");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void fazerEncomenda() {

        System.out.println("Fazer encomenda");

        System.out.println("1 - Medicamentos");
        System.out.println("2 - Substancia ativa");
        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        boolean found = false;

        switch (opcao) {
            case 1:

                System.out.println("\n\n Insira o nome do medicamento");
                String nomeMedicamento = scanner2.nextLine();

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getDesignacao().equals(nomeMedicamento)) {
                        Encomenda encomenda = new Encomenda(medicamento, user, 1);
                        encomendas.add(encomenda);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Não foi encontrado nenhum medicamento com esse nome");
                }

                break;
            case 2:
                System.out.println("\n\n Insira o nome da substancia ativa");
                String nomeSubstancia = scanner2.nextLine();

                for (Componente componente : componentes) {
                    if (componente.getDesignacao().equals(nomeSubstancia)) {
                        Encomenda encomenda = new Encomenda(componente, user, 2);
                        encomendas.add(encomenda);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Não foi encontrado nenhum medicamento com essa substancia ativa");
                }

                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

    }

}
