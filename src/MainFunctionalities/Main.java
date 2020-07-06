package MainFunctionalities;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static String currentUserName, currentUserType;
    public static DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    @Override
    public void start(Stage mainStage) throws IOException {
        Parent logInStageRoot = FXMLLoader.load(getClass().getResource("/LogIn/resources/LogInForm.fxml"));
        mainStage.setScene(new Scene(logInStageRoot,1024,720));
        mainStage.setTitle("Log In form");
        mainStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
