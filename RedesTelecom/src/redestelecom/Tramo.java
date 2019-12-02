package redestelecom;

import Models.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Tramo extends javax.swing.JFrame {
    private final BaseDatos BD;
    
    private Amplificador amplificador;
    private Atenuador atenuador;
    private Conector conector;
    private Empalme empalme;
    private FibraExterna fibraExterna;
    private FibraInterna fibraInterna;
    private Receptor receptor;
    private TransmisorOptico transmisorOptico;
    
    public Tramo(Connection conexionActiva) throws SQLException {
        initComponents();
        this.BD = new BaseDatos(conexionActiva);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setTitle(".:: Generar tramo ::.");
        this.bloquearCampos();
    }
    
    private void startProcess(String seleccion) {
        if (seleccion != "Longitud de onda") {
            System.out.println(seleccion);
            this.desbloquearCampos();
            int longOnda = Integer.parseInt(seleccion);
            try {
                this.loadData(longOnda);
                this.processData();
                this.putData();
            } catch (SQLException ex) {
                Logger.getLogger(Tramo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Elige un valor válido");
            this.bloquearCampos();
        }
    }
    
    private void loadData(int WL) throws SQLException {
        this.loadAmplificador();
        this.loadAtenuador();
        this.loadConector();
        this.loadEmpalme();
        this.loadFibraExterna(WL);
        this.loadFibraInterna(WL);
        this.loadReceptor(WL);
        this.loadTransmisorOptico(WL);
    }
    
    private void processData() {
      
       
        float Dtotal =0;
        float A = this.transmisorOptico.Potencia;
        float B = this.amplificador.PoutMax;
        float C = this.conector.PInsercion;
        float dExt = this.fibraExterna.lc;
        float dInt = this.fibraInterna.lc;
        float eExt = this.fibraExterna.atenuacion;
        float eInt = this.fibraInterna.atenuacion;
        float F = this.amplificador.PinMin;
        float G = this.amplificador.PinMax;
        float H = this.receptor.PinMin;
        float I = this.receptor.PinMax;
        float J = this.atenuador.atenuacion;
        float x = (dExt*eExt);
        float y = (((3/2)*dExt)*eExt);
        float []Respuesta = new float[1000];
        Respuesta[0]= A + B - C;
        
        for (int i=1; i<= Dtotal; i++){
           
       Respuesta[i] = Respuesta[i-1] - C - x;
        while (Dtotal<200000){  
         if (Respuesta[i]>= F && Respuesta[i]<=G){
             Respuesta[i+1]=Respuesta[i]-C+B;
             Respuesta[i+2]=Respuesta[i+1]-C-x;
              System.out.println(Respuesta[i]);
              Dtotal+=dExt; 
         }
         else  {
               Respuesta[i+1]=Respuesta[i]-C-y;
               Respuesta[i+2]=Respuesta[i+1]-C+B;
               System.out.println(Respuesta[i]);
               Dtotal+=3/2*dExt; 
         }
          
       System.out.println(Dtotal);
        }
        }  
    }
    
   /* private void SumaSI(){
        float A = this.transmisorOptico.Potencia;
        float B = this.amplificador.PoutMax;
        float C = this.conector.PInsercion;
           float dExt = this.fibraExterna.lc;
           float eExt = this.fibraExterna.atenuacion;
      float x = (dExt*eExt);
        float R1 = A + B - C;
        float R2 = R1 - C - x;
    }*/
    
    /*private void SumaNo(){
     float A = this.transmisorOptico.Potencia;
        float B = this.amplificador.PoutMax;
        float C = this.conector.PInsercion;
           float dExt = this.fibraExterna.lc;
           float eExt = this.fibraExterna.atenuacion;
      float x = ((2/3*dExt)*eExt);
        float R1 = A + B - C;
        float R2 = R1 - C - x;
    }*/
    
    private void putData() {
        this.putAmplificador();
        this.putAtenuador();
        this.putConector();
        this.putEmpalme();
        this.putFOExterna();
        this.putFOInterna();
        this.putReceptor();
        this.putTXOptico();
    }
    
    private void loadAmplificador() throws SQLException {
        this.amplificador = this.BD.getAmplificador();
    }
    
    private void loadAtenuador() throws SQLException {
        this.atenuador = this.BD.getAtenuador();
    }
    
    private void loadConector() throws SQLException {
        this.conector = this.BD.getConector();
    }
    
    private void loadEmpalme() throws SQLException {
        this.empalme = this.BD.getEmpalme();
    }
    
    private void loadFibraExterna(int WL) throws SQLException {
        this.fibraExterna = this.BD.getFibraExterna(WL);
    }
    
    private void loadFibraInterna(int WL) throws SQLException {
        this.fibraInterna = this.BD.getFibraInterna(WL);
    }
    
    private void loadReceptor(int WL) throws SQLException {
        this.receptor = this.BD.getReceptor(WL);
    }
    
    private void loadTransmisorOptico(int WL) throws SQLException {
        this.transmisorOptico = this.BD.getTransmisorOptico(WL);
    }
    
    private void putAmplificador() {
        jTextFieldAmplificador.setText(this.amplificador.mensaje);
    }
    
    private void putAtenuador() {
        jTextFieldAtenuador.setText(this.atenuador.mensaje);
    }
    
    private void putConector() {
        jTextFieldConector.setText(this.conector.mensaje);
    }
    
    private void putEmpalme() {
        jTextFieldEmpalme.setText(this.empalme.mensaje);
    }
    
    private void putFOExterna() {
        jTextFieldFOExterna.setText(this.fibraExterna.mensaje);
    }
    
    private void putFOInterna() {
        jTextFieldFOInterna.setText(this.fibraInterna.mensaje);
    }
    
    private void putReceptor() {
        jTextFieldReceptor.setText(this.receptor.mensaje);
    }
    
    private void putTXOptico() {
        jTextFieldTxOptico.setText(this.transmisorOptico.mensaje);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxOrigen = new javax.swing.JComboBox<>();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxWL = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldFOExterna = new javax.swing.JTextField();
        jTextFieldFOInterna = new javax.swing.JTextField();
        jTextFieldTxOptico = new javax.swing.JTextField();
        jTextFieldConector = new javax.swing.JTextField();
        jTextFieldEmpalme = new javax.swing.JTextField();
        jTextFieldReceptor = new javax.swing.JTextField();
        jTextFieldAmplificador = new javax.swing.JTextField();
        jTextFieldAtenuador = new javax.swing.JTextField();
        jTextFieldConectorPzas = new javax.swing.JTextField();
        jTextFieldEmpalmePzas = new javax.swing.JTextField();
        jTextFieldReceptorPzas = new javax.swing.JTextField();
        jTextFieldAmplificadorPzas = new javax.swing.JTextField();
        jTextFieldAtenuadorPzas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Generar tramo");

        jComboBoxOrigen.setEditable(true);
        jComboBoxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "La Paz, Baja California Sur" }));
        jComboBoxOrigen.setEnabled(false);

        jComboBoxDestino.setEditable(true);
        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cd. Constitución, Baja California Sur" }));
        jComboBoxDestino.setEnabled(false);

        jComboBoxWL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Longitud de onda", "1310", "1550" }));
        jComboBoxWL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWLActionPerformed(evt);
            }
        });

        jButtonOK.setText("Cotizar");

        jLabel2.setText("Longitud de onda");

        jLabel3.setText("Fibra óptica externa");

        jLabel4.setText("Fibra óptica interna");

        jLabel5.setText("Transmisor óptico");

        jLabel6.setText("Conector");

        jLabel7.setText("Empalme");

        jLabel8.setText("Amplificador");

        jLabel9.setText("Atenuador");

        jLabel10.setText("Receptor");

        jTextFieldFOExterna.setText("Fibra óptica externa");

        jTextFieldFOInterna.setText("Fibra óptica interna");

        jTextFieldTxOptico.setText("Transmisor óptico");

        jTextFieldConector.setText("Conector");

        jTextFieldEmpalme.setText("Empalme");

        jTextFieldReceptor.setText("Receptor");

        jTextFieldAmplificador.setText("Amplificador");

        jTextFieldAtenuador.setText("Atenuador");

        jTextFieldConectorPzas.setText("Piezas");

        jTextFieldEmpalmePzas.setText("Piezas");

        jTextFieldReceptorPzas.setText("Piezas");

        jTextFieldAmplificadorPzas.setText("Piezas");

        jTextFieldAtenuadorPzas.setText("Piezas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldConector, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldEmpalme, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jTextFieldReceptor))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldReceptorPzas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jButtonOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldAmplificador, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jTextFieldAtenuador))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldAmplificadorPzas)
                                            .addComponent(jTextFieldAtenuadorPzas, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldTxOptico)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxWL, 0, 260, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldFOExterna)
                                    .addComponent(jTextFieldFOInterna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEmpalmePzas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldConectorPzas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFOExterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxWL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTxOptico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFOInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldConector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAmplificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldConectorPzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAmplificadorPzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmpalme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAtenuador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmpalmePzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAtenuadorPzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReceptorPzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxWLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWLActionPerformed
        // TODO add your handling code here:
        this.startProcess(jComboBoxWL.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxWLActionPerformed
    
    private void bloquearCampos() {
        jTextFieldAmplificador.setEditable(false);
        jTextFieldAmplificador.setEnabled(false);
        jTextFieldAmplificadorPzas.setEditable(false);
        jTextFieldAmplificadorPzas.setEnabled(false);
        
        jTextFieldAtenuador.setEditable(false);
        jTextFieldAtenuador.setEnabled(false);
        jTextFieldAtenuadorPzas.setEditable(false);
        jTextFieldAtenuadorPzas.setEnabled(false);
        
        jTextFieldConector.setEditable(false);
        jTextFieldConector.setEnabled(false);
        jTextFieldConectorPzas.setEditable(false);
        jTextFieldConectorPzas.setEnabled(false);
        
        jTextFieldEmpalme.setEditable(false);
        jTextFieldEmpalme.setEnabled(false);
        jTextFieldEmpalmePzas.setEditable(false);
        jTextFieldEmpalmePzas.setEnabled(false);
        
        jTextFieldFOExterna.setEditable(false);
        jTextFieldFOExterna.setEnabled(false);
        
        jTextFieldFOInterna.setEditable(false);
        jTextFieldFOInterna.setEnabled(false);
        
        jTextFieldReceptor.setEditable(false);
        jTextFieldReceptor.setEnabled(false);
        jTextFieldReceptorPzas.setEditable(false);
        jTextFieldReceptorPzas.setEnabled(false);
        
        jTextFieldTxOptico.setEditable(false);
        jTextFieldTxOptico.setEnabled(false);
        
        jButtonOK.setEnabled(false);
    }
    
    private void desbloquearCampos() {
        jTextFieldAmplificador.setEnabled(true);
        jTextFieldAmplificadorPzas.setEnabled(true);
        
        jTextFieldAtenuador.setEnabled(true);
        jTextFieldAtenuadorPzas.setEnabled(true);
        
        jTextFieldConector.setEnabled(true);
        jTextFieldConectorPzas.setEnabled(true);
        
        jTextFieldEmpalme.setEnabled(true);
        jTextFieldEmpalmePzas.setEnabled(true);
        
        jTextFieldFOExterna.setEnabled(true);
        
        jTextFieldFOInterna.setEnabled(true);
        
        jTextFieldReceptor.setEnabled(true);
        jTextFieldReceptorPzas.setEnabled(true);
        
        jTextFieldTxOptico.setEnabled(true);
        
        jButtonOK.setEnabled(true);
    }
    
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
            java.util.logging.Logger.getLogger(Tramo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tramo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tramo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tramo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConexionSQL BaseSQL = new ConexionSQL();
                Connection BD = BaseSQL.getConexionSQL();
                try {
                    new Tramo(BD).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tramo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JComboBox<String> jComboBoxOrigen;
    private javax.swing.JComboBox<String> jComboBoxWL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldAmplificador;
    private javax.swing.JTextField jTextFieldAmplificadorPzas;
    private javax.swing.JTextField jTextFieldAtenuador;
    private javax.swing.JTextField jTextFieldAtenuadorPzas;
    private javax.swing.JTextField jTextFieldConector;
    private javax.swing.JTextField jTextFieldConectorPzas;
    private javax.swing.JTextField jTextFieldEmpalme;
    private javax.swing.JTextField jTextFieldEmpalmePzas;
    private javax.swing.JTextField jTextFieldFOExterna;
    private javax.swing.JTextField jTextFieldFOInterna;
    private javax.swing.JTextField jTextFieldReceptor;
    private javax.swing.JTextField jTextFieldReceptorPzas;
    private javax.swing.JTextField jTextFieldTxOptico;
    // End of variables declaration//GEN-END:variables
}
