public class funcionarios {

    private String nome;
    private int ano_nascimento;
    private int id;
    private String cargo;
    private double salario;

    void exibir_funcionario() {
        System.out.println("""
                ========== Dados do funcionario =======
                Funcionario: %s
                Ano de nascimento: %d 
                Matricula (ID): %d
                Cargo atual: %s
                Salario: %2f
                """.formatted(nome, ano_nascimento, id, cargo, salario));
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
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
