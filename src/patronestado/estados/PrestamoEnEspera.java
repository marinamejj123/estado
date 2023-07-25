/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronestado.estados;

import javax.swing.JOptionPane;
import patronestado.Estado;
import patronestado.Prestamo;

/**
 *
 * @author Usuario
 */
public class PrestamoEnEspera implements Estado {

    private Prestamo prestamo;

    @Override
    public void cambiarPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public void esperandoSolicitud() {
        JOptionPane.showMessageDialog(null, "Esperando un nuevo préstamo");
    }

    @Override
    public void solicitando() {
        JOptionPane.showMessageDialog(null, "Préstamo solicitado");
        prestamo.setPosicion(1);
        prestamo.cambiarEstado(prestamo.getEstados().get(prestamo.getPosicion()));
        prestamo.setMensaje("Prestamo solicitado");
    }

    @Override
    public void prestamoConfirmado() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: No hay ningún préstamo solicitado para confirmar");
    }

    @Override
    public void prestamoRechazado() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: No hay ningún préstamo solicitado para rechazar");
    }

    @Override
    public void devolviendo() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: No hay ningún préstamo para devolver");
    }

}
