package br.com.first.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.first.dal.ConnectionModel;

public class RemoveUserLogic {
	private JTextField textIDUsersAdmin;
    private JTextField textUsernameAdmin;
    private JTextField textLoginAdmin;
    private JTextField textPasswordAdmin;
    private JTextField textFoneAdmin;
    private JTextField textEmailAdmin;
    
    public void Logic(JTextField textIDUsersAdmin,JTextField textUsernameAdmin, JTextField textLoginAdmin, JTextField textPasswordAdmin, JTextField textFoneAdmin, JTextField textEmailAdmin) {
    	this.textIDUsersAdmin = textIDUsersAdmin;
        this.textUsernameAdmin = textUsernameAdmin;
        this.textLoginAdmin = textLoginAdmin;
        this.textPasswordAdmin = textPasswordAdmin;
        this.textFoneAdmin = textFoneAdmin;
        this.textEmailAdmin = textEmailAdmin;
    }
    Connection connect = ConnectionModel.connector();
    PreparedStatement pst = null;
    ResultSet rs = null;
    public void RemoverUsuario() {
	    if ("admin".equals(textLoginAdmin.getText()) && "admin".equals(textPasswordAdmin.getText())) {
	        JOptionPane.showMessageDialog(null, "Unable to remove user Administrator main.");
	        return;
	    }
	    int resposta = JOptionPane.showConfirmDialog(null, "Do you want to remove the user permanently?", "Confirmação", JOptionPane.YES_NO_OPTION);
	    if (resposta == JOptionPane.YES_OPTION) {
	        String removerUsuarioSql = "DELETE FROM users WHERE idusers = ? OR usuario = ? OR login = ? OR senha = ? OR fone = ? OR email = ?";
	        try {
	            pst = connect.prepareStatement(removerUsuarioSql);
	            pst.setString(1, textIDUsersAdmin.getText());
	            pst.setString(2, textUsernameAdmin.getText());
	            pst.setString(3, textLoginAdmin.getText());
	            pst.setString(4, textPasswordAdmin.getText());
	            pst.setString(5, textFoneAdmin.getText());
	            pst.setString(6, textEmailAdmin.getText());
	            int rowsAffected = pst.executeUpdate();
	            if (rowsAffected > 0) {
	            	JOptionPane.showMessageDialog(null, "User Removed Successfully.");
//	            	Limpar();
	            } else {
	            	JOptionPane.showMessageDialog(null, "It is not possible to remove the user\nCheck the proper completion of the fields.");
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "It is not possible to remove the user.");
	        }
	    }
	}
}