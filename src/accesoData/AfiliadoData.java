package accesoData;

import Entidades.Afiliado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AfiliadoData {

    private Connection con = null;

    public AfiliadoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAfiliado(Afiliado afiliado) {

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

}
