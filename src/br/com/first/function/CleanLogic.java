package br.com.first.function;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CleanLogic {
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
    public void Limpar () {
		textIDUsersAdmin.setText("");
        textUsernameAdmin.setText("");
        textLoginAdmin.setText("");
        textPasswordAdmin.setText("");
        textFoneAdmin.setText("");
        textEmailAdmin.setText("");
        comboBoxPerfilAdmin.setSelectedIndex(0);
	}
}