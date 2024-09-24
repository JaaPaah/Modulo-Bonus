import java.util.List;

public class BonusCalculator {

    public static int calcularBonus(List<Funcionario> funcionarios, List<Departamento> departamentos) throws Exception {
        if (funcionarios.isEmpty() || departamentos.isEmpty()) {
            throw new Exception("Código 1: Uma das tabelas está vazia.");
        }

        // Identifica o(s) departamento(s) com o maior valor de vendas
        double maiorVenda = departamentos.stream()
                                         .mapToDouble(Departamento::getTotalVendas)
                                         .max()
                                         .orElse(0);

        List<Departamento> departamentosComMaiorVenda = departamentos.stream()
                                                                     .filter(departamento -> departamento.getTotalVendas() == maiorVenda)
                                                                     .toList();

        // Verifica se há funcionários nos departamentos de maior venda
        List<Funcionario> funcionariosElegiveis = funcionarios.stream()
                                                              .filter(funcionario -> departamentosComMaiorVenda.stream()
                                                                                                              .anyMatch(departamento -> departamento.getId() == funcionario.getDepartamentoId()))
                                                              .toList();

        if (funcionariosElegiveis.isEmpty()) {
            throw new Exception("Código 2: Não há funcionários elegíveis.");
        }

        // Aplica bônus
        for (Funcionario funcionario : funcionariosElegiveis) {
            if (funcionario.getSalario() >= 150000 || funcionario.getCargo().equalsIgnoreCase("Gerente")) {
                funcionario.setSalario(funcionario.getSalario() + 1000);
            } else {
                funcionario.setSalario(funcionario.getSalario() + 2000);
            }
        }

        return 0;  // Execução bem-sucedida
    }
}
