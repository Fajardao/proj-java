import java.util.Scanner;
import java.util.List;

public class MenuFarmaceutico {
    
    private static Farmaceutico user;
    private static Scanner scanner2 = new Scanner(System.in);

    public static void MenuFarmaceutico(Farmaceutico atualUser) {

        user = atualUser;

        boolean loop = true;

        while (loop) {

            // Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Adicionar medicamento");
            System.out.println("2 - Adicionar categoria");
            System.out.println("3 - Adicionar excipiente");
            System.out.println("4 - Ver serviços");
            System.out.println("5 - Ver dados pessoais");
            System.out.println("6 - Alterar dados pessoais");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();
            scanner2.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar medicamento");
                    break;
                case 2:
                    System.out.println("Adicionar categoria");
                    break;
                case 3:
                    System.out.println("Adicionar excipiente");
                    break;
                case 4:
                    System.out.println("Ver serviços");
                    break;
                case 5:
                    System.out.println("Ver dados pessoais");
                    System.out.println(atualUser);
                    break;
                case 6:
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

        }

    }

    private static void adicionarMedicamento() {

        System.out.println("Designação");
        String designacao = scanner2.nextLine();

        System.out.println("Marca");
        String marca = scanner2.nextLine();

        System.out.println("Laboratório");
        String laboratorio = scanner2.nextLine();

        System.out.println("Lote");
        String lote = scanner2.nextLine();

        System.out.println("Componente ativo");
        Componente componenteActivo = selectComponente();

        System.out.println("Dosagem");
        String dosagem = scanner2.nextLine();

        System.out.println("Quantidade em stock");
        int quantidadeStock = scanner2.nextInt();

        System.out.println("Preço de venda");
        double precoVenda = scanner2.nextDouble();

        System.out.println("Ano de fabrico");
        int anoFabrico = scanner2.nextInt();

        System.out.println("Autorização médica");
        boolean autorizacaoMedica = scanner2.nextBoolean();

        System.out.println("Genérico");
        boolean generico = scanner2.nextBoolean();

        Medicamento medicamento = new Medicamento(designacao, marca, laboratorio, lote, componenteActivo, dosagem,quantidadeStock, precoVenda, anoFabrico, autorizacaoMedica, generico);

        List<Medicamento> medicamentos = Main.getMedicamentos();

        medicamentos.add(medicamento);

    }
    
    private static Componente selectComponente() {
        
        int i = 1;
        boolean loop = true;
        
        List<Componente> componentes = Main.getComponentes();
        
        while (loop) {
        System.out.println("\nLista de componentes");
        System.out.println("Selecione o componente que pretende adicionar\n");
        
        for (Componente componente : Main.getComponentes()) {
            System.out.println(i++ + " - " + componente);
            componentes.add(componente);
        }
        
        int escolhido = scanner2.nextInt();
        
        if (escolhido < 0 || escolhido > componentes.size()) {
            System.out.println("Opção inválida");
        } else {
                for (Componente componente : Main.getComponentes()) {
                    
                    if (componente.equals(componentes.get(escolhido - 1))) {
                        return componente;
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
                String confirmacao = scanner2.nextLine();

                if (novaPassword.equals(confirmacao)) {
                    System.out.println("Password alterada com sucesso");
                    user.setPassword(novaPassword);
                } else {
                    System.out.println("Passwords não coincidem");
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

}
