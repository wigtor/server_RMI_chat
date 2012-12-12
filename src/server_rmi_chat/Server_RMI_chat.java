/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server_rmi_chat;

/**
 *
 * @author victor
 */
public class Server_RMI_chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Server_window window = new Server_window();
        window.setVisible(true);        
        Chat_window chat = new Chat_window();
        chat.setVisible(true);
        
        
    }
}
