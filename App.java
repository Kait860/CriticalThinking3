package criticalthinking3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Initializes menu
        stage.setTitle("User Interface Menu 1");
        MenuItem menu1 = new MenuItem("Print Date & Time");
        MenuItem menu2 = new MenuItem("Write Contents to log.txt");
        MenuItem menu3 = new MenuItem("Make The Frame Green");
        MenuItem menu4 = new MenuItem("Close Menu");
        
        //first menu option will return the date and time
        menu1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                Label time = new Label(dateTimeString);
                System.out.println(time);
            }
        });

        //second menu option will write the contents to file named "log.txt"
        menu2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
            }
        });

        //third menu option will make the frame background color green
        menu3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
            }
        });

        //fourth menu option will exit the program
        menu4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
            }
        });

        //creates the HBox and sets the scene/menu buttons
        MenuButton menuButton = new MenuButton("Make A Selection: ", null, menu1, menu2, menu3, menu4);
        HBox hbox = new HBox(menuButton);
        Scene scene = new Scene (hbox,400,300);
        stage.setScene(scene);
        stage.show();


    }

    //launches the application
    public static void main(String[] args) {
        Application.launch(args);
    }

}