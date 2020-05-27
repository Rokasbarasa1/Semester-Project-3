package view.employeeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.employeeList.EmployeeListViewModel;

public class EmployeeListController {
    @FXML
    private ListView<String> employeeList;
    private ViewHandler viewHandler;
    private EmployeeListViewModel viewModel;

    public void init(EmployeeListViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        employeeList.getItems().addAll(viewModel.populateListView());
    }


    @FXML
    void onBack(ActionEvent event) {
        viewHandler.openCalendarView();
    }

    @FXML
    void onCreateEmployee(ActionEvent event) {
        viewHandler.openCreateUserView();
    }
}
