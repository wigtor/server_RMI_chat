/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DB_Conector {
    String mensaje="";
    boolean Conectado;
    String IP = "localhost";
    String DB = "labdistribuidos";
    int PUERTO = 3306;
    
    public Connection CrearConexion(){
        Connection conexion=null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://"+IP+":"+PUERTO+"/"+DB+"";
        String usuario = "root";
        String clave = "lab3Distribuidos";

        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usuario,clave);             
            mensaje="Conectado MySQL";
            Conectado = true;
            
            if(conexion.isClosed()){
                mensaje="Desconectado MySQL";
                Conectado = false;
            }         
            
        } catch (Exception ex){
            mensaje=ex.toString();
            Conectado = false;
	}
	System.out.println(mensaje);
        return conexion;  
    }
    
    public void CerrarConexion(Connection C){
    	Connection conexion;
        
        try{
            conexion=(Connection)C;
            conexion.close();

            mensaje="Conectado MySQL";
            Conectado = true;
            if(conexion.isClosed()){
                    mensaje="Desconectado MySQL";
                    Conectado = false;
            }        
        }
        catch(Exception ex){
            mensaje=ex.toString();  
            Conectado = false;
        }    
    }
    
    public String Mensaje(){
        return mensaje;    
    }
    
    public boolean Conectado(){
        return Conectado;
    }
    
    
    public ResultSet SELECT(Connection C, String Consulta){
        
        Statement scSQL;
        ResultSet rsListaRegistros = null;
        
        try{
            scSQL = C.createStatement();
            rsListaRegistros = scSQL.executeQuery(Consulta);
        }
        catch(Exception Ex){
            System.out.println(Ex.toString());           
        }
        
        return rsListaRegistros;
    }
    
    public int INSERT(Connection C,String Consulta){
    
        Statement scSQL;
        int FilasAfectadas;
        
        try{
            scSQL = C.createStatement();
	    
            FilasAfectadas = scSQL.executeUpdate(Consulta, Statement.RETURN_GENERATED_KEYS);
            if(FilasAfectadas!=0){
		int resultado = 0;
		ResultSet rs = scSQL.getGeneratedKeys();
		if (rs.next()){
		    resultado=rs.getInt(1);
		}
                return resultado;
            }
            else{
                return 0;
            }            
        }
        catch(Exception Ex){
            System.out.println(Ex.toString());
            return 0;
        }        
    
    }
    
    public boolean UPDATE(Connection C,String Consulta){
    
        Statement scSQL;
        int FilasAfectadas;
        
        try{
            scSQL = C.createStatement();
            FilasAfectadas = scSQL.executeUpdate(Consulta);
            if(FilasAfectadas!=0){
                return true;
            }
            else{
                return false;
            }            
        }
        catch(Exception Ex){
            System.out.println(Ex.toString());            
            return false;
        }        
    
    }
        
    public boolean DELETE(Connection C,String Consulta){
    
        Statement scSQL;
        int FilasAfectadas;
        
        try{
            scSQL = C.createStatement();
            FilasAfectadas = scSQL.executeUpdate(Consulta);
            if(FilasAfectadas!=0){
                return true;
            }
            else{
                return false;
            }            
        }
        catch(Exception Ex){
            System.out.println(Ex.toString());           
            return false;
        }        
    
    }
    
    
    public static Object[][] ResultSetToArray(ResultSet rs)
    {
        Object obj[][]=null;

        try
        {

        rs.last();

        ResultSetMetaData rsmd = rs.getMetaData();

        int numCols = rsmd.getColumnCount();

        int numFils =rs.getRow();

        obj=new Object[numFils][numCols];
        int j = 0;

        rs.beforeFirst();

        while (rs.next())
        {
            for (int i=0;i<numCols;i++)
            {

                obj[j][i]=rs.getObject(i+1);
            }
            j++;

        }

        }
        catch(Exception e)
        {

        }

        return obj;
    }
    
}
