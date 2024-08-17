package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import org.example.db.DBConnection;
import org.example.model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private DatePicker txtBirthday;

    @FXML
    private JFXTextField txtCnumber;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXComboBox<String> txtType;

    @FXML
    void btnonActionAddCustomer(ActionEvent event) {
        Customer customer = new Customer(txtId.getText(),txtType.getValue(),txtName.getText(), txtAddress.getText(), txtCnumber.getText(), txtBirthday.getValue());
        List<Customer> connection = DBConnection.getInstance().getConnection();

        connection.add(customer);
        txtClear();
    }
    public void txtClear(){
        txtId.setText(null);
        txtType.setValue(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtCnumber.setText(null);
        txtBirthday.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> title= FXCollections.observableArrayList();
        title.add("Mr.");
        title.add("Mrs.");
        title.add("Miss.");

        txtType.setItems(title);
    }
}
