package criticalthinking3;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    //initialize primary variables
    private TextField display;
    private JFrame frame;
    private MenuItem menu1, menu2, menu3, menu4;
    private MenuButton menuButton;
    private HBox hbox;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        //Initializes menu
        stage.setTitle("User Interface Menu 1");
        frame = new JFrame("Menu Selection");
        frame.setSize(400,300);
        menu1 = new MenuItem("Print Date & Time");
        menu2 = new MenuItem("Write Contents to log.txt");
        menu3 = new MenuItem("Make The Frame Green");
        menu4 = new MenuItem("Close Menu");
        
        //first menu option will return the date and time
        menu1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                display = new TextField(dateTimeString);
                display.setVisible(true);
                display.setEditable(false);
            }
        });

        //second menu option will write the contents to file named "log.txt"
        menu2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                PrintWriter out;
                try {
                    out = new PrintWriter("log.txt");
                    out.println(display);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        //third menu option will make the frame background color green
        menu3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                float huePick = (float) Math.random();
                Color colorPick = Color.getHSBColor(huePick, 1.0f,1.0f);
                frame.getContentPane().setBackground(colorPick);
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
        menuButton = new MenuButton("Make A Selection: ", null, menu1, menu2, menu3, menu4);
        hbox = new HBox(menuButton);
        scene = new Scene (hbox,400,300);
        stage.setScene(scene);
        stage.show();


    }

    //launches the application
    public static void main(String[] args) {
        Application.launch(args);
    }

}