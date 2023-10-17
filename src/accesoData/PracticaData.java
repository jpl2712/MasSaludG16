/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoData;

import Entidades.Orden;
import Entidades.Practica;
import Entidades.Prestador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PracticaData {

    private Connection con = null;
    

    public PracticaData() {
        this.con = Conexion.getConexion();
    }

    public void guardarPractica(Practica practica) {
        String sql = " INSERT INTO `practicas`(`Copago`, `codigo`, `detalle`) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, practica.getCopago());
            ps.setInt(2, practica.getCodigo());
            ps.setString(3, practica.getDetalle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                practica.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Practica Registrada");

            }

        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Error al acceder a la tabla practicas");
        }

    }

    public void ModificarPractica(Practica practica) {

        String sql = " UPDATE `practicas` SET `Copago`= ?,`detalle`= ? WHERE `codigo`= ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, practica.getCopago());
            ps.setInt(3, practica.getCodigo());
            ps.setString(2, practica.getDetalle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                practica.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Practica Modificada");

            }

        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Error al acceder a la tabla practicas");
        }

    }

    public void eliminarPractica(Practica practica) {

        String sql = " DELETE FROM `practicas` WHERE `codigo`= ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, practica.getCodigo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                practica.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Practica Eliminada");

            }

        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Error al acceder a la tabla practicas");
        }

    }

    public List<Orden> PracticasPorPrestador() {

        ArrayList<Orden> practicasXprestador = new ArrayList<>();

       
        String sql = "SELECT "
                + "    prestador.nombre, "
                + "    prestador.apellido, "
                + "    COUNT(practicas.codigo) AS cantidad , "
                + "    practicas.codigo, "
                + "    practicas.detalle "
                + "FROM  practicas"
                + " JOIN orden ON practicas.codigo = orden.codigo "
                + " JOIN prestador ON prestador.idPrestador = orden.Prestador "
                + "GROUP BY prestador.idPrestador, prestador.nombre, prestador.apellido, practicas.codigo, practicas.detalle ";
        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Orden orden = new Orden();
                Prestador prestador = new Prestador();
                Practica practica = new Practica();

                prestador.setApellido(rs.getString("apellido"));
                prestador.setNombre(rs.getString("nombre"));
                practica.setCodigo(rs.getInt("codigo"));
                practica.setDetalle(rs.getString("detalle"));

                orden.setPrestador(prestador);
                orden.setCodigo(practica);

                orden.setCantidadPracticas(rs.getInt("cantidad"));

                practicasXprestador.add(orden);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a una de las tablas");
        }

        return practicasXprestador;

    }

    public List<Orden> LiquidacionPorPrestador() { 

        ArrayList<Orden> liquidacionXprestador = new ArrayList<>();

        String sql = "SELECT "
                + " prestador.nombre, "
                + " prestador.apellido, "
                + " SUM(practicas.Copago) AS Liquidacion "
                + " FROM practicas "
                + "JOIN orden ON practicas.codigo = orden.codigo "
                + "JOIN prestador ON prestador.idPrestador = orden.Prestador "
                + "GROUP BY  prestador.idPrestador, prestador.nombre, prestador.apellido ";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Orden orden = new Orden();
                Prestador prestador = new Prestador();
                Practica practica = new Practica();

                prestador.setApellido(rs.getString("apellido"));
                prestador.setNombre(rs.getString("nombre"));
               
               

                orden.setPrestador(prestador);
                orden.setCodigo(practica);

                orden.setLiquidacion(rs.getDouble("Liquidacion"));

                liquidacionXprestador.add(orden);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a una de las tablas " + ex.getMessage());
        }
        return liquidacionXprestador;

    }
    public List<Practica> listarPracticas() {

        String sql = "SELECT `Copago`, `codigo`, `detalle` FROM `practicas` ";
        
        ArrayList<Practica> practicas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Practica practica = new Practica();
                practica.setCopago(rs.getInt("Copago"));
                practica.setCodigo(rs.getInt("codigo"));
                practica.setDetalle(rs.getString("detalle"));
              
                practicas.add(practica);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla practica ");
        }

        return practicas;
    }

}
