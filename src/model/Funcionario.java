package model;

public abstract class Funcionario {

    private String nome;
    private int anoNascimento;
    private int id;
    private String cargo;
    private double salario;

    public Funcionario(String nome, int anoNascimento,
                       int id, String cargo, double salario) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public abstract double calcularBonus();

    public void exibirFuncionario() {
        System.out.println("\n===== DADOS DO FUNCIONARIO =====");
        System.out.println("Nome: " + nome);
        System.out.println("Ano de nascimento: " + anoNascimento);
        System.out.println("Matricula: " + id);
        System.out.println("Cargo: " + cargo);
        System.out.printf("Salario: R$ %.2f%n", salario);
        System.out.printf("Bonus: R$ %.2f%n", calcularBonus());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
