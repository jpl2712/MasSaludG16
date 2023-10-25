package accesoData;

import Entidades.Afiliado;
import Entidades.Especialidad;
import Entidades.Prestador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EspecialidadData {

    private Connection con = null;

    public EspecialidadData() {
        con = Conexion.getConexion();
    }

    public void guardarEspecialidad(Especialidad especialidad) {

        String sql = "INSERT INTO especialidad(especialidad) VALUES (?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, especialidad.getEspecialidad());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                especialidad.setIdEspecialidad(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Especialidad agregada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla");
        }

    }

    public void modificarEspecialidad(Especialidad especialidad) {

        String sql = "UPDATE especialidad SET especialidad = ?  WHERE idEspecialidad= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, especialidad.getEspecialidad());
            ps.setInt(2, especialidad.getIdEspecialidad());
            int devolucion = ps.executeUpdate();
            if (devolucion == 1) {
                JOptionPane.showMessageDialog(null, "Especialidad modificada");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }

    }

    public void borrarEspecialidad(int id) {

        String sql = " DELETE FROM especialidad WHERE idEspecialidad = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Borrada");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }

    }

    public List<Prestador> listarPrestadores(int id) {

        ArrayList<Prestador> prestadores = new ArrayList();

        String sql = "SELECT nombre, apellido, dni, matricula FROM prestador WHERE activo = 1 "
                + "AND especialidad = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestador prestador = new Prestador();
                prestador.setNombre(rs.getString("nombre"));
                prestador.setApellido(rs.getString("apellido"));
                prestador.setDni(rs.getInt("dni"));
                prestador.setMatricula(rs.getInt("matricula"));

                prestadores.add(prestador);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }
        return prestadores;

    }

    public List<Afiliado> listarPacientesPorEspecialidad(int id) {

        ArrayList<Afiliado> pacientes = new ArrayList();

        String sql = "SELECT afiliado.nombre, afiliado.apellido, afiliado.dni "
                + "FROM afiliado "
                + "JOIN orden ON orden.Afiliado = afiliado.idAfiliado "
                + "JOIN prestador ON prestador.idPrestador = orden.Prestador "
                + "JOIN especialidad ON especialidad.idEspecialidad = prestador.especialidad "
                + "WHERE especialidad.idEspecialidad = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setNombre(rs.getString("afiliado.nombre"));
                afiliado.setApellido(rs.getString("afiliado.apellido"));
                afiliado.setDni(rs.getInt("afiliado.dni"));

                pacientes.add(afiliado);

            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }

        return pacientes;
    }

    public Especialidad buscarEspecialidad(int id) {
        Especialidad especialidad = null;
        String sql = "SELECT idEspecialidad, especialidad FROM especialidad WHERE idEspecialidad = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setEspecialidad(rs.getString("especialidad"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }

        return especialidad;
    }

    public List<Especialidad> listarEspecialidades() {
        ArrayList<Especialidad> especialidades = new ArrayList();
        String sql = "SELECT idEspecialidad, especialidad FROM especialidad ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setEspecialidad(rs.getString("especialidad"));
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));

                especialidades.add(especialidad);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }
        return especialidades;
    }

    public Especialidad buscarEspecialidadPorNombre(String espec) {
        Especialidad especialidad = null;
        String sql = "SELECT idEspecialidad, especialidad FROM especialidad WHERE especialidad = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, espec);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setEspecialidad(rs.getString("especialidad"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex);
        }

        return especialidad;
    }

}
