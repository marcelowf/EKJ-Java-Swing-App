package br.com.first.screen;

import br.com.first.function.*;
import br.com.first.screen.WindowFirst;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class WindowFirst {

	private RemoveUserLogic removeUserFunction;
	private NewUserLogic newUserFunction;
	private SearchUserLogic searchUserFunction;
	private UpdateUserLogic updateUserFunction;
	private CleanLogic cleanFunction;
	private NewPasteLogic newPasteFunction;
    private JFrame frame;
	private JLabel lblIDUsersAdmin;
    private JLabel lblUsernameAdmin;
	private JLabel lblLoginAdmin;
    private JLabel lblPasswordAdmin;
	private JLabel lblFoneAdmin;
	private JLabel lblEmailAdmin;
	private JLabel lblPerfilAdmin;
	private JTextField textFoneAdmin;
	private JTextField textEmailAdmin;
	private JTextField textIDUsersAdmin;
	private JTextField textUsernameAdmin;
	private JTextField textLoginAdmin;
	private JTextField textPasswordAdmin;
	private JComboBox<String> comboBoxPerfilAdmin;
	private JPanel panelBtnsAdmin;
	private JButton btnNewUser;
    private JButton btnRemoveUser;
    private JButton btnEditUser;
    private JButton btnSerchUser;
    private JButton btnNewPaste;
    private JButton btnCleanUser;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowFirst window = new WindowFirst();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public WindowFirst() {
        initialize();
        removeUserFunction.Logic(textIDUsersAdmin, textUsernameAdmin, textLoginAdmin, textPasswordAdmin, textFoneAdmin, textEmailAdmin);
        newUserFunction.Logic( textUsernameAdmin, textLoginAdmin, textPasswordAdmin, textFoneAdmin, textEmailAdmin, comboBoxPerfilAdmin);
        searchUserFunction.Logic(textIDUsersAdmin, textUsernameAdmin, textLoginAdmin, textPasswordAdmin, textFoneAdmin, textEmailAdmin, comboBoxPerfilAdmin);
        updateUserFunction.Logic(textIDUsersAdmin, textUsernameAdmin, textLoginAdmin, textPasswordAdmin, textFoneAdmin, textEmailAdmin, comboBoxPerfilAdmin);
        cleanFunction.Logic(textIDUsersAdmin, textUsernameAdmin, textLoginAdmin, textPasswordAdmin, textFoneAdmin, textEmailAdmin, comboBoxPerfilAdmin);
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void FromSettingsLabels (JLabel label) {
    	label.setFont(new Font("Tahoma", Font.PLAIN, 20));
    	label.setForeground(Color.WHITE);
        frame.getContentPane().add(label);
    }
    
    private void FromSettingsTextFields (JTextField field) {
    	field.setColumns(10);
    	frame.getContentPane().add(field);
    }
    
    private void BtnSettings (JButton button) {
        panelBtnsAdmin.add(button);
    	button.setOpaque(false);
    	button.setContentAreaFilled(false);
    	button.setBorder(null);
    	button.setPreferredSize(new Dimension(60, 50));
    }

    private void IconSettings (JButton button , String URL) {
    	ImageIcon NameIcon = new ImageIcon(WindowFirst.class.getResource(URL));
        Image scaledImage = NameIcon.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        button.setIcon(scaledIcon);
    }
    
    public void initialize() {
    	
    	removeUserFunction = new RemoveUserLogic();
        newUserFunction = new NewUserLogic();
        searchUserFunction = new SearchUserLogic();
        updateUserFunction = new UpdateUserLogic();
        cleanFunction = new CleanLogic();
        newPasteFunction = new NewPasteLogic();
        
        		
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(WindowFirst.class.getResource("/br/com/first/icon/Logo.png")));
        frame.getContentPane().setBackground(new Color(128, 128, 128));
        frame.setSize(472, 419);
        frame.setBounds(100, 100, 472, 419);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Title");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        
        lblIDUsersAdmin = new JLabel("ID User:");
        lblIDUsersAdmin.setBounds(33, 33, 114, 27);
        FromSettingsLabels(lblIDUsersAdmin);
        
        lblUsernameAdmin = new JLabel("Username:");
        lblUsernameAdmin.setBounds(33, 71, 114, 27);
        FromSettingsLabels(lblUsernameAdmin);
        
        lblLoginAdmin = new JLabel("Login:");
        lblLoginAdmin.setBounds(33, 109, 114, 27);
        FromSettingsLabels(lblLoginAdmin);
        
        lblPasswordAdmin = new JLabel("Password:");
        lblPasswordAdmin.setBounds(33, 147, 114, 27);
        FromSettingsLabels(lblPasswordAdmin);
        
        lblFoneAdmin = new JLabel("Fone:");
        lblFoneAdmin.setBounds(33, 185, 114, 27);
        FromSettingsLabels(lblFoneAdmin);
        
        lblEmailAdmin = new JLabel("Email:");
        lblEmailAdmin.setBounds(33, 224, 114, 27);
        FromSettingsLabels(lblEmailAdmin);
        
        lblPerfilAdmin = new JLabel("Perfil:");
        lblPerfilAdmin.setBounds(33, 262, 114, 27);
        FromSettingsLabels(lblPerfilAdmin);
        
        textIDUsersAdmin = new JTextField();
        textIDUsersAdmin.setBounds(157, 33, 265, 27);
        FromSettingsTextFields (textIDUsersAdmin);
        
        textUsernameAdmin = new JTextField();
        textUsernameAdmin.setBounds(157, 71, 265, 27);
        FromSettingsTextFields (textUsernameAdmin);
        
        textLoginAdmin = new JTextField();
        textLoginAdmin.setBounds(157, 109, 265, 27);
        FromSettingsTextFields (textLoginAdmin);
        
        textPasswordAdmin = new JTextField();
        textPasswordAdmin.setBounds(157, 147, 265, 27);
        FromSettingsTextFields (textPasswordAdmin);
        
        textFoneAdmin = new JTextField();
        textFoneAdmin.setBounds(157, 185, 265, 27);
        FromSettingsTextFields (textFoneAdmin);
        
        textEmailAdmin = new JTextField();
        textEmailAdmin.setBounds(157, 224, 265, 27);
        FromSettingsTextFields (textEmailAdmin);
        
        comboBoxPerfilAdmin = new JComboBox<>();
        comboBoxPerfilAdmin.addItem("Select");
        comboBoxPerfilAdmin.addItem("Administrator");
        comboBoxPerfilAdmin.addItem("User");
        comboBoxPerfilAdmin.setBounds(157, 261, 265, 28);
        frame.getContentPane().add(comboBoxPerfilAdmin);

        panelBtnsAdmin = new JPanel();
        panelBtnsAdmin.setBackground(new Color(173, 173, 173));
        panelBtnsAdmin.setBounds(0, 320, 456, 60);
        frame.getContentPane().add(panelBtnsAdmin);
        
        btnNewUser = new JButton();
        btnNewUser.setBounds(14, 13, 40, 40);
        btnNewUser.setToolTipText("New User");
        btnNewUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	newUserFunction.NovoUsuario();
        	}
        });
        IconSettings ( btnNewUser,"/br/com/first/icon/NewUser.png");
        BtnSettings (btnNewUser);
        
        btnRemoveUser = new JButton();
        btnRemoveUser.setBounds(73, 13, 40, 40);
        btnRemoveUser.setToolTipText("Remove User");
        btnRemoveUser.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	    	removeUserFunction.RemoverUsuario();
        	}
        });
        IconSettings ( btnRemoveUser,"/br/com/first/icon/RemoveUser.png");
        BtnSettings (btnRemoveUser);
        
        btnEditUser = new JButton();
        btnEditUser.setBounds(136, 16, 33, 33);
        btnEditUser.setToolTipText("Edit User");
        btnEditUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	updateUserFunction.EditarUsuario();
        	}
        });
        IconSettings ( btnEditUser,"/br/com/first/icon/EditUser.png");
        BtnSettings (btnEditUser);
        
        btnSerchUser = new JButton();
        btnSerchUser.setBounds(191, 17, 33, 33);
        btnSerchUser.setToolTipText("Serch User");
        btnSerchUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	searchUserFunction.ConsultaUsuario();
        	}
        });
        IconSettings ( btnSerchUser,"/br/com/first/icon/SerchUser.png");
        BtnSettings (btnSerchUser);
        
        btnNewPaste = new JButton();
        btnNewPaste.setBounds(235, 8, 50, 50);
        btnNewPaste.setToolTipText("New Paste");
        btnNewPaste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            newPasteFunction.NewPaste();
            }
        });
        IconSettings ( btnNewPaste,"/br/com/first/icon/NewPaste.png");
        BtnSettings (btnNewPaste);
        
        btnCleanUser = new JButton();
        btnCleanUser.setBounds(235, 8, 50, 50);
        btnCleanUser.setToolTipText("Clear Fields");
        btnCleanUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            cleanFunction.Limpar();
            }
        });
        IconSettings (btnCleanUser , "/br/com/first/icon/Clean.png");
        BtnSettings (btnCleanUser);
    }
}