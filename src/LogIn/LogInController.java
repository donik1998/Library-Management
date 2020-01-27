package LogIn;

import Registration.RegistrationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private Pane mainPane;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Label mainLabel;

    @FXML
    private TextField userNameToLogIn;

    @FXML
    private PasswordField userPasswordToLogIn;

    @FXML
    private Button signInButton;

    @FXML
    private Label separatorLabel;

    @FXML
    private ImageView backgroundThreeImage;

    @FXML
    private Button registerButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button backgroundThreeButton;

    @FXML
    private ImageView backgroundTwoImage;

    @FXML
    private ImageView backgroundOneImage;

    @FXML
    private Button backgroundTwoButton;

    @FXML
    private Button backgroundOneButton;

    @FXML
    void changeBackgroundImage(ActionEvent event) {
        if(event.getTarget().equals(backgroundThreeButton)){
            backgroundImage.setImage(backgroundThreeImage.getImage());
            backgroundTwoImage.setEffect(null);
            backgroundOneImage.setEffect(null);
            backgroundThreeImage.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0));
            backgroundThreeButton.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.WHITE,10,0.75,0,0));
        }
        if(event.getTarget().equals(backgroundTwoButton)){
            backgroundImage.setImage(backgroundTwoImage.getImage());
            backgroundOneImage.setEffect(null);
            backgroundThreeImage.setEffect(null);
            backgroundTwoImage.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0));
            backgroundTwoButton.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.WHITE,10,0.75,0,0));
        }
        if(event.getTarget().equals(backgroundOneButton)){
            backgroundImage.setImage(backgroundOneImage.getImage());
            backgroundTwoImage.setEffect(null);
            backgroundThreeImage.setEffect(null);
            backgroundOneButton.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.WHITE,10,0.75,0,0));
            backgroundOneImage.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0));
        }
    }
    @FXML
    void exit(ActionEvent event) {
        if(event.getTarget().equals(exitButton)){
            Stage tempStage = (Stage) exitButton.getScene().getWindow();
            tempStage.close();
        }
    }

    @FXML
    void mouseHover(MouseEvent event) {
        //hover effect for main label
        if(event.getSource().equals(mainLabel)){
            mainLabel.setScaleX(1.0095);
            mainLabel.setScaleY(1.0095);
            mainLabel.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.BLACK,10,0.5,0,0));
        }
        //hover effect for exit button
        if(event.getSource().equals(exitButton)){
            exitButton.setEffect(new DropShadow(5, Color.RED));
            exitButton.setScaleY(1.0095);
            exitButton.setScaleX(1.0095);
            exitButton.setTextFill(Color.RED);
        }
        //hover effect for username input
        if(event.getSource().equals(userNameToLogIn)){
            userNameToLogIn.setEffect(new DropShadow(10,Color.WHITE));
            userNameToLogIn.setBorder(new Border(
                    new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(5))
            ));
            userNameToLogIn.setScaleY(1.0095);
            userNameToLogIn.setScaleX(1.0095);
        }
        //hover effect for password input
        if(event.getSource().equals(userPasswordToLogIn)){
            userPasswordToLogIn.setEffect(new DropShadow(10,Color.WHITE));
            userPasswordToLogIn.setBorder(new Border(
                    new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(5))
            ));
            userPasswordToLogIn.setScaleX(1.0095);
            userPasswordToLogIn.setScaleY(1.0095);
        }
        //hover effect for sign in button
        if(event.getSource().equals(signInButton)){
            signInButton.setEffect(new Glow(1));
            signInButton.setScaleY(1.0095);
            signInButton.setScaleX(1.0095);
        }
        //hover effect for register button
        if(event.getSource().equals(registerButton)){
            registerButton.setScaleY(1.0095);
            registerButton.setScaleX(1.0095);
            registerButton.setEffect(new Glow(0.8));
        }
        //hover effect for third background image
        if(event.getSource().equals(backgroundThreeButton)){
            backgroundThreeButton.setScaleY(1.0095);
            backgroundThreeButton.setScaleX(1.0095);
            backgroundThreeButton.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.BLACK,10,0.75,0,0));
        }
        //hover effect for second image button
        if(event.getSource().equals(backgroundTwoButton)){
            backgroundTwoButton.setScaleY(1.0095);
            backgroundTwoButton.setScaleX(1.0095);
            backgroundTwoButton.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.BLACK,10,0.75,0,0));
        }
        //hover effect for first image button
        if(event.getSource().equals(backgroundOneButton)){
            backgroundOneButton.setEffect(new DropShadow(BlurType.GAUSSIAN,Color.BLACK,10,0.5,0,0));
            backgroundOneButton.setScaleX(1.0095);
            backgroundOneButton.setScaleY(1.0095);
        }
    }

    @FXML
    void mouseHoverExit(MouseEvent event) {
        //hover exit effect for main label
        if(event.getSource().equals(mainLabel)){
            mainLabel.setEffect(new Glow(1));
            mainLabel.setScaleX(1);
            mainLabel.setScaleY(1);
        }
        //hover exit effect for exit button
        if(event.getSource().equals(exitButton)){
            exitButton.setEffect(new DropShadow(5,Color.BLACK));
            exitButton.setScaleY(1);
            exitButton.setScaleX(1);
            exitButton.setTextFill(Color.BLACK);
        }
        //hover exit effect for username input
        if(event.getSource().equals(userNameToLogIn)){
            userNameToLogIn.setEffect(new Glow(0.5));
            userNameToLogIn.setBorder(new Border(
                    new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(5))
            ));
            userNameToLogIn.setScaleY(1);
            userNameToLogIn.setScaleX(1);
        }
        //hover exit effect for password input
        if(event.getSource().equals(userPasswordToLogIn)){
            userPasswordToLogIn.setEffect(new Glow(0.5));
            userPasswordToLogIn.setBorder(new Border(
                    new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(5))
            ));
            userPasswordToLogIn.setScaleX(1);
            userPasswordToLogIn.setScaleY(1);
        }
        //hover exit effect for sign in button
        if(event.getSource().equals(signInButton)){
            signInButton.setEffect(new Glow(0.5));
            signInButton.setScaleY(1);
            signInButton.setScaleX(1);
        }
        //hover exit effect for register button
        if(event.getSource().equals(registerButton)){
            registerButton.setScaleY(1);
            registerButton.setScaleX(1);
            registerButton.setEffect(new Glow(0.5));
            registerButton.setEffect(new DropShadow(
                    BlurType.GAUSSIAN,Color.BLACK,15,0.5,0,0
            ));
        }
        //hover exit effect for third background image
        if(event.getSource().equals(backgroundThreeButton)){
            backgroundThreeButton.setScaleY(1);
            backgroundThreeButton.setScaleX(1);
            backgroundThreeButton.setEffect(null);
        }
        //hover exit effect for second background image
        if(event.getSource().equals(backgroundTwoButton)){
            backgroundTwoButton.setScaleY(1);
            backgroundTwoButton.setScaleX(1);
            backgroundTwoButton.setEffect(null);
        }
        //hover exit effect for first background image
        if(event.getSource().equals(backgroundOneButton)){
            backgroundOneButton.setEffect(null);
            backgroundOneButton.setScaleX(1);
            backgroundOneButton.setScaleY(1);
        }
    }

    @FXML
    void userRegistration(ActionEvent event) throws IOException {
        if(event.getTarget().equals(registerButton)){
            Pane newScenePane = FXMLLoader.load(getClass().getResource("/Registration/resources/Registration.fxml"));
            mainPane.getChildren().add(newScenePane);
        }
    }

    @FXML
    void userSignIn(ActionEvent event) {
        if(event.getTarget().equals(signInButton)){

        }
    }
}
