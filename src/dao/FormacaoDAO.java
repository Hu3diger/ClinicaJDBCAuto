package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Formacao;

/**
 *
 * @author martin_ruediger
 */
public class FormacaoDAO extends AbstractDAO<Formacao>{

    public FormacaoDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO formacao (nome) VALUES (?)";
        this.SQL_UPDATE = "UPDATE formacao SET nome=? WHERE id=?";
    }
    
    @Override
    public Formacao fillObject(ResultSet rs) throws SQLException {
        Formacao formacao = new Formacao();
        formacao.setId(rs.getInt("id"));
        formacao.setNome(rs.getString("nome"));
        return formacao;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, Formacao form) throws SQLException {
        int ParameterIndex = 1;
        stmt.setString(ParameterIndex++, form.getNome());
        return ParameterIndex;
    }
    
}
