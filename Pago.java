package Victor_Tesoura;

import java.text.DecimalFormat;

public abstract class Pago extends Evento implements Bilhetes {

    protected int bilhete;
    protected double preco;
    public static DecimalFormat df;

    public Pago(byte codigo, String nome, String local, String data, String hora, char categoria, char tipo, int bilhete, double preco) {
        super(codigo, nome, local, data, hora, categoria, tipo);
        this.bilhete = bilhete;
        this.preco = preco;
        df = new DecimalFormat("###,##0.00 Mt");
    }

    public Pago() {
        this((byte) 0, "", "", "", "", ' ', ' ', 0, 0);
    }

    public void setBilhete(int bilhete) {
        if (bilhete > 10) {
            this.bilhete = bilhete;

        }
    }

    public int getBilhete() {
        return bilhete;
    }

    public void setPreco(double preco) {
        if (preco > 10) {
            this.preco = preco;
        }
    }

    public double getPreco() {
        return preco;
    }

    //**Defesa**//metodo abstracto que acumular o total
    public double calcularTotal() {
        Calculos c = new Calculos();
        return c.total(bilhete, preco);
    }

    //**Defesa**//metodo abstracto acumular bilhetes
    public int calcularBilhetes() {
        Calculos c = new Calculos();
        return c.bilhetes(bilhete);
    }

    @Override
    public String toString() {
        return super.toString() + ", Pago [bilhete=" + bilhete + ", preco=" + df.format(preco);
    }

}
