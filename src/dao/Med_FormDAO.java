package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.med_form;

/**
 *
 * @author martin_ruediger
 */
public class Med_FormDAO extends AbstractDAO<med_form>{

    public Med_FormDAO() {
        super();
        this.SQL_CREATE = "INSERT INTO medico_formacao (formacao,medico_crm) VALUES (?,?)";
        this.SQL_UPDATE = "UPDATE medico_formacao SET formacao=?, medico_crm=? WHERE id=?";
    }

    @Override
    public med_form fillObject(ResultSet rs) throws SQLException {
        med_form medform = new med_form();
        medform.setId(rs.getInt("id"));
        medform.setFormacao(new FormacaoDAO().findById(rs.getInt("formacao")));
        medform.setMedico(new MedicoDAO().findById(rs.getInt("medico_crm")));
        return medform;
    }

    @Override
    public int bindingObject(PreparedStatement stmt, med_form medform) throws SQLException {
        int ParameterIndex = 1;
        stmt.setInt(ParameterIndex++, medform.getFormacao().getId());
        stmt.setInt(ParameterIndex++, medform.getMedico().getId());
        return ParameterIndex;
    }
    
    
    
}
