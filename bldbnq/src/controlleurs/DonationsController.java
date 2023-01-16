package controlleurs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;

public class DonationsController implements Initializable  {
	@FXML
	private PieChart pieChart;
	@FXML
	private BarChart barChart;

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	
	
	public Connection connectDb() {
		try{
		Class. forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
		
		return con;
		}catch (Exception e) {e.printStackTrace();	}
		return null; 
	}
	 public void fillPieChart() {
	        try {
	        	String chartPie = "SELECT COUNT(id) from donor";
	        	connect = connectDb();

	        	prepare = connect.prepareStatement (chartPie) ;
				result = prepare.executeQuery() ;
	            if (result.next()) {
	                pieChart.setUserData(result.getString(1));
	            }
 PieChart.Data donor = new PieChart.Data("donor",Integer.parseInt( result.getString(1)));
	           
	            String chartPie2 = "SELECT COUNT(id) from patient";
	            prepare = connect.prepareStatement (chartPie2) ;
				result = prepare.executeQuery() ;
	           
	            if (result.next()) {
	                pieChart.setUserData(result.getInt(1));
	            }


	            PieChart.Data patient = new PieChart.Data("patient",result.getDouble(1));
	           

	            pieChart.getData().add(donor);
	            pieChart.getData().add(patient);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		String chartSql = "SELECT type,QuantityL from bloodchar";
				connect = connectDb();

				try {
						XYChart.Series series1 = new XYChart.Series();
						series1.setName("bloodType") ;
						prepare = connect.prepareStatement (chartSql) ;
						result = prepare.executeQuery() ;

						while(result.next ()){
							
					series1.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
					
					

						}
						
					barChart.getData().add(series1);
				}
				catch (Exception e) {
					e.printStackTrace ();}

				fillPieChart();
	
	}
	
}