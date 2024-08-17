package org.example.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import org.example.db.DBConnection;
import org.example.model.Customer;

import java.util.List;

public class SearchCustomerFormController {

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
    private JFXTextField txtUpdateId;

    @FXML
    void btnOnActionSearch(ActionEvent event) {
        String updateId = txtUpdateId.getText();
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (Customer customer : customerList) {
            try {
                if (customer.getId().equals(updateId)) {
                    txtId.setText(customer.getId());
                    txtName.setText(customer.getFname());
                    txtAddress.setText(customer.getAddress());
                    txtCnumber.setText(customer.getCnumber());
                    txtBirthday.setValue(customer.getBirthday());
                }
            }catch (NullPointerException e){

            }

        }
    }

}
