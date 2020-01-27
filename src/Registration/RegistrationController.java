package Registration;

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
import java.util.List;

public class RegistrationController {
    @FXML
    public Label fieldsRequirement;

    @FXML
    private Pane mainPane;

    @FXML
    private Rectangle currentUIPositionRectangle;

    @FXML
    private Button studentWhiteUI;

    @FXML
    private Button studentRedUI;

    @FXML
    private Button studentGreenUI;

    @FXML
    private Button studentBlueUI;

    @FXML
    private Button studentYellowUI;

    @FXML
    private Button studentDarkUI;

    @FXML
    private Button studentOrangeUI;

    @FXML
    private Button studentVioletUI;

    @FXML
    private Button studentBrownUI;

    @FXML
    private Label mainLabel;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField studentIDField;

    @FXML
    private TextField studentPhoneNumberField;

    @FXML
    private TextField studentMailboxField;

    @FXML
    private DatePicker studentDOBField;

    @FXML
    private RadioButton maleStudentButton;

    @FXML
    private Label studentGenderLabel;

    @FXML
    private RadioButton femaleStudentButton;

    @FXML
    private RadioButton noGenderButton;

    @FXML
    private CheckBox studentConsentCheckbox;

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
    private TextField studentUsernameField;

    @FXML
    private TextField studentPasswordField;
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
    @FXML
    void changeUI(ActionEvent event) {
        if(event.getTarget().equals(studentWhiteUI)){
            mainPane.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
            scaleButton(studentWhiteUI,1.2);
            unScaleAll(studentWhiteUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentWhiteUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentWhiteUI.getBackground());
            fieldsRequirement.setTextFill(Color.RED);
            mainLabel.setTextFill(Color.WHITE);
            studentGenderLabel.setTextFill(Color.BLACK);
            studentConsentCheckbox.setTextFill(Color.BLACK);
            regulationsLabel.setTextFill(Color.BLACK);
            favouriteGenreLabel.setTextFill(Color.BLACK);
            maleStudentButton.setTextFill(Color.BLACK);
            femaleStudentButton.setTextFill(Color.BLACK);
            noGenderButton.setTextFill(Color.BLACK);
        }
        if(event.getTarget().equals(studentRedUI)){
            scaleButton(studentRedUI,1.2);
            unScaleAll(studentRedUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentRedUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentRedUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("DD5044"));
            studentGenderLabel.setTextFill(Color.WHITE);
            studentConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleStudentButton.setTextFill(Color.WHITE);
            femaleStudentButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(studentGreenUI)){
            scaleButton(studentGreenUI,1.2);
            unScaleAll(studentGreenUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentGreenUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentGreenUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("2AA76A"));
            studentGenderLabel.setTextFill(Color.WHITE);
            studentConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleStudentButton.setTextFill(Color.WHITE);
            femaleStudentButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(studentBlueUI)){
            scaleButton(studentBlueUI,1.2);
            unScaleAll(studentBlueUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentBlueUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentBlueUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("1479F3"));
            studentGenderLabel.setTextFill(Color.WHITE);
            studentConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleStudentButton.setTextFill(Color.WHITE);
            femaleStudentButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(studentYellowUI)){
            scaleButton(studentYellowUI,1.2);
            unScaleAll(studentYellowUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentYellowUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentYellowUI.getBackground());
            fieldsRequirement.setTextFill(Color.BLACK);
            mainLabel.setTextFill(Color.web("FBD140"));
            studentGenderLabel.setTextFill(Color.BLACK);
            studentConsentCheckbox.setTextFill(Color.BLACK);
            regulationsLabel.setTextFill(Color.BLACK);
            favouriteGenreLabel.setTextFill(Color.BLACK);
            maleStudentButton.setTextFill(Color.BLACK);
            femaleStudentButton.setTextFill(Color.BLACK);
            noGenderButton.setTextFill(Color.BLACK);
        }
        if(event.getTarget().equals(studentDarkUI)){
            scaleButton(studentDarkUI,1.2);
            unScaleAll(studentDarkUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentDarkUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentDarkUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("555555"));
            studentGenderLabel.setTextFill(Color.web("B2B2A4"));
            studentConsentCheckbox.setTextFill(Color.web("B2B2A4"));
            regulationsLabel.setTextFill(Color.web("B2B2A4"));
            favouriteGenreLabel.setTextFill(Color.web("B2B2A4"));
            maleStudentButton.setTextFill(Color.web("B2B2A4"));
            femaleStudentButton.setTextFill(Color.web("B2B2A4"));
            noGenderButton.setTextFill(Color.web("B2B2A4"));
        }
        if(event.getTarget().equals(studentOrangeUI)){
            scaleButton(studentOrangeUI,1.2);
            unScaleAll(studentOrangeUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentOrangeUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentOrangeUI.getBackground());
            fieldsRequirement.setTextFill(Color.BLACK);
            mainLabel.setTextFill(Color.web("F15A24"));
            studentGenderLabel.setTextFill(Color.WHITE);
            studentConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleStudentButton.setTextFill(Color.WHITE);
            femaleStudentButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(studentVioletUI)){
            scaleButton(studentVioletUI,1.2);
            unScaleAll(studentVioletUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentVioletUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentVioletUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("A949F3"));
            studentGenderLabel.setTextFill(Color.WHITE);
            studentConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleStudentButton.setTextFill(Color.WHITE);
            femaleStudentButton.setTextFill(Color.WHITE);
            noGenderButton.setTextFill(Color.WHITE);
        }
        if(event.getTarget().equals(studentBrownUI)){
            scaleButton(studentBrownUI,1.2);
            unScaleAll(studentBrownUI);
            previousUIndex=currentUIndex;
            currentUIndex=UIButtons.indexOf(studentBrownUI);
            changeCurrentUIPointer();
            mainPane.setBackground(studentBrownUI.getBackground());
            fieldsRequirement.setTextFill(Color.WHITE);
            mainLabel.setTextFill(Color.web("8D0A04"));
            studentGenderLabel.setTextFill(Color.WHITE);
            studentConsentCheckbox.setTextFill(Color.WHITE);
            regulationsLabel.setTextFill(Color.WHITE);
            favouriteGenreLabel.setTextFill(Color.WHITE);
            maleStudentButton.setTextFill(Color.WHITE);
            femaleStudentButton.setTextFill(Color.WHITE);
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
            maleStudentButton.setToggleGroup(genders);
            femaleStudentButton.setToggleGroup(genders);
            noGenderButton.setToggleGroup(genders);
            UIButtons = List.of(studentWhiteUI, studentRedUI, studentGreenUI, studentBlueUI,
                    studentYellowUI, studentDarkUI, studentOrangeUI, studentBrownUI, studentVioletUI);
            favouriteGenres.setItems(genres);
        }
    }

    @FXML
    void mouseHoverExit(MouseEvent event) {

    }

    @FXML
    void register(ActionEvent event) {

    }
}
