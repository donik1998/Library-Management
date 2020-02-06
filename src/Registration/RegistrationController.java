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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
            "Science","Technical/Reference","Novel","Other","Not listed", "None"
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
    private void scaleButton(Button buttonToScale){
        buttonToScale.setScaleY(1.2);
        buttonToScale.setScaleX(1.2);
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
            scaleButton(whiteUI);
            unScaleAll(whiteUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(whiteUI);
            changeCurrentUIPointer();
            mainPane.setBackground(whiteUI.getBackground());
            mainLabel.setTextFill(Color.WHITE);
            fieldsRequirement.setTextFill(Color.RED);
            memberGenderLabel.setTextFill(Color.BLACK);
            memberConsentCheckbox.setTextFill(Color.BLACK);
            regulationsLabel.setTextFill(Color.BLACK);
            favouriteGenreLabel.setTextFill(Color.BLACK);
            maleMemberButton.setTextFill(Color.BLACK);
            femaleMemberButton.setTextFill(Color.BLACK);
            noGenderButton.setTextFill(Color.BLACK);
        }
        if(event.getTarget().equals(redUI)){
            scaleButton(redUI);
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
            scaleButton(greenUI);
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
            scaleButton(blueUI);
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
            scaleButton(yellowUI);
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
            scaleButton(darkUI);
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
            scaleButton(orangeUI);
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
            scaleButton(violetUI);
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
            scaleButton(brownUI);
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
            memberUsername.setTooltip(new Tooltip("Username should be more than 8"));
            memberPassword.setTooltip(new Tooltip("Your password should be at least 8 characters long"));
            dateOfBirthField.setTooltip(new Tooltip("Please choose valid date of birth to confirm that you are older than 12 years"));
            fullNameField.setTooltip(new Tooltip("Enter your full name here"));
            favouriteGenres.setTooltip(new Tooltip("This is not required"));
            favouriteGenres.getSelectionModel().select("None");
            mailboxField.setTooltip(new Tooltip("Make sure to indicate your e-mail correctly"));
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
    void register(ActionEvent event) throws SQLException, IOException {
        if(event.getTarget().equals(registerButton)){
            boolean validationComplete = true, correctUsername, correctName = true, correctMailbox, noGenderChosen, invalidDOB = false, noConsent;
            String errorMessage = "\0", currentGender = "\0";
            Alert errorNotification = new Alert(Alert.AlertType.ERROR);
            errorNotification.setHeaderText("Validation failed");
            errorNotification.setTitle("Error");
            //check name to avoid special characters and numbers
            if(fullNameField.getText().length()>0){
                for(int i=0;i<fullNameField.getText().length();i++){
                    correctName = (fullNameField.getText().charAt(i) > 65 && fullNameField.getText().charAt(i) < 90) ||
                            (fullNameField.getText().charAt(i) > 97 && fullNameField.getText().charAt(i) < 122);
                }
            } else {
                errorMessage+="Full name field is empty!\n";
            }
            noConsent = !memberConsentCheckbox.isSelected();
            correctUsername = memberUsername.getText().length() > 8 && memberUsername.getText().length() != 8;
            correctMailbox = mailboxField.getText().contains("@");
            noGenderChosen = (!maleMemberButton.isSelected() && !femaleMemberButton.isSelected() && !noGenderButton.isSelected());
            LocalDate dateOfBirth = dateOfBirthField.getValue();
            LocalDate currentTime = LocalDate.now();
            if(dateOfBirth!=null){
                invalidDOB = (ChronoUnit.DAYS.between(currentTime,dateOfBirth)) > 0 && (ChronoUnit.YEARS.between(currentTime,dateOfBirth) < 12);
            } else {
                errorMessage+="Date of birth is not chosen\n";
            }
            if(!correctName){
                errorMessage+="Your name should contain upper or lower case English alphabet letters only!\n";
            }
            if(!correctUsername){
                errorMessage+="Your username's should be greater than 8\n";
            }
            if(invalidDOB){
                errorMessage+="Invalid date of birth. You have to be older than 12\n";
            }
            if(!correctMailbox){
                errorMessage+="Incorrect e-mail\n";
            }
            if(noGenderChosen){
                errorMessage+="Choose option for gender\n";
            }
            if(noConsent){
                errorMessage+="Wee need your consent to proceed further\n";
            }
            if (maleMemberButton.isSelected()){
                currentGender = maleMemberButton.getText();
            } else if (femaleMemberButton.isSelected()){
                currentGender = femaleMemberButton.getText();
            } else {
                currentGender = noGenderButton.getText();
            }
            errorNotification.setContentText(errorMessage);
            if(!errorMessage.equals("\0")){
                errorNotification.show();
                validationComplete = false;
            }
            if(validationComplete){
                Main.dbConnection.changeConnection("library","root","");
                Main.dbConnection.executeCustomQuery("INSERT INTO members VALUES ('" + fullNameField.getText() + "','" + mailboxField.getText() +
                        "','" + phoneNumberField.getText() + "', '" + currentGender +"', '" + favouriteGenres.getValue() + "', " +
                        "'" + dateOfBirthField.getValue() + "','" + memberUsername.getText() + "','" + memberPassword.getText() + "')");
            }
            Pane newScenePane = FXMLLoader.load(getClass().getResource("/Member/resources/MemberPage.fxml"));
            mainPane.getChildren().add(newScenePane);
        }
    }
}
