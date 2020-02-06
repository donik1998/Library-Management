package Administrator;

import Main.Main;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
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

    private List<Button> UIButtons;
    private int previousUIndex = 0, currentUIndex = 0;
    private Effect previousEffect;

    //function to change background image of the button
    private BackgroundImage changeBackgroundImage(Image image){
        return new BackgroundImage(
                image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,false,true));
    }
    //function to fill labels with buttonPressed color
    private void changeLabelColor(Button buttonPressed){
        //getting background color for mainPane and mainLabel
        mainLabel.setTextFill(buttonPressed.getBackground().getFills().get(0).getFill());
        mainPane.setBackground(new Background(
                new BackgroundFill(buttonPressed.getBackground().getFills().get(0).getFill(),null,null)
        ));
        //changing the color for button labels
        booksManagementLabel.setTextFill(buttonPressed.getBackground().getFills().get(0).getFill());
        membersManagementLabel.setTextFill(buttonPressed.getBackground().getFills().get(0).getFill());
        librarianManagementLabel.setTextFill(buttonPressed.getBackground().getFills().get(0).getFill());
    }

    @FXML
    void setupScene(MouseEvent event) {
        UIButtons = List.of(whiteUI,redUI,greenUI,blueUI,yellowUI,darkUI, orangeUI,brownUI,violetUi);
        mainLabel.setText(Main.currentUserName.toUpperCase() + "'s Administrator Page");
        accountSettingsButton.setStyle(null);
        logOutButton.setStyle(null);
        bookManagementButton.setStyle(null);
        librarianManagementButton.setStyle(null);
        membersManagementButton.setStyle(null);
        booksManagementLabel.setEffect(new DropShadow(
                BlurType.GAUSSIAN, Color.BLACK, 5,0.5,0,0
        ));
        membersManagementLabel.setEffect(new DropShadow(
                BlurType.GAUSSIAN, Color.BLACK, 5,0.5,0,0
        ));
        librarianManagementLabel.setEffect(new DropShadow(
                BlurType.GAUSSIAN, Color.BLACK, 5,0.5,0,0
        ));
        accountSettingsButton.setEffect(new DropShadow(
                BlurType.GAUSSIAN,Color.BLACK,5,0.5,0,0
        ));
        logOutButton.setEffect(new DropShadow(
                BlurType.GAUSSIAN,Color.BLACK,5,0.5,0,0
        ));
        membersManagementButton.setEffect(new DropShadow(
                BlurType.GAUSSIAN,Color.BLACK,5,0.5,0,0
        ));
        bookManagementButton.setEffect(new DropShadow(
                BlurType.GAUSSIAN,Color.BLACK,5,0.5,0,0
        ));
        librarianManagementButton.setEffect(new DropShadow(
                BlurType.GAUSSIAN,Color.BLACK,5,0.5,0,0
        ));
        accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingImage.png")))))
        )));
        logOutButton.setBackground(new Background(changeBackgroundImage(
                new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImage.png")))))
        )));
        bookManagementButton.setBackground(new Background(changeBackgroundImage(
                new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementIcon.png")))))
        )));
        librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementIcon.png")))))
        )));
        membersManagementButton.setBackground(new Background(changeBackgroundImage(
                new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementIcon.png")))))
        )));
    }

    //function to move UI pointer (circle) towards chosen UI
    private void moveCurrentUIPointer(){
        TranslateTransition translateTransition = new TranslateTransition(new Duration(200),UIPointer);
        translateTransition.setByY(0);
        translateTransition.setByX(100*(currentUIndex-previousUIndex));
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    @FXML
    void changeUI(ActionEvent event) {
        if(event.getTarget().equals(whiteUI)){
            changeLabelColor(whiteUI);
            //changing icons
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingImage.png")))))
            )));
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImage.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementIcon.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementIcon.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementIcon.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(whiteUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(redUI)){
            changeLabelColor(redUI);
            //changing icons
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingsRedUI.png")))))
            )));
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logOutRedUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementRedUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementRedUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementRedUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(redUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(greenUI)){
            changeLabelColor(greenUI);
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingImageGreenUI.png")))))
            )));
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImageGreenUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementGreenUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagemenGreenUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementGreenUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(greenUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(blueUI)){
            changeLabelColor(blueUI);
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingImageBlueUI.png")))))
            )));
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImageBlueUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementBlueUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementBlueUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementBlueUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(blueUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(yellowUI)){
            changeLabelColor(yellowUI);
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImageYellowUI.png")))))
            )));
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingsYellowUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementYellowUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementYellowUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementYellowUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(yellowUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(darkUI)){
            changeLabelColor(darkUI);
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingsDarkUI.png")))))
            )));
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImageDarkUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementDarkUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementDarkUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagementDarkUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(darkUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(orangeUI)){
            changeLabelColor(orangeUI);
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImageOrangeUI.png")))))
            )));
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingOrange.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementOrangeUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagemenOrangeUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementOrangeUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(orangeUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(brownUI)){
            changeLabelColor(brownUI);
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingBrownUI.png")))))
            )));
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logOutBrownUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementBrownUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagemenBrownUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementBrownUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(brownUI);
            moveCurrentUIPointer();
        }
        if(event.getTarget().equals(violetUi)){
            changeLabelColor(violetUi);
            logOutButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/logoutImageVioletUI.png")))))
            )));
            accountSettingsButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/settingsVioletUI.png")))))
            )));
            membersManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/memberManagementVioletUI.png")))))
            )));
            librarianManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/librarianManagemenVioletUI.png")))))
            )));
            bookManagementButton.setBackground(new Background(changeBackgroundImage(
                    new Image(String.valueOf(new File(String.valueOf(getClass().getResource("/Administrator/imgs/booksManagementVioletUI.png")))))
            )));
            previousUIndex = currentUIndex;
            currentUIndex = UIButtons.indexOf(violetUi);
            moveCurrentUIPointer();
        }
    }

    @FXML
    void logOut(ActionEvent event)throws IOException {
        if(event.getTarget().equals(logOutButton)){
            Pane newStagePAne = FXMLLoader.load(getClass().getResource("/LogIn/resources/LogInForm.fxml"));
            mainPane.getChildren().add(newStagePAne);
        }
    }

    @FXML
    void showAccountSettings(ActionEvent event) throws IOException {
        Pane newScenePane = FXMLLoader.load(getClass().getResource("/Administrator/resources/PersonalSettings.fxml"));
        newScenePane.setBackground(mainPane.getBackground());
        Stage newStage = new Stage();
        newStage.setScene(new Scene(newScenePane,1024,720));
        newStage.setTitle("Personal settings");
        newStage.show();
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
        if(event.getSource().equals(accountSettingsButton)){
            previousEffect = accountSettingsButton.getEffect();
            accountSettingsButton.setEffect(new DropShadow(
                    BlurType.GAUSSIAN,Color.RED,10,0.5,0,0
            ));
            if (mainPane.getBackground().getFills().get(0).getFill().equals(orangeUI.getBackground().getFills().get(0).getFill())){
                accountSettingsButton.setEffect(new DropShadow(
                        BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0
                ));
            }
        }
        if(event.getSource().equals(logOutButton)){
            previousEffect = logOutButton.getEffect();
            logOutButton.setEffect(new DropShadow(
                    BlurType.GAUSSIAN,Color.RED,10,0.5,0,0
            ));
            if (mainPane.getBackground().getFills().get(0).getFill().equals(orangeUI.getBackground().getFills().get(0).getFill())){
                logOutButton.setEffect(new DropShadow(
                        BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0
                ));
            }
        }
        if(event.getSource().equals(bookManagementButton)){
            previousEffect = bookManagementButton.getEffect();
            bookManagementButton.setEffect(new DropShadow(
                    BlurType.GAUSSIAN,Color.RED,10,0.5,0,0
            ));
            if (mainPane.getBackground().getFills().get(0).getFill().equals(orangeUI.getBackground().getFills().get(0).getFill())){
                bookManagementButton.setEffect(new DropShadow(
                        BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0
                ));
            }
        }
        if(event.getSource().equals(librarianManagementButton)){
            previousEffect = librarianManagementButton.getEffect();
            librarianManagementButton.setEffect(new DropShadow(
                    BlurType.GAUSSIAN,Color.RED,10,0.5,0,0
            ));
            if (mainPane.getBackground().getFills().get(0).getFill().equals(orangeUI.getBackground().getFills().get(0).getFill())){
                librarianManagementButton.setEffect(new DropShadow(
                        BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0
                ));
            }
        }
        if(event.getSource().equals(membersManagementButton)){
            previousEffect = membersManagementButton.getEffect();
            membersManagementButton.setEffect(new DropShadow(
                    BlurType.GAUSSIAN,Color.RED,10,0.5,0,0
            ));
            if (mainPane.getBackground().getFills().get(0).getFill().equals(orangeUI.getBackground().getFills().get(0).getFill())){
                membersManagementButton.setEffect(new DropShadow(
                        BlurType.GAUSSIAN,Color.WHITE,10,0.5,0,0
                ));
            }
        }
    }

    @FXML
    void mouseHoverExit(MouseEvent event) {
        if(event.getSource().equals(accountSettingsButton)){
            accountSettingsButton.setEffect(previousEffect);
            previousEffect = null;
        }
        if(event.getSource().equals(logOutButton)){
            logOutButton.setEffect(previousEffect);
            previousEffect = null;
        }
        if(event.getSource().equals(bookManagementButton)){
            bookManagementButton.setEffect(previousEffect);
            previousEffect = null;
        }
        if(event.getSource().equals(librarianManagementButton)){
            librarianManagementButton.setEffect(previousEffect);
            previousEffect = null;
        }
        if(event.getSource().equals(membersManagementButton)){
            membersManagementButton.setEffect(previousEffect);
            previousEffect = null;
        }
    }
}
