package alture.netbombafx.controller;

import alture.netbombafx.model.entity.Plano;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPlanosController {

    @FXML
    private TableView<Plano> planTableView;

    @FXML
    private TableColumn<Plano, String> planNameColumn;

    @FXML
    private TableColumn<Plano, String> planVelocidadeColumn;

    @FXML
    private TableColumn<Plano, String> planPrecoColumn;

    @FXML
    private Button buttonAdicionarPlano;

    private final ObservableList<Plano> planos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        planNameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        planVelocidadeColumn.setCellValueFactory(new PropertyValueFactory<>("velocidade"));
        planPrecoColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));
    }

    @FXML
    private void onAdicionarClick() {
        System.out.println("Botão Adicionar clicado");
        // Aqui você pode abrir um novo formulário para cadastrar um novo Cliente
    }

}