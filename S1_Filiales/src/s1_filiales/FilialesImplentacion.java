package s1_filiales;

import cliente_servidores1.Despachos_FilialPOA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class FilialesImplentacion extends Despachos_FilialPOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    @Override
    public int insertarFiliales(String codigo, String nombre, String origen, String ubicacion, String actividad, String fecha_creacion) {

        String query = "";
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_filiales_s1", "root", "");
            query = "INSERT INTO tbl_filiales VALUES (NULL,'" + codigo + "','" + nombre + "','" + origen + "','" + ubicacion + "','" + actividad + "',NOW())";
            System.out.println(query);
            Statement st = cn.createStatement();
            int valor = st.executeUpdate(query);

            if (valor > 0) {
                resultado = valor;
            } else {
                resultado = 0;
            }

            st.close();
            cn.close();
            System.out.println("VENGO DEL SERVIDOR S1_FILIALES");
        } catch (Exception ex) {
            Logger.getLogger(FilialesImplentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public String consultaFiliales_id(String id_filial) {
        String query = "";
        int resultado = 0;
        String nombre = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_filiales_s1", "root", "");
            query = "SELECT nombre FROM tbl_filiales WHERE codigo = '" + id_filial + "'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                nombre = rs.getString("nombre");
            }

            rs.close();
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(FilialesImplentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

    @Override
    public int validarUsuarioServidor1(String usuario, String contrasena) {
        String query = "";
        int resultado = 0, valor = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_filiales_s1", "root", "");
            query = "SELECT count(id) as resultado FROM tbl_usuario_server1 where usuario = '" + usuario + "' and contrasena = '" + contrasena + "';";
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
            Logger.getLogger(FilialesImplentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
