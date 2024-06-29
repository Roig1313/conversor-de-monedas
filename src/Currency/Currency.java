package Currency;

import com.aluracursos.principal.com.Principalconbusqueda;
import com.aluracursos.principal.com.TituloOMBD;
import com.google.gson.annotations.SerializedName;

public class Currency {

    private String monedaACambiar;
    private double monto;
    private int option;
    private String cambiarALaMoneda;
    private String siglasMoneda;
    private double tipoCambio;

    public Currency() {
        this.option = 0; // Puedes inicializar los valores por defecto que prefieras
        this.monto = 0.0;
        this.monedaACambiar = "";
        this.cambiarALaMoneda = "";
        this.siglasMoneda = "";
        this.tipoCambio = 0.0;
    }

    public Currency(TituloOMBD baseOresultado, double montoResultado) {
        siglasMoneda = baseOresultado.base_code();
        cambiarALaMoneda = baseOresultado.target_code();
        monto = montoResultado*baseOresultado.conversion_rate();
    }


    @Override
    public String toString() {
        return "Currency{" +
                "tipoCambio=" + tipoCambio +
                '}';
    }




    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

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
        System.out.println("El monto en "+cambiarALaMoneda+" es: ");
//        System.out.println("El monto en "+cambiarALaMoneda+" es: "+monto*tipoCambio+siglasMoneda);
    }




}
