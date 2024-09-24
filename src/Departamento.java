public class Departamento {
    private int id;
    private double totalVendas;

    public Departamento(int id, double totalVendas) {
        this.id = id;
        this.totalVendas = totalVendas;
    }

    public int getId() {
        return id;
    }

    public double getTotalVendas() {
        return totalVendas;
    }
}
