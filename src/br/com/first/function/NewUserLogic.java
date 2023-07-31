package br.com.first.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.com.first.dal.ConnectionModel;

public class NewUserLogic {
    private JTextField textUsernameAdmin;
    private JTextField textLoginAdmin;
    private JTextField textPasswordAdmin;
    private JTextField textFoneAdmin;
    private JTextField textEmailAdmin;
    private JComboBox<String> comboBoxPerfilAdmin;
    
    public void Logic(JTextField textUsernameAdmin, JTextField textLoginAdmin, JTextField textPasswordAdmin, JTextField textFoneAdmin, JTextField textEmailAdmin, JComboBox<String> comboBoxPerfilAdmin) {
        this.textUsernameAdmin = textUsernameAdmin;
        this.textLoginAdmin = textLoginAdmin;
        this.textPasswordAdmin = textPasswordAdmin;
        this.textFoneAdmin = textFoneAdmin;
        this.textEmailAdmin = textEmailAdmin;
        this.comboBoxPerfilAdmin = comboBoxPerfilAdmin;
    }
    Connection connect = ConnectionModel.connector();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void NovoUsuario() {
	    String usuario = textUsernameAdmin.getText();
	    String login = textLoginAdmin.getText();
	    String senha = textPasswordAdmin.getText();
	    String fone = textFoneAdmin.getText();
	    String email = textEmailAdmin.getText();
	    String perfil = comboBoxPerfilAdmin.getSelectedItem().toString();
	    if (usuario.isEmpty() || login.isEmpty() || senha.isEmpty() || fone.isEmpty() || email.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please fill in all the required fields.");
	        return;
	    }
	    String novoUsuarioSql = "INSERT INTO users (usuario, login, senha, fone, email, perfil) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        pst = connect.prepareStatement(novoUsuarioSql);
	        pst.setString(1, usuario);
	        pst.setString(2, login);
	        pst.setString(3, senha);
	        pst.setString(4, fone);
	        pst.setString(5, email);
	        if (perfil.equals("Administrator")) {
	            pst.setString(6, "Administrator");
	        } else {
	            pst.setString(6, "User");
	        }
	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "New user entered successfully.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////	            Limpar();
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to insert new user.");
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Failed to insert new user.");
	    }
	}    
}
