package dao;

import database.Conexao;
import model.Funcionario;
import model.Gerente;
import model.Caixa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void cadastrar(Funcionario funcionario) throws SQLException {

        String sql = """
            INSERT INTO funcionarios
            (nome, ano_nascimento, cargo, salario,
             saldo_inicial, saldo_fechamento)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, funcionario.getNome());
            comando.setInt(2, funcionario.getAnoNascimento());
            comando.setString(3, funcionario.getCargo());
            comando.setDouble(4, funcionario.getSalario());

            if (funcionario instanceof Caixa) {

                Caixa caixa = (Caixa) funcionario;

                comando.setDouble(5, caixa.getSaldoInicial());
                comando.setDouble(6, caixa.getSaldoFechamento());

            } else {

                comando.setNull(5, Types.DOUBLE);
                comando.setNull(6, Types.DOUBLE);
            }

            comando.executeUpdate();

            System.out.println("Funcionario cadastrado com sucesso!");
        }
    }

    public List<Funcionario> listar() throws SQLException {

        List<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM funcionarios";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int ano = resultado.getInt("ano_nascimento");
                String cargo = resultado.getString("cargo");
                double salario = resultado.getDouble("salario");

                Funcionario funcionario;

                if (cargo.equalsIgnoreCase("Gerente")) {

                    funcionario = new Gerente(
                            nome, ano, id, salario
                    );

                } else if (cargo.equalsIgnoreCase("Caixa")) {

                    double inicial =
                            resultado.getDouble("saldo_inicial");

                    double fechamento =
                            resultado.getDouble("saldo_fechamento");

                    funcionario = new Caixa(
                            nome, ano, id, salario,
                            inicial, fechamento
                    );

                } else {
                    continue;
                }

                funcionarios.add(funcionario);
            }
        }

        return funcionarios;
    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            int linhas = comando.executeUpdate();

            if (linhas > 0) {
                System.out.println("Funcionario excluido com sucesso!");
            } else {
                System.out.println("Funcionario nao encontrado.");
            }
        }
    }
}