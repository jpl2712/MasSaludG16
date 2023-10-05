package accesoData;

import Entidades.Afiliado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AfiliadoData {

    private Connection con = null;

    public AfiliadoData() {
        con = Conexion.getConexion();
    }

    public void nuevoAfiliado(Afiliado afiliado) {

        String sql = "INSERT INTO afiliado(nombre, apellido, dni, activo)"
                + "VALUES(? , ? , ? , ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, afiliado.getNombre());
            ps.setString(2, afiliado.getApellido());
            ps.setInt(3, afiliado.getDni());
            ps.setBoolean(4, afiliado.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                afiliado.setIdAfiliado(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Afiliado Guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }
    }

    public void modificarAfiliadoPorId(Afiliado afiliado) {

        String sql = "UPDATE afiliado SET nombre = ?, apellido = ?, dni = ? "
                + "WHERE idAfiliado = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, afiliado.getNombre());
            ps.setString(2, afiliado.getApellido());
            ps.setInt(3, afiliado.getDni());
            ps.setInt(4, afiliado.getIdAfiliado());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }
    }

    public void modificarAfiliadoPorDni(Afiliado afiliado) {

        String sql = "UPDATE afiliado SET nombre = ?, apellido = ? "
                + "WHERE dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, afiliado.getNombre());
            ps.setString(2, afiliado.getApellido());
            ps.setInt(3, afiliado.getDni());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }
    }

    public void bajaAfiliadoPorId(int id) {

        String sql = "UPDATE afiliado SET activo = 0 WHERE idAfiliado = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado dado de baja");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

    }

    public void altaAfiliadoPorId(int id) {

        String sql = "UPDATE afiliado SET activo = 1 WHERE idAfiliado = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado dado de alta");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

    }

    public void bajaAfiliadoPorDni(int dni) {

        String sql = "UPDATE afiliado SET activo = 0 WHERE dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado dado de baja");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

    }

    public void altaAfiliadoPorDni(int dni) {

        String sql = "UPDATE afiliado SET activo = 1 WHERE dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado dado de alta");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

    }

    public void eliminarAfiliadoPorId(int id) {

        String sql = "DELETE FROM afiliado WHERE idAfiliado = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado eliminado del sistema");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

    }

    public void eliminarAfiliadoPorDni(int dni) {

        String sql = "DELETE FROM afiliado WHERE dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Afiliado eliminado del sistema");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

    }
    
    /////////////////////////////////////////////////////////////////////
    
    public Afiliado buscarAfiliadoPorId(int id) {

        String sql = "SELECT idAfiliado, nombre, apellido, dni FROM afiliado WHERE idAfiliado = ? AND activo = 1";
        Afiliado afiliado = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                afiliado = new Afiliado();
                afiliado.setIdAfiliado(rs.getInt("idAfiliado"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setDni(rs.getInt("dni"));
                afiliado.setActivo(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese afiliado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

        return afiliado;
    }
    
    public Afiliado buscarAfiliadoPorDni(int dni) {

        String sql = "SELECT idAfiliado, nombre, apellido, dni FROM afiliado WHERE dni = ? AND activo = 1";
        Afiliado afiliado = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                afiliado = new Afiliado();
                afiliado.setIdAfiliado(rs.getInt("idAfiliado"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setDni(rs.getInt("dni"));
                afiliado.setActivo(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese afiliado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

        return afiliado;
    }
    
    public Afiliado buscarAfiliadoGeneralPorDni(int dni) {

        String sql = "SELECT idAfiliado, nombre, apellido, dni, activo FROM afiliado WHERE dni = ? ";
        Afiliado afiliado = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                afiliado = new Afiliado();
                afiliado.setIdAfiliado(rs.getInt("idAfiliado"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setDni(rs.getInt("dni"));
                afiliado.setActivo(rs.getBoolean("activo"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese afiliado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

        return afiliado;
    }

    public Afiliado buscarAfiliadoGeneralPorId(int id) {

        String sql = "SELECT idAfiliado, nombre, apellido, dni, activo FROM afiliado WHERE idAfiliado = ? ";
        Afiliado afiliado = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                afiliado = new Afiliado();
                afiliado.setIdAfiliado(rs.getInt("idAfiliado"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setDni(rs.getInt("dni"));
                afiliado.setActivo(rs.getBoolean("activo"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese afiliado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

        return afiliado;
    }
    
    public List<Afiliado> listarAfiliadosActivos() {

        String sql = "SELECT idAfiliado, nombre, apellido, dni  FROM afiliado WHERE activo = 1";
        ArrayList<Afiliado> afiliados = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setIdAfiliado(rs.getInt("idAfiliado"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setDni(rs.getInt("dni"));
                
                afiliado.setActivo(true);

                afiliados.add(afiliado);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

        return afiliados;
    }
    
    public List<Afiliado> listarAfiliadosInactivos() {

        String sql = "SELECT idAfiliado, nombre, apellido, dni  FROM afiliado WHERE activo = 0";
        ArrayList<Afiliado> afiliados = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setIdAfiliado(rs.getInt("idAfiliado"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setDni(rs.getInt("dni"));
                
                afiliado.setActivo(false);
   
                afiliados.add(afiliado);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla afiliado");
        }

        return afiliados;
    }
}