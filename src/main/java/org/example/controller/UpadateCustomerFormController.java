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

public class UpadateCustomerFormController implements Initializable {

    public JFXTextField txtUpdateId;
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
    void btnOnActionUpdateCustomer(ActionEvent event) {
        String updateId = txtUpdateId.getText();
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (Customer customer : customerList) {
            if (customer.getId().equals(updateId)) {
              customer.setId(txtId.getText());
              customer.setType(txtType.getValue());
              customer.setName(txtName.getText());
              customer.setFname(txtType.getValue()+txtName.getText());
              customer.setAddress(txtAddress.getText());
              customer.setCnumber(txtCnumber.getText());
              customer.setBirthday(txtBirthday.getValue());
            }
        }
    }

    public void btnOnActionSearch(ActionEvent actionEvent) {
        String updateId = txtUpdateId.getText();
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (Customer customer : customerList) {
            try {
                if (customer.getId().equals(updateId)) {
                    txtId.setText(customer.getId());
                    txtType.setValue(customer.getType());
                    txtName.setText(customer.getName());
                    txtAddress.setText(customer.getAddress());
                    txtCnumber.setText(customer.getCnumber());
                    txtBirthday.setValue(customer.getBirthday());
                }
            }catch (NullPointerException e){

            }

        }
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
