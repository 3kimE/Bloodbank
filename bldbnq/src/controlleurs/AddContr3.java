package controlleurs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Connexionmysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddContr3  implements Initializable {
	Connection cnx;
	
	public PreparedStatement st;
	public ResultSet result;
	 
	    private AnchorPane root;

		 @FXML
	    private  Parent fxml ;
		  @FXML
		    private Label Total_dm;

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
	    private ComboBox<String>bloodtype;
	  String[] bloood={"A+","A-","B+","B-","O+","O-","AB+","AB-"};
	  @FXML
	    private TextField litre;

	  // add litre
	  

	   @FXML
	    void add_litre(ActionEvent event) throws IOException {
	    	int type=0;

	    	
	  	  try{
	            st = cnx.prepareStatement("select * from bloodchar where type = ?");
	            st.setString(1,bloodtype.getValue());
	            ResultSet rs = st.executeQuery();

	            while (rs.next()) {
	            	System.out.println(rs.getInt(3));
	            	System.out.println(litre.getText());
	            	
	            	int d = Integer.valueOf(litre.getText())+rs.getInt(3);
	            	System.out.println(d);
	            	
	            	st=cnx.prepareStatement("UPDATE bloodchar SET QuantityL= ? WHERE type = ?");
	            	st.setString(1,String.valueOf(d));
	            	st.setString(2,bloodtype.getValue());
	            	st.execute();
	            
	            }

	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	  

			Alert alert= new Alert(AlertType.CONFIRMATION,"Blood was added.", javafx.scene.control.ButtonType.OK);
			 Close_btn(event);
			alert.showAndWait();
		
	  	  }
	   
	   
	  
	   @FXML
	    void Close_btn(ActionEvent event) throws IOException {
	    	Stage stage1;
	    	stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	
	    	stage1.close();
	    	 

	    }
	  
	  
	  @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			cnx= Connexionmysql.connecxionBD();
			bloodtype.getItems().addAll(bloood);
			
			 
		}
	 
	
}
