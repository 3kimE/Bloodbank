package controlleurs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



import application.Connexionmysql;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControlleur implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
    @FXML
    private Button btn_logni;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_username;
    private Parent fxml;
    @FXML
    void OpenHome() {
    	String nom=txt_username.getText();
    	String pass=txt_password.getText();
    	
    	String sql ="select Username,Password from admin";
    	
    	try {
			st = cnx.prepareStatement(sql);
			result= st.executeQuery();
			
			if(result.next()) {
				
		    	if(nom.equals(result.getString("Username"))&& pass.equals(result.getString("Password"))) {
		    	    closeStage();
		    		System.out.println("bien");
		    		Stage home=new Stage();
		    	    
		    		try {
		    			fxml= FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"));
		    			Scene scene =new Scene(fxml);
		    			home.setScene(scene);
		    			home.setResizable(false);
		    			home.show();
		    			
		    		} catch(IOException e) {
		    			e.printStackTrace();
		    		}
		    		
		    	}else {
		    		Alert alert = new Alert(AlertType.ERROR,"Username Or Password is incorrect!",javafx.scene.control.ButtonType.OK);
		    		alert.showAndWait();
		    	}
				
				
			}
			
			
			
	    	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   
    
    }

    public void closeStage() { 	
    		((Stage)  txt_username.getScene().getWindow()).close();	
	}

	@FXML
    void SendPassword() {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx=Connexionmysql.connecxionBD();
		
	}

}
