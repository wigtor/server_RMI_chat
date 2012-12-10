/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfazServidor extends Remote{
    public int Suma(int X,int Y)  throws RemoteException;
}