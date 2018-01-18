package s3_conductores;

import cliente_servidores3.Despachos_ConductorPOA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConductoresImplementacion extends Despachos_ConductorPOA{

    @Override
    public int insertarConductores(String codigo,String nombre_completo, int edad, String direccion, String telefono, String experiencia, String fecha_creacion) {
        String query = "";
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_conductores_s3", "root", "");
            query = "INSERT INTO tbl_conductores VALUES (NULL,'" + codigo + "','" + nombre_completo + "','" + edad + "','" + direccion + "','" + telefono + "','" + experiencia + "',NOW())";
            Statement st = cn.createStatement();
            int valor = st.executeUpdate(query);

            if (valor > 0) {
                resultado = valor;
            } else {
                resultado = 0;
            }

            st.close();
            cn.close();
            System.out.println("VENGO DEL SERVIDOR S3_CONDUCTORES");   
        } catch (Exception ex) {
            Logger.getLogger(ConductoresImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public String consultaConductor_id(String id_conductor) {
        String query = "";
        int resultado = 0;
        String nombre = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_conductores_s3", "root", "");
            query = "SELECT nombre_completo FROM tbl_conductores WHERE codigo = '" + id_conductor + "'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                nombre = rs.getString("nombre_completo");
            }

            rs.close();
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(ConductoresImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

    @Override
    public int validarUsuarioServidor3(String usuario, String contrasena) {
        String query = "";
        int resultado = 0,valor = 0;
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_conductores_s3", "root", "");
            query = "SELECT count(id) as resultado FROM tbl_usuario_server3 where usuario = '" + usuario + "' and contrasena = '" + contrasena + "';";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                valor = Integer.parseInt(rs.getString("resultado"));
            }

            if (valor > 0) {
                resultado = valor;
            } else {
                resultado = 0;
            }

            st.close();
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(ConductoresImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
