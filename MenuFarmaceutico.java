import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuFarmaceutico {

    private static Farmaceutico user;
    private static Scanner scanner2 = new Scanner(System.in);

    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Componente> componentes = new ArrayList<>();
    private static List<Encomenda> encomendas = new ArrayList<>();
    private static List<Categoria> categorias = new ArrayList<>();
    private static List<Excipiente> excipientes = new ArrayList<>();

    public static void menuFarmaceutico(Farmaceutico atualUser, List<Medicamento> medicamentos,
            List<Componente> componentes, List<Encomenda> encomendas, List<Categoria> categorias,
            List<Excipiente> excipientes) {

        user = atualUser;
        MenuFarmaceutico.medicamentos = medicamentos;
        MenuFarmaceutico.componentes = componentes;
        MenuFarmaceutico.encomendas = encomendas;
        MenuFarmaceutico.categorias = categorias;
        MenuFarmaceutico.excipientes = excipientes;

        boolean loop = true;

        while (loop) {

            Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Adicionar medicamento");
            System.out.println("2 - Adicionar categoria");
            System.out.println("3 - Adicionar componente ativo");
            System.out.println("4 - Adicionar excipiente");
            System.out.println("5 - Gerir serviços");
            System.out.println("6 - Ver dados pessoais");
            System.out.println("7 - Alterar dados pessoais");
            System.out.println("8 - Alterar stock de medicamentos");
            System.out.println("9 - Listar/Pesquisa");
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
                    adicionarCategoria();
                    break;
                case 3:
                    System.out.println("Adicionar componente ativo");
                    addComponente();
                    break;
                case 4:
                    System.out.println("Adicionar excipiente");
                    addExcipiente();
                    break;
                case 5:
                    System.out.println("Ver serviços");
                    verServicos();
                    break;
                case 6:
                    System.out.println("Ver dados pessoais");
                    System.out.println(atualUser);
                    break;
                case 7:
                    System.out.println("Alterar dados pessoais");
                    editarDadosPessoais();
                    break;
                case 8:
                    System.out.println("Alterar stock de medicamentos");
                    alterarStock();
                    break;
                case 9:
                    System.out.println("Listar/Pesquisa");
                    listarPesquisa();
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

    private static void verServicos() {

        Main.clearScreen();

        System.out.println("Lista de serviços\n");

        List<Integer> validIds = new ArrayList<>();

        for (Encomenda encomenda : encomendas) {
            Farmaceutico local = encomenda.getFarmaceutico();
            if (local != null && local.equals(user) && List.of(2, 3).contains(encomenda.getEstado())) {
                if (encomenda.getTipo().equals("normal")) {
                    System.out.println(encomenda);
                } else {
                    System.out.println("**" + encomenda.toString().toUpperCase() + "**");
                }
                validIds.add(encomenda.getId());
            }
        }
        
        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();

        if (opcao <= 0 || !validIds.contains(opcao)) {
            if (opcao == 0) {
                System.out.println("Voltar");
            } else {
                System.out.println("Opção inválida");
            }
        } else {
            for (Encomenda encomenda : encomendas) {

                if (encomenda.getId() == opcao) {

                    System.out.println("1 - Ver detalhes");
                    if (encomenda.getEstado() == 2) {
                        System.out.println("2 - Iniciar processo");
                    } else {
                        System.out.println("2 - Concluir processo");
                    }
                    System.out.println("3 - Alterar prioridade");

                    if (encomenda.getMedicamento() == null) {
                        System.out.println("4 - Definir medicamento");
                    }

                    System.out.println("0 - Voltar");

                    int opcao2 = scanner2.nextInt();

                    switch (opcao2) {
                        case 2:
                            if (encomenda.getEstado() == 2) {
                                encomenda.changeEstado(3);
                                System.out.println("Processo iniciado");
                                Log.log(user.getNome() + " iniciou o processo da encomenda " + encomenda.getId());
                            } else {
                                encomenda.complete();
                                encomenda.getMedicamento().setStock(encomenda.getMedicamento().getQuantidadeStock() - 1);
                                System.out.println("Processo concluído");
                                Log.log(user.getNome() + " concluiu o processo da encomenda " + encomenda.getId());
                            }
                            break;
                        case 3:
                            System.out.println("1 - Normal");
                            System.out.println("2 - Urgente");
                            int escolha = scanner2.nextInt();
                            if (escolha == 1) {
                                encomenda.changeTipo(1);
                                System.out.println("Prioridade alterada para normal");
                                Log.log(user.getNome() + " alterou a prioridade da encomenda " + encomenda.getId()
                                        + " para normal");
                            } else if (escolha == 2) {
                                encomenda.changeTipo(2);
                                System.out.println("Prioridade alterada para urgente");
                                Log.log(user.getNome() + " alterou a prioridade da encomenda " + encomenda.getId()
                                        + " para urgente");
                            } else {
                                System.out.println("Opção inválida");
                            }
                            break;
                        case 1:
                            System.out.println(encomenda.getDetails());
                            break;
                        case 4:
                            if (encomenda.getMedicamento() == null) {
                                System.out.println("Subtancia ativa - " + encomenda.getComponente().getDesignacao());
                                System.out.println("Selecione o medicamento");
                                int i = 1;
                                List<Medicamento> templist = new ArrayList<>();
                                for (Medicamento medicamento : medicamentos) {
                                    if (medicamento.getComponenteActivo().equals(encomenda.getComponente())) {
                                        templist.add(medicamento);
                                        System.out.println(i++ + " - " + medicamento.getDesignacao());
                                    }
                                }
                                int escolhido = scanner2.nextInt();
                                encomenda.setMedicamento(templist.get(escolhido - 1));
                                System.out.println("Medicamento definido");
                                Log.log(user.getNome() + " definiu o medicamento "
                                        + encomenda.getMedicamento().getDesignacao() + " para a encomenda "
                                        + encomenda.getId());
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

            }

        }

    }

    private static void addExcipiente() {

        Main.clearScreen();

        System.out.println("Designação");
        String designacao = scanner2.nextLine();

        System.out.println("Codigo");
        String codigo = scanner2.nextLine();

        System.out.println("Quantidade");
        int quantidade = scanner2.nextInt();

        Excipiente excipiente = new Excipiente(designacao, codigo, quantidade);
        excipientes.add(excipiente);
        Log.log(user.getNome() + " adicionou o excipiente " + excipiente.getDesignacao());
    }

    private static void adicionarCategoria() {

        Main.clearScreen();

        System.out.println("Designação");
        String designacao = scanner2.nextLine();

        System.out.println("Código Infarmed");
        String codInfarmed = scanner2.nextLine();

        System.out.println("Código");
        int codigo = scanner2.nextInt();
        scanner2.nextLine();

        System.out.println("Fornecedor");
        String fornecedor = scanner2.nextLine();

        if (Categoria.verificaUnicidade(codigo)) {
            Categoria categoria = new Categoria(designacao, codInfarmed, codigo, fornecedor);
            System.out.println("Categoria adicionada com sucesso");
            categorias.add(categoria);
            Log.log(user.getNome() + " adicionou a categoria " + categoria.getDesignacao());
        } else {
            System.out.println("Código já existente");
        }
    }

    private static void addComponente() {

        Main.clearScreen();

        System.out.println("Designação");
        String designacao = scanner2.nextLine();

        System.out.println("Codigo");
        String codigo = scanner2.nextLine();

        System.out.println("Quantidade");
        int quantidade = scanner2.nextInt();

        Componente componente = new Componente(designacao, codigo, quantidade);
        componentes.add(componente);
        Log.log(user.getNome() + " adicionou o componente " + componente.getDesignacao());
    }

    private static void adicionarMedicamento() {

        Main.clearScreen();

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
        float precoVenda = scanner2.nextFloat();
        scanner2.nextLine();

        System.out.println("Ano de fabrico");
        int anoFabrico = scanner2.nextInt();
        scanner2.nextLine();

        System.out.println("Autorização médica");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int opcao = scanner2.nextInt();

        boolean autorizacaoMedica;

        if (opcao == 1) {
            autorizacaoMedica = true;
        } else {
            autorizacaoMedica = false;
        }

        System.out.println("Genérico");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        opcao = scanner2.nextInt();

        boolean generico;

        if (opcao == 1) {
            generico = true;
        } else {
            generico = false;
        }

        Medicamento medicamento = new Medicamento(designacao, marca, laboratorio, lote, componenteActivo, dosagem,
                quantidadeStock, precoVenda, anoFabrico, autorizacaoMedica, generico);

        Log.log(user.getNome() + " adicionou o medicamento " + medicamento.getDesignacao());

        medicamentos.add(medicamento);

        Log.log(user.getNome() + " adicionou o medicamento " + medicamento.getDesignacao());

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

        Main.clearScreen();

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

                Log.log(user.getNome() + " alterou o nome");

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

                    Log.log(user.getNome() + " alterou a password");

                } else {
                    System.out.println("Passwords não coincidem");
                }

                break;
            case 3:
                System.out.println("Morada");
                String novaMorada = scanner2.nextLine();
                user.setMorada(novaMorada);

                Log.log(user.getNome() + " alterou a morada");

                break;
            case 0:
                System.out.println("Voltar");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

    }

    private static void alterarStock() {

        Main.clearScreen();

        System.out.println("Selecione o medicamento");

        int i = 1;
        for (Medicamento medicamento : medicamentos) {
            System.out.println(i++ + " - " + medicamento.getDesignacao() + " - " + medicamento.getQuantidadeStock());
        }

        int escolhido = scanner2.nextInt();
        scanner2.nextLine();

        if (escolhido < 0 || escolhido > medicamentos.size()) {
            System.out.println("Opção inválida");
        } else {
            if (escolhido == 0) {
                System.out.println("Voltar");
            } else {
                for (Medicamento medicamento : medicamentos) {

                    if (medicamento.equals(medicamentos.get(escolhido - 1))) {

                        System.out.println("Quantidade em stock");
                        int quantidadeStock = scanner2.nextInt();
                        scanner2.nextLine();

                        medicamento.setStock(quantidadeStock);

                        Log.log(user.getNome() + " alterou o stock do medicamento " + medicamento.getDesignacao());

                    }
                }
            }
        }

    }
    
    private static void listarPesquisa() {

        Main.clearScreen();

        System.out.println("1 - Listar medicamentos");
        System.out.println("2 - Listar encomendas");
        System.out.println("3 - Pesquisar medicamentos por nome");
        System.out.println("4 - Pesquisar medicamentos por categoria");
        System.out.println("5 - Pesquisar medicamentos por componente");
        System.out.println("6 - Pesquisar medicamentos por Genérico");
        System.out.println("7 - Pesquisar medicamentos por Não Genérico");
        System.out.println("8 - Pesquisar medicamentos abaixo de stock");

        int opcao = scanner2.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Listar medicamentos");
                for (Medicamento medicamento : medicamentos) {
                    System.out.println(medicamento);
                }
                break;
            case 2:
                System.out.println("Listar encomendas");
                for (Encomenda encomenda : encomendas) {
                    if (encomenda.getFarmaceutico() != null && encomenda.getFarmaceutico().equals(user)) {
                        System.out.println(encomenda);
                    }
                }
                break;
            case 3:
                System.out.println("Pesquisar medicamentos por nome\n");

                System.out.println("Insira o nome do medicamento");

                String nomeMedicamento = scanner2.nextLine();

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getDesignacao().contains(nomeMedicamento)) {
                        System.out.println(medicamento);
                    }
                }

                break;
            case 4:
                System.out.println("Pesquisar medicamentos por categoria\n");

                System.out.println("Insira o nome da categoria");

                String nomeCategoria = scanner2.nextLine();

                for (Medicamento medicamento : medicamentos) {
                    for (Categoria categoria : medicamento.getCategorias()) {
                        if (categoria.getDesignacao().contains(nomeCategoria)) {
                            System.out.println(medicamento);
                        }
                    }
                }

                break;
            case 5:
                System.out.println("Pesquisar medicamentos por componente\n");

                System.out.println("Insira o nome do componente");

                String nomeComponente = scanner2.nextLine();

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getComponenteActivo().getDesignacao().contains(nomeComponente)) {
                        System.out.println(medicamento);
                    }
                }

                break;
            case 6:
                System.out.println("Pesquisar medicamentos por Genérico");

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.isGenerico()) {
                        System.out.println(medicamento);
                    }
                }

                break;
            case 7:
                System.out.println("Pesquisar medicamentos por Não Genérico");

                for (Medicamento medicamento : medicamentos) {
                    if (!medicamento.isGenerico()) {
                        System.out.println(medicamento);
                    }
                }

                break;
            case 8:
                System.out.println("Pesquisar medicamentos abaixo de stock\n");

                System.out.println("Insira a quantidade de stock");

                int quantidadeStock = scanner2.nextInt();

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getQuantidadeStock() < quantidadeStock) {
                        System.out.println(medicamento);
                    }
                }

                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
