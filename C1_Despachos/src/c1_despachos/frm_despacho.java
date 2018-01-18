package c1_despachos;

import Conexion.ConexioSQLite;
import cliente_servidores1.Despachos_Filial;
import cliente_servidores1.Despachos_FilialHelper;
import cliente_servidores2.Despachos_Productos;
import cliente_servidores2.Despachos_ProductosHelper;
import cliente_servidores3.Despachos_Conductor;
import cliente_servidores3.Despachos_ConductorHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import javax.swing.table.DefaultTableCellRenderer;

public class frm_despacho extends javax.swing.JFrame {

    public static ConexioSQLite conexion;
    public static DefaultTableModel modelo;
    public static DefaultTableCellRenderer Alinear;
    public static Despachos_Filial despacho_filial;
    public static Despachos_Productos despacho_productos;
    public static Despachos_Conductor despacho_conductores;

    public frm_despacho() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargar_tabla();
        ancho_columnas();
        centrar_datos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_filial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_peso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_autorizo = new javax.swing.JTextField();
        txt_nombre_filial = new javax.swing.JTextField();
        txt_id_producto = new javax.swing.JTextField();
        txt_nombre_producto = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_id_conductor = new javax.swing.JTextField();
        txt_nombre_conductor = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_fecha_salida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_fecha_llegada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_hora_salida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_hora_llegada = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_despacho = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DESPACHOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel2.setText("ID FILIAL :");

        txt_id_filial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setText("ID PRODUCTO :");

        jLabel4.setText("DIRECCION :");

        jLabel5.setText("PESO :");

        jLabel6.setText("AUTORIZO :");

        txt_id_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_id_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_productoActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("ID CONDUCTOR :");

        txt_id_conductor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_id_conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_conductorActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 204, 255));
        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fechas y Horas"));

        jLabel8.setText("FEC. SALIDA :");

        txt_fecha_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_salidaActionPerformed(evt);
            }
        });

        jLabel9.setText("FEC. LLEGADA :");

        txt_fecha_llegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_llegadaActionPerformed(evt);
            }
        });

        jLabel10.setText("HOR. SALIDA :");

        txt_hora_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_salidaActionPerformed(evt);
            }
        });

        jLabel11.setText("HOR. LLEGADA :");

        txt_hora_llegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_llegadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_fecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_hora_salida)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txt_hora_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_fecha_salida)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_fecha_llegada)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_hora_salida)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_hora_llegada)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 12, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(59, 59, 59)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_autorizo, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                            .addComponent(txt_peso)))))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id_conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre_conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_id_filial, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nombre_filial, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton3)
                            .addComponent(jButton5)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nombre_filial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_id_filial)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(txt_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre_conductor, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id_conductor)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_autorizo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabla_despacho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID DESPACHO", "DIRECCION", "PESO", "FECHA SALIDA", "HORA SALIDA", "FECHA LLEGADA", "HORA LLEGADA"
            }
        ));
        tabla_despacho.setRowHeight(23);
        jScrollPane1.setViewportView(tabla_despacho);
        if (tabla_despacho.getColumnModel().getColumnCount() > 0) {
            tabla_despacho.getColumnModel().getColumn(0).setMinWidth(90);
            tabla_despacho.getColumnModel().getColumn(0).setPreferredWidth(90);
            tabla_despacho.getColumnModel().getColumn(0).setMaxWidth(90);
            tabla_despacho.getColumnModel().getColumn(1).setMinWidth(510);
            tabla_despacho.getColumnModel().getColumn(1).setPreferredWidth(510);
            tabla_despacho.getColumnModel().getColumn(1).setMaxWidth(510);
            tabla_despacho.getColumnModel().getColumn(2).setMinWidth(100);
            tabla_despacho.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla_despacho.getColumnModel().getColumn(2).setMaxWidth(100);
            tabla_despacho.getColumnModel().getColumn(3).setMinWidth(100);
            tabla_despacho.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla_despacho.getColumnModel().getColumn(3).setMaxWidth(100);
            tabla_despacho.getColumnModel().getColumn(4).setMinWidth(100);
            tabla_despacho.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla_despacho.getColumnModel().getColumn(4).setMaxWidth(100);
            tabla_despacho.getColumnModel().getColumn(5).setMinWidth(100);
            tabla_despacho.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabla_despacho.getColumnModel().getColumn(5).setMaxWidth(100);
            tabla_despacho.getColumnModel().getColumn(6).setMinWidth(100);
            tabla_despacho.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla_despacho.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int id_filial = 0;
        String nombre_filial = "";
        int id_producto = 0;
        String descripcion_producto = "";
        int id_conductor = 0;
        String nombre_conductor = "";
        String direccion = "";
        String peso = "";
        String autorizo = "";
        String f_salida = "";
        String h_salida = "";
        String f_llegada = "";
        String h_llegada = "";
        
        id_filial = Integer.parseInt(txt_id_filial.getText());
        nombre_filial = txt_nombre_filial.getText();
        id_producto = Integer.parseInt(txt_id_producto.getText());
        descripcion_producto = txt_nombre_producto.getText();
        id_conductor = Integer.parseInt(txt_id_producto.getText());
        nombre_conductor = txt_nombre_conductor.getText();
        direccion = txt_direccion.getText();
        peso = txt_peso.getText();
        autorizo = txt_autorizo.getText();
        f_salida = txt_fecha_salida.getText();
        h_salida = txt_hora_salida.getText();
        f_llegada = txt_fecha_llegada.getText();
        h_llegada = txt_hora_llegada.getText();

        DespachoImplementacion implementacion = new DespachoImplementacion();
        int resultado = implementacion.insertarDespachos(id_filial, nombre_filial, id_producto, descripcion_producto, id_conductor, nombre_conductor, direccion.toUpperCase(), f_salida, h_salida, f_llegada, h_llegada,peso, autorizo.toUpperCase(), "NOW()");

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "DESPACHO INSERTADO");
            LimpiarCampos();
            cargar_tabla();
            centrar_datos();
            ancho_columnas();
            conexion.cerrar();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTADAR");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_hora_llegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_llegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_llegadaActionPerformed

    private void txt_hora_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_salidaActionPerformed

    private void txt_fecha_llegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_llegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_llegadaActionPerformed

    private void txt_fecha_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_salidaActionPerformed

    private void txt_id_conductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_conductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_conductorActionPerformed

    private void txt_id_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_productoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String id_filial = txt_id_filial.getText();

        if (id_filial.equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO FILIAL");
        } else {            
            
            if (despacho_filial.consultaFiliales_id(id_filial).equals("")) {

                int ax = JOptionPane.showConfirmDialog(null, "EL CODIGO DE LA FILIAL NO EXISTE \n ¿DESEA CREA UNA NUEVA FILIAL?");

                if (ax == JOptionPane.YES_OPTION) {

                    frm_filiales filial = new frm_filiales();
                    filial.setVisible(true);

                } else if (ax == JOptionPane.NO_OPTION) {
                    txt_id_filial.setText("");
                    txt_nombre_filial.setText("");
                }
            } else {
                String nombre = despacho_filial.consultaFiliales_id(id_filial);
                txt_nombre_filial.setText(nombre);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String id_producto = txt_id_producto.getText();

        if (id_producto.equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO DE PRODUCTO");
        } else {

            if (despacho_productos.consultaProductos_id(id_producto).equals("")) {

                int ax = JOptionPane.showConfirmDialog(null, "EL CODIGO DEL PRODUCTO NO EXISTE \n ¿DESEA CREA UNA NUEVO PRODUCTO?");

                if (ax == JOptionPane.YES_OPTION) {
                    frm_productos producto = new frm_productos();
                    producto.setVisible(true);

                } else if (ax == JOptionPane.NO_OPTION) {
                    txt_id_producto.setText("");
                    txt_nombre_producto.setText("");

                }

            } else {
                String nombre_2 = despacho_productos.consultaProductos_id(id_producto);
                txt_nombre_producto.setText(nombre_2);
            }

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id_conductor = txt_id_conductor.getText();
        if (id_conductor.equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO DE CONDUCTOR");
        } else {

            if (despacho_conductores.consultaConductor_id(id_conductor).equals("")) {

                int ax = JOptionPane.showConfirmDialog(null, "EL CODIGO DEL CONDUCTOR NO EXISTE \n ¿DESEA CREA UNA NUEVO CONDUCTOR?");

                if (ax == JOptionPane.YES_OPTION) {
                    frm_conductores conductor = new frm_conductores();
                    conductor.setVisible(true);

                } else if (ax == JOptionPane.NO_OPTION) {
                    txt_id_conductor.setText("");
                    txt_nombre_conductor.setText("");
                }

            } else {
                String nombre = despacho_conductores.consultaConductor_id(id_conductor);
                txt_nombre_conductor.setText(nombre);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {

        try {

            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            despacho_filial = Despachos_FilialHelper.narrow(ncRef.resolve_str("Despachos_Filial"));
            despacho_productos = Despachos_ProductosHelper.narrow(ncRef.resolve_str("Despachos_Productos"));
            despacho_conductores = Despachos_ConductorHelper.narrow(ncRef.resolve_str("Despachos_Conductor"));
            
            System.out.println("interfaces ok");
            
        } catch (InvalidName e) {
            System.out.println("Error Name: " + e);
        } catch (NotFound e) {
            System.out.println("Error Found 1: " + e);
        } catch (CannotProceed e) {
            System.out.println("Error Proceed: " + e);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.out.println("Error: " + e);
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
            System.out.println("ClassNotFoundException");
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             System.out.println("InstantiationException");
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("IllegalAccessException");
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_despacho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("UnsupportedLookAndFeelException");
        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frm_despacho().setVisible(true);
//            }
//        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_despacho;
    private javax.swing.JTextField txt_autorizo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_fecha_llegada;
    private javax.swing.JTextField txt_fecha_salida;
    private javax.swing.JTextField txt_hora_llegada;
    private javax.swing.JTextField txt_hora_salida;
    private javax.swing.JTextField txt_id_conductor;
    private javax.swing.JTextField txt_id_filial;
    private javax.swing.JTextField txt_id_producto;
    private javax.swing.JTextField txt_nombre_conductor;
    private javax.swing.JTextField txt_nombre_filial;
    private javax.swing.JTextField txt_nombre_producto;
    private javax.swing.JTextField txt_peso;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        txt_id_filial.setText("");
        txt_nombre_filial.setText("");;
        txt_id_producto.setText("");
        txt_nombre_producto.setText("");
        txt_id_conductor.setText("");
        txt_nombre_conductor.setText("");
        txt_direccion.setText("");
        txt_peso.setText("");
        txt_autorizo.setText("");
        txt_fecha_salida.setText("");
        txt_hora_salida.setText("");
        txt_fecha_llegada.setText("");
        txt_hora_llegada.setText("");
    }

    public void cargar_tabla() {

        String[] titulos = {"ID", "DIRECCION", "PESO", "FECHA SALIDA", "HORA SALIDA", "FECHA LLEGADA", "HORA LLEGADA",};
        String[] registro = new String[7];
        String query = "";

        modelo = new DefaultTableModel(null, titulos);

        ConexioSQLite con = new ConexioSQLite();
        Connection cn = con.ConectarDespachodb();

        query = "SELECT "
                + "id_despacho, "
                + "direccion_despacho, "
                + "peso_mercancia, "
                + "fecha_salida, "
                + "hora_salida, "
                + "fecha_llegada, "
                + "hora_llegada "
                + "FROM "
                + "tbl_despacho;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                registro[0] = rs.getString("id_despacho");
                registro[1] = rs.getString("direccion_despacho");
                registro[2] = rs.getString("peso_mercancia");
                registro[3] = rs.getString("fecha_salida");
                registro[4] = rs.getString("hora_salida");
                registro[5] = rs.getString("fecha_llegada");
                registro[6] = rs.getString("hora_llegada");

                modelo.addRow(registro);
            }
            tabla_despacho.setModel(modelo);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void ancho_columnas() {
        tabla_despacho.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabla_despacho.getColumnModel().getColumn(1).setPreferredWidth(460);
        tabla_despacho.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla_despacho.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla_despacho.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla_despacho.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla_despacho.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    
      public void centrar_datos() {
        Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla_despacho.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tabla_despacho.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tabla_despacho.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tabla_despacho.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tabla_despacho.getColumnModel().getColumn(6).setCellRenderer(Alinear);
    }

}
