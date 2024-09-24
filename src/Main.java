import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Criando departamentos
            List<Departamento> departamentos = new ArrayList<>();
            departamentos.add(new Departamento(1, 50000));
            departamentos.add(new Departamento(2, 100000));  // Maior valor de vendas
            departamentos.add(new Departamento(3, 100000));  // Outro com maior valor de vendas

            // Criando funcionários
            List<Funcionario> funcionarios = new ArrayList<>();
            funcionarios.add(new Funcionario(1, 120000, "Desenvolvedor", 1));
            funcionarios.add(new Funcionario(2, 150000, "Gerente", 2));  // Gerente
            funcionarios.add(new Funcionario(3, 140000, "Desenvolvedor", 2));  // Elegível
            funcionarios.add(new Funcionario(4, 160000, "Desenvolvedor", 3));  // Salário >= 150.000

            // Calculando bônus
            int resultado = BonusCalculator.calcularBonus(funcionarios, departamentos);

            // Resultado da execução
            if (resultado == 0) {
                System.out.println("Bônus aplicado com sucesso!");
                for (Funcionario f : funcionarios) {
                    System.out.println("Funcionário ID: " + f.getId() + " - Novo Salário: " + f.getSalario());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
