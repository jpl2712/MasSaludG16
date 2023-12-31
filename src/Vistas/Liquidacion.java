/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Practica;
import Entidades.Prestador;
import accesoData.PracticaData;
import accesoData.PrestadorData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Liquidacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Liquidacion
     */
    private DefaultTableModel modelo = new DefaultTableModel();
    private PrestadorData pd = new PrestadorData();
    private Prestador prestador = null;
    private PracticaData ptd = new PracticaData();
     
    
    
    public Liquidacion() {
        initComponents();
        ListaDesplegablePrestadores();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jcPrestador = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtLiquidacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Liquidacion");

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Detalle", "Codigo", "Copago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabla);

        jcPrestador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcPrestadorItemStateChanged(evt);
            }
        });
        jcPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPrestadorActionPerformed(evt);
            }
        });

        jLabel6.setText("Prestador");

        jtLiquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtLiquidacionActionPerformed(evt);
            }
        });

        jLabel2.setText("El total a cobrar (en pesos) es ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jcPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtLiquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtLiquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPrestadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcPrestadorActionPerformed

    private void jcPrestadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcPrestadorItemStateChanged
        // TODO add your handling code here:
        Prestador prestador = (Prestador) jcPrestador.getSelectedItem();
        
        DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();

        List<Practica> liquidaciones = ptd.liquidacionPorPrestador(prestador);
        double liquidacion = 0;
        modelo.setRowCount(0);
        for(Practica elem: liquidaciones){
            Object[] fila = { elem.getCodigo(), elem.getDetalle(), elem.getCopago()};
            modelo.addRow(fila);
            liquidacion = liquidacion + elem.getCopago();
        }
        jtLiquidacion.setText(String.valueOf(liquidacion));
        
        //kkdk
    }//GEN-LAST:event_jcPrestadorItemStateChanged

    private void jtLiquidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtLiquidacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtLiquidacionActionPerformed
    private void ListaDesplegablePrestadores() {

        PrestadorData prestadorData = new PrestadorData();
        List<Prestador> prestadores = prestadorData.listarPrestadores();
        jcPrestador.removeAllItems();

        Prestador blanco = new Prestador();
        blanco.setNombre("Buscar orden por prestador");
        jcPrestador.addItem(blanco);
        for (Prestador prestador : prestadores) {
            jcPrestador.addItem(prestador);
        }
    }
    private void limpiar2(){
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JComboBox<Prestador> jcPrestador;
    private javax.swing.JTextField jtLiquidacion;
    // End of variables declaration//GEN-END:variables
}
