/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package santiagorodriguezhernandez_aa2_ev01;

/**
 *
 * @author USUARIO
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SantiagoRodriguezHernandez_AA2_EV01 {

    
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3307/auto_escuela";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        try {
            // TODO code application logic here

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SantiagoRodriguezHernandez_AA2_EV01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            
            
            statement.executeUpdate("INSERT INTO ASIGNATURA(NOMBRE, DESCRIPCION) VALUES('Manejo Avanzado',"
                    + " 'Curso para perfeccionar técnicas de conducción en condiciones difíciles')");
            rs = statement.executeQuery("SELECT * FROM ASIGNATURA");
            rs.next();
            do{
                System.out.println("Datos insertados correctamente en la tabla ASIGNATURA:");
                System.out.println(rs.getInt("id") + ":" + rs.getString("nombre"));
            }while(rs.next());
            
            
            // Consulta de datos
           rs = statement.executeQuery("SELECT * FROM ASIGNATURA");
            while (rs.next()) {
               System.out.println("Datos consultados correctamente en la tabla ASIGNATURA:");
                System.out.println(rs.getInt("id") + ":" + rs.getString("nombre") + " - " + rs.getString("descripcion"));
           }
            
            //Actualizacion de datos
            String nuevoNombre = "Manejo Avanzado II";
            String nuevaDescripcion = "Curso avanzado para perfeccionar técnicas de conducción en condiciones extremas";
            statement.executeUpdate("UPDATE ASIGNATURA SET nombre = '" + nuevoNombre + "', descripcion = '" + nuevaDescripcion + "' "
                    + "WHERE nombre = 'Manejo Avanzado'");
            System.out.println("El nombre y la descripción de la asignatura 'Manejo Avanzado' han sido actualizados correctamente.");

            // Eliminación de datos
            statement.executeUpdate("DELETE FROM ASIGNATURA WHERE nombre = 'Manejo Avanzado II'");
            System.out.println("Datos eliminados correctamente de la tabla ASIGNATURA.");
            

        } catch (SQLException ex) {
            Logger.getLogger(SantiagoRodriguezHernandez_AA2_EV01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}



