package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//use of -- // 

    private Controller controller;

    @Override
    public void stop() throws Exception {
        controller.terminateAll();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();//FXMLLoader.load(getClass().getResource("sample.fxml"));
        controller = loader.getController();
        primaryStage.setTitle("Time Keeper");
        primaryStage.setScene(new Scene(root, 1200, 875));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
