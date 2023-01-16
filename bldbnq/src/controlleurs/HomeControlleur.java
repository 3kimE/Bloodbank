package controlleurs;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Connexionmysql;
import application.Main;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;





public class HomeControlleur implements Initializable{
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;

    @FXML
    private Label Total_dm;

    @FXML
    private Label totalReq;

	   @FXML
	    private Label Total_donor;
	   @FXML
	    private Label Total_patient;
    @FXML
    private Label dm_ABm;

    @FXML
    private Label dm_ABp;

    @FXML
    private Label dm_Am;

    @FXML
    private Label dm_Ap;

    @FXML
    private Label dm_Bm;
    @FXML
    private Label dm_Bp;

    @FXML
    private Label dm_Om;

    @FXML
    private Label dm_Op;

    @FXML
    private AnchorPane root;

	 @FXML
    private  Parent fxml ;
  
	
	 
	  
	   


	    @FXML
	    void BloodRequests(MouseEvent event) {
	    	try {
				fxml= FXMLLoader.load(getClass().getResource("/Interfaces/BloodRequest.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    }

	    @FXML
	    void BloodStock(MouseEvent event) {

	    }

	    @FXML
	    void Donations(MouseEvent event) {
	    	try {
				fxml= FXMLLoader.load(getClass().getResource("/Interfaces/Donations.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    }

	    @FXML
	    void Donor(MouseEvent event) {
	    	try {
				fxml= FXMLLoader.load(getClass().getResource("/Interfaces/Donor.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

	    }

	    @FXML
	    void Home(MouseEvent event) {
	    	try {
				fxml= FXMLLoader.load(getClass().getResource("/Interfaces/Accueil.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

	    }

   @FXML
	    void Patient(MouseEvent event) {
	    	try {
				fxml= FXMLLoader.load(getClass().getResource("/Interfaces/Patient.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	
	    }

	    
	    @FXML
	    void add_blood() {
	    	try {
				fxml= FXMLLoader.load(getClass().getResource("/Interfaces/add3.fxml"));
				Scene scene =new Scene(fxml);
				Stage home=new Stage();
				home.setScene(scene);
				home.setResizable(false);
				home.show();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
	    	
	    	

	    }
	   
	    
	  

	    
	    //affichage des informations de home
	    
	  
	  
  public void  Showblood() {
	  int A=0;
	    	
	  try{
         
          st = cnx.prepareStatement("select * from bloodchar");
          ResultSet rs = st.executeQuery();
          int i = 1;
          while (rs.next()) {
             if(rs.getString(2).equals("A+")) {
              dm_Ap.setText(rs.getString(3)); }
             if(rs.getString(2).equals("A-")) {
              dm_Am.setText(rs.getString(3));}
             if(rs.getString(2).equals("B+")) {
              dm_Bp.setText(rs.getString(3));}
             if(rs.getString(2).equals("B-")) {
              dm_Bm.setText(rs.getString(3));}
             if(rs.getString(2).equals("O+")) {
              dm_Op.setText(rs.getString(3));}
             if(rs.getString(2).equals("O-")) {
              dm_Om.setText(rs.getString(3));}
             if(rs.getString(2).equals("AB+")) {
              dm_ABp.setText(rs.getString(3));}
             if(rs.getString(2).equals("AB-")) {
              dm_ABm.setText(rs.getString(3));}
        	 
    
          }
          A = Integer.parseInt( dm_Ap.getText())+Integer.parseInt( dm_Am.getText())+Integer.parseInt( dm_Bp.getText())
          +Integer.parseInt( dm_Bm.getText())+Integer.parseInt( dm_Op.getText())+Integer.parseInt( dm_Om.getText())
          +Integer.parseInt( dm_ABp.getText())
         + Integer.parseInt( dm_ABm.getText());

        Total_dm.setText(String.valueOf(A));

      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
  }


	

  // count total donor
  public void  Showdonors() {
	  int A=0;
  	
	  try{
         
          st = cnx.prepareStatement("SELECT * from donor");
          ResultSet rs = st.executeQuery();

          while (rs.next()) {
             
           A++;
   
          }
          
          Total_donor.setText(String.valueOf(A));

      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
  }

  // count total patient
  public void  Showpatient() {
	  int A=0;
  	
	  try{
         
          st = cnx.prepareStatement("SELECT * from patient");
          ResultSet rs = st.executeQuery();

          while (rs.next()) {
             
           A++;
   
          }
          
          Total_patient.setText(String.valueOf(A));

      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
  }


  // count total Request
  public void  Showrequste() {
	  int A=0;
  	
	  try{
         
          st = cnx.prepareStatement("SELECT * from requste");
          ResultSet rs = st.executeQuery();

          while (rs.next()) {
             
           A++;
   
          }
          
          totalReq.setText(String.valueOf(A));

      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
  }


  
  
	    
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cnx= Connexionmysql.connecxionBD();
		 Showblood();
		 Showdonors();
		 Showpatient();
		 Showrequste();
	}

	

}
