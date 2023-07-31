package br.com.first.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.first.dal.ConnectionModel;

public class UpdateUserLogic {
	private JTextField textIDUsersAdmin;
    private JTextField textUsernameAdmin;
    private JTextField textLoginAdmin;
    private JTextField textPasswordAdmin;
    private JTextField textFoneAdmin;
    private JTextField textEmailAdmin;
    private JComboBox<String> comboBoxPerfilAdmin;
    
    public void Logic(JTextField textIDUsersAdmin,JTextField textUsernameAdmin, JTextField textLoginAdmin, JTextField textPasswordAdmin, JTextField textFoneAdmin, JTextField textEmailAdmin, JComboBox<String> comboBoxPerfilAdmin) {
    	this.textIDUsersAdmin = textIDUsersAdmin;
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
	public void EditarUsuario() {
	    String editUsuarioSql = "UPDATE users SET usuario = ?, login = ?, senha = ?, fone = ?, email = ?, perfil = ? WHERE idusers = ?";
	    String ifIdExistSql = "SELECT * FROM users WHERE idusers = ?";
	    try {
	        String id = textIDUsersAdmin.getText();
	        pst = connect.prepareStatement(ifIdExistSql);
	        pst.setString(1, id);
	        rs = pst.executeQuery();
	        if (textIDUsersAdmin.getText().equals("1")) {
	        	JOptionPane.showMessageDialog(null, "The main Administrator cannot be changed.");
	        } else {
	        	if (rs.next()) {
		            pst = connect.prepareStatement(editUsuarioSql);
		            pst.setString(1, textUsernameAdmin.getText());
		            pst.setString(2, textLoginAdmin.getText());
		            pst.setString(3, textPasswordAdmin.getText());
		            pst.setString(4, textFoneAdmin.getText());
		            pst.setString(5, textEmailAdmin.getText());
		            int selectedIndex = comboBoxPerfilAdmin.getSelectedIndex();
		            if (selectedIndex == 1) {
		                pst.setString(6, "Administrator");
		            } else {
		                pst.setString(6, "User");
		            }
		            pst.setString(7, id);
		            int rowsAffected = pst.executeUpdate();
		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(null, "User updated successfully.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to update user.");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Invalid user ID. Please enter a valid ID.");
		        }
	        }
	    } 
	    catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "It is not possible to edit the user.");
	    }
	}
}