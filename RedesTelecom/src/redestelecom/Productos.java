package redestelecom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivantrejo
 */
public class Productos extends javax.swing.JFrame {
    private Connection BaseDeDatos;

    public Productos(Connection conexionActiva) {
        initComponents();
        BaseDeDatos = conexionActiva;
        this.setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Redes de telecomunicaciones :: Productos");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTfibra = new javax.swing.JTable();
        btnFibra = new javax.swing.JButton();
        btnConectores = new javax.swing.JButton();
        TxOptic = new javax.swing.JButton();
        JAmp = new javax.swing.JButton();
        Emp = new javax.swing.JButton();
        ATN = new javax.swing.JButton();
        Rx = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(51, 255, 0));

        jTfibra.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTfibra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fabricante", "Tipo", "Longitud de Onda ", "Atenuación", "AN", "Ancho de Banda", "Longitud de Carrete", "Costo", "Aplicación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTfibra);

        btnFibra.setText("Fibras");
        btnFibra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFibraActionPerformed(evt);
            }
        });

        btnConectores.setText("Conectores");
        btnConectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectoresActionPerformed(evt);
            }
        });

        TxOptic.setText("Transmisores");
        TxOptic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxOpticActionPerformed(evt);
            }
        });

        JAmp.setText("Amplificadores");
        JAmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAmpActionPerformed(evt);
            }
        });

        Emp.setText("Empalmes");
        Emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpActionPerformed(evt);
            }
        });

        ATN.setText("Atenuadores");
        ATN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATNActionPerformed(evt);
            }
        });

        Rx.setText("Receptores");
        Rx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnFibra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConectores, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxOptic, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JAmp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Emp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ATN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rx, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnFibra, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(btnConectores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxOptic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JAmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ATN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Rx, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFibraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFibraActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT fabricante, tipo, WL, atenuacion, BW, LC, Costo, exterior, interior FROM producto");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Fabricante");
            modelo.addColumn("Tipo");
            modelo.addColumn("Longitud de Onda");
            modelo.addColumn("Atenuación");
            modelo.addColumn("Ancho de Banda");
            modelo.addColumn("Longitud de Carrete");
            modelo.addColumn("Costo $");
            modelo.addColumn("Exterior");
            modelo.addColumn("Interior");

            while(rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);
                }
            modelo.addRow(filas);
            }
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_btnFibraActionPerformed

    private void btnConectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectoresActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT conector, precio, descripcion, tipo, PInsercion FROM conectores");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Conectore");
            modelo.addColumn("Costo $");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Tipo");
            modelo.addColumn("Perdidas de Inserción");

            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_btnConectoresActionPerformed

    private void TxOpticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxOpticActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT Nombre, WL, Potencia, costo FROM txOptic");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Longitud de Onda");
            modelo.addColumn("Potencia");
            modelo.addColumn("Costo $");

            while(rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_TxOpticActionPerformed

    private void JAmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAmpActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT Nombre, PinMin, PinMax, PoutMin, PoutMax, Ganancia, costo  FROM amplificadores");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Potencia de Entrada Minima(dBm)");
            modelo.addColumn("Potencia de Entrada Maxima(dBm)");
            modelo.addColumn("Potencia de Salida Minima(dBm)");
            modelo.addColumn("Potencia de Salida Maxima(dBm)");
            modelo.addColumn("Ganacia(dBm)");
            modelo.addColumn("Costo $");

            while(rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_JAmpActionPerformed

    private void EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT nombre, precio, perdidas  FROM empalmes");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Costo $");
            modelo.addColumn("Perdidas dB");

            while(rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);

                }
                modelo.addRow(filas);
            }
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_EmpActionPerformed

    private void ATNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATNActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT nombre, precio, atenuacion  FROM atenuadores");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Costo $");
            modelo.addColumn("Atenuación dB");

            while(rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
        
    }//GEN-LAST:event_ATNActionPerformed

    private void RxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RxActionPerformed
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jTfibra.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            //Conexion conn = new Conexion();
            //Connection con = conn.getConexion();

            String sql = ("SELECT nombre, precio, PinMin, PinMax, WL  FROM Rx ");
            ps = BaseDeDatos.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int  cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Costo $");
            modelo.addColumn("Potencia de entrada minima dBm");
            modelo.addColumn("Potencia de entrada maxima dBm");
            modelo.addColumn("Longitud de Onda nm");


            while(rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0;i < cantidadColumnas; i++ ) {
                    filas[i] = rs.getObject(i+1);
                }
            modelo.addRow(filas);
            } 
        } catch(SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_RxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConexionSQL BaseSQL = new ConexionSQL();
                Connection BD = BaseSQL.getConexionSQL();
                new Productos(BD).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATN;
    private javax.swing.JButton Emp;
    private javax.swing.JButton JAmp;
    private javax.swing.JButton Rx;
    private javax.swing.JButton TxOptic;
    private javax.swing.JButton btnConectores;
    private javax.swing.JButton btnFibra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTfibra;
    // End of variables declaration//GEN-END:variables
}
