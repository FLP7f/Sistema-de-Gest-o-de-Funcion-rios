package model;

public class Caixa extends Funcionario {

    private double saldoInicial;
    private double saldoFechamento;

    public Caixa(String nome, int anoNascimento,
                 int id, double salario,
                 double saldoInicial, double saldoFechamento) {

        super(nome, anoNascimento, id, "Caixa", salario);

        this.saldoInicial = saldoInicial;
        this.saldoFechamento = saldoFechamento;
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.10;
    }

    public void exibirSaldos() {

        double diferenca = saldoFechamento - saldoInicial;

        System.out.println("\n===== FECHAMENTO DO CAIXA =====");

        System.out.printf("Saldo inicial: R$ %.2f%n", saldoInicial);
        System.out.printf("Saldo fechamento: R$ %.2f%n", saldoFechamento);
        System.out.printf("Diferenca: R$ %.2f%n", diferenca);

        if (diferenca > 0) {
            System.out.println("Resultado: Saldo positivo.");
        } else if (diferenca < 0) {
            System.out.println("Resultado: Saldo negativo.");
        } else {
            System.out.println("Resultado: Sem diferenca.");
        }
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoFechamento() {
        return saldoFechamento;
    }

    public void setSaldoFechamento(double saldoFechamento) {
        this.saldoFechamento = saldoFechamento;
    }
}

