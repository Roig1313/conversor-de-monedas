package Currency;

public class Currency {
    private String monedaACambiar;
    private double monto;
    private int option;
    private String cambiarALaMoneda;
    private String siglasMoneda;

    public String getMonedaACambiar() {
        return monedaACambiar;
    }

    public double getMonto() {
        return monto;
    }

    public int getOption() {
        return option;
    }

    public String getCambiarALaMoneda() {
        return cambiarALaMoneda;
    }

    public String getSiglasMoneda() {
        return siglasMoneda;
    }

    public void setMonedaACambiar(String monedaACambiar) {
        this.monedaACambiar = monedaACambiar;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public void setCambiarALaMoneda(String cambiarALaMoneda) {
        this.cambiarALaMoneda = cambiarALaMoneda;
    }

    public void setSiglasMoneda(String siglasMoneda) {
        this.siglasMoneda = siglasMoneda;
    }

    public void monedaSeleccionada(){
        System.out.println("El monto en "+cambiarALaMoneda+" es: "+monto+siglasMoneda);
    }

}
