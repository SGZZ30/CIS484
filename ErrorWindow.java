
package group;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pzy30
 */
public class ErrorWindow  {
    
  
    public ErrorWindow (String message){
        Stage stage = new Stage();
        StackPane p = new StackPane();
        Label lbl = new Label(message);
        p.getChildren().add(lbl);
        p.setAlignment(Pos.CENTER);
        
        Scene ps = new Scene(p,300,300);
        stage.setTitle(message);
        stage.setScene(ps);
        stage.show();
        
    }

    
}
