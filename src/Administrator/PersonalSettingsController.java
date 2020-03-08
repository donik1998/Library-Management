package Administrator;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

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
    private boolean unchecked = true;

    @FXML
    void activateField(ActionEvent event) {
        if (fullNameCheckbox.isSelected()){
            newFullName.setDisable(false);
        } else {
            newFullName.setDisable(true);
        }
        if (phoneCheckbox.isSelected()) {
            newPhoneNumber.setDisable(false);
        }else {
            newPhoneNumber.setDisable(true);
        }
        if (mailboxCheckbox.isSelected()){
            newMailbox.setDisable(false);
        } else {
            newMailbox.setDisable(true);
        }
        if (usernameCheckbox.isSelected()){
            newUsername.setDisable(false);
        } else {
            newUsername.setDisable(true);
        }
        if (passwordCheckbox.isSelected()){
            newPassword.setDisable(false);
        } else {
            newPassword.setDisable(true);
        }
        if (DOBCheckbox.isSelected()){
            newDOB.setDisable(false);
        } else {
            newDOB.setDisable(true);
        }
        if(genderCheckbox.isSelected()){
            newHiddenGender.setDisable(false);
            newFemaleGender.setDisable(false);
            newMaleGender.setDisable(false);
        } else {
            newHiddenGender.setDisable(true);
            newFemaleGender.setDisable(true);
            newMaleGender.setDisable(true);
        }
    }
    @FXML
    void checkAllBoxes(ActionEvent event) {
        if(event.getTarget().equals(checkAllButton)){
            if(unchecked){
                fullNameCheckbox.setSelected(true);
                phoneCheckbox.setSelected(true);
                mailboxCheckbox.setSelected(true);
                usernameCheckbox.setSelected(true);
                passwordCheckbox.setSelected(true);
                DOBCheckbox.setSelected(true);
                genderCheckbox.setSelected(true);
                activateField(event);
                unchecked = false;
            } else {
                fullNameCheckbox.setSelected(false);
                phoneCheckbox.setSelected(false);
                mailboxCheckbox.setSelected(false);
                usernameCheckbox.setSelected(false);
                passwordCheckbox.setSelected(false);
                DOBCheckbox.setSelected(false);
                genderCheckbox.setSelected(false);
                activateField(event);
                unchecked = true;
            }
        }
    }

    @FXML
    void closeForm(ActionEvent event) {
        Stage currentStage = ((Stage) cancelButton.getScene().getWindow());
        currentStage.close();
    }

    @FXML
    void setupScene(MouseEvent event) throws SQLException {
        newFemaleGender.setToggleGroup(genders);
        newMaleGender.setToggleGroup(genders);
        newHiddenGender.setToggleGroup(genders);
        mainLabel.setTextFill(mainPane.getBackground().getFills().get(0).getFill());
        mainLabel.setEffect(new DropShadow(
                BlurType.GAUSSIAN, Color.BLACK, 5, 0.3, 0, 0
        ));
        if (!genderCheckbox.isSelected()) {
            newHiddenGender.setDisable(true);
            newFemaleGender.setDisable(true);
            newMaleGender.setDisable(true);
        } else {
            newHiddenGender.setDisable(false);
            newFemaleGender.setDisable(false);
            newMaleGender.setDisable(false);
        }
        if (!DOBCheckbox.isSelected()){
            newDOB.setDisable(true);
        } else {
            newDOB.setDisable(false);
        }
        if (!passwordCheckbox.isSelected()){
            newPassword.setDisable(true);
        } else {
            newPassword.setDisable(false);
        }
        if (!usernameCheckbox.isSelected()){
            newUsername.setDisable(true);
        } else {
            newUsername.setDisable(false);
        }
        if(!mailboxCheckbox.isSelected()){
            newMailbox.setDisable(true);
        } else {
            newMailbox.setDisable(false);
        }
        if (!phoneCheckbox.isSelected()){
            newPhoneNumber.setDisable(true);
        } else {
            newPhoneNumber.setDisable(false);
        }
        if (!fullNameCheckbox.isSelected()){
            newFullName.setDisable(true);
        } else {
            newFullName.setDisable(false);
        }
        //loading current data from database
        Main.dbConnection.openConnection("library", "root", "");
        Main.dbConnection.setResultSet("SELECT * FROM users WHERE Username='" + Main.currentUserName + "'" +
                " AND `User Type`='" + Main.currentUserType + "'");
        while (Main.dbConnection.getResultSet().next()){
            newFullName.setText(Main.dbConnection.getResultSet().getString("Name"));
            newPhoneNumber.setText(Main.dbConnection.getResultSet().getString("Phone"));
            newMailbox.setText(Main.dbConnection.getResultSet().getString("E-mail"));
            newUsername.setText(Main.dbConnection.getResultSet().getString("Username"));
            newPassword.setText(Main.dbConnection.getResultSet().getString("Password"));
            newDOB.setValue(LocalDate.parse(Main.dbConnection.getResultSet().getString("Date of Birth")));
            if(Main.dbConnection.getResultSet().getString("Gender").equals("Male")){
                newMaleGender.setSelected(true);
            } else if (Main.dbConnection.getResultSet().getString("Gender").equals("Female")){
                newFemaleGender.setSelected(true);
            } else {
                newHiddenGender.setSelected(true);
            }
        }
        Main.dbConnection.closeConnection();
    }

    @FXML
    void updateAccount(ActionEvent event) throws SQLException {
        if (event.getTarget().equals(saveButton)){
            Main.dbConnection.openConnection("library", "root", "");
            Main.dbConnection.setResultSet("SELECT * FROM users WHERE Username='" + Main.currentUserName + "' AND " +
                    "`User Type`='" + Main.currentUserType + "'");
            if (fullNameCheckbox.isSelected()){
                Main.dbConnection.executeCustomQuery("UPDATE members SET Username='" + newFullName.getText() + "' WHERE Name='" + Main.dbConnection.getResultSet().getString("Name") + "'");
            }
            if (phoneCheckbox.isSelected()){

            }
            if (mailboxCheckbox.isSelected()){

            }


            Main.dbConnection.closeConnection();
        }
    }

}
