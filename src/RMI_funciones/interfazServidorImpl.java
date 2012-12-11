/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_funciones;


import RMI_interfaz.interfazServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class interfazServidorImpl extends UnicastRemoteObject implements interfazServidor{
    public interfazServidorImpl() throws RemoteException{
        super();
    }
    
    @Override
    public String getIpPublicaServer() throws RemoteException {
        
        return null;
    }
    
    @Override
    public String getIpCliente() throws RemoteException {
        
        return null;
    }
    
    @Override
    public int conectar(String username, String pass, int puertoEscuchaCliente) throws RemoteException {
        
        return 0;
    }
    
    @Override
    public boolean conectarSala(int idSesion, String username, String nombreSala) {
        
        
        return false;
    }
    
    @Override
    public boolean enviarMensajeSala(int idSesion, String username, String salaSelected, String mensaje, String timestamp) {
        
        return false;
    }
    
    @Override
    public boolean desconectarSala(int idSesion, String username, String nombreSala) {
        
        
        return false;
    }
    
    @Override
    public int desconectar(int idSesion) {
        
        return 0;
    }
    
    @Override
    public String registrarUsuario(String username, String pass) {
        
        return null;
    }
    
    /*
    @Override
    public ArrayList<UsuarioFromCliente> getUsuariosConectados(int idSesion);
    
    */
    
    @Override
    public String cambiarPass(String nombre, String pass, String passNew) {
        
        return null;
    }
    
    @Override
    public ArrayList<String> getSalasChat(int idSesion) {
        
        return null;
    }
}
