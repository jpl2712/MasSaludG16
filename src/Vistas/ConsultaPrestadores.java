/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author Usuario
 */
import Entidades.Prestador;
import accesoData.PrestadorData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaPrestadores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaPrestadores
     */
    
    //private List<Prestador> listaP;
    private List<Prestador> listaActivos;
    private List<Prestador> listaInactivos;
    private PrestadorData prestadorData;
    private DefaultTableModel modelo;
    
    
    public ConsultaPrestadores() {
        initComponents();
        
        this.setTitle(" Consulta Prestadores ");
        
        prestadorData = new PrestadorData();
        listaActivos = prestadorData.listarPrestadoresActivos();
        listaInactivos = prestadorData.listarPrestadoresInactivos();
        
        modelo = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }

        };
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jrActivos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePrestador = new javax.swing.JTable();
        jrInactivos = new javax.swing.JRadioButton();
        jbModificar = new javax.swing.JButton();
        jbAlta = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jrActivos.setText("Prestadores Activos");
        jrActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrActivosActionPerformed(evt);
            }
        });

        tablePrestador.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePrestador);

        jrInactivos.setText("Prestadores Inactivos");
        jrInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrInactivosActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");

        jbAlta.setText("Alta");
        jbAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaActionPerformed(evt);
            }
        });

        jbBaja.setText("Baja");
        jbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jrActivos)
                        .addGap(90, 90, 90)
                        .addComponent(jrInactivos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jbModificar)
                        .addGap(64, 64, 64)
                        .addComponent(jbAlta)
                        .addGap(69, 69, 69)
                        .addComponent(jbBaja)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrActivos)
                    .addComponent(jrInactivos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbAlta)
                    .addComponent(jbBaja))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivosActionPerformed
        // TODO add your handling code here:
        
        borrarFilaTabla();
        jrInactivos.setSelected(false);
        cargarDatosActivos();
        jbAlta.setEnabled(false);
        jbModificar.setEnabled(true);
        jbBaja.setEnabled(true);
        
        
    }//GEN-LAST:event_jrActivosActionPerformed

    private void jrInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrInactivosActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        jrActivos.setSelected(false);
        cargarDatosInactivos();
        
        jbAlta.setEnabled(true);
        jbModificar.setEnabled(true);
        jbBaja.setEnabled(false);
        
    }//GEN-LAST:event_jrInactivosActionPerformed

    private void jbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaActionPerformed
        // TODO add your handling code here:
        int fila = tablePrestador.getSelectedRow();
        if (fila != -1) {

            String dato = String.valueOf(modelo.getValueAt(tablePrestador.getSelectedRow(), 0));

            int id = Integer.parseInt(dato);

            //JOptionPane.showMessageDialog(null, id);
            PrestadorData pd = new PrestadorData();
            
            pd.altaPrestadorPorId(id);
            modelo.removeRow(tablePrestador.getSelectedRow());
        }
    }//GEN-LAST:event_jbAltaActionPerformed

    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        // TODO add your handling code here:
        int fila = tablePrestador.getSelectedRow();
        if (fila != -1) {

            String dato = String.valueOf(modelo.getValueAt(tablePrestador.getSelectedRow(), 0));

            int id = Integer.parseInt(dato);

            //JOptionPane.showMessageDialog(null, id);
            PrestadorData pd = new PrestadorData();
            
            pd.bajaPrestadorPorId(id);
            modelo.removeRow(tablePrestador.getSelectedRow());
        }
        
    }//GEN-LAST:event_jbBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlta;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbModificar;
    private javax.swing.JRadioButton jrActivos;
    private javax.swing.JRadioButton jrInactivos;
    private javax.swing.JTable tablePrestador;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dni");
        //modelo.addColumn("Especialidad");
        modelo.addColumn("Matricula");
        modelo.addColumn("Estado");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        tablePrestador.setModel(modelo);

    }

    private void cargarDatosActivos() {
     
        Prestador selec = (Prestador) jrActivos.getSelectedIcon();
        listaActivos = prestadorData.listarPrestadoresActivos();

        for (Prestador p : listaActivos) {
            modelo.addRow(new Object[]{
                p.getIdPrestador(),
                p.getNombre(),
                p.getApellido(),
                p.getDni(),
                //p.getEspecialidad().getEspecialidad(),
                p.getMatricula(),
                p.isActivo()
            });
        }
    }

    private void cargarDatosInactivos() {

        PrestadorData pData = new PrestadorData();
        Prestador selec = (Prestador) jrActivos.getSelectedIcon();
        listaInactivos = pData.listarPrestadoresInactivos();

        for (Prestador p : listaInactivos) {
            modelo.addRow(new Object[]{
                p.getIdPrestador(),
                p.getNombre(),
                p.getApellido(),
                p.getDni(),
                //p.getEspecialidad().getEspecialidad(),
                p.getMatricula(),
                p.isActivo()
            });
        }
    }

    private void borrarFilaTabla() {
        int indice = modelo.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private boolean chequearDni(int dni) {
        PrestadorData pData = new PrestadorData();
        Prestador prestador = pData.buscarPrestadorPorDni(dni);
                
        if (prestador == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un prestador con ese dni");
//            limpiarCampos();
            return false;
        }
    }

    private boolean validarTxt(String txt) {
        int n = txt.length();
        boolean bandera = false;
        for (int i = 0; i < n; i++) {
            bandera = !(txt.substring(i).equalsIgnoreCase("0") || txt.substring(i).equalsIgnoreCase("1")
                    || txt.substring(i).equalsIgnoreCase("2") || txt.substring(i).equalsIgnoreCase("3")
                    || txt.substring(i).equalsIgnoreCase("4") || txt.substring(i).equalsIgnoreCase("5")
                    || txt.substring(i).equalsIgnoreCase("6") || txt.substring(i).equalsIgnoreCase("7")
                    || txt.substring(i).equalsIgnoreCase("8") || txt.substring(i).equalsIgnoreCase("9"));
        }
        return bandera;
    }



}
