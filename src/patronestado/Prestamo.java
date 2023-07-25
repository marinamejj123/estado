/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronestado;

import java.util.ArrayList;
import patronestado.estados.PrestamoDevuelto;
import patronestado.estados.PrestamoEnEspera;
import patronestado.estados.PrestamoRealizado;
import patronestado.estados.PrestamoSolicitado;

/**
 *
 * @author Usuario
 */
public class Prestamo {

    private ArrayList<Estado> estados = new ArrayList<Estado>();
    private int posicion;
    private String mensaje;
    private String nombrePrestamo;

    public Prestamo() {
        addEstados();
        posicion = 0;
        nombrePrestamo = "";
        this.cambiarEstado(this.estados.get(posicion));
    }

    private void addEstados() {
        estados.add(new PrestamoEnEspera());
        estados.add(new PrestamoSolicitado());
        estados.add(new PrestamoRealizado());
        estados.add(new PrestamoDevuelto());
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombrePrestamo() {
        return nombrePrestamo;
    }

    public void setNombrePrestamo(String nombrePrestamo) {
        this.nombrePrestamo = nombrePrestamo;
    }
    
    public void cambiarEstado(Estado estado) {
        this.estados.set(posicion, estado);
        this.estados.get(posicion).cambiarPrestamo(this);
        this.setMensaje("En espera...");
    }

    public void esperandoSolicitud() {
        this.estados.get(posicion).esperandoSolicitud();
    }

    public void solicitando() {
        this.estados.get(posicion).solicitando();
    }

    public void prestamoConfirmado() {
        this.estados.get(posicion).prestamoConfirmado();
    }

    public void prestamoRechazado() {
        this.estados.get(posicion).prestamoRechazado();
    }

    public void devolviendo() {
        this.estados.get(posicion).devolviendo();
    }

}
