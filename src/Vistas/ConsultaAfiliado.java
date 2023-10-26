/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Afiliado;
import accesoData.AfiliadoData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ConsultaAfiliado extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaAfiliado
     */
    private List<Afiliado> listaActivos;
    private List<Afiliado> listaInactivos;
    private AfiliadoData afiliadoData;
    private DefaultTableModel modelo;

    public ConsultaAfiliado() {
        initComponents();
        this.setTitle(" Consulta Afiliados ");
        afiliadoData = new AfiliadoData();
        listaActivos = afiliadoData.listarAfiliadosActivos();
        listaInactivos = afiliadoData.listarAfiliadosInactivos();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTAfiliados = new javax.swing.JTable();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jrActivos = new javax.swing.JRadioButton();
        jrInactivos = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jTAfiliados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTAfiliados);

        jBModificar.setText("Modificar");
        jBModificar.setEnabled(false);
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.setEnabled(false);
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBAlta.setText("Alta");
        jBAlta.setEnabled(false);
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBBaja.setText("Baja");
        jBBaja.setEnabled(false);
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jrActivos.setText("Afiliados activos");
        jrActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrActivosActionPerformed(evt);
            }
        });

        jrInactivos.setText("Afiliados inactivos");
        jrInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrInactivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jBModificar)
                .addGap(43, 43, 43)
                .addComponent(jBAlta)
                .addGap(38, 38, 38)
                .addComponent(jBBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBEliminar)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jrActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jrInactivos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrActivos)
                    .addComponent(jrInactivos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBModificar)
                    .addComponent(jBEliminar)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivosActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        jrInactivos.setSelected(false);
        cargarDatosActivos();
        jBAlta.setEnabled(false);
        jBModificar.setEnabled(true);
        jBBaja.setEnabled(true);
        jBEliminar.setEnabled(true);


    }//GEN-LAST:event_jrActivosActionPerformed

    private void jrInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrInactivosActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        jrActivos.setSelected(false);
        cargarDatosInactivos();
        jBAlta.setEnabled(true);
        jBModificar.setEnabled(true);
        jBBaja.setEnabled(false);
        jBEliminar.setEnabled(true);
    }//GEN-LAST:event_jrInactivosActionPerformed


    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // TODO add your handling code here:
        try{
        
        int fila = jTAfiliados.getSelectedRow();
        if (fila != -1) {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre");
            String apellido = JOptionPane.showInputDialog(this, "Ingrese apellido");
            if(nombre.isEmpty() || apellido.isEmpty()){
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return;
            }
            String dniStr = JOptionPane.showInputDialog(this, "Ingrese dni");
            int dni = Integer.parseInt(dniStr);

            boolean v1 = validarTxt(nombre);
            boolean v2 = validarTxt(apellido);

            if (v1 && v2) {
                if (chequearDni(dni)) {

                    String dato = String.valueOf(modelo.getValueAt(jTAfiliados.getSelectedRow(), 0));
                    int id = Integer.parseInt(dato);
                    //JOptionPane.showMessageDialog(null, id);
                    AfiliadoData ad = new AfiliadoData();
                    Afiliado a = new Afiliado(id, nombre, apellido, dni);
                    ad.modificarAfiliadoPorId(a);
                    modelo.removeRow(jTAfiliados.getSelectedRow());
                    modelo.addRow(new Object[]{
                        a.getIdAfiliado(),
                        a.getNombre(),
                        a.getApellido(),
                        a.getDni(),
                        a.isActivo()
                    });

                }
            }else{
                JOptionPane.showMessageDialog(null, "Nombre o apellido invalidos");
            }
            
        }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Debe ingresar un número valido");
        }

    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
        int fila = jTAfiliados.getSelectedRow();
        if (fila != -1) {

            String dato = String.valueOf(modelo.getValueAt(jTAfiliados.getSelectedRow(), 0));

            int id = Integer.parseInt(dato);

            //JOptionPane.showMessageDialog(null, id);
            AfiliadoData ad = new AfiliadoData();
            ad.altaAfiliadoPorId(id);
            modelo.removeRow(jTAfiliados.getSelectedRow());
        }
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        // TODO add your handling code here:
        int fila = jTAfiliados.getSelectedRow();
        if (fila != -1) {
            //JOptionPane.showMessageDialog(null, "Correcto");
            //Afiliado a = (Afiliado)jTAfiliados.getSelectionModel();

            String dato = String.valueOf(modelo.getValueAt(jTAfiliados.getSelectedRow(), 0));

            int id = Integer.parseInt(dato);

            //JOptionPane.showMessageDialog(null, id);
            AfiliadoData ad = new AfiliadoData();
            ad.bajaAfiliadoPorId(id);

            modelo.removeRow(jTAfiliados.getSelectedRow());

        }
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jTAfiliados.getSelectedRow();
        if (fila != -1) {
            //JOptionPane.showMessageDialog(null, "Correcto");
            //Afiliado a = (Afiliado)jTAfiliados.getSelectionModel();

            String dato = String.valueOf(modelo.getValueAt(jTAfiliados.getSelectedRow(), 0));

            int id = Integer.parseInt(dato);

            //JOptionPane.showMessageDialog(null, id);
            AfiliadoData ad = new AfiliadoData();
            ad.eliminarAfiliadoPorId(id);

            modelo.removeRow(jTAfiliados.getSelectedRow());

        }

    }//GEN-LAST:event_jBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAfiliados;
    private javax.swing.JRadioButton jrActivos;
    private javax.swing.JRadioButton jrInactivos;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dni");
        modelo.addColumn("Estado");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTAfiliados.setModel(modelo);

    }

    private void cargarDatosActivos() {
        AfiliadoData aData = new AfiliadoData();
        Afiliado selec = (Afiliado) jrActivos.getSelectedIcon();
        listaActivos = aData.listarAfiliadosActivos();

        for (Afiliado a : listaActivos) {
            modelo.addRow(new Object[]{
                a.getIdAfiliado(),
                a.getNombre(),
                a.getApellido(),
                a.getDni(),
                a.isActivo()
            });
        }
    }

    private void cargarDatosInactivos() {

        AfiliadoData aData = new AfiliadoData();
        Afiliado selec = (Afiliado) jrActivos.getSelectedIcon();
        listaInactivos = aData.listarAfiliadosInactivos();

        for (Afiliado a : listaInactivos) {
            modelo.addRow(new Object[]{
                a.getIdAfiliado(),
                a.getNombre(),
                a.getApellido(),
                a.getDni(),
                a.isActivo()
            });
        }
    }

    private void borrarFilaTabla() {
        int indice = modelo.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

//    private void limpiarCampos(){
//        jTNombre.setText("");
//        jTApellido.setText("");
//        jTDni.setText("");
//        jRActivo.setSelected(true);
//        
//    }
    private boolean chequearDni(int dni) {
        Afiliado afiliado = afiliadoData.buscarAfiliadoGeneralPorDni(dni);
        if (afiliado == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un afiliado con ese dni");
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
