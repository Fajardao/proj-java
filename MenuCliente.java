import java.util.Scanner;

public class MenuCliente {

    private static Scanner scanner2 = new Scanner(System.in);

    public static void menuCliente(Utilizadores atualUser) {

        boolean loop = true;

        while (loop) {

            Main.clearScreen();

            int opcao = 10;

            System.out.println("Bem vindo " + atualUser.getNome());

            System.out.println("1 - Fazer encomenda");
            System.out.println("0 - Logout");

            opcao = scanner2.nextInt();

            switch (opcao) {
                case 1:
                    fazerEncomenda();
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

    private static void fazerEncomenda() {
/*
        int i = 1;

        System.out.println("\nLista de produtos");
        System.out.println("Selecione o produto que pretende encomendar\n");

        for (Produto produto : Main.produtos) {
            System.out.println(i + " - " + produto.getNome());
            i++;
        }

        int opcao = scanner2.nextInt();

        System.out.println("Quantidade: ");
        int quantidade = scanner2.nextInt();

        System.out.println("Morada: ");
        String morada = scanner2.nextLine();

        System.out.println("Telefone: ");
        int telefone = scanner2.nextInt();

        System.out.println("Data de entrega: ");
        String dataEntrega = scanner2.nextLine();

        System.out.println("Hora de entrega: ");
        String horaEntrega = scanner2.nextLine();

        System.out.println("Observações: ");
        String observacoes = scanner2.nextLine();

        System.out.println("Encomenda efetuada com sucesso");

        Encomenda encomenda = new Encomenda(Main.produtos.get(opcao - 1), quantidade, morada, telefone, dataEntrega, horaEntrega, observacoes);

        Main.encomendas.add(encomenda);*/

    }
}
