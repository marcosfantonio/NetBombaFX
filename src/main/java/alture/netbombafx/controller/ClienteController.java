package alture.netbombafx.controller;

import alture.netbombafx.model.entity.Cliente;
import alture.netbombafx.model.services.ClienteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClienteController {

    @FXML
    private TableView<Cliente> tableView;

    @FXML
    private TableColumn<Cliente, String> nameColumn;

    @FXML
    private TableColumn<Cliente, String> idColumn;

    @FXML
    private TableColumn<Cliente, String> cpfColumn;

    private ClienteService clienteService = new ClienteService();

    private final ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        List<Cliente> clientes = clienteService.readClienteTable();
        tableView.setItems(FXCollections.observableArrayList(clientes));

    }

    @FXML
    public void adicionarClienteTela(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("adicionarCliente.fxml"));
            VBox root = loader.load();
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Adicionar Plano");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}