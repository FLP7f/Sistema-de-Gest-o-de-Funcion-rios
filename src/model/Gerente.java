package model;

public class Gerente extends Funcionario {

    public Gerente(String nome, int anoNascimento,
                   int id, double salario) {

        super(nome, anoNascimento, id, "Gerente", salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.20;
    }
}
