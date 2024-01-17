import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuFarmaceutico {
    
    private static Farmaceutico user;
    private static Scanner scanner2 = new Scanner(System.in);

    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Componente> componentes = new ArrayList<>();
    private static List<Encomenda> encomendas = new ArrayList<>();

    public static void menuFarmaceutico(Farmaceutico atualUser, List<Medicamento> medicamentos,List<Componente> componentes, List<Encomenda> encomendas) {

        user = atualUser;
        MenuFarmaceutico.medicamentos = medicamentos;
        MenuFarmaceutico.componentes = componentes;
        MenuFarmaceutico.encomendas = encomendas;

        boolean loop = true;

        while (loop) {

            // Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Adicionar medicamento");
            System.out.println("2 - Adicionar categoria");
            System.out.println("3 - Adicionar componente ativo");
            System.out.println("4 - Adicionar excipiente");
            System.out.println("5 - Ver serviços");
            System.out.println("6 - Ver dados pessoais");
            System.out.println("7 - Alterar dados pessoais");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();
            scanner2.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar medicamento");
                    adicionarMedicamento();
                    break;
                case 2:
                    System.out.println("Adicionar categoria");
                    break;
                case 3:
                    System.out.println("Adicionar componente ativo");
                    addComponente();
                    break;
                case 4:
                    System.out.println("Adicionar excipiente");
                    break;
                case 5:
                    System.out.println("Ver serviços");
                    break;
                case 6:
                    System.out.println("Ver dados pessoais");
                    System.out.println(atualUser);
                    break;
                case 7:
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
    
    private static void addComponente() {
        
        System.out.println("Designação");
        String designacao = scanner2.nextLine();

        System.out.println("Codigo");
        String codigo = scanner2.nextLine();

        System.out.println("Quantidade");
        int quantidade = scanner2.nextInt();

        Componente componente = new Componente(designacao, codigo, quantidade);
        componentes.add(componente);
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
        scanner2.nextLine();

        System.out.println("Dosagem");
        String dosagem = scanner2.nextLine();

        System.out.println("Quantidade em stock");
        int quantidadeStock = scanner2.nextInt();
        scanner2.nextLine();

        System.out.println("Preço de venda");
        double precoVenda = scanner2.nextDouble();
        scanner2.nextLine();

        System.out.println("Ano de fabrico");
        int anoFabrico = scanner2.nextInt();
        scanner2.nextLine();

        System.out.println("Autorização médica");
        boolean autorizacaoMedica = scanner2.nextBoolean();

        System.out.println("Genérico");
        boolean generico = scanner2.nextBoolean();

        Medicamento medicamento = new Medicamento(designacao, marca, laboratorio, lote, componenteActivo, dosagem,quantidadeStock, precoVenda, anoFabrico, autorizacaoMedica, generico);


        medicamentos.add(medicamento);

    }
    
    private static Componente selectComponente() {
        
        int i = 1;
        boolean loop = true;
        
        
        while (loop) {
        System.out.println("\nLista de componentes");
        System.out.println("Selecione o componente que pretende adicionar\n");
        
        for (Componente componente : componentes) {
            System.out.println(i++ + " - " + componente.getDesignacao());
        }
        
        int escolhido = scanner2.nextInt();
        
        if (escolhido < 0 || escolhido > componentes.size()) {
            System.out.println("Opção inválida");
        } else {
                for (Componente componente : componentes) {
                    
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
