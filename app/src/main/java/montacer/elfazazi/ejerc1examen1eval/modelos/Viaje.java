package montacer.elfazazi.ejerc1examen1eval.modelos;

import java.io.Serializable;

public class Viaje implements Serializable {
    private String destino;

    private int personas;

    private int dias;

    private int tipoViaje;

    private int extras;

    public Viaje() {
    }

    public Viaje(String destino, int personas, int dias, int tipoViaje, int extras) {
        this.destino = destino;
        this.personas = personas;
        this.dias = dias;
        this.tipoViaje = tipoViaje;
        this.extras = extras;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(int tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "destino='" + destino + '\'' +
                ", personas=" + personas +
                ", dias=" + dias +
                ", tipoViaje=" + tipoViaje +
                ", extras=" + extras +
                '}';
    }
}
