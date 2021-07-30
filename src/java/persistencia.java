
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEVELOPER
 */
public class persistencia {
    
    private Connection cn;
    private ResultSet rs;
private preparedStatement ps;
private ResultSet rsn;

public String servidor, basededatos, usuario, clave,ejecutar; 
public Connection conectarse(){

        
        try {
            Class.forName("com.mysql.jdbc.driver");
        
           cn=DriverManager.getConnection("jdbc:mysql//");
                    
                    servidor="remotemysql.com";
                    
                   basededatos= "datosdeingreso";
                    
                   usuario="root";
                            
                            clave="";
                            cn=DriverManager.getConnection ("jdbc:mysql//" + servidor + basededatos, usuario, clave);
        
            

    
    } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    





    @SuppressWarnings("empty-statement") 
     ResultSet consultaSQL (String busqueda) throws SQLException{ 


        try {
            ps=(preparedStatement) conectarse().prepareStatement(busqueda);
        } catch (SQLException ex) {
            Logger.getLogger(persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
rs=ps.executeQuery();
rsn=    (ResultSet) rs.getMetaData();


return rs;
        
}

    

