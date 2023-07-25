/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronestado.estados;

import java.awt.event.ActionEvent;
import patronestado.estados.PrestamoEnEspera;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import patronestado.Estado;
import patronestado.Prestamo;

/**
 *
 * @author Usuario
 */
public class PrestamoDevuelto implements Estado {

    private Prestamo prestamo;

    @Override
    public void cambiarPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public void esperandoSolicitud() {
        JOptionPane.showMessageDialog(null, "Préstamo en espera");
        prestamo.setPosicion(0);
        prestamo.cambiarEstado(prestamo.getEstados().get(prestamo.getPosicion()));
        prestamo.setMensaje("En espera...");

    }

    @Override
    public void solicitando() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: Préstamo devuelto, no se puede solicitar");
    }

    @Override
    public void prestamoConfirmado() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: No hay préstamo que confirmar");
    }

    @Override
    public void prestamoRechazado() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: No hay préstamo que rechazar");
    }

    @Override
    public void devolviendo() {
        JOptionPane.showMessageDialog(null, "Préstamo devuelto");
    }

}
