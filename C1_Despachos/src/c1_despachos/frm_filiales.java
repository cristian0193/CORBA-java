package c1_despachos;

import Conexion.ConexioSQLite;
import cliente_servidores1.Despachos_Filial;
import cliente_servidores1.Despachos_FilialHelper;
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

public class frm_filiales extends javax.swing.JFrame {

    public static ConexioSQLite conexion;
    public static DefaultTableModel modelo;
    public static Despachos_Filial despacho_filial;

    public frm_filiales() {
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
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_origen = new javax.swing.JTextField();
        combo_ubicacion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_actividad = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_filiales = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FILIALES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("ORIGEN :");

        combo_ubicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "CALI", "BOGOTA", "MEDELLIN", "BARRANQUILLA", "CARTAGENA" }));

        jLabel4.setText("UBICACION :");

        jLabel5.setText("ACTIVIDAD :");

        txt_actividad.setColumns(20);
        txt_actividad.setRows(5);
        jScrollPane2.setViewportView(txt_actividad);

        jLabel6.setText("CODIGO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigo)
                            .addComponent(txt_nombre)
                            .addComponent(txt_origen, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabla_filiales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "ORIGEN", "UBICACION", "FECHA"
            }
        ));
        tabla_filiales.setRowHeight(23);
        jScrollPane1.setViewportView(tabla_filiales);
        if (tabla_filiales.getColumnModel().getColumnCount() > 0) {
            tabla_filiales.getColumnModel().getColumn(0).setMinWidth(30);
            tabla_filiales.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla_filiales.getColumnModel().getColumn(0).setMaxWidth(30);
            tabla_filiales.getColumnModel().getColumn(1).setMinWidth(300);
            tabla_filiales.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla_filiales.getColumnModel().getColumn(1).setMaxWidth(300);
            tabla_filiales.getColumnModel().getColumn(2).setMinWidth(150);
            tabla_filiales.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_filiales.getColumnModel().getColumn(2).setMaxWidth(150);
            tabla_filiales.getColumnModel().getColumn(3).setMinWidth(130);
            tabla_filiales.getColumnModel().getColumn(3).setPreferredWidth(130);
            tabla_filiales.getColumnModel().getColumn(3).setMaxWidth(130);
            tabla_filiales.getColumnModel().getColumn(4).setMinWidth(100);
            tabla_filiales.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla_filiales.getColumnModel().getColumn(4).setMaxWidth(100);
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
                        .addGap(57, 57, 57)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
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
        String nombre = "";
        String origen = "";
        String ubicacion = "";
        String actividad = "";

        codigo = txt_codigo.getText();
        nombre = txt_nombre.getText();
        origen = txt_origen.getText();
        ubicacion = combo_ubicacion.getSelectedItem().toString();
        actividad = txt_actividad.getText();

        if (codigo.equals("") ||nombre.equals("") || origen.equals("") || ubicacion.equals("") || actividad.equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE TODOS LOS CAMPOS");
        } else {
            DespachoImplementacion filial = new DespachoImplementacion();
            int resultado = filial.insertarFiliales(codigo,nombre.toUpperCase(), origen.toUpperCase(), ubicacion.toUpperCase(), actividad.toUpperCase(), "NOW()");

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "FILIAL INSERTADO");
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
//            java.util.logging.Logger.getLogger(frm_filiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frm_filiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frm_filiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frm_filiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frm_filiales().setVisible(true);
//            }
//        });
//    }

        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            despacho_filial = Despachos_FilialHelper.narrow(ncRef.resolve_str("Despachos_Filial"));

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
    private javax.swing.JComboBox<String> combo_ubicacion;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_filiales;
    private javax.swing.JTextArea txt_actividad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_origen;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        txt_codigo.setText("");
        txt_nombre.setText("");
        txt_origen.setText("");
        txt_actividad.setText("");
        combo_ubicacion.setSelectedIndex(0);
    }

    // METODO PARA CARGAR TABLA FILIALES
    public void cargar_tabla() {

//        conexion = new ConexioSQLite();
//        conexion.coneccionbase();
        String[] titulos = {"ID", "CODIGO","NOMBRE", "ORIGEN", "UBICACION", "FECHA_CREACION"};
        String[] registro = new String[6];
        String query = "";

        modelo = new DefaultTableModel(null, titulos);

        ConexioSQLite con = new ConexioSQLite();
        Connection cn = con.ConectarFilialesdb();

        query = "SELECT "
                + "ID, "
                + "CODIGO, "
                + "NOMBRE, "
                + "ORIGEN, "
                + "UBICACION, "
                + "FECHA_CREACION "
                + "FROM "
                + "tbl_filiales;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                registro[0] = rs.getString("ID");
                registro[1] = rs.getString("CODIGO");
                registro[2] = rs.getString("NOMBRE");
                registro[3] = rs.getString("ORIGEN");
                registro[4] = rs.getString("UBICACION");
                registro[5] = rs.getString("FECHA_CREACION");

                modelo.addRow(registro);
            }
            tabla_filiales.setModel(modelo);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void ancho_columnas() {
        tabla_filiales.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla_filiales.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla_filiales.getColumnModel().getColumn(2).setPreferredWidth(240);
        tabla_filiales.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla_filiales.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla_filiales.getColumnModel().getColumn(5).setPreferredWidth(130);
    }

}
