/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronestado;

/**
 *
 * @author Usuario
 */
public interface Estado {
    
    void cambiarPrestamo(Prestamo prestamo);
    void esperandoSolicitud();
    void solicitando();
    void prestamoConfirmado();
    void prestamoRechazado();
    void devolviendo();
}
