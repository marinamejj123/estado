/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronestado.estados;

import patronestado.estados.PrestamoRealizado;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import patronestado.Estado;
import patronestado.Prestamo;

/**
 *
 * @author Usuario
 */
public class PrestamoSolicitado implements Estado {

    private Prestamo prestamo;

    @Override
    public void cambiarPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public void esperandoSolicitud() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: Existe un préstamo en solicitud");
    }

    @Override
    public void solicitando() {
        JOptionPane.showMessageDialog(null, "Ya existe un préstamo solicitado");
    }

    @Override
    public void prestamoConfirmado() {
        JOptionPane.showMessageDialog(null, "Préstamo confirmado");
        prestamo.setPosicion(2);
        prestamo.cambiarEstado(prestamo.getEstados().get(prestamo.getPosicion()));
        prestamo.setMensaje("Prestamo Realizado");
    }

    @Override
    public void prestamoRechazado() {
        JOptionPane.showMessageDialog(null, "Préstamo rechazado");
        prestamo.setPosicion(0);
        prestamo.cambiarEstado(prestamo.getEstados().get(prestamo.getPosicion()));
        prestamo.setMensaje("En espera...");
    }

    @Override
    public void devolviendo() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: Todavia no se realizó ningún préstamo");
    }

}
