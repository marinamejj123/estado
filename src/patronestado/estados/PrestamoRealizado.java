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
public class PrestamoRealizado implements Estado {

    private Prestamo prestamo;

    @Override
    public void cambiarPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public void esperandoSolicitud() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: Existe un préstamo realizado");
    }

    @Override
    public void solicitando() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: Préstamo realizado, no se puede solicitar");
    }

    @Override
    public void prestamoConfirmado() {
        JOptionPane.showMessageDialog(null,
                "Préstamo ya confirmado");
    }

    @Override
    public void prestamoRechazado() {
        JOptionPane.showMessageDialog(null,
                "Acción inválida: Préstamo ya confirmado, no se puede rechazar");
    }

    @Override
    public void devolviendo() {
        JOptionPane.showMessageDialog(null, "Préstamo devuelto");
        prestamo.setPosicion(3);
        prestamo.cambiarEstado(prestamo.getEstados().get(prestamo.getPosicion()));
        prestamo.setMensaje("Prestamo devuelto");
    }

}
