package Administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.List;

public class AdministratorPageController {

    @FXML
    private Pane mainPane;

    @FXML
    private Label mainLabel;

    @FXML
    private Button accountSettingsButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button membersManagementButton;

    @FXML
    private Button librarianManagementButton;

    @FXML
    private Button bookManagementButton;

    @FXML
    private Label membersManagementLabel;

    @FXML
    private Label librarianManagementLabel;

    @FXML
    private Label booksManagementLabel;

    @FXML
    private Button whiteUI;

    @FXML
    private Button redUI;

    @FXML
    private Button greenUI;

    @FXML
    private Button blueUI;

    @FXML
    private Button yellowUI;

    @FXML
    private Button darkUI;

    @FXML
    private Button orangeUI;

    @FXML
    private Button brownUI;

    @FXML
    private Button violetUi;

    @FXML
    private Circle UIPointer;

    private Image membersManagementButtonImage;
    private Image librarianManagementButtonImage;
    private Image bookManagementButtonImage;
    private Image logOutImage;
    private Image accountSettingsButtonImage;
    private BackgroundImage tempBackImage;
    private List<Button> UIButtons = List.of(whiteUI,redUI,greenUI,blueUI,yellowUI,darkUI, orangeUI,brownUI,violetUi);
    private int previousUIndex = 0;

    @FXML
    void setupScene(MouseEvent event) {
        accountSettingsButton.setStyle(null);
        accountSettingsButtonImage = new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingImage.png")))));
        tempBackImage = new BackgroundImage(
                accountSettingsButtonImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(80,80,true,true,false,true));
        accountSettingsButton.setBackground(new Background(tempBackImage));
        logOutButton.setStyle(null);
        logOutImage = new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImage.png")))));
        tempBackImage = new BackgroundImage(
                logOutImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                new BackgroundSize(80,80,true,true,false,true)
        );
        logOutButton.setBackground(new Background(tempBackImage));
        bookManagementButtonImage = new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementIcon.png")))));
        bookManagementButton.setStyle(null);
        bookManagementButtonImage = new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementIcon.png")))));
        tempBackImage = new BackgroundImage(
                bookManagementButtonImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,false,true)
        );
        bookManagementButton.setBackground(new Background(tempBackImage));
        librarianManagementButton.setStyle(null);
        librarianManagementButtonImage = new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementIcon.png")))));
        tempBackImage = new BackgroundImage(
                librarianManagementButtonImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,false,true)
        );
        librarianManagementButton.setBackground(new Background(tempBackImage));
        membersManagementButton.setStyle(null);
        membersManagementButtonImage = new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementIcon.png")))));
        tempBackImage = new BackgroundImage(
                membersManagementButtonImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,false,true)
        );
        membersManagementButton.setBackground(new Background(tempBackImage));
    }
    private void moveCurrentUIPointer(){

    }

    @FXML
    void changeUI(ActionEvent event) {
        if(event.getTarget().equals(whiteUI)){
            mainLabel.setTextFill(whiteUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(redUI)){
            mainLabel.setTextFill(redUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(greenUI)){
            mainLabel.setTextFill(greenUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(blueUI)){
            mainLabel.setTextFill(blueUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(yellowUI)){
            mainLabel.setTextFill(yellowUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(darkUI)){
            mainLabel.setTextFill(darkUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(orangeUI)){
            mainLabel.setTextFill(orangeUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(brownUI)){
            mainLabel.setTextFill(brownUI.getBackground().getFills().get(0).getFill());
        }
        if(event.getTarget().equals(violetUi)){
            mainLabel.setTextFill(violetUi.getBackground().getFills().get(0).getFill());
        }
    }

    @FXML
    void logOut(ActionEvent event)throws IOException {
        Pane newStagePAne = FXMLLoader.load(getClass().getResource("/LogIn/resources/LogInForm.fxml"));
        mainPane.getChildren().add(newStagePAne);
    }

    @FXML
    void showAccountSettings(ActionEvent event) {

    }

    @FXML
    void showBookManagementDialog(ActionEvent event) {

    }

    @FXML
    void showLibrarianManagementDialog(ActionEvent event) {

    }

    @FXML
    void showMembersManagementDialog(ActionEvent event) {

    }

    @FXML
    void mouseHover(MouseEvent event) {

    }

    @FXML
    void mouseHoverExit(MouseEvent event) {

    }
}
