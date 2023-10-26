package accesoData;

import Entidades.Afiliado;
import Entidades.Orden;
import Entidades.Practica;
import Entidades.Prestador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OrdenData {

    private Connection con = null;

    public OrdenData() {
        con = Conexion.getConexion();
    }

    public void nuevaOrden(Orden orden) {

        String sql = "INSERT INTO orden(fecha_Emision, codigo, afiliado, prestador, fecha_Vencimiento, formaPago)"
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, (Date) orden.getFechaEmision());
            ps.setInt(2, orden.getCodigo().getCodigo());
            ps.setInt(3, orden.getAfiliado().getIdAfiliado());
            ps.setInt(4, orden.getPrestador().getIdPrestador());
            ps.setDate(5, (Date) orden.getFechaVencimiento());
            ps.setString(6,orden.getFormaPago());
      
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orden.setIdOrden(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Orden guardada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla orden");
        }
    }

    public void modificarOrden(int id) {

        String sql = "UPDATE orden SET fecha_Emision = ?, codigo = ?, afiliado = ?, prestador ?, fecha_Emision = ?, formaPago = ? "
                + " WHERE idOrden = ?";

        try {
            Orden orden = new Orden();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, (Date) orden.getFechaEmision());
            ps.setInt(2, orden.getCodigo().getCodigo());
            ps.setInt(3, orden.getAfiliado().getIdAfiliado());
            ps.setInt(4, orden.getPrestador().getIdPrestador());
            ps.setDate(5, (Date) orden.getFechaVencimiento());
            ps.setString(6, orden.getFormaPago());
            ps.setInt(7, id);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orden.setIdOrden(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Orden modificada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla orden");
        }
    }
    
    
    public List<Orden> listarOrdenesPorAfiliado(Afiliado afiliado) {
        List<Orden> ordenes = new ArrayList();
        String sql = "SELECT o.idOrden, o.fecha_Emision, o.codigo, a.nombre AS afiliado_nombre, a.apellido AS afiliado_apellido, p.nombre AS prestador_nombre, p.apellido AS prestador_apellido, o.fecha_Vencimiento, o.formaPago "
                + "FROM orden o "
                + "JOIN afiliado a ON o.Afiliado = a.idAfiliado "
                + "JOIN prestador p ON o.Prestador = p.idPrestador "
                + "WHERE o.afiliado = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, afiliado.getIdAfiliado());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden();
                Practica practica = new Practica();
                Afiliado afil = new Afiliado();
                Prestador prestador = new Prestador();

                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                practica.setCodigo(rs.getInt("codigo"));
                orden.setCodigo(practica);
                afil.setNombre(rs.getString("afiliado_nombre"));
                afil.setApellido(rs.getString("afiliado_apellido"));
                orden.setAfiliado(afil);
                prestador.setNombre(rs.getString("prestador_nombre"));
                prestador.setApellido(rs.getString("prestador_apellido"));
                orden.setPrestador(prestador);
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));
                ordenes.add(orden);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla " + ex);
        }

        return ordenes;

    }

    public void eliminarOrden(int id) {

        String sql = "DELETE FROM `orden` WHERE idOrden = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Orden eliminada ");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla orden ");
        }

    }

    public List<Orden> listarOrdenPorEspecialidad(int id) {

        ArrayList<Orden> ordenes = new ArrayList();

        String sql = "SELECT o.idOrden, o.fecha_Emision, o.codigo, a.nombre AS afiliado_nombre, a.apellido AS afiliado_apellido, p.nombre AS prestador_nombre, p.apellido AS prestador_apellido, o.fecha_Vencimiento, o.formaPago \n"
                + "FROM orden o "
                + "JOIN prestador p ON p.idPrestador = o.Prestador "
                + "JOIN especialidad ON especialidad.idEspecialidad = p.especialidad "
                + "JOIN afiliado a ON o.Afiliado = a.idAfiliado "
                + "WHERE especialidad.idEspecialidad = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orden orden = new Orden();
                Afiliado afil = new Afiliado();
                Prestador prestador = new Prestador();
                Practica practica = new Practica();

                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                practica.setCodigo(rs.getInt("codigo"));
                orden.setCodigo(practica);
                afil.setNombre(rs.getString("afiliado_nombre"));
                afil.setApellido(rs.getString("afiliado_apellido"));
                orden.setAfiliado(afil);
                prestador.setNombre(rs.getString("prestador_nombre"));
                prestador.setApellido(rs.getString("prestador_apellido"));
                orden.setPrestador(prestador);
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));
                ordenes.add(orden);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }

        return ordenes;
    }
    
    public  List<Orden> listarOrden( ) {
    
    String sql = " SELECT `fecha_Emision`, `codigo`, `Afiliado`, `Prestador`, `fecha_Vencimiento`, `formaPago` FROM `orden` ";
        ArrayList<Orden> ordenes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden();
                Afiliado afiliado = new Afiliado();
                Prestador prestador = new Prestador();
                Practica practica = new Practica();
                
                prestador.setIdPrestador(rs.getInt("prestador"));
                afiliado.setIdAfiliado(rs.getInt("afiliado"));
                
                practica.setCodigo(rs.getInt("codigo"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));

                orden.setPrestador(prestador);
                orden.setAfiliado(afiliado);
                orden.setCodigo(practica);
   
                ordenes.add(orden);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ordenes " + ex.getMessage());
        }

        return ordenes;
    
}
 public  List<Orden> listarOrdenXidOrden( int id) {
    
     String sql = "SELECT o.idOrden, o.fecha_Emision, o.codigo, a.nombre AS afiliado_nombre, a.apellido AS afiliado_apellido, p.nombre AS prestador_nombre, p.apellido AS prestador_apellido, o.fecha_Vencimiento, o.formaPago "
                + "FROM orden o "
                + "JOIN afiliado a ON o.Afiliado = a.idAfiliado "
                + "JOIN prestador p ON o.Prestador = p.idPrestador "
                + "WHERE o.idOrden = ? ";
        ArrayList<Orden> ordenes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden();
                Afiliado afil = new Afiliado();
                Prestador prestador = new Prestador();
                Practica practica = new Practica();

                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                practica.setCodigo(rs.getInt("codigo"));
                orden.setCodigo(practica);
                afil.setNombre(rs.getString("afiliado_nombre"));
                afil.setApellido(rs.getString("afiliado_apellido"));
                orden.setAfiliado(afil);
                prestador.setNombre(rs.getString("prestador_nombre"));
                prestador.setApellido(rs.getString("prestador_apellido"));
                orden.setPrestador(prestador);
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));
                ordenes.add(orden);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ordenes " + ex.getMessage());
        }

        return ordenes;
 }
       public List<Orden> listarOrdenesPorPrestador(Prestador prestador) {
        List<Orden> ordenes = new ArrayList();
        String sql = "SELECT o.idOrden, o.fecha_Emision, o.codigo, a.nombre AS afiliado_nombre, a.apellido AS afiliado_apellido, p.nombre AS prestador_nombre, p.apellido AS prestador_apellido, o.fecha_Vencimiento, o.formaPago "
                + "FROM orden o "
                + "JOIN afiliado a ON o.Afiliado = a.idAfiliado "
                + "JOIN prestador p ON o.Prestador = p.idPrestador "
                + "WHERE o.prestador = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, prestador.getIdPrestador());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden();
                Practica practica = new Practica();
                Afiliado afil = new Afiliado();

                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                practica.setCodigo(rs.getInt("codigo"));
                orden.setCodigo(practica);
                afil.setNombre(rs.getString("afiliado_nombre"));
                afil.setApellido(rs.getString("afiliado_apellido"));
                orden.setAfiliado(afil);
                prestador.setNombre(rs.getString("prestador_nombre"));
                prestador.setApellido(rs.getString("prestador_apellido"));
                orden.setPrestador(prestador);
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));
                ordenes.add(orden);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla " + ex);
        }

        return ordenes;

    }

    public List<Orden> listarOrdenesPorPractica(Practica practica) {
        List<Orden> ordenes = new ArrayList();
        String sql = "SELECT o.idOrden, o.fecha_Emision, o.codigo, a.nombre AS afiliado_nombre, a.apellido AS afiliado_apellido, p.nombre AS prestador_nombre, p.apellido AS prestador_apellido, o.fecha_Vencimiento, o.formaPago "
                + "FROM orden o "
                + "JOIN afiliado a ON o.Afiliado = a.idAfiliado "
                + "JOIN prestador p ON o.Prestador = p.idPrestador "
                + "WHERE o.codigo = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, practica.getCodigo());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden();

                Afiliado afil = new Afiliado();
                Prestador prestador = new Prestador();
                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                practica.setCodigo(rs.getInt("codigo"));
                orden.setCodigo(practica);
                afil.setNombre(rs.getString("afiliado_nombre"));
                afil.setApellido(rs.getString("afiliado_apellido"));
                orden.setAfiliado(afil);
                prestador.setNombre(rs.getString("prestador_nombre"));
                prestador.setApellido(rs.getString("prestador_apellido"));
                orden.setPrestador(prestador);
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));
                ordenes.add(orden);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla " + ex);
        }

        return ordenes;

    }

    public List<Orden> listarOrdenesPorFecha(Date fechaEmision) {
        List<Orden> ordenes = new ArrayList();
        String sql = "SELECT o.idOrden, o.fecha_Emision, o.codigo, a.nombre AS afiliado_nombre, a.apellido AS afiliado_apellido, p.nombre AS prestador_nombre, p.apellido AS prestador_apellido, o.fecha_Vencimiento, o.formaPago "
                + "FROM orden o "
                + "JOIN afiliado a ON o.Afiliado = a.idAfiliado "
                + "JOIN prestador p ON o.Prestador = p.idPrestador "
                + "WHERE o.fecha_Emision = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, fechaEmision);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orden orden = new Orden();
                Practica practica = new Practica();
                Afiliado afil = new Afiliado();
                Prestador prestador = new Prestador();
                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaEmision(rs.getDate("fecha_Emision"));
                practica.setCodigo(rs.getInt("codigo"));
                orden.setCodigo(practica);
                afil.setNombre(rs.getString("afiliado_nombre"));
                afil.setApellido(rs.getString("afiliado_apellido"));
                orden.setAfiliado(afil);
                prestador.setNombre(rs.getString("prestador_nombre"));
                prestador.setApellido(rs.getString("prestador_apellido"));
                orden.setPrestador(prestador);
                orden.setFechaVencimiento(rs.getDate("fecha_Vencimiento"));
                orden.setFormaPago(rs.getString("formaPago"));
                ordenes.add(orden);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla " + ex);
        }

        return ordenes;

    }

   
}
