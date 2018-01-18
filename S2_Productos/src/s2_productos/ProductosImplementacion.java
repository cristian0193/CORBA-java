package s2_productos;

import cliente_servidores2.Despachos_ProductosPOA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductosImplementacion extends Despachos_ProductosPOA {

    @Override
    public int insertarProductos(String codigo, String descripcion, int cantidad_stock, String fecha_fabricacion, String fecha_vencimiento, String fecha_creacion) {
        String query = "";
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_productos_s2", "root", "");
            query = "INSERT INTO tbl_productos VALUES (NULL,'" + codigo + "','" + descripcion + "'," + cantidad_stock + ",'" + fecha_fabricacion + "','" + fecha_vencimiento + "',NOW())";
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
            System.out.println("VENGO DEL SERVIDOR S2_PRODUCTOS");
        } catch (Exception ex) {
            Logger.getLogger(ProductosImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public String consultaProductos_id(String id_producto) {
        String query = "";
        int resultado = 0;
        String descripcion = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_productos_s2", "root", "");
            query = "SELECT descripcion FROM tbl_productos WHERE codigo = '" + id_producto + "'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                descripcion = rs.getString("descripcion");
            }

            rs.close();
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(ProductosImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripcion;
    }

    @Override
    public int validarUsuarioServidor2(String usuario, String contrasena) {
        String query = "";
        int resultado = 0, valor = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_productos_s2", "root", "");
            query = "SELECT count(id) as resultado FROM tbl_usuario_server2 where usuario = '" + usuario + "' and contrasena = '" + contrasena + "';";
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
            Logger.getLogger(ProductosImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
