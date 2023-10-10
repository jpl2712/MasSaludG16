package accesoData;

import Entidades.Especialidad;
import Entidades.Prestador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PrestadorData {

      private Connection con = null;
    private Object prestador;

    public PrestadorData() {
        con = Conexion.getConexion();

    }
    
    public void guardarPrestador(Prestador prestador) {

        String sql = "INSERT INTO prestador( nombre, apellido, dni, activo, especialidad, matricula) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, prestador.getApellido());
                ps.setString(2, prestador.getNombre());
                ps.setInt(3, prestador.getDni());
                ps.setBoolean(4, prestador.isActivo());
                ps.setInt(5, prestador.getEspecialidad().getIdEspecialidad());
                ps.setInt(6, prestador.getMatricula());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    prestador.setIdPrestador(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Prestador Guardado");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestador");
        }
    }
    
    public void modificarPrestador(Prestador prestador){

        String sql = "UPDATE prestador SET apellido = ?, nombre = ?,dni = ?, activo = ?, especialidad = ?, matricula = ? "
                + "WHERE idPrestador = ?";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, prestador.getApellido());
            ps.setString(2, prestador.getNombre());
            ps.setInt(3, prestador.getDni());
            ps.setBoolean(4, true);
            ps.setInt(5, prestador.getEspecialidad().getIdEspecialidad());
            ps.setInt(6, prestador.getMatricula());
            ps.setInt(7, prestador.getIdPrestador());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Prestador modificado");
            } else System.out.println("error");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestador");
        }
    }
    
    public void eliminarPrestador(int id) {

        String sql = "UPDATE prestador SET activo = 0 WHERE idPrestador = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Prestador eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestador");
        }
    }
    
    
    public Prestador buscarPrestadorPorDni(int id) {
        String sql = "SELECT idPrestador, apellido, nombre, dni, activo, especialidad, matricula FROM prestador"
                + "WHERE idPrestador = ?";
        Prestador prestador = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql); 
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    prestador = new Prestador();
                    Especialidad esp = new Especialidad();
                    prestador.setIdPrestador(rs.getInt("idPrestador"));
                    prestador.setApellido(rs.getString("apellido"));
                    prestador.setNombre(rs.getString("nombre"));
                    prestador.setDni(rs.getInt("dni"));
                    prestador.setActivo(rs.getBoolean("true"));
                    esp.setIdEspecialidad(rs.getInt("especialidad"));
                    prestador.setEspecialidad(esp);
                    prestador.setMatricula(rs.getInt("matricula"));
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese prrstador");
                }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestador");        }

        return prestador;

    }

}
