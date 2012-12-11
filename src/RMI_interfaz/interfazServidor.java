/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface interfazServidor extends Remote{
    public String getIpPublicaServer() throws RemoteException;
    public String getIpCliente() throws RemoteException;
    public int conectar(String username, String pass, int puertoEscuchaCliente) throws RemoteException;
    public boolean conectarSala(int idSesion, String username, String nombreSala) throws RemoteException;
    public boolean enviarMensajeSala(int idSesion, String username, String salaSelected, String mensaje, String timestamp) throws RemoteException;
    public boolean desconectarSala(int idSesion, String username, String nombreSala) throws RemoteException;
    public int desconectar(int idSesion) throws RemoteException;
    public String registrarUsuario(String username, String pass) throws RemoteException;
    //public ArrayList<UsuarioFromCliente> getUsuariosConectados(int idSesion) throws RemoteException;
    public String cambiarPass(String nombre, String pass, String passNew) throws RemoteException;
    public ArrayList<String> getSalasChat(int idSesion) throws RemoteException;
    
    /*probando commit*/
    
}