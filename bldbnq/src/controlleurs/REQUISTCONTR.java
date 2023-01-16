package controlleurs;

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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Request;

public class REQUISTCONTR {
   
	int id;
	int myIndex;
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;


	 @FXML
	 private  Parent fxml ;
	 @FXML
	    private AnchorPane root;
    @FXML
    private TableColumn<Request, String> Request_table;

    @FXML
    private TableView<Request> RequestsTable;

    @FXML
    private TableColumn<Request, Integer> id_table;

    @FXML
    private TableColumn<Request, String> titleR_table;
    
    public ObservableList<Request> data= FXCollections.observableArrayList();
    
    
    
    
    public void  ShowRequste() {
    
    	String sql ="select * from requste";
    
    	try {
			st=cnx.prepareStatement(sql);
			result=st.executeQuery();
			while(result.next()) {
				
			data.add( new Request(result.getInt("id"),result.getString("titleR"),
					result.getString("Request")));
			
					
				
			}
		} catch (SQLException e) {e.printStackTrace();
	    }
    	
    	id_table.setCellValueFactory( new PropertyValueFactory<Request,Integer>("id"));
    	titleR_table.setCellValueFactory( new PropertyValueFactory<Request,String>("titleR"));
    	Request_table.setCellValueFactory( new PropertyValueFactory<Request,String>("Requste"));
    	
    	RequestsTable.setItems(data);
 

   
    
        // select ligne
        
    	RequestsTable.setRowFactory(tv->{
        	TableRow<Request> myRow = new TableRow<>();
        	myRow.setOnMouseClicked(event->
        	{
        		if(event.getClickCount() == 1 &&(!myRow.isEmpty())) {
        			
        			myIndex = RequestsTable.getSelectionModel().getSelectedIndex();
        			id=Integer.parseInt(String.valueOf(RequestsTable.getItems().get(myIndex).getId()));
        			System.out.print(id);
        		}
        	
        });
        return myRow;
        });
        

    }
    public void refrech() {
		data.clear();
		initialize();
	}
  //delte ligne
	
	   @FXML
	    void Delete_btn()  throws IOException{

		   if(id == -1) {
			   
		
 			Alert alert= new Alert(AlertType.CONFIRMATION,"please select a ligne.", javafx.scene.control.ButtonType.OK);
 			alert.showAndWait();
	   
		   }else{
			   
			  try {
				  
				  st=cnx.prepareStatement("delete from requste where id =?");
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
    
    public void initialize() {
    	cnx= Connexionmysql.connecxionBD();
	
		id=-1;
		ShowRequste();
		 
	}
    
    



     
    }
	
