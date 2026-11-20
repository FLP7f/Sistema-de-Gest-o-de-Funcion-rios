import database.Conexao;
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        try (Connection conexao = Conexao.conectar()) {

            System.out.println("Conexão com MySQL realizada!");
            System.out.println("Banco conectado: "
                + conexao.getCatalog());

        } catch (Exception e) {
            System.out.println("Erro na conexão:");
            e.printStackTrace();
        }
    }
}