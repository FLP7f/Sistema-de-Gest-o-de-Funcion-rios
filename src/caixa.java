public class caixa extends funcionarios {

    private Double saldo_fechamento;  // Saldo de fechamento do caixa no dia
    private Double saldo_inicial; // Saldo do caixa no momento de abertura

    void exibir_saldos() {

        System.out.println("========= Valores do dia ======== ");
        System.out.println(" Saldo inicial >>> " + saldo_inicial);
        System.out.println(" Saldo fechamento >>> " + saldo_fechamento);

        Double diferenca = saldo_fechamento - saldo_inicial;

        if (saldo_inicial <= saldo_fechamento) {
            System.out.println(" Tivemos lucro de >>> " + diferenca);
        } else {
            System.out.println(" Não tivemos lucro >>> " + diferenca);
        }

    }


    public Double getSaldo_fechamento() {
        return saldo_fechamento;
    }

    public void setSaldo_fechamento(Double saldo_fechamento) {
        this.saldo_fechamento = saldo_fechamento;
    }

    public Double getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(Double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }
}
