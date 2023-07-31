package br.com.first.function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.first.dal.ConnectionModel;

public class NewPasteLogic {
	public void NewPaste() {
		Connection connect = ConnectionModel.connector();
		String nomeArquivo = ("dados_banco_MW.txt");
	    String query = "SELECT * FROM users";
	    try (Statement stmt = connect.createStatement();
	    	ResultSet resultSet = stmt.executeQuery(query);
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
	    	while (resultSet.next()) {
	        	String colunaId = resultSet.getString("idusers");
	        	String colunaUser = resultSet.getString("usuario");
	        	String colunaLogin = resultSet.getString("login");
	        	String colunaSenha = resultSet.getString("senha");
	        	String colunaFone = resultSet.getString("fone");
	        	String coluna2Email = resultSet.getString("email");
	        	String colunaPerfil = resultSet.getString("perfil");
	           	writer.write(colunaId + "\t" + colunaUser + "\t" + colunaLogin + "\t" + colunaSenha + "\t" 
	           			+ colunaFone + "\t" + coluna2Email + "\t" + colunaPerfil + "\n");
	       	}
	        System.out.println("Arquivo criado com sucesso!");
	    } catch (SQLException | IOException e) {
	    	e.printStackTrace();
	    }
	}
}