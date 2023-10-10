package accesoData;

import Entidades.Afiliado;
import Entidades.Orden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class OrdenData {

    private Connection con = null;

    public OrdenData() {
        con = Conexion.getConexion();
    }
    
    
    public void nuevaOrden(Orden orden) {

        String sql = "INSERT INTO orden(codigo, afiliado, prestador, formaPago, fechaEmision, fechaVencimiento)"
                + "VALUES(? ,?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orden.getCodigo().getCodigo());
            ps.setInt(2, orden.getAfiliado().getIdAfiliado());
            ps.setInt(3, orden.getPrestador().getIdPrestador());
            ps.setString(4, orden.getFormaPago());
            ps.setDate(5, orden.getFechaEmision());
            ps.setDate(6, orden.getFechaVencimiento());
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

}
