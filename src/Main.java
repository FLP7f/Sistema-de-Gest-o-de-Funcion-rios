import dao.FuncionarioDAO;
import model.Funcionario;
import model.Gerente;
import model.Caixa;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FuncionarioDAO dao = new FuncionarioDAO();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n==================================");
            System.out.println(" SISTEMA DE GESTAO DE FUNCIONARIOS");
            System.out.println("==================================");
            System.out.println("1 - Cadastrar funcionario");
            System.out.println("2 - Listar funcionarios");
            System.out.println("3 - Excluir funcionario");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = Integer.parseInt(scanner.nextLine());

            try {

                switch (opcao) {

                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        excluir();
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opcao invalida!");
                }

            } catch (SQLException e) {
                System.out.println("Erro no banco: " + e.getMessage());
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrar() throws SQLException {

        System.out.println("\n===== CADASTRO =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Ano de nascimento: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Salario: R$ ");
        double salario = lerDouble();

        System.out.println("\n1 - Gerente");
        System.out.println("2 - Caixa");
        System.out.print("Cargo: ");

        int tipo = Integer.parseInt(scanner.nextLine());

        Funcionario funcionario;

        if (tipo == 1) {

            funcionario = new Gerente(
                    nome, ano, 0, salario
            );

        } else if (tipo == 2) {

            System.out.print("Saldo inicial: R$ ");
            double inicial = lerDouble();

            System.out.print("Saldo de fechamento: R$ ");
            double fechamento = lerDouble();

            funcionario = new Caixa(
                    nome, ano, 0, salario, inicial, fechamento
            );

        } else {

            System.out.println("Cargo invalido!");
            return;
        }

        dao.cadastrar(funcionario);
    }

    private static void listar() throws SQLException {

        List<Funcionario> funcionarios = dao.listar();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }

        for (Funcionario funcionario : funcionarios) {

            funcionario.exibirFuncionario();

            if (funcionario instanceof Caixa) {
                ((Caixa) funcionario).exibirSaldos();
            }
        }
    }

    private static void excluir() throws SQLException {

        System.out.print("Digite a matrícula do funcionario: ");

        int id = Integer.parseInt(scanner.nextLine());

        dao.excluir(id);
    }

    private static double lerDouble() {

        return Double.parseDouble(
                scanner.nextLine().replace(",", ".")
        );
    }
}