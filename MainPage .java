/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;


public class MainPage {
    ArrayList<InventoryItem> invData = new ArrayList<>();
    TableView<InventoryItem> invTable;
    ObservableList<InventoryItem> iTableData; 
    
    ArrayList<Employee> empData = new ArrayList<>();
    TableView<Employee> empTable;
    ObservableList<Employee> empTableData; 
    
    ArrayList<ProductSale> saleData = new ArrayList<>();
    TableView<ProductSale> saleTable;
    ObservableList<ProductSale> saleTableData; 
    
    
    TabPane tbPane = new TabPane();
    Tab tab1 = new Tab("Inventory");
    Tab tab2 = new Tab("Point-Of-Sales");
    Tab tab3 = new Tab("Employees");
    Tab tab4 = new Tab("Suppliers");
    Tab tab5 = new Tab("Payroll");
    Tab tab6 = new Tab("Expenses");
    
    GridPane overallPane = new GridPane();
    GridPane invPane = new GridPane();
    GridPane posPane = new GridPane();
    GridPane empPane = new GridPane();
    GridPane supPane = new GridPane();
    GridPane payPane = new GridPane();
    GridPane expPane = new GridPane();
    
    Label invId = new Label("Inventory ID: ");
    TextField invIdTf = new TextField();
    Label prodId = new Label("Product ID: ");
    ComboBox cbProdId = new ComboBox();
    Label storeId = new Label("Store ID: ");
    ComboBox cbStId = new ComboBox();
    Label quantity = new Label("Quantity: ");
    TextField quantityTf = new TextField();
    Button addInv = new Button("Add ->");
    Button editInv = new Button("Edit ->");
    Button deleteInv = new Button("Delete ->");
    
    Label posSaleId = new Label("Sale ID: ");
    TextField posSaleTf = new TextField();
    Label posPId = new Label("Product ID:  ");
    ComboBox cbPId = new ComboBox();
    Label posQ = new Label("Quantity:  ");
    TextField posQTF= new TextField();
    Label posPrice = new Label("Price:  ");
    TextField price = new TextField();
    Button clear = new Button("Clear");
    Button send = new Button("Send");
    
    Label empId = new Label("Employee ID: ");
    ComboBox cbEmpId = new ComboBox();
    Label empName = new Label("Name: ");
    TextField empNameTf = new TextField();
    Label empPhone = new Label("Phone: ");
    TextField empPhoneTf = new TextField();
    Label empAddress = new Label("Address: ");
    TextField empAddressTf = new TextField();
    Label empSalary = new Label("Salary: ");
    TextField empSalaryTf = new TextField();
    Label empType = new Label("Type: ");
    ComboBox cbEmpType = new ComboBox();
    Button addEmp = new Button("Add ->");
    Button editEmp = new Button("Edit ->");
    Button deleteEmp = new Button("Delete ->");
    
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
    
    public  MainPage () {
        tab1.setClosable(false);
        tab2.setClosable(false);
        tab3.setClosable(false);
        tab4.setClosable(false);
        tab5.setClosable(false);
        tab6.setClosable(false);
        
        invPane.add(invId, 0, 2);
        invPane.add(invIdTf, 1, 2, 3, 1);
        invIdTf.setEditable(false);
        invPane.add(prodId, 0, 3);
        invPane.add(cbProdId, 1, 3, 3, 1);
        invPane.add(storeId, 0, 4);
        invPane.add(cbStId, 1, 4, 3, 1);
        invPane.add(quantity, 0, 5);
        invPane.add(quantityTf, 1, 5);
        invPane.add(addInv, 1, 6);
        invPane.add(editInv, 2, 6);
        invPane.add(deleteInv, 3, 6);
        
        posPane.add(posSaleId, 0, 0);
        posPane.add(posSaleTf, 1, 0);
        posPane.add(posPId, 0, 1);
        posPane.add(cbPId, 1, 1);
        posPane.add(posQ, 0, 2);
        posPane.add(posQTF, 1, 2);
        posPane.add(posPrice, 0, 3);
        posPane.add(price, 1, 3);
        posPane.add(clear, 0, 4);
        posPane.add(send, 1, 4);
        
        empPane.add(empId, 0, 0);
        empPane.add(cbEmpId, 1, 0);
        empPane.add(empName, 0, 1);
        empPane.add(empNameTf, 1, 1, 3, 1);
        empPane.add(empPhone, 0, 2);
        empPane.add(empPhoneTf, 1, 2, 3, 1);
        empPane.add(empAddress, 0, 3);
        empPane.add(empAddressTf, 1, 3, 3, 1);
        empPane.add(empSalary, 0, 4);
        empPane.add(empSalaryTf, 1, 4, 3, 1);
        empPane.add(empType, 0, 5);
        empPane.add(cbEmpType, 1, 5);
        empPane.add(addEmp, 1, 6);
        empPane.add(editEmp, 2, 6);
        empPane.add(deleteEmp, 3, 6);
        
        
        invPane.setAlignment(Pos.CENTER);
        
        tab1.setContent(invPane);
        tab2.setContent(posPane);
        tab3.setContent(empPane);
        
        tbPane.getTabs().add(tab1);
        tbPane.getTabs().add(tab2);
        tbPane.getTabs().add(tab3);
        tbPane.getTabs().add(tab4);
        tbPane.getTabs().add(tab5);
        tbPane.getTabs().add(tab6);
        
        overallPane.setAlignment(Pos.TOP_CENTER
        );
        overallPane.add(tbPane, 0, 0);
        
        Scene primaryScene = new Scene(overallPane,1000,700);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Store IS");
        primaryStage.show();
        
        
        
        addInv.setOnAction((ActionEvent e) -> {
            // Create a new Employee instance object
            // and add it to the empData ArrayList
            invData.add(new InventoryItem(
                    cbProdId.getSelectionModel().toString(),                   
                    cbStId.getSelectionModel().toString(),
                    quantityTf.getText()));
                   
            
            InventoryItem tempRef = invData.get(invData.size()-1);
            String sqlQuery = "";
            sqlQuery += "INSERT INTO JAVAUSER.INVENTORYITEM (INVENTORYITEMID,PRODUCTID,STOREID,QUANTITYONHAND) VALUES (";
            sqlQuery += "'" + tempRef.getInventoryItemID() + "',";
            sqlQuery += "'" + tempRef.getProductID() + "',";
            sqlQuery += "'" + tempRef.getStoreID() + "',";
            sqlQuery += "'" + tempRef.getQuantity() + "')";
            
            
            sendDBCommand(sqlQuery);
        });
        invTable = new TableView<>();
        iTableData = FXCollections.observableArrayList();
        invTable.setItems(iTableData);
        TableColumn colInvIdNum = new TableColumn("Inventory ID");
        TableColumn colProdId = new TableColumn("Product ID");
        TableColumn colStId = new TableColumn("Store ID");
        
        try{
            String sqlQuery1 = "SELECT * FROM INVENTORYITEM";
            sendDBCommand(sqlQuery1);
            while (dbResults.next()){
                iTableData.add(new InventoryItem(dbResults.getString(2),dbResults.getString(3),dbResults.getString(4)));
            }
        }
        catch(SQLException x){
            System.out.println(x.toString());
        } 
        
        colInvIdNum.setCellValueFactory(new PropertyValueFactory<ThriftyStore.InventoryItem, String>("invItemID"));
        colProdId.setCellValueFactory(new PropertyValueFactory<ThriftyStore.InventoryItem, String>("prodID"));
        colStId.setCellValueFactory(new PropertyValueFactory<ThriftyStore.InventoryItem, String>("storeID"));
        
        
        
        invTable.getColumns().addAll(colInvIdNum, colProdId, colStId);
        invPane.add(invTable, 4, 0, 3, 9);
       
        empTable = new TableView<>();
        empTableData = FXCollections.observableArrayList();
        empTable.setItems(empTableData);
        TableColumn colempIdNum = new TableColumn("ID");
        TableColumn colempName = new TableColumn("Name");
        TableColumn colempPhone = new TableColumn("Phone");
        TableColumn colempAddress= new TableColumn("Address");
        TableColumn colempSalary = new TableColumn("Salary");
        TableColumn colempType = new TableColumn("Type");
        
        empTable.getColumns().addAll(colempIdNum, colempName, colempPhone, colempAddress, colempSalary, colempType);
        empPane.add(empTable, 4, 0, 7, 9);
        
        send.setOnAction((ActionEvent e) -> {
            // Create a new Employee instance object
            // and add it to the empData ArrayList
//            saleData.add(new ProductSale(
//                    cbProdId.getSelectionModel().toString(),                   
//                    cbStId.getSelectionModel().toString(),
//                    quantityTf.getText()));
//                   
            
            InventoryItem tempRef = invData.get(invData.size()-1);
            String sqlQuery = "";
            sqlQuery += "INSERT INTO JAVAUSER.INVENTORYITEM (INVENTORYITEMID,PRODUCTID,STOREID,QUANTITYONHAND) VALUES (";
            sqlQuery += "'" + tempRef.getInventoryItemID() + "',";
            sqlQuery += "'" + tempRef.getProductID() + "',";
            sqlQuery += "'" + tempRef.getStoreID() + "',";
            sqlQuery += "'" + tempRef.getQuantity() + "')";
            
            
            sendDBCommand(sqlQuery);
        });
        
        saleTable = new TableView<>();
        saleTableData = FXCollections.observableArrayList();
        saleTable.setItems(saleTableData);
        TableColumn colSaleIdNum = new TableColumn("Sale ID: ");
        TableColumn colQuantity = new TableColumn("Quantity: ");
        TableColumn colPrice = new TableColumn("Price: ");
        TableColumn colTotalPrice = new TableColumn("TotalPrice: ");
        
        saleTable.getColumns().addAll(colSaleIdNum, colQuantity, colPrice, colTotalPrice);
        posPane.add(saleTable, 4, 0, 7, 9);
    
    }

    public void sendDBCommand(String sqlQuery)
    {
        
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser"; 
        String userPASS = "javapass"; 
        OracleDataSource ds;
        
        
        try
        {
            
            ds = new OracleDataSource();
            
            ds.setURL(URL);
            
            dbConn = ds.getConnection(userID,userPASS);
            
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            dbResults = commStmt.executeQuery(sqlQuery); 
            
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        
    }
}
