package controlleurs;
import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Donor;
import models.patient;
import javafx.collections.ObservableList;

public class PatientC  implements Initializable   {
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
int id;
int myIndex;


	 @FXML
	 private  Parent fxml ;
	 @FXML
	    private AnchorPane root;
	  @FXML
	    private TextField CIN_searsh;
	 @FXML
	    private TableColumn<patient, Integer> id_table;


	 @FXML
	    private TableColumn<patient, String> Action_table;

	    @FXML
	    private Button Add;

	    @FXML
	    private TableColumn<patient, String> CIN_table;

	    @FXML
	    private Button Delete;

	    @FXML
	    private TableColumn<patient, Integer> Mobile_table;

	    @FXML
	    private Button Update;

	    @FXML
	    private TableColumn<patient, String> bloodtype_table;

	    @FXML
	    private TableColumn<patient, String> Fullname_table;

	    @FXML
	    private TableColumn<patient, String> gender_table;

	    @FXML
	    private TableView<patient> table;

	    
	    public ObservableList<patient> data= FXCollections.observableArrayList();
	    @FXML
	    private ComboBox<String> bloodtype;
	    String[] bloood={"A+","A-","B+","B-","O+","O-","AB+","B-"};
	    
	   
	    @FXML
	    void Updatedonor() {

	    }

	  

	    @FXML
	    void deletedonor() {

	    }
	    @FXML
	    void searsh_btn() {
	    	String type = bloodtype.getValue();
	
		    
	    	try {
	    		data.clear();
				st=cnx.prepareStatement(  "select *from  patient WHERE bloodtype=? ");
				st.setString(1,type);
				
				result=st.executeQuery();
				while(result.next()) {
					
				data.add( new patient(result.getInt("id"),result.getString("Fullname"),result.getString("CIN"),
						result.getString("gender"),result.getInt("Mobile"),result.getString("bloodtype"),
						result.getString("Action")))	;
					
					
				}
			} catch (SQLException e) {e.printStackTrace();
		    }
	    	
	    	id_table.setCellValueFactory( new PropertyValueFactory<patient,Integer>("id"));
	    	Action_table.setCellValueFactory( new PropertyValueFactory<patient,String>("Action"));
	    	CIN_table.setCellValueFactory( new PropertyValueFactory<patient,String>("CIN"));
	    	Mobile_table.setCellValueFactory( new PropertyValueFactory<patient,Integer>("Mobile"));
	    	bloodtype_table.setCellValueFactory( new PropertyValueFactory<patient,String>("bloodtype"));
	    	Fullname_table.setCellValueFactory( new PropertyValueFactory<patient,String>("Fullname"));
	    	gender_table.setCellValueFactory( new PropertyValueFactory<patient,String>("gender"));
	        table.setItems(data);

	    }		
					
					
		
				
				
				
			
	  
	    public void  Showdonor() {
	    	
	    	String sql ="select * from  patient ";
	    
	    	try {
				st=cnx.prepareStatement(sql);
				result=st.executeQuery();
				while(result.next()) {
					
				data.add( new patient(result.getInt("id"),result.getString("Fullname"),result.getString("CIN"),
						result.getString("gender"),result.getInt("Mobile"),result.getString("bloodtype"),
						result.getString("Action")))	;
					
					
				}
			} catch (SQLException e) {e.printStackTrace();
		    }
	    	
	    	id_table.setCellValueFactory( new PropertyValueFactory<patient,Integer>("id"));
	    	Action_table.setCellValueFactory( new PropertyValueFactory<patient,String>("Action"));
	    	CIN_table.setCellValueFactory( new PropertyValueFactory<patient,String>("CIN"));
	    	Mobile_table.setCellValueFactory( new PropertyValueFactory<patient,Integer>("Mobile"));
	    	bloodtype_table.setCellValueFactory( new PropertyValueFactory<patient,String>("bloodtype"));
	    	Fullname_table.setCellValueFactory( new PropertyValueFactory<patient,String>("Fullname"));
	    	gender_table.setCellValueFactory( new PropertyValueFactory<patient,String>("gender"));
	        table.setItems(data);
	 
   // selest ligne
	        
	        table.setRowFactory(tv->{
	        	TableRow<patient> myRow = new TableRow<>();
	        	myRow.setOnMouseClicked(event->
	        	{
	        		if(event.getClickCount() == 1 &&(!myRow.isEmpty())) {
	        			
	        			myIndex = table.getSelectionModel().getSelectedIndex();
	        			id=Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
	        			System.out.print(id);
	        		}
	        	
	        });
	        return myRow;
	        });
	        

	   
	    

	    }
	    
		
		public void refrech() {
			data.clear();
			initializ();
		}
		
		//delte ligne
		
		   @FXML
		    void Delete_btn()  throws IOException{

			   if(id == -1) {
				   
			
	    			Alert alert= new Alert(AlertType.CONFIRMATION,"please select a ligne.", javafx.scene.control.ButtonType.OK);
	    			alert.showAndWait();
		   
			   }else{
				   
				  try {
					  
					  st=cnx.prepareStatement("delete from patient where id =?");
					  st.setInt(1, id);
					  st.execute();
					  refrech();

		    			Alert alert= new Alert(AlertType.CONFIRMATION,"ligne was deleted .", javafx.scene.control.ButtonType.OK);
		    			alert.showAndWait();
					  
				  }catch (SQLException ee){
					  System.out.print(ee.getMessage());
					 
					  
				  }
				  
				   
			   }
			   
			   
			   
			   
			   
			   
			   
		    }


    @FXML
    void addbtn() {
    	try {
			fxml= FXMLLoader.load(getClass().getResource("/Interfaces/add2.fxml"));
			Scene scene =new Scene(fxml);
			Stage home=new Stage();
			home.setScene(scene);
			home.setResizable(false);
			home.show();
			
		} catch(IOException e) {
			e.printStackTrace();
		}

    }

 








	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx= Connexionmysql.connecxionBD();
		bloodtype.getItems().addAll(bloood);
		id=-1;
		 Showdonor();
	}
  
    
	public void initializ() {
		
		
		Showdonor();
	
    

	}

     
    }
	


	
	
	