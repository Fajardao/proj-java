import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MenuGestor {

    private static List<Utilizadores> users = new ArrayList<>();
    private static List<Farmaceutico> farmaceuticos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Componente> componentes = new ArrayList<>();
    private static List<Encomenda> encomendas = new ArrayList<>();

    private static Utilizadores user;

    private static Scanner scanner2 = new Scanner(System.in);

    public static void menuGestor(Utilizadores atualUser, List<Utilizadores> users, List<Farmaceutico> farmaceuticos,
            List<Cliente> clientes, List<Medicamento> medicamentos, List<Componente> componentes,
            List<Encomenda> encomendas) throws IOException {

        MenuGestor.users = users;
        MenuGestor.farmaceuticos = farmaceuticos;
        MenuGestor.clientes = clientes;
        MenuGestor.medicamentos = medicamentos;
        MenuGestor.componentes = componentes;
        MenuGestor.encomendas = encomendas;

        user = atualUser;

        boolean loop = true;

        while (loop) {

            Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Validar utilizadores");
            System.out.println("2 - Confirmar encomendas");
            System.out.println("3 - Encerrar encomendas");
            System.out.println("4 - Ver dados pessoais");
            System.out.println("5 - Alterar dados pessoais");
            System.out.println("6 - Adicionar gestor");
            System.out.println("7 - Adicionar farmacêutico");
            System.out.println("8 - Listagens/Pesquisas");
            System.out.println("9 - Ver log");
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
                    System.out.println("Encerrar encomendas");
                    encerrarEncomendas();
                    break;
                case 4:
                    System.out.println("Ver dados pessoais");
                    System.out.println(atualUser);
                    break;
                case 5:
                    System.out.println("Alterar dados pessoais");
                    editarDadosPessoais();
                    break;
                case 6:
                    adicionarGestor();
                    break;
                case 7:
                    adicionarFarmaceutico();
                    break;
                case 8:
                    System.out.println("Listagens/Pesquisas");
                    System.out.println("1 - Listagens");
                    System.out.println("2 - Pesquisas");

                    int opcao2 = scanner2.nextInt();

                    switch (opcao2) {
                        case 1:
                            listagens();
                            break;
                        case 2:
                            pesquisas();
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                case 9:
                    System.out.println("Ver log");
                    Log.verLog();
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

    private static void confirmarEncomendas() {

        Main.clearScreen();

        System.out.println("\nLista de encomendas por confirmar");
        System.out.println("Selecione a encomenda que pretende confirmar\n");

        List<Integer> validIds = new ArrayList<Integer>();

        for (Encomenda encomenda : encomendas) {
            if (encomenda.getEstado() == 1) {
                System.out.println(encomenda);
                validIds.add(encomenda.getId());
            }
        }
        System.out.println("0 - Voltar\n");

        int escolhido = scanner2.nextInt();

        if (escolhido < 0 || !validIds.contains(escolhido)) {
            System.out.println("Opção inválida");
            return;
        } else {
            if (escolhido == 0) {
                return;
            } else {
                for (Encomenda encomenda : encomendas) {

                    if (encomenda.equals(encomendas.get(escolhido - 1))) {
                        System.out.println("Insira o nome do farmacêutico");
                        encomenda.setFarmaceutico(selectFarmaceutico());
                        encomenda.changeEstado(2);

                        Log.log(user.getNome() + " confirmou a encomenda " + encomenda.getId());

                        System.out.println("Encomenda confirmada com sucesso");
                        break;
                    }
                }
            }
        }
    }

    private static Farmaceutico selectFarmaceutico() {

        Main.clearScreen();

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

    private static void encerrarEncomendas() {

        Main.clearScreen();

        System.out.println("\nLista de encomendas por encerrar");
        System.out.println("Selecione a encomenda que pretende encerrar\n");

        for (Encomenda encomenda : encomendas) {
            if (encomenda.getEstado() == 4) {
                System.out.println(encomenda);
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
                for (Encomenda encomenda : encomendas) {

                    if (encomenda.equals(encomendas.get(escolhido - 1))) {
                        encomenda.changeEstado(5);

                        Log.log(user.getNome() + " encerrou a encomenda " + encomenda.getId());

                        System.out.println("Encomenda encerrada com sucesso");
                        break;
                    }
                }
            }
        }
    }

    private static void editarDadosPessoais() {

        Main.clearScreen();

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

                Log.log(user.getNome() + " alterou o nome");

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

                    Log.log(user.getNome() + " alterou a password");

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

        Main.clearScreen();

        int i = 1;

        List<String> notActive = new ArrayList<String>();

        System.out.println("\nLista de utilizadores não ativos");
        System.out.println("Selecione o utilizador que pretende validar\n");

        for (Cliente client : clientes) {
            if (client.getAtivo() == false) {
                System.out.println(i++ + " - " + client.getNome());
                notActive.add(client.getNome());
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
                for (Cliente client : clientes) {

                    if (client.getNome().equals(notActive.get(escolhido - 1))) {
                        client.setAtivo();

                        Log.log(user.getNome() + " validou o utilizador " + client.getNome());

                        break;
                    }
                }
            }
        }
    }

    private static void adicionarGestor() throws IOException {

        Main.clearScreen();

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

            Log.log(user.getNome() + " adicionou o gestor " + novoGestor.getNome());

            users.add(novoGestor);

            System.out.println("Gestor adicionado com sucesso");
        } else {
            System.out.println("Login ou email já existente");
        }

    }

    private static void adicionarFarmaceutico() throws IOException {

        Main.clearScreen();

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
                Farmaceutico novoFarmaceutico = new Farmaceutico(login, password, nome, true, email, "farmaceutico",
                        nif, morada, telefone);
                farmaceuticos.add(novoFarmaceutico);

                Log.log(user.getNome() + " adicionou o farmacêutico " + novoFarmaceutico.getNome());

                System.out.println("Farmacêutico adicionado com sucesso");
            } else {
                System.out.println("NIF ou telefone já existente");
            }
        } else {
            System.out.println("Login ou email já existente");
        }

    }

    private static void listagens() {

        Main.clearScreen();

        System.out.println("1 - Listagens de utilizadores");
        System.out.println("2 - Listagens de medicamentos");
        System.out.println("3 - Listagens de encomendas");

        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Listagens de medicamentos");
                listarUtilizadores();
                break;
            case 2:
                System.out.println("Listagens de medicamentos");
                listarMedicamentos();
                break;
            case 3:
                System.out.println("Listagens de encomendas");
                listarEncomendas();
                break;
            case 0:
                System.out.println("Voltar");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void listarUtilizadores() {

        Main.clearScreen();

        System.out.println("1 - Listar todos os utilizadores");
        System.out.println("2 - Listar utilizadores por tipo");

        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Listar todos os utilizadores\n");

                List<String> listUsers = new ArrayList<String>();

                for (Utilizadores utilizador : users) {
                    listUsers.add(utilizador.getNome());
                }

                for (Farmaceutico farmaceutico : farmaceuticos) {
                    listUsers.add(farmaceutico.getNome());
                }

                for (Cliente cliente : clientes) {
                    listUsers.add(cliente.getNome());
                }

                Collections.sort(listUsers);

                for (String nome : listUsers) {
                    System.out.println(nome + "\n");
                }

                break;
            case 2:
                System.out.println("Listar utilizadores por tipo\n");

                System.out.println("1 - Gestores");
                System.out.println("2 - Farmacêuticos");
                System.out.println("3 - Clientes");

                System.out.println("0 - Voltar");

                int opcao2 = scanner2.nextInt();

                switch (opcao2) {
                    case 1:
                        System.out.println("Listar gestores\n");

                        List<String> listGestores = new ArrayList<String>();

                        for (Utilizadores utilizador : users) {
                            if (utilizador.getTipo().equals("gestor")) {
                                listGestores.add(utilizador.getNome());
                            }
                        }

                        Collections.sort(listGestores);

                        for (String nome : listGestores) {
                            System.out.println(nome + "\n");
                        }

                        break;
                    case 2:
                        System.out.println("Listar farmacêuticos\n");

                        List<String> listFarmaceuticos = new ArrayList<String>();

                        for (Farmaceutico farmaceutico : farmaceuticos) {
                            listFarmaceuticos.add(farmaceutico.getNome());
                        }

                        Collections.sort(listFarmaceuticos);

                        for (String nome : listFarmaceuticos) {
                            System.out.println(nome + "\n");
                        }

                        break;
                    case 3:
                        System.out.println("Listar clientes\n");

                        List<String> listClientes = new ArrayList<String>();

                        for (Cliente cliente : clientes) {
                            listClientes.add(cliente.getNome());
                        }

                        Collections.sort(listClientes);

                        for (String nome : listClientes) {
                            System.out.println(nome + "\n");
                        }

                        break;
                    case 0:
                        System.out.println("Voltar");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
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

    private static void listarMedicamentos() {

        Main.clearScreen();

        List<String> listMedicamentos = new ArrayList<String>();

        for (Medicamento medicamento : medicamentos) {
            listMedicamentos.add(medicamento.getDesignacao());
        }

        Collections.sort(listMedicamentos);

        for (String nome : listMedicamentos) {
            System.out.println(nome + "\n");
        }

    }

    private static void listarEncomendas() {

        Main.clearScreen();

        System.out.println("1 - Listar encomendas por estado");
        System.out.println("2 - Listar encomendas por cliente");

        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Listar encomendas por estado\n");

                System.out.println("1 - Pendentes");
                System.out.println("2 - Confirmadas");
                System.out.println("3 - A decorrer");
                System.out.println("4 - Concluídas");
                System.out.println("5 - Encerradas");

                System.out.println("0 - Voltar");

                int opcao2 = scanner2.nextInt();

                switch (opcao2) {
                    case 1:
                        System.out.println("Listar encomendas pendentes\n");

                        for (Encomenda encomenda : encomendas) {
                            if (encomenda.getEstado() == 1) {
                                System.out.println(encomenda);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Listar encomendas confirmadas\n");

                        for (Encomenda encomenda : encomendas) {
                            if (encomenda.getEstado() == 2) {
                                System.out.println(encomenda);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Listar encomendas a decorrer\n");

                        for (Encomenda encomenda : encomendas) {
                            if (encomenda.getEstado() == 3) {
                                System.out.println(encomenda);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Listar encomendas concluídas\n");

                        for (Encomenda encomenda : encomendas) {
                            if (encomenda.getEstado() == 4) {
                                System.out.println(encomenda);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Listar encomendas encerradas\n");

                        for (Encomenda encomenda : encomendas) {
                            if (encomenda.getEstado() == 5) {
                                System.out.println(encomenda);
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Voltar");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }
                break;
            case 2:
                System.out.println("Listar encomendas por cliente\n");

                System.out.println("Insira o nome do cliente");

                String nome = scanner2.nextLine();

                boolean clientFound = false;
                boolean encomendaFound = false;

                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nome)) {
                        for (Encomenda encomenda : encomendas) {
                            if (encomenda.getCliente().equals(cliente)) {
                                System.out.println(encomenda);
                                encomendaFound = true;
                            }
                        }
                        clientFound = true;
                    }
                }

                if (!clientFound) {
                    System.out.println("Cliente não encontrado");
                } else if (!encomendaFound) {
                    System.out.println("Cliente não tem encomendas");
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

    private static void pesquisas() {

        Main.clearScreen();

        System.out.println("1 - Pesquisar utilizadores");
        System.out.println("2 - Pesquisar medicamentos");
        System.out.println("3 - Pesquisar encomendas");

        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        switch (opcao) {
            case 1:
                pesquisarUtilizadores();
                break;
            case 2:
                pesquisarMedicamentos();
                break;
            case 3:
                pesquisarEncomendas();
                break;
            case 0:
                System.out.println("Voltar");
                break;
            default:
                System.out.println("Opção inválida");
                break;

        }
    }

    private static void pesquisarUtilizadores() {

        Main.clearScreen();

        System.out.println("Pesquisar utilizadores\n");

        System.out.println("1 - Pesquisar por nome");
        System.out.println("2 - Pesquisar por email");
        System.out.println("3 - Pesquisar por login");

        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Pesquisar por nome\n");

                System.out.println("Insira o nome do utilizador");

                String nome = scanner2.nextLine();

                boolean userFound = false;

                for (Utilizadores utilizador : users) {
                    if (utilizador.getNome().contains(nome)) {
                        System.out.println(utilizador);
                        userFound = true;
                    }
                }

                for (Farmaceutico farmaceutico : farmaceuticos) {
                    if (farmaceutico.getNome().contains(nome)) {
                        System.out.println(farmaceutico);
                        userFound = true;
                    }
                }

                for (Cliente cliente : clientes) {
                    if (cliente.getNome().contains(nome)) {
                        System.out.println(cliente);
                        userFound = true;
                    }
                }

                if (!userFound) {
                    System.out.println("Utilizador não encontrado");
                }

                break;
            case 2:
                System.out.println("Pesquisar por email\n");

                System.out.println("Insira o email do utilizador");

                String email = scanner2.nextLine();

                boolean emailFound = false;

                for (Utilizadores utilizador : users) {
                    if (utilizador.getEmail().equals(email)) {
                        System.out.println(utilizador);
                        emailFound = true;
                    }
                }

                for (Farmaceutico farmaceutico : farmaceuticos) {
                    if (farmaceutico.getEmail().equals(email)) {
                        System.out.println(farmaceutico);
                        emailFound = true;
                    }
                }

                for (Cliente cliente : clientes) {
                    if (cliente.getEmail().equals(email)) {
                        System.out.println(cliente);
                        emailFound = true;
                    }
                }

                if (!emailFound) {
                    System.out.println("Utilizador não encontrado");
                }

                break;
            case 3:
                System.out.println("Pesquisar por login\n");

                System.out.println("Insira o login do utilizador");

                String login = scanner2.nextLine();

                boolean loginFound = false;

                for (Utilizadores utilizador : users) {
                    if (utilizador.getLogin().contains(login)) {
                        System.out.println(utilizador);
                        loginFound = true;
                    }
                }

                for (Farmaceutico farmaceutico : farmaceuticos) {
                    if (farmaceutico.getLogin().contains(login)) {
                        System.out.println(farmaceutico);
                        loginFound = true;
                    }
                }

                for (Cliente cliente : clientes) {
                    if (cliente.getLogin().contains(login)) {
                        System.out.println(cliente);
                        loginFound = true;
                    }
                }

                if (!loginFound) {
                    System.out.println("Utilizador não encontrado");
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

    private static void pesquisarMedicamentos() {

        Main.clearScreen();

        System.out.println("Pesquisar medicamentos\n");

        System.out.println("1 - Pesquisar por nome");
        System.out.println("2 - Pesquisar por categoria");
        System.out.println("3 - Pesquisar por componente");
        System.out.println("4 - Pesquisar por Genericos");
        System.out.println("5 - Pesquisar por Não Genericos");
        System.out.println("6 - Pesquisar abaixo de stock");

        System.out.println("0 - Voltar");

        int opcao = scanner2.nextInt();
        scanner2.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Pesquisar por nome\n");

                System.out.println("Insira o nome do medicamento");

                String nome = scanner2.nextLine();

                boolean medicamentoFound = false;

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getDesignacao().contains(nome)) {
                        System.out.println(medicamento);
                        medicamentoFound = true;
                    }
                }

                if (!medicamentoFound) {
                    System.out.println("Medicamento não encontrado");
                }

                break;
            case 2:
                System.out.println("Pesquisar por categoria\n");

                System.out.println("Insira o nome da categoria");

                String categoria = scanner2.nextLine();

                boolean categoriaFound = false;

                for (Medicamento medicamento : medicamentos) {
                    for (Categoria cat : medicamento.getCategorias()) {
                        if (cat.getDesignacao().contains(categoria)) {
                            System.out.println(medicamento);
                            categoriaFound = true;
                        }
                    }
                }

                if (!categoriaFound) {
                    System.out.println("Medicamento não encontrado");
                }

                break;
            case 3:
                System.out.println("Pesquisar por componente\n");

                System.out.println("Insira o nome do componente");

                String componente = scanner2.nextLine();

                boolean componenteFound = false;

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getComponenteActivo().getDesignacao().contains(componente)) {
                        System.out.println(medicamento);
                        componenteFound = true;
                    }
                }

                if (!componenteFound) {
                    System.out.println("Medicamento não encontrado");
                }

                break;
            case 4:
                System.out.println("Pesquisar por Genericos\n");

                boolean genericoFound = false;

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.isGenerico()) {
                        System.out.println(medicamento);
                        genericoFound = true;
                    }
                }

                if (!genericoFound) {
                    System.out.println("Medicamento não encontrado");
                }

                break;
            case 5:
                System.out.println("Pesquisar por Não Genericos\n");

                boolean naoGenericoFound = false;

                for (Medicamento medicamento : medicamentos) {
                    if (!medicamento.isGenerico()) {
                        System.out.println(medicamento);
                        naoGenericoFound = true;
                    }
                }

                if (!naoGenericoFound) {
                    System.out.println("Medicamento não encontrado");
                }

                break;
            case 6:
                System.out.println("Pesquisar abaixo de stock\n");

                System.out.println("Insira a quantidade");

                int quantidade = scanner2.nextInt();

                boolean stockFound = false;

                for (Medicamento medicamento : medicamentos) {
                    if (medicamento.getQuantidadeStock() < quantidade) {
                        System.out.println(medicamento);
                        stockFound = true;
                    }
                }

                if (!stockFound) {
                    System.out.println("Medicamento não encontrado");
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

    private static void pesquisarEncomendas() {

        Main.clearScreen();

        System.out.println("Pesquisar encomendas\n");

        System.out.println("Insira o id da encomenda");

        int id = scanner2.nextInt();

        boolean encomendaFound = false;

        for (Encomenda encomenda : encomendas) {
            if (encomenda.getId() == id) {
                System.out.println(encomenda);
                encomendaFound = true;
            }
        }

        if (!encomendaFound) {
            System.out.println("Encomenda não encontrada");
        }

    }

}
