package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.quarto;

/**
 *
 * @author Martin_Ruediger
 */
public class QuartoDAO extends AbstractDAO<quarto>{

    public QuartoDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO quarto (andar,numero) VALUES (?,?)";
        this.SQL_UPDATE = "UPDATE quarto SET andar=?,numero=? WHERE id=?";
    }

    @Override
    public quarto fillObject(ResultSet rs) throws SQLException {
        quarto quarto = new quarto();
        quarto.setId(rs.getInt("id"));
        quarto.setAndar(rs.getInt("andar"));
        quarto.setNumero(rs.getInt("numero"));
        return quarto;
        
    }

    @Override
    public int bindingObject(PreparedStatement stmt, quarto quarto) throws SQLException {
        int ParameterIndex = 1;
        stmt.setInt(ParameterIndex++, quarto.getAndar());
        stmt.setInt(ParameterIndex++, quarto.getNumero());
        return ParameterIndex;
    }

}
