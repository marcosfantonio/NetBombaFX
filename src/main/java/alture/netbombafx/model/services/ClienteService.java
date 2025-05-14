package alture.netbombafx.model.entity.services;

import java.util.List;

import main.model.dao.ClienteDAO;
import main.model.dao.PlanoDAO;
import main.model.entity.Assinatura;
import main.model.entity.Cliente;
import main.model.entity.Endereco;
import main.model.entity.Plano;

public class ClienteService {
    public static void createCliente ( String nome, String cpf, String rua, int numero, int plano) {
        Endereco endereco = EnderecoService.createEndereco(rua, numero);
        Assinatura assinatura = AssinaturaService.createAssinatura(PlanoService.readPlanoById(plano));

        Cliente cliente = new Cliente.Builder()
                .nome(nome)
                .cpf(cpf)
                .endereco(endereco)
                .Assinatura(assinatura)
                .build();

        ClienteDAO.addCliente(cliente);
    }

    public static Cliente readClienteById ( int id ) {
        return ClienteDAO.getCliente(id);
    }

    public static void editCliente ( int id, String nome, String cpf, String rua, int numero, int plano_id ) {
        ClienteDAO.updateCliente(id, nome, cpf, rua, numero, plano_id);
    }

    public static void deleteCliente (int id ) {
        ClienteDAO.deleteCliente(id);
    }

    public static List<Cliente> readClienteTable () {
        return ClienteDAO.readClienteTable();
    }

    public static void cancelarInternet ( int id) {
        if (ClienteService.readClienteById(id).getAssinatura().isStatus()) {
            ClienteDAO.cancelarInternet(id);
        }
        else {
            return;
        }
    }

    public static void ativarInternet ( int id) {
        if (!ClienteService.readClienteById(id).getAssinatura().isStatus()) {
            ClienteDAO.ativarInternet(id);
        }
        else {
            return;
        }
    }
}