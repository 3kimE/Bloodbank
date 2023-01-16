package controlleurs;
import java.io.IOException;

import models.Donor;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Connexionmysql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddContr  implements Initializable {
	 @FXML
	 private  Parent fxml ;
	 @FXML
	    private AnchorPane root;

	    @FXML
	    private ComboBox<String> bloodtype;
	    String[] bloood={"A+","A-","B+","B-","O+","O-","AB+","AB-"};
	    
   
	 @FXML
	    private TableColumn<Donor, Integer> id_table;


	 @FXML
	    private TableColumn<Donor, String> Action_table;


	    @FXML
	    private TableColumn<Donor, String> CIN_table;


	    @FXML
	    private Button add_donor;
	    @FXML
	    private Button Delete;

	    @FXML
	    private TableColumn<Donor, Integer> Mobile_table;

	    @FXML
	    private Button Update;

	    @FXML
	    private TableColumn<Donor, String> bloodtype_table;

	    @FXML
	    private TableColumn<Donor, String> Fullname_table;

	    @FXML
	    private TableColumn<Donor, String> gender_table;

	    @FXML
	    private TableView<Donor> table;
	    public ObservableList<Donor> data= FXCollections.observableArrayList(); 

	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;


    @FXML
    private TextField Mobile;
    @FXML
    private ComboBox<String> Action;
    String[] action= {"Donor","Patient"}
;    @FXML
    private TextField CIN;

    @FXML
    private TextField Fullname;

   
    @FXML
    private ComboBox<String> gender;
    String[] Gender={"Male","Female"};
    
    
  
	// add btn
 

	@FXML
    void add_donor(ActionEvent event) throws IOException  {
    	String Fullnamee= Fullname.getText();
    	String CINe= CIN.getText();
    	String bloodtypee= bloodtype.getValue();
    	String Mobilee= Mobile.getText();
    	String gendere= gender.getValue();
    	String Actione= Action.getValue();
    	
    	String sql =" insert into donor (Fullname,CIN,gender,Mobile,bloodtype,Action) values(?,?,?,?,?,?)";
    	
    	if(!Fullnamee.equals("") && !CINe.equals("")&&!bloodtypee.equals("")&&!Mobilee.equals("")
    			&&!gendere.equals("")&&!Actione.equals(""));
    	
		
    	{
    		
    	  	try {
    			st=cnx.prepareStatement(sql);
    			st.setString(1,Fullnamee);
    			st.setString(2,CINe);
    			st.setString(3,gendere);
    			st.setString(4,Mobilee);
    			st.setString(5,bloodtypee);
    			st.setString(6,Actione);
    			st.execute();    
    			
    			Alert alert= new Alert(AlertType.CONFIRMATION,"donor aded suscuscu.", javafx.scene.control.ButtonType.OK);
    			 Close_btn(event);
    			alert.showAndWait();
    		
    			
    			
    			
    		} catch (SQLException e){
    			
    			e.printStackTrace();
    		}
    	  	
    	} 
    	
    
    		}
        	
    		

    
    //close btn
    		
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
		gender.getItems().addAll(Gender);
		Action.getItems().addAll(action);
		 
	}
  
    
  
    }

  
  
    	

    
