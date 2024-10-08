/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Reportes;

import Proyecto.FormularioRegistro.Cliente;
import Proyecto.FormularioRegistro.Frm_Registros;
import Proyecto.Frm_Turnos;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author mjiad
 */
public final class Frm_Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Reportes
     */
    String NombreHolaArhivo = "";
    ArrayList<Cliente> lista;
    String[] ListaCombo = {"Numero de clientes atendidos", "Clientes que abandonaron"};
    String[] ListaAtendidosDia = {"Tipo identficacion", "Numero de identificacion", "Fecha del turno"};
    String[] ListaNoAtendidos = {"Tipo de identificacion", "Numero identificacion"};
    Frm_Registros registros;
    Frm_Turnos turnos;

    public Frm_Reportes() {
        initComponents();
        registros = turnos.getRegistros();
        lista = registros.getListaDocumentos();
        turnos = turnos.getInstance();
        RellenarTablos(0);
        llenaComboBox();
        setLocationRelativeTo(null);
    }

    public void RellenarTablos(int Indice) {
        DefaultTableModel model = new DefaultTableModel();
        DecimalFormat df = new DecimalFormat("#");
        for (Cliente cliente : lista) {
            if (cliente.getFechaTurno() != null && Indice == 1) {
                model.setColumnIdentifiers(ListaAtendidosDia);
                model.addRow(new Object[]{
                    cliente.getTipoIdendificacion(),
                    df.format(cliente.getNumeroIdentificacion()),
                    cliente.getFechaTurno()});
                Tabla_Reportes.setModel(model);
                NombreHolaArhivo = "Reportes de Clientes Atendidos";
            } else if (Indice == 2 && cliente.getFechaTurno() == null) {
                model.setColumnIdentifiers(ListaNoAtendidos);
                model.addRow(new Object[]{
                    cliente.getTipoIdendificacion(),
                    df.format(cliente.getNumeroIdentificacion()),});
                Tabla_Reportes.setModel(model);
                NombreHolaArhivo = "Reportes de clientes que abandonaron";
            }
        }
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
        ComoBobox_Reportes = new javax.swing.JComboBox<>();
        Btn_ExportarExcel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Reportes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");

        jLabel1.setText("Reportes");

        ComoBobox_Reportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComoBobox_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComoBobox_ReportesActionPerformed(evt);
            }
        });

        Btn_ExportarExcel.setText("Exportar Reporte (Excel)");
        Btn_ExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ExportarExcelActionPerformed(evt);
            }
        });

        Tabla_Reportes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Tabla_Reportes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(534, 534, 534))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComoBobox_Reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_ExportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComoBobox_Reportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_ExportarExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenaComboBox() {
        ComoBobox_Reportes.removeAllItems();
        ComoBobox_Reportes.addItem("Seleccione...");
        for (String ListaCombo1 : ListaCombo) {
            ComoBobox_Reportes.addItem(ListaCombo1);
        }
    }

    private void ComoBobox_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComoBobox_ReportesActionPerformed
        int IndiceSeleccionado = ComoBobox_Reportes.getSelectedIndex();
        if (IndiceSeleccionado == 1 || IndiceSeleccionado == 2) {
            RellenarTablos(IndiceSeleccionado);
        }
    }//GEN-LAST:event_ComoBobox_ReportesActionPerformed

    public void ExportToExcel(String ruta) throws IOException, WriteException {
        try {
            WritableWorkbook worbook = Workbook.createWorkbook(new File(ruta));
            WritableSheet sheet = worbook.createSheet(NombreHolaArhivo, 0);

            for (int i = 0; i < Tabla_Reportes.getColumnCount(); i++) {
                Label label = new Label(i, 0, Tabla_Reportes.getColumnName(i));
                sheet.addCell(label);
            }
            
            for (int fila = 0; fila < Tabla_Reportes.getRowCount(); fila++){
                for(int colum = 0; colum < Tabla_Reportes.getColumnCount(); colum++){
                    Object value = Tabla_Reportes.getValueAt(fila, colum);
                    Label label = new Label(colum, fila+1, value != null ? value.toString() : "");
                    sheet.addCell(label);
                }
            }
            
            worbook.write();
            worbook.close();
            JOptionPane.showMessageDialog(Tabla_Reportes, "Informe exportado","Exportar Informe", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Tabla_Reportes, "no se pudo exportar","Exportar informe", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Btn_ExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ExportarExcelActionPerformed
        try {
            ExportToExcel(NombreHolaArhivo + ".xls");
        } catch (IOException | WriteException ex) {
            Logger.getLogger(Frm_Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_ExportarExcelActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_ExportarExcel;
    private javax.swing.JComboBox<String> ComoBobox_Reportes;
    private javax.swing.JTable Tabla_Reportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
