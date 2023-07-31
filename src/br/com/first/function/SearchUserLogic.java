package br.com.first.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.first.dal.ConnectionModel;

public class SearchUserLogic {
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
    public boolean ConsultaUsuario() {
	    String consultaSql = "SELECT * FROM users WHERE 0=0";
	    if (!textIDUsersAdmin.getText().equals("")) {
	    	consultaSql += " AND idusers = ?";
	    } 
	    if (!textUsernameAdmin.getText().equals("")) {
	    	consultaSql += " AND usuario = ?";
	    } 
	    if (!textLoginAdmin.getText().equals("")) {
	    	consultaSql += " AND login = ?";
	    } 
	    if(!textPasswordAdmin.getText().equals("")) {
	    	consultaSql += " AND senha = ?";
	    }
	    if(!textFoneAdmin.getText().equals("")) {
	    	consultaSql += " AND fone = ?";
	    }
		if(!textEmailAdmin.getText().equals("")) {
			consultaSql += " AND email = ?";
		}
		if(comboBoxPerfilAdmin.getSelectedItem().equals("1") || comboBoxPerfilAdmin.getSelectedItem().equals("2")) {
			consultaSql += " AND perfil = ?";
	    }
		if (consultaSql.equals("SELECT * FROM users WHERE 0=0")) {
			JOptionPane.showMessageDialog(null,"No information.\nCheck the filled informations.",
                    "Warning!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
		        pst = connect.prepareStatement(consultaSql);
			    int contador = 1;
			    if (!textIDUsersAdmin.getText().equals("")) {
			        pst.setString(contador, textIDUsersAdmin.getText());
			        contador++;
				} if (!textUsernameAdmin.getText().equals("")) {
					pst.setString(contador, textUsernameAdmin.getText());
				    contador++;
				} if (!textLoginAdmin.getText().equals("")) {
				    pst.setString(contador, textLoginAdmin.getText());
				    contador++;
				} if (!textPasswordAdmin.getText().equals("")) {
					pst.setString(contador, textPasswordAdmin.getText());
				    contador++;
				} if (!textFoneAdmin.getText().equals("")) {
					pst.setString(contador, textFoneAdmin.getText());
				    contador++;
				} if (!textEmailAdmin.getText().equals("")) {
					pst.setString(contador, textEmailAdmin.getText());
				    contador++;
				} if (comboBoxPerfilAdmin.getSelectedItem().equals("1") || comboBoxPerfilAdmin.getSelectedItem().equals("2")) {
				    pst.setString(contador, comboBoxPerfilAdmin.getSelectedItem().toString());
				    contador++;
				}
		        rs = pst.executeQuery();
		        if (rs.next()) {
		            textIDUsersAdmin.setText(rs.getString(1));
		            textUsernameAdmin.setText(rs.getString(2));
		            textLoginAdmin.setText(rs.getString(3));
		            textPasswordAdmin.setText(rs.getString(4));
		            textFoneAdmin.setText(rs.getString(5));
		            textEmailAdmin.setText(rs.getString(6));
		            if (rs.getString(7).equals("Administrator")) {
		                comboBoxPerfilAdmin.setSelectedIndex(1);
		            } else {
		                comboBoxPerfilAdmin.setSelectedIndex(2);
		            }
		            return true;
		        } else {
		        	JOptionPane.showMessageDialog(null,"User not found.\nCheck the filled informations.",
		                    "Warning!", JOptionPane.INFORMATION_MESSAGE);
		        	return false;
		        }
		    }
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "It is not possible to search for the user.");
	     	}
		}
		return false;
	}
}