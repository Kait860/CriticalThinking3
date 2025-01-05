package criticalthinking3;

import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    //initialize primary variables
    private TextArea display;
    private Menu menu1, menu2, menu3, menu4;
    private MenuBar menuBar;
    private HBox hbox;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        //Initializes menu
        stage.setTitle("User Interface Menu 1");

        menuBar = new MenuBar();
        menu1 = new Menu("Print Date & Time");
        menu2 = new Menu("Write Contents to log.txt");
        menu3 = new Menu("Make The Frame Green");
        menu4 = new Menu("Close Menu");

        display = new TextArea();
        
        //first menu option will return the date and time
        menu1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
                String dateTimeString = now.format(formatter);
                display.append(dateTimeString + "\n");
            }
        });

        //second menu option will write the contents to file named "log.txt"
        menu2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    FileWriter out = new FileWriter("log.txt", true);
                    out.write(display.getText());
                    out.close();
                } catch (IOException r) {
                    r.printStackTrace();
                }
            }
        });

        //third menu option will make the frame background color green
        menu3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Random rand = new Random();
                int g = rand.nextInt(256);
                menuBar.setStyle(String.format("-fx-background-color: rgb(0,%d,0)", g));
            }
        });

        //fourth menu option will exit the program
        menu4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.exit(0);
            }
        });

        //creates the HBox and sets the scene/menu buttons
        menuBar.getMenus().addAll( menu1, menu2, menu3, menu4);
        hbox = new HBox(menuBar);
        scene = new Scene (hbox,400,300);
        stage.setScene(scene);
        stage.show();


    }

    //launches the application
    public static void main(String[] args) {
        Application.launch(args);
    }

}