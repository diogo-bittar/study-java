package modulo2;

public class Apolice {
    private String segurado;
    private double premio;
    private String categoria;

    public Apolice(String segurado, double premio, String categoria){
        this.segurado = segurado;
        this.premio = premio;
        this.categoria = categoria;

    }

    public String getSegurado() { return segurado; }
    public double getPremio() { return premio; }
    public String getCategoria() { return categoria; }
}
