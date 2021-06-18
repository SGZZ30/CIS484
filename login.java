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
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author pzy30
 */
public class login extends Application {

    Label lblID = new Label("ID");
    Label lblPwd = new Label("Password");
    TextField txtID = new TextField();
    TextField txtPwd = new TextField();
    Button btnLogin = new Button("Login");
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    @Override
    public void start(Stage primaryStage) {
        GridPane gp = new GridPane();
        gp.add(lblID, 0, 0);
        gp.add(lblPwd, 0, 1);
        gp.add(txtID, 1, 0);
        gp.add(txtPwd, 1, 1);

        gp.add(btnLogin, 0, 2);

        gp.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gp, 300, 250);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        btnLogin.setOnAction(e -> {
            String tempid = txtID.getText();
            String temppwd = txtPwd.getText();

            String sql = "select employeePassword from employee where employeeID = " + tempid;
            String URL = "jdbc:oracle:thin:@localhost:1521:XE";
            String userID = "javauser"; // Change to YOUR Oracle username
            String userPASS = "javapass"; // Change to YOUR Oracle password
            OracleDataSource ds;
            try {
                // instantiate a new data source object
                ds = new OracleDataSource();
                // Where is the database located? Web? Local?
                ds.setURL(URL);
                // Send the user/pass and get an open connection.
                dbConn = ds.getConnection(userID, userPASS);
                // When we get results
                //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
                //   will see our resultset update in real time.
                //  -CONCUR_READ_ONLY means that we cannot accidentally change the
                //   data in our database by using the .update____() methods of
                //   the ResultSet class - TableView controls are impacted by
                //   this setting as well.
                commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                // We send the query to the DB. A ResultSet object is instantiated
                //  and we are returned a reference to it, that we point to from
                // dbResults.
                // Because we declared dbResults at the datafield level
                // we can see the results from anywhere in our Class.
                dbResults = commStmt.executeQuery(sql); // Sends the Query to the DB
                String correctpwd = dbResults.getString(0);
                if (temppwd.equals(correctpwd)){
                   MainPage mp = new MainPage();
                } else {
                    ErrorWindow er= new ErrorWindow("Wrong password");
                }
                
                
                // The results are stored in a ResultSet structure object
                // pointed to by the reference variable dbResults
                // Because we declared this variable globally above, we can use
                // the results in any method in the class.
            } catch (SQLException sqle) {
                System.out.println(sqle.toString());
            }

        });

    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
