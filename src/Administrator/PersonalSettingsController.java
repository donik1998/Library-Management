package Administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PersonalSettingsController {

    @FXML
    private Pane mainPane;

    @FXML
    private Label mainLabel;

    @FXML
    private CheckBox fullNameCheckbox;

    @FXML
    private TextField newFullName;

    @FXML
    private CheckBox phoneCheckbox;

    @FXML
    private TextField newPhoneNumber;

    @FXML
    private TextField newMailbox;

    @FXML
    private TextField newUsername;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Button checkAllButton;

    @FXML
    private CheckBox mailboxCheckbox;

    @FXML
    private CheckBox usernameCheckbox;

    @FXML
    private CheckBox passwordCheckbox;

    @FXML
    private DatePicker newDOB;

    @FXML
    private CheckBox DOBCheckbox;

    @FXML
    private CheckBox genderCheckbox;

    @FXML
    private RadioButton newMaleGender;

    @FXML
    private RadioButton newFemaleGender;

    @FXML
    private RadioButton newHiddenGender;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    private ToggleGroup genders = new ToggleGroup();

    @FXML
    void activateField(ActionEvent event) {

    }

    @FXML
    void checkAllBoxes(ActionEvent event) {

    }

    @FXML
    void closeForm(ActionEvent event) {

    }

    @FXML
    void setupScene(MouseEvent event) {
        newFemaleGender.setToggleGroup(genders);
        newMaleGender.setToggleGroup(genders);
        newHiddenGender.setToggleGroup(genders);

    }

    @FXML
    void updateAccount(ActionEvent event) {

    }

}
