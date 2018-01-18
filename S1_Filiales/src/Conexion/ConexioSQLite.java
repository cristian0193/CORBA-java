package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexioSQLite {

    public static Connection conectar = null;
    public static Statement sentencia;
    public static ResultSet resultado;
    public static String query = "";

//METODO CONECTAR TABLAS
    public Connection ConectarFilialesdb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_filiales_s1", "root", "");
            System.out.println("CONECTO BIEN TABLA ........");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conectar;
    }
    
    
//METODOS DE DESCONEXION
    public static void cerrar() {
        try {
            conectar.close();
            System.out.println("CONEXION CERRADA ...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("NO SE CERRO CONEXION ...");
        }
    }

}
