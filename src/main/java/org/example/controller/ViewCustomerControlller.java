package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.db.DBConnection;
import org.example.model.Customer;

import java.util.List;

public class ViewCustomerControlller {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colBirthday;

    @FXML
    private TableColumn colCnumber;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    void btnonActionAddCustomer(ActionEvent event) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fname"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCnumber.setCellValueFactory(new PropertyValueFactory<>("cnumber"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        List<Customer> customerList = DBConnection.getInstance().getConnection();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        for (Customer customer : customerList) {
            try {
                if (customer.getId()!=null) {
                    customerObservableList.add(customer);
                }
            }catch (NullPointerException e){

            }

        }




        tblCustomer.setItems(customerObservableList);
    }

}
