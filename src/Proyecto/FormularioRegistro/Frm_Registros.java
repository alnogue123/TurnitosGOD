/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto.FormularioRegistro;

import Reportes.Frm_Reportes;
import InicioSesion.Frm_InicioSesion;
import Proyecto.Frm_Turnos;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mjiad
 */
public class Frm_Registros extends javax.swing.JFrame {

    private final String[] Encabezado = {"Tipo  de Identificacion", "Numero de identificacion", "Turno"};
    private final String[] TiposIdentificaion = {"Cedula de Ciudadania", "Tarjeta de Identidad", "Registro Civil", "Pasaporte"};
    private final String[] Motivos = {"Retiros", "Prestamos", "Consignaciones"};
    private String TipoDocumento;
    private double numeroDocumento;
    private Frm_Turnos Turnitos = null;
    private static Frm_Registros instance;

    private ArrayList<Cliente> ListaDocumentos;
    private final ArrayList<MotivoVisita> Listamotivos;
    public String turno, modulo;
    private int contadorR = 0;
    private int contadorP = 0;
    private int contadorC = 0;
    private int fila = 0;
    private int fila2 = 0;

    public Frm_Registros() {
        initComponents();
        ListaDocumentos = new ArrayList<>();
        Listamotivos = new ArrayList<>();
        Turnitos = Turnitos.getInstance();
        setLocationRelativeTo(null);
        CrearTabla();
        Turnitos.PersonalizarTabla(TablModificable);
        CrearComboBox();
    }

    public static Frm_Registros getInstance() {
        if (instance == null) {
            instance = new Frm_Registros();
        }
        return instance;
    }

    public void Sesion(String sesion) {
        this.setTitle("Registro del empleado " + "(" + "Sesion de " + sesion + ")");
        MenuItem_Reportes.setEnabled(true);
        if (sesion.equals("Empleado")) {
            MenuItem_Reportes.setEnabled(false);
        }
    }

    public ArrayList<Cliente> getListaDocumentos() {
        return this.ListaDocumentos;
    }

    private void CrearTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        DecimalFormat df = new DecimalFormat("#");
        modelo.setColumnIdentifiers(Encabezado);
        for (int i = 0; i < ListaDocumentos.size(); i++) {
            modelo.addRow(new Object[]{
                ListaDocumentos.get(i).getTipoIdendificacion(),
                df.format(ListaDocumentos.get(i).getNumeroIdentificacion()).replace(".0", ""),
                ListaDocumentos.get(i).getTurno()
            });
        }
        TablModificable.setModel(modelo);
    }

    public final void CrearComboBox() {
        CB_TipoIdentificacion.removeAllItems();
        CB_motivo.removeAllItems();
        CB_motivo.addItem("Seleccione");
        CB_TipoIdentificacion.addItem("Seleccione");
        for (String Motivo : Motivos) {
            CB_motivo.addItem(Motivo);
        }
        for (String TiposIdentificaion1 : TiposIdentificaion) {
            CB_TipoIdentificacion.addItem(TiposIdentificaion1);
        }
    }

    public void llenarVariables() {
        if (Txt_NumeroIdentificacion != null && !Txt_NumeroIdentificacion.getText().trim().isEmpty()) {
            TipoDocumento = CB_TipoIdentificacion.getSelectedItem().toString();
            String motivo = CB_motivo.getSelectedItem().toString().toLowerCase();
            switch (motivo.toLowerCase()) {
                case "retiros":
                    contadorR++;
                    turno = "R" + contadorR;
                    modulo = "Modulo - 01";
                    break;
                case "prestamos":
                    contadorP++;
                    turno = "P" + contadorP;
                    modulo = "Modulo - 02";
                    break;
                case "consignaciones":
                    contadorC++;
                    turno = "C" + contadorC;
                    modulo = "Modulo - 03";
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane, "Motivo no reconocido", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Ingrese el número de identificación", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public JTable getTablModificable() {
        return TablModificable;
    }

    public void SeleccionarFilaTabla(JTable Tabla) {
        if (fila < Tabla.getRowCount() && fila >= 0) {
            int filaSeleccionada = fila;
            fila++;
            Tabla.selectAll();
            Tabla.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
            Tabla.scrollRectToVisible(Tabla.getCellRect(filaSeleccionada, 0, true));
        } else {
            JOptionPane.showMessageDialog(rootPane, "La tabla esta vacia o ya se selecciono la ultima fila");
            fila = 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CB_motivo = new javax.swing.JComboBox<>();
        Txt_NumeroIdentificacion = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Btn_registrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablModificable = new javax.swing.JTable();
        CB_TipoIdentificacion = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItem_Reportes = new javax.swing.JMenuItem();
        MenuItem_CerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registro del empleado");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        CB_motivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Numero de identificacion");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Tipo de Identificacion");

        Btn_registrar.setText("Registrar");
        Btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Motivo");

        TablModificable.setModel(new javax.swing.table.DefaultTableModel(
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
        TablModificable.setEnabled(false);
        jScrollPane1.setViewportView(TablModificable);

        CB_TipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_NumeroIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB_motivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB_TipoIdentificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_TipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_NumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_registrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Opciones");

        MenuItem_Reportes.setText("Reportes");
        MenuItem_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_ReportesActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItem_Reportes);

        MenuItem_CerrarSesion.setText("Cerrar Sesion");
        MenuItem_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_CerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItem_CerrarSesion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrarActionPerformed
        if (CB_TipoIdentificacion.getSelectedIndex() != 0) {
            if (CB_motivo.getSelectedIndex() != 0) {
                try {
                    llenarVariables();
                    numeroDocumento = Double.parseDouble(Txt_NumeroIdentificacion.getText());
                    String[] encabezados = {"Turno", "Modulo"};
                    ValidadCliente();
                    Turnitos.ConstruirTabla(Turnitos.getTablaTurnos(), encabezados);
                    CrearTabla();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Solo ingrese números", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione un motivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione su tipo de documento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Btn_registrarActionPerformed

    private void ValidadCliente() {
        boolean Encontrado = false;
        for (Cliente client : ListaDocumentos) {
            if (client.getNumeroIdentificacion() == Integer.parseInt(Txt_NumeroIdentificacion.getText())) {
                Encontrado = true;
                break;
            }
        }

        if (!Encontrado) {
            ListaDocumentos.add(new Cliente(TipoDocumento, numeroDocumento, turno, modulo));
            Listamotivos.add(new MotivoVisita(CB_motivo.getSelectedItem().toString()));
        } else {
            JOptionPane.showMessageDialog(rootPane, "El cliente ya fue registrado anteriormente");
        }
    }

    private void MenuItem_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_CerrarSesionActionPerformed

        int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de que deseas cerrar esta sesion?", "Alerta", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE);
        if (eleccion == 0) {
            Frm_InicioSesion iniciosesion = new Frm_InicioSesion();
            iniciosesion.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_MenuItem_CerrarSesionActionPerformed

    private void MenuItem_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_ReportesActionPerformed
        // TODO add your handling code here:
        Frm_Reportes reportes = new Frm_Reportes();
        reportes.setVisible(true);
    }//GEN-LAST:event_MenuItem_ReportesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de que deseas cerrar esta sesion?", "Alerta", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE);
        if (eleccion == 0) {
            Frm_InicioSesion iniciosesion = new Frm_InicioSesion();
            iniciosesion.setVisible(true);
            this.dispose();
        }else{
            
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Frm_Registros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Registros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Registros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Registros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_registrar;
    private javax.swing.JComboBox<String> CB_TipoIdentificacion;
    private javax.swing.JComboBox<String> CB_motivo;
    private javax.swing.JMenuItem MenuItem_CerrarSesion;
    private javax.swing.JMenuItem MenuItem_Reportes;
    private javax.swing.JTable TablModificable;
    private java.awt.TextField Txt_NumeroIdentificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
