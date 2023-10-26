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
                ps.close();
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
            ps.close();

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
            
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestador");
        }
        
    }
    
    
    public Prestador buscarPrestadorPorDni(int dni) {
        String sql = "SELECT idPrestador, nombre, apellido, dni, activo, especialidad, matricula FROM prestador"
                + " WHERE dni = ?";
        Prestador prestador = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql); 
                ps.setInt(1, dni);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    prestador = new Prestador();
                    Especialidad esp = new Especialidad();
                    prestador.setIdPrestador(rs.getInt("idPrestador"));
                    prestador.setNombre(rs.getString("nombre"));
                    prestador.setApellido(rs.getString("apellido"));
                    prestador.setDni(rs.getInt("dni"));
                    prestador.setActivo(rs.getBoolean("activo"));
                    esp.setIdEspecialidad(rs.getInt("especialidad"));
                    prestador.setEspecialidad(esp);
                    prestador.setMatricula(rs.getInt("matricula"));
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese prestador");
                }
                
                ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,  "Error al acceder a la tabla prestador" + ex);        }
            
        return prestador;

    }

    public List<Prestador> listarPrestadores() {

        String sql = "SELECT `idPrestador`, `nombre`, `apellido` FROM `prestador` WHERE activo = 1 ";
        
        ArrayList<Prestador> prestadores = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestador pres = new Prestador();
                pres.setIdPrestador(rs.getInt("idPrestador"));
                pres.setNombre(rs.getString("nombre"));
                pres.setApellido(rs.getString("apellido"));
                
                pres.setActivo(true);

                prestadores.add(pres);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestador");
        }

        return prestadores;
    }
    
    
    public List<Prestador> listarPrestadoresActivos() {

        String sql = "SELECT idPrestador, nombre, apellido, dni, especialidad, matricula  "
                + "FROM prestador WHERE activo = 1";
        ArrayList<Prestador> prestadores = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestador p = new Prestador();
                Especialidad esp = new Especialidad();
         
                p.setIdPrestador(rs.getInt("idPrestador"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDni(rs.getInt("dni"));
                //esp.setIdEspecialidad(rs.getInt("especialidad"));
                p.setMatricula(rs.getInt("matricula"));
                p.setActivo(true);

                prestadores.add(p);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "!!!Error al acceder a la tabla prestador");
        }

        return prestadores;
    }
    
    public List<Prestador> listarPrestadoresInactivos() {

        String sql = "SELECT idPrestador, nombre, apellido, dni, especialidad, matricula  "
                + "FROM prestador WHERE activo = 0";
        ArrayList<Prestador> prestadores = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestador p = new Prestador();
                Especialidad esp = new Especialidad();
                EspecialidadData espD = new EspecialidadData();
                p.setIdPrestador(rs.getInt("idPrestador"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDni(rs.getInt("dni"));
                //p.setEpecialidad.getEspecialidad(respD.buscarEspecialidad(0)
                p.setMatricula(rs.getInt("matricula"));   
                p.setActivo(false);

                prestadores.add(p);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "&&&&Error al acceder a la tabla prestador");
        }

        return prestadores;
    }

}
