package alture.netbombafx.model.entity.services;

import main.model.dao.EnderecoDAO;
import main.model.dao.PlanoDAO;
import main.model.entity.Endereco;
import main.model.entity.Plano;

public class EnderecoService {
    public static Endereco createEndereco( String rua, int numero) {
        Endereco endereco = new Endereco.Builder()
                .rua(rua)
                .numero(numero)
                .build();
        EnderecoDAO.addEndereco(endereco);
        return endereco;
    }

    public static Endereco readEnderecoById ( int id ) {
        return EnderecoDAO.getEndereco(id);
    }

    public static void editEndereco ( int id , String rua, int numero ) {
        EnderecoDAO.updateEndereco(id, rua, numero);
    }

    public static void deleteEndereco ( int id ) {
        EnderecoDAO.deleteEndereco(id);
    }
}