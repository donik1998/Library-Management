package Registration;

import Main.Main;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegistrationController {
    @FXML
    private Pane mainPane;

    @FXML
    private Label mainLabel;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField mailboxField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private RadioButton maleMemberButton;

    @FXML
    private Label memberGenderLabel;

    @FXML
    private RadioButton femaleMemberButton;

    @FXML
    private RadioButton noGenderButton;

    @FXML
    private CheckBox memberConsentCheckbox;

    @FXML
    private Label favouriteGenreLabel;

    @FXML
    private ComboBox<String> favouriteGenres;

    @FXML
    private Label regulationsLabel;

    @FXML
    private TextArea regulationsTextArea;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField memberUsername;

    @FXML
    private TextField memberPassword;

    @FXML
    private Label fieldsRequirement;

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
    private Button violetUI;

    @FXML
    private Button brownUI;

    @FXML
    private Button orangeUI;

    @FXML
    private Rectangle currentUIPositionRectangle;

    private List<Button> UIButtons;
    private ToggleGroup genders = new ToggleGroup();
    private int previousUIndex = 0, currentUIndex = 0;
    private ObservableList<String> genres = FXCollections.observableArrayList(
            "\0","Adventures","Fiction","Non-fiction",
            "Science","Technical/Reference","Novel","Other","Not listed"
    );

    //reusable function to set initial size of buttons, except the one included to parameter
    private void unScaleAll(Button except){
        if(UIButtons.contains(except)){
            for (int i = 0; i< UIButtons.size(); i++){
                if(UIButtons.indexOf(except)!=i){
                    UIButtons.get(i).setScaleX(1);
                    UIButtons.get(i).setScaleY(1);
                }
            }
        }
    }
    //reusable function to scale specified button
    private void scaleButton(Button buttonToScale, double scale){
        buttonToScale.setScaleY(scale);
        buttonToScale.setScaleX(scale);
    }
    //function to move current UI pointer
    private void changeCurrentUIPointer(){
        currentUIPositionRectangle.setEffect(new Glow(1));
        TranslateTransition translateDown = new TranslateTransition(new Duration(200),currentUIPositionRectangle);
        translateDown.setByX(0);
        translateDown.setByY(40*(currentUIndex-previousUIndex));
        translateDown.setAutoReverse(false);
        translateDown.play();
    }
    //hover effect for textFields
    private void inputHoverEffects(TextField hoverTarget){
        hoverTarget.setScaleX(1.0095);
        hoverTarget.setScaleY(1.0095);
        hoverTarget.setEffect(new Glow(1));
        hoverTarget.setBorder(new Border(
                new BorderStroke(Color.web("A4B7D8"),BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(2))
        ));
    }
    //hover exit effect for textFields
    private void inputHoverExitEffects(TextField hoverExitTarget){
        if(!hoverExitTarget.isFocused()){
            hoverExitTarget.setScaleX(1);
            hoverExitTarget.setScaleY(1);
            hoverExitTarget.setBorder(new Border(
                    new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(1))
            ));
        }else {
            inputHoverEffects(hoverExitTarget);
        }
    }
    @FXML
    void changeUI(ActionEvent event){
        if(event.getTarget().equals(whiteUI)){
            mainPane.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
            scaleButton(whiteUI,1.2);
            unScaleAll(whiteUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(whiteUI);
            changeCurrentUIPointer();
            mainPane.setBackground(whiteUI.getBackground());
            fieldsRequirement.setTextFill(Color.RED);
            mainLabel.setTextFill(Color.WHITE);
            memberGenderLabel.setTextFill(Color.BLACK);
            memberConsentCheckbox.setTextFill(Color.BLACK);
            regulationsLabel.setTextFill(Color.BLACK);
            favouriteGenreLabel.setTextFill(Color.BLACK);
            maleMemberButton.setTextFill(Color.BLACK);
            femaleMemberButton.setTextFill(Color.BLACK);
            noGenderButton.setTextFill(Color.BLACK);
        }
        if(event.getTarget().equals(redUI)){
            scaleButton(redUI,1.2);
            unScaleAll(redUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(redUI);
            changeCurrentUIPointer();
            mainPane.setBackground(redUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("DD5044"));
            memberGenderLabel.setTextFill(Color.WHITE);
            memberConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleMemberButton.setTextFill(Color.WHITE);
            femaleMemberButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(greenUI)){
            scaleButton(greenUI,1.2);
            unScaleAll(greenUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(greenUI);
            changeCurrentUIPointer();
            mainPane.setBackground(greenUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("2AA76A"));
            memberGenderLabel.setTextFill(Color.WHITE);
            memberConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleMemberButton.setTextFill(Color.WHITE);
            femaleMemberButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(blueUI)){
            scaleButton(blueUI,1.2);
            unScaleAll(blueUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(blueUI);
            changeCurrentUIPointer();
            mainPane.setBackground(blueUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("2EA5E2"));
            memberGenderLabel.setTextFill(Color.WHITE);
            memberConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleMemberButton.setTextFill(Color.WHITE);
            femaleMemberButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(yellowUI)){
            scaleButton(yellowUI,1.2);
            unScaleAll(yellowUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(yellowUI);
            changeCurrentUIPointer();
            mainPane.setBackground(yellowUI.getBackground());
            fieldsRequirement.setTextFill(Color.BLACK);
            mainLabel.setTextFill(Color.web("FBD140"));
            memberGenderLabel.setTextFill(Color.BLACK);
            memberConsentCheckbox.setTextFill(Color.BLACK);
            regulationsLabel.setTextFill(Color.BLACK);
            favouriteGenreLabel.setTextFill(Color.BLACK);
            maleMemberButton.setTextFill(Color.BLACK);
            femaleMemberButton.setTextFill(Color.BLACK);
            noGenderButton.setTextFill(Color.BLACK);
        }
        if(event.getTarget().equals(darkUI)){
            scaleButton(darkUI,1.2);
            unScaleAll(darkUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(darkUI);
            changeCurrentUIPointer();
            mainPane.setBackground(darkUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("555555"));
            memberGenderLabel.setTextFill(Color.web("B2B2A4"));
            memberConsentCheckbox.setTextFill(Color.web("B2B2A4"));
            regulationsLabel.setTextFill(Color.web("B2B2A4"));
            favouriteGenreLabel.setTextFill(Color.web("B2B2A4"));
            maleMemberButton.setTextFill(Color.web("B2B2A4"));
            femaleMemberButton.setTextFill(Color.web("B2B2A4"));
            noGenderButton.setTextFill(Color.web("B2B2A4"));
        }
        if(event.getTarget().equals(orangeUI)){
            scaleButton(orangeUI,1.2);
            unScaleAll(orangeUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(orangeUI);
            changeCurrentUIPointer();
            mainPane.setBackground(orangeUI.getBackground());
            fieldsRequirement.setTextFill(Color.BLACK);
            mainLabel.setTextFill(Color.web("F15A24"));
            memberGenderLabel.setTextFill(Color.WHITE);
            memberConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleMemberButton.setTextFill(Color.WHITE);
            femaleMemberButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(violetUI)){
            scaleButton(violetUI,1.2);
            unScaleAll(violetUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(violetUI);
            changeCurrentUIPointer();
            mainPane.setBackground(violetUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("A949F3"));
            memberGenderLabel.setTextFill(Color.WHITE);
            memberConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleMemberButton.setTextFill(Color.WHITE);
            femaleMemberButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(brownUI)){
            scaleButton(brownUI,1.2);
            unScaleAll(brownUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(brownUI);
            changeCurrentUIPointer();
            mainPane.setBackground(brownUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("8D0A04"));
            memberGenderLabel.setTextFill(Color.WHITE);
            memberConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleMemberButton.setTextFill(Color.WHITE);
            femaleMemberButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
    }

    @FXML
    void closeForm(ActionEvent event) throws IOException{
        if(event.getTarget().equals(cancelButton)){
            Pane newStagePAne = FXMLLoader.load(getClass().getResource("/LogIn/resources/LogInForm.fxml"));
            mainPane.getChildren().add(newStagePAne);
        }
    }

    @FXML
    void mouseHover(MouseEvent event) {
        //setup scene on mouse entered to main pane
        if(event.getSource().equals(mainPane)){
            maleMemberButton.setToggleGroup(genders);
            femaleMemberButton.setToggleGroup(genders);
            noGenderButton.setToggleGroup(genders);
            UIButtons = List.of(whiteUI, redUI, greenUI, blueUI,
                    yellowUI, darkUI, orangeUI, brownUI, violetUI);
            favouriteGenres.setItems(genres);
        }
        //hover effect for inputs
        if(event.getSource().equals(fullNameField)){
            inputHoverEffects(fullNameField);
        }
        if(event.getSource().equals(phoneNumberField)){
            inputHoverEffects(phoneNumberField);
        }
        if(event.getSource().equals(mailboxField)){
            inputHoverEffects(mailboxField);
        }
        if(event.getSource().equals(memberUsername)){
            inputHoverEffects(memberUsername);
        }
        if(event.getSource().equals(memberPassword)){
            inputHoverEffects(memberPassword);
        }
    }

    @FXML
    void mouseHoverExit(MouseEvent event) {
        //hover exit effect for inputs
        if(event.getSource().equals(fullNameField)){
            inputHoverExitEffects(fullNameField);
        }
        if(event.getSource().equals(phoneNumberField)){
            inputHoverExitEffects(phoneNumberField);
        }
        if(event.getSource().equals(mailboxField)){
            inputHoverExitEffects(mailboxField);
        }
        if(event.getSource().equals(memberUsername)){
            inputHoverExitEffects(memberUsername);
        }
        if(event.getSource().equals(memberPassword)){
            inputHoverExitEffects(memberPassword);
        }
    }

    @FXML
    void register(ActionEvent event) {

    }
}
