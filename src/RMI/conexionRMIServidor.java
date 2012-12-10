/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;


import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexionRMIServidor {
    private static Registry registry;
    private static boolean activo = false;
    
    //mensajes de estados
    public static final String conectado = "Conectado";
    public static final String desconectado = "Desconectado";

    public static boolean isActivo() {
        return activo;
    }

    public static void setActivo(boolean activo) {
        conexionRMIServidor.activo = activo;
    }
    
    public Registry getRegistry(int puerto) throws RemoteException{
        //Se inicia RMIREGISTRY para el registro de objetos
        //startRegistry(puerto de comunicación), no es necesario especificar la direccion
        startRegistry(puerto);
        return registry;
    }

    public boolean detener() throws RemoteException{
        try {
            //Se saca de rmiregistry el objeto "Implementacion"
            //Ya no esta disponible para ser consumido
            registry.unbind("Implementacion");
            activo = false;
        } catch (NotBoundException ex) {
            Logger.getLogger(conexionRMIServidor.class.getName()).log(Level.SEVERE, null, ex);
            activo = true;
            return false;
        } catch (AccessException ex) {
            Logger.getLogger(conexionRMIServidor.class.getName()).log(Level.SEVERE, null, ex);
            activo = true;
            return false;
        }
        return true;
    }
    private static void startRegistry(int Puerto) throws RemoteException{
        try{
            registry = LocateRegistry.getRegistry(Puerto);
            registry.list();
            activo = true;
        }
        catch(RemoteException e){
            registry = LocateRegistry.createRegistry(Puerto);
            registry.list();
            activo = true;
        }
    }
}
