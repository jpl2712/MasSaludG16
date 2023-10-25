/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.Afiliado;
import Entidades.Especialidad;
import Entidades.Orden;
import Entidades.Practica;
import Entidades.Prestador;
import accesoData.AfiliadoData;
import accesoData.EspecialidadData;
import accesoData.OrdenData;
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
public class OrdenesPor extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();

    public OrdenesPor() {
        initComponents();
        armarCabecera();
        ListaDesplegablePrestadores();
        ListaDesplegablePracticas();
        ListaDesplegableEspecialidades();

        this.setTitle(" Buscar Orden ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jT_Afiliado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jC_Prestadores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jC_Practicas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jC_Especialidades = new javax.swing.JComboBox<>();
        jB_BuscarOrden = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BuscarOrden_Tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Modificar_orden = new javax.swing.JButton();
        Eliminar_orden = new javax.swing.JButton();

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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Afiliado :");

        jT_Afiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_AfiliadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Prestador :");

        jC_Prestadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jC_PrestadoresItemStateChanged(evt);
            }
        });

        jLabel3.setText("Practica :");

        jC_Practicas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jC_PracticasItemStateChanged(evt);
            }
        });

        jLabel4.setText("Especialidad :");

        jC_Especialidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jC_EspecialidadesItemStateChanged(evt);
            }
        });

        jB_BuscarOrden.setText("Buscar");
        jB_BuscarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BuscarOrdenActionPerformed(evt);
            }
        });

        BuscarOrden_Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(BuscarOrden_Tabla);

        jLabel5.setText("Fecha de Emision :");

        jLabel6.setText("Orden nro: ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Ingrese o Seleccione una opcion para su Busqueda de Ordenes");

        Modificar_orden.setText("Modificar Orden");

        Eliminar_orden.setText("Eliminar Orden");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jT_Afiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jC_Practicas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jB_BuscarOrden))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jC_Especialidades, javax.swing.GroupLayout.Alignment.LEADING, 0, 236, Short.MAX_VALUE)
                                    .addComponent(jC_Prestadores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(26, 26, 26)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(Modificar_orden)
                        .addGap(217, 217, 217)
                        .addComponent(Eliminar_orden)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jT_Afiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jC_Prestadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jC_Practicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jC_Especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jB_BuscarOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificar_orden)
                    .addComponent(Eliminar_orden))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jT_AfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_AfiliadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_AfiliadoActionPerformed

    private void jB_BuscarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BuscarOrdenActionPerformed

        List<Orden> resultados = new ArrayList<>();
        OrdenData ordenData = new OrdenData();

        int idOrden = -1;
        int dni = -1;
        java.util.Date fechaEmisionUtil = jDateChooser1.getDate();
        java.sql.Date fechaEmisionSql = null;
        modelo.setRowCount(0);

        if (!jTextField1.getText().isEmpty()) {
            idOrden = Integer.parseInt(jTextField1.getText());
            resultados.addAll(ordenData.listarOrdenXidOrden(idOrden));
        }
        if (!jT_Afiliado.getText().isEmpty()) {
            dni = Integer.parseInt(jT_Afiliado.getText());
            AfiliadoData buscarAf = new AfiliadoData();
            Afiliado afiliado = buscarAf.buscarAfiliadoPorDni(dni);
            resultados.addAll(ordenData.listarOrdenesPorAfiliado(afiliado));
        }
        if (fechaEmisionUtil != null) {
            fechaEmisionSql = new java.sql.Date(fechaEmisionUtil.getTime());
            resultados.addAll(ordenData.listarOrdenesPorFecha(fechaEmisionSql));
        }

        for (Orden orden : resultados) {
            Object[] fila = {
                orden.getIdOrden(),
                orden.getPrestador().getApellido() + " , " + orden.getPrestador().getNombre(),
                orden.getAfiliado().getApellido() + " , " + orden.getAfiliado().getNombre(),
                orden.getCodigo().getCodigo(),
                orden.getFechaEmision() + " // " + orden.getFechaVencimiento()
            };
            modelo.addRow(fila);
        }
        jTextField1.setText("");
        jT_Afiliado.setText("");

    }//GEN-LAST:event_jB_BuscarOrdenActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jC_PrestadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jC_PrestadoresItemStateChanged
        List<Orden> resultados = new ArrayList<>();
        OrdenData ordenData = new OrdenData();
        Prestador prestador = (Prestador) jC_Prestadores.getSelectedItem();
        System.out.println("Prestador seleccionado: " + prestador);
        modelo.setRowCount(0);
        if (prestador != null) {

            resultados.addAll(ordenData.listarOrdenesPorPrestador(prestador));
            System.out.println("Entra en el método prestador" + resultados);
            for (Orden orden : resultados) {
                Object[] fila = {
                    orden.getIdOrden(),
                    orden.getPrestador().getApellido() + " , " + orden.getPrestador().getNombre(),
                    orden.getAfiliado().getApellido() + " , " + orden.getAfiliado().getNombre(),
                    orden.getCodigo().getCodigo(),
                    orden.getFechaEmision() + " // " + orden.getFechaVencimiento()
                };
                modelo.addRow(fila);
            }
        } else {
            // Prestador es null, puedes manejar este caso si es necesario
            System.out.println("Prestador seleccionado es null");
        }
    }//GEN-LAST:event_jC_PrestadoresItemStateChanged

    private void jC_PracticasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jC_PracticasItemStateChanged
        List<Orden> resultados = new ArrayList<>();
        OrdenData ordenData = new OrdenData();
        Practica practica = (Practica) jC_Practicas.getSelectedItem();
        modelo.setRowCount(0);

        if (practica != null) {
            resultados.addAll(ordenData.listarOrdenesPorPractica(practica));
            System.out.println("Entra en el método practica" + resultados);
            for (Orden orden : resultados) {

                Object[] fila = {
                    orden.getIdOrden(),
                    orden.getPrestador().getApellido() + " , " + orden.getPrestador().getNombre(),
                    orden.getAfiliado().getApellido() + " , " + orden.getAfiliado().getNombre(),
                    orden.getCodigo().getCodigo(),
                    orden.getFechaEmision() + " // " + orden.getFechaVencimiento()
                };
                modelo.addRow(fila);
            }
        } else {

            System.out.println("Practica seleccionada es null");
        }

    }//GEN-LAST:event_jC_PracticasItemStateChanged

    private void jC_EspecialidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jC_EspecialidadesItemStateChanged
       
        List<Orden> resultados = new ArrayList<>();
        OrdenData ordenData = new OrdenData();
        Especialidad especialidad = (Especialidad) jC_Especialidades.getSelectedItem();
        modelo.setRowCount(0);
        if (especialidad != null) {
            int id = especialidad.getIdEspecialidad();
            resultados.addAll(ordenData.listarOrdenPorEspecialidad(id));
            for (Orden orden : resultados) {

                Object[] fila = {
                    orden.getIdOrden(),
                    orden.getPrestador().getApellido() + " , " + orden.getPrestador().getNombre(),
                    orden.getAfiliado().getApellido() + " , " + orden.getAfiliado().getNombre(),
                    orden.getCodigo().getCodigo(),
                    orden.getFechaEmision() + " // " + orden.getFechaVencimiento()
                };
                modelo.addRow(fila);
            }
        } else {

            System.out.println("Practica seleccionada es null");

        }
    }//GEN-LAST:event_jC_EspecialidadesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BuscarOrden_Tabla;
    private javax.swing.JButton Eliminar_orden;
    private javax.swing.JButton Modificar_orden;
    private javax.swing.JButton jB_BuscarOrden;
    private javax.swing.JComboBox<Especialidad> jC_Especialidades;
    private javax.swing.JComboBox<Practica> jC_Practicas;
    private javax.swing.JComboBox<Prestador> jC_Prestadores;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jT_Afiliado;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void ListaDesplegablePrestadores() {

        PrestadorData prestadorData = new PrestadorData();
        List<Prestador> prestadores = prestadorData.listarPrestadores();
        jC_Prestadores.removeAllItems();

        Prestador blanco = new Prestador();
        blanco.setNombre("Buscar orden por prestador");
        jC_Prestadores.addItem(blanco);
        for (Prestador prestador : prestadores) {
            jC_Prestadores.addItem(prestador);
        }
    }

    private void ListaDesplegablePracticas() {

        PracticaData practicaD = new PracticaData();

        List<Practica> listarPracticas = practicaD.listarPracticas();
        jC_Practicas.removeAllItems();
        Practica blanco = new Practica();
        blanco.setDetalle("Buscar Orden por Practica");
        jC_Practicas.addItem(blanco);

        for (Practica practicas : listarPracticas) {
            jC_Practicas.addItem(practicas);
        }

    }

    private void ListaDesplegableEspecialidades() {

        EspecialidadData especialidadD = new EspecialidadData();
        List<Especialidad> especialidades = especialidadD.listarEspecialidades();

        jC_Especialidades.removeAllItems();
        Especialidad blanco = new Especialidad();
        blanco.setEspecialidad("Buscar orden por Esp");
        jC_Especialidades.addItem(blanco);

        for (Especialidad especialidad : especialidades) {
            jC_Especialidades.addItem(especialidad);
        }

    }

    private void armarCabecera() {

        modelo.addColumn("Id Orden");
        modelo.addColumn("Prestador");
        modelo.addColumn("Afiliado");
        modelo.addColumn("Practica");
        modelo.addColumn("Fecha Emision y Vto");

        BuscarOrden_Tabla.setModel(modelo);
    }
}
