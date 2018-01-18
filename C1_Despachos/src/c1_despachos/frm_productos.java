package c1_despachos;

import Conexion.ConexioSQLite;
import cliente_servidores2.Despachos_Productos;
import cliente_servidores2.Despachos_ProductosHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class frm_productos extends javax.swing.JFrame {

    public static ConexioSQLite conexion;
    public static DefaultTableModel modelo;
    public static Despachos_Productos despacho_productos;

    public frm_productos() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargar_tabla();
        ancho_columnas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fabricacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_vencimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel2.setText("DESCRIPCION:");

        jLabel3.setText("STOCK :");

        jLabel4.setText("F.FABRICACION:");

        jLabel6.setText("F.VENCIMIENTO:");

        jLabel5.setText("CODIGO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigo)
                            .addComponent(txt_descripcion)
                            .addComponent(txt_stock, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_fabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_fabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION", "STOCK", "F.FABRICACION", "F.VENCIMIENTO"
            }
        ));
        tabla_productos.setRowHeight(23);
        jScrollPane1.setViewportView(tabla_productos);
        if (tabla_productos.getColumnModel().getColumnCount() > 0) {
            tabla_productos.getColumnModel().getColumn(0).setMinWidth(30);
            tabla_productos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla_productos.getColumnModel().getColumn(0).setMaxWidth(30);
            tabla_productos.getColumnModel().getColumn(1).setMinWidth(320);
            tabla_productos.getColumnModel().getColumn(1).setPreferredWidth(320);
            tabla_productos.getColumnModel().getColumn(1).setMaxWidth(320);
            tabla_productos.getColumnModel().getColumn(2).setMinWidth(100);
            tabla_productos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla_productos.getColumnModel().getColumn(2).setMaxWidth(100);
            tabla_productos.getColumnModel().getColumn(3).setMinWidth(130);
            tabla_productos.getColumnModel().getColumn(3).setPreferredWidth(130);
            tabla_productos.getColumnModel().getColumn(3).setMaxWidth(130);
            tabla_productos.getColumnModel().getColumn(4).setMinWidth(130);
            tabla_productos.getColumnModel().getColumn(4).setPreferredWidth(130);
            tabla_productos.getColumnModel().getColumn(4).setMaxWidth(130);
        }

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String codigo = "";
        String descripcion = "";
        int stock1 = 0;
        String stock2 = "";
        String fabricacion = "";
        String vencimiento = "";

        codigo = txt_codigo.getText();
        descripcion = txt_descripcion.getText();
        stock2 = txt_stock.getText();
        fabricacion = txt_fabricacion.getText();
        vencimiento = txt_vencimiento.getText();

        if (codigo.equals("") ||descripcion.equals("") || stock2.equals("") || fabricacion.equals("") || vencimiento.equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE TODOS LOS CAMPOS");
        } else {
            stock1 = Integer.parseInt(txt_stock.getText());
            DespachoImplementacion producto = new DespachoImplementacion();

            int resultado = producto.insertarProductos(codigo, descripcion.toUpperCase(), stock1, fabricacion.toUpperCase(), vencimiento.toUpperCase(), "NOW()");

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "PRODUCTO INSERTADO");
                LimpiarCampos();
                cargar_tabla();
                ancho_columnas();
                conexion.cerrar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTADAR");
                LimpiarCampos();
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frm_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frm_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frm_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frm_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frm_productos().setVisible(true);
//            }
//        });

        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            despacho_productos = Despachos_ProductosHelper.narrow(ncRef.resolve_str("Despachos_Productos"));

        } catch (InvalidName e) {
            System.out.println("Error InvalidName: " + e);
        } catch (NotFound e) {
            System.out.println("Error NotFound: " + e);
        } catch (CannotProceed e) {
            System.out.println("Error CannotProceed: " + e);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.out.println("Error org.omg : " + e);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_fabricacion;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_vencimiento;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_stock.setText("");
        txt_fabricacion.setText("");
        txt_vencimiento.setText("");
    }

    // METODO PARA CARGAR TABLA FILIALES
    public void cargar_tabla() {

//        conexion = new ConexioSQLite();
//        conexion.coneccionbase();
        String[] titulos = {"ID","CODIGO", "DESCRIPCION", "STOCK", "F.FABRICACION", "F.VENCIMIENTO", "FECHA_CREACION"};
        String[] registro = new String[7];
        String query = "";

        modelo = new DefaultTableModel(null, titulos);

        ConexioSQLite con = new ConexioSQLite();
        Connection cn = con.ConectarProductosdb();

        query = "SELECT "
                + "ID, "
                + "CODIGO, "
                + "DESCRIPCION, "
                + "CANTIDAD_STOCK, "
                + "FECHA_FABRICACION, "
                + "FECHA_VENCIMIENTO, "
                + "FECHA_CREACION "
                + "FROM "
                + "tbl_productos;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                registro[0] = rs.getString("ID");
                registro[1] = rs.getString("CODIGO");
                registro[2] = rs.getString("DESCRIPCION");
                registro[3] = rs.getString("CANTIDAD_STOCK");
                registro[4] = rs.getString("FECHA_FABRICACION");
                registro[5] = rs.getString("FECHA_VENCIMIENTO");
                registro[6] = rs.getString("FECHA_CREACION");

                modelo.addRow(registro);
            }
            tabla_productos.setModel(modelo);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void ancho_columnas() {
        tabla_productos.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla_productos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla_productos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla_productos.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla_productos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla_productos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla_productos.getColumnModel().getColumn(5).setPreferredWidth(130);
    }

}
