package alture.netbombafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private VBox clienteVbox;

    public void initialize() {
        loadContentFXML("TelaCliente.fxml");
    }

    private void loadContentFXML(String caminhoFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(caminhoFXML));
            Parent content = loader.load();
            clienteVbox.getChildren().clear();
            clienteVbox.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarClientes() {
        loadContentFXML("TelaCliente.fxml");
    }

    @FXML
    private void mostrarPlanos (){
        loadContentFXML("TelaPlanos.fxml");
    }
}