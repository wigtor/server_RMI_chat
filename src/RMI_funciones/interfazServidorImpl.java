/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_funciones;


import RMI_interfaz.interfazServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class interfazServidorImpl extends UnicastRemoteObject implements interfazServidor{
    public interfazServidorImpl() throws RemoteException{
        super();
    }
    
    @Override
    public int Suma(int X, int Y) throws RemoteException {
        return X+Y;
    }
}
