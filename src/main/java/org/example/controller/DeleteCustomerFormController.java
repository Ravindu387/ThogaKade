package org.example.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import org.example.db.DBConnection;
import org.example.model.Customer;

import java.util.List;

public class DeleteCustomerFormController {

    @FXML
    private JFXButton btnOnActionYes;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private DatePicker txtBirthday;

    @FXML
    private JFXTextField txtCnumber;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtUpdateId;

    @FXML
    void btnOnActionSearch(ActionEvent event) {
        String updateId = txtUpdateId.getText();
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (Customer customer : customerList) {
            try {
                if (customer.getId().equals(updateId)) {
                    txtName.setText(customer.getFname());
                    txtAddress.setText(customer.getAddress());
                    txtCnumber.setText(customer.getCnumber());
                    txtBirthday.setValue(customer.getBirthday());
                }
            }catch (NullPointerException e){

            }

        }
    }

    public void btnOnActionYes(ActionEvent actionEvent) {
        String updateId = txtUpdateId.getText();
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (Customer customer : customerList) {
            if (customer.getId().equals(updateId)) {
                customerList.remove(customer);
                txtClear();
            }
        }
    }

    public void txtClear(){
        txtName.setText(null);
        txtAddress.setText(null);
        txtCnumber.setText(null);
        txtBirthday.setValue(null);
    }
}


