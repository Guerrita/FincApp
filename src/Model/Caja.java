package Model;

import java.util.List;

public class Caja {
    private int capital,
                ingresos,
                egresos;
    private List<Transaccion> facturas;
    private Finca finca;

    public Caja(int capital, int ingresos, int egresos) {
        this.capital = capital;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }

    public List<Transaccion> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Transaccion> facturas) {
        this.facturas = facturas;
    }

}

