import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

    private static List<Utilizadores> users = new ArrayList<>(); //tipo users 
                                                                 //estado falso
    private static List<Farmaceutico> farmaceuticos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Componente> componentes = new ArrayList<>();
    private static List<Encomenda> encomendas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int erro = 0;
    private static int firstRun = 0;

    private static Utilizadores user;

    public static void main(String[] args) {

        boolean loop = true;

        load();

        for (Encomenda localEncomenda : encomendas) {
            System.out.println(localEncomenda.getConfirmado());
            
        }

        while (loop == true) {

            //clearScreen();

            user = null;

            System.out.println("XOXOXOXOXOXOXOXOXOXOXOXOX");
            System.out.println("O                       O");
            System.out.println("X       1 - Login       X");
            System.out.println("O      2 - Registar     O");
            System.out.println("X       3 - Sair        X");
            System.out.println("O                       O");
            System.out.println("XOXOXOXOXOXOXOXOXOXOXOXOX");

            if (erro == 1) {
                System.out.println("\u001B[31mERRO:\u001B[0m Não existe dados anteriores guardados.");
            }

            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Opção escolhida: " + opcao);

            switch (opcao) {
                case 1:
                    System.out.println("Login");
                    login();
                    break;
                case 2:
                    System.out.println("Registar");
                    registar();
                    break;
                case 3:
                    System.out.println("A terminar...");
                    save();
                    loop = false;
                    break;

                case 4:

                    System.out.println("Menu gestor");
                    MenuGestor.menuGestor(users.get(0), users, farmaceuticos, clientes, medicamentos, componentes,
                            encomendas);
                    break;

                case 5:

                    System.out.println("Menu cliente");
                    MenuCliente.menuCliente(clientes.get(0), medicamentos, componentes, encomendas);
                    break;
                case 6:
                    System.out.println("-----DUMP-----");

                    System.out.println("\nUtilizadores:");
                    for (Utilizadores localUser : users) {
                        System.out.println(localUser.getNome());
                    }

                    System.out.println("\nFarmaceuticos:");
                    for (Farmaceutico localFarmaceutico : farmaceuticos) {
                        System.out.println(localFarmaceutico.getNome());
                    }

                    System.out.println("\nClientes:");
                    for (Cliente localCliente : clientes) {
                        System.out.println(localCliente.getNome());
                    }
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            if (loop == true) {
                System.out.println("Prima enter para continuar");
                scanner.nextLine();
            }
        }
    }
    
    public static void login() {

        //clearScreen();

        System.out.println("\nE-mail: ");
        String email = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        for (Utilizadores localUser : users) {
            if (localUser.getEmail().equals(email)) {
                user = localUser;
                break;
            }
        }
        if (user == null) {
            for (Farmaceutico localFarmaceutico : farmaceuticos) {
                if (localFarmaceutico.getEmail().equals(email)) {
                    user = localFarmaceutico;
                    System.out.println("1");
                    break;
                }
            }
        }
        if (user == null) {
            for (Cliente localCliente : clientes) {
                if (localCliente.getEmail().equals(email)) {
                    user = localCliente;
                    System.out.println("2");
                    break;
                }
            }
        }

        int valid = 0;

        if (user != null) {
            System.out.println("Utilizador encontrado");
            System.out.println(password);
            if (user.verificaPassword(password)) {
                System.out.println("Password correta");
                if (user.getAtivo()) {
                    System.out.println("Utilizador ativo");
                    valid = 1;
                } else {
                    System.out.println("Utilizador inativo");
                }
            } else {
                System.out.println("Password incorreta");
            }
        } else {
            System.out.println("Utilizador não encontrado");
        
        }
        if (valid == 1) {
            afterLogin();
        }
    }


    public static void registar() {

        //clearScreen();

        if (firstRun == 1) {
            System.out.println("Registo de gestor (primeira execução):");
        } else {
            System.out.println("Registo de utilizador:");
        }

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

            if (firstRun == 1) {
                Utilizadores user = new Utilizadores(username, password, nome, true, email, "gestor");
                users.add(user);
                firstRun = 0;
            } else {
    
                System.out.println("NIF: ");
                int nif = scanner.nextInt();
                scanner.nextLine();
    
                System.out.println("Morada: ");
                String morada = scanner.nextLine();
    
                System.out.println("Telefone: ");
                int telefone = scanner.nextInt();
                scanner.nextLine();
                
                if (Utilizadores.verificaUnicidade(username, email)) {
                    if (Utilizadores.verifyNifTel(nif, telefone)) {
                        Cliente cliente = new Cliente(username, password, nome, false, email, "user", nif, morada,
                        telefone);
                clientes.add(cliente);
                System.out.println("Utilizador registado com sucesso\n");
                    } else {
                        System.out.println("NIF ou telefone inválidos");
                    }
                    
                }
                else {
                    System.out.println("Login ou email já existente");
                }
            }
        } else {
            System.out.println("Passwords diferentes");
        }

        

        

    }

    public static void afterLogin() {

        clearScreen();

        if (user.getTipo().equals("gestor")) {
            MenuGestor.menuGestor(user, users, farmaceuticos, clientes, medicamentos, componentes, encomendas);
        } else if (user.getTipo().equals("user")) {
            MenuCliente.menuCliente((Cliente) user, medicamentos, componentes, encomendas);
        } else if (user.getTipo().equals("farmaceutico")) {
            MenuFarmaceutico.menuFarmaceutico((Farmaceutico) user, medicamentos, componentes, encomendas);
        } else {
            System.out.println("Tipo de utilizador inválido");
        }

    }

    public static void encerrarPrograma(){
    
        clearScreen();
        
        if(user!=null){
            System.out.println("Adeus "+user.getNome());
        }else{
            System.out.println("Adeus");
        }
        save();
    }

    public static void save() {
        System.out.println("A guardar...");
        try {
            FileOutputStream fileOut = new FileOutputStream("dados_apl.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            Files data = new Files(users, farmaceuticos, clientes, medicamentos, componentes, encomendas);
            out.writeObject(data);
  
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void load() {
        System.out.println("A carregar...");
        try {
            FileInputStream fileIn = new FileInputStream("dados_apl.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            if (obj instanceof Files) {
                Files data = (Files) obj;
                users = data.getUsers();
                farmaceuticos = data.getFarmaceuticos();
                clientes = data.getClientes();
                medicamentos = data.getMedicamentos();
                componentes = data.getComponentes();
                encomendas = data.getEncomendas();
                // Carregue outros dados do objeto data aqui
            } else {
                System.out.println("Data is not of type Data");
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            erro = 1;
            firstRun = 1;
            registar();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
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

}