package alture.netbombafx.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assinatura_id", referencedColumnName = "id")
    private Assinatura assinatura;

    public static class Builder{

        private int id;
        private String nome;
        private String cpf;
        private Endereco endereco;
        private Assinatura assinatura;

        public Builder id( int id ) {
            this.id = id;
            return this;
        }

        public Builder nome ( String nome ) {
            this.nome = nome;
            return this;
        }

        public Builder cpf ( String cpf ) {
            this.cpf = cpf;
            return this;
        }

        public Builder endereco ( Endereco endereco ) {
            this.endereco = endereco;
            return this;
        }

        public Builder Assinatura ( Assinatura assinatura) {
            this.assinatura = assinatura;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();

            cliente.id = id;
            cliente.nome = nome;
            cliente.cpf = cpf;
            cliente.endereco = endereco;
            cliente.assinatura = assinatura;

            return cliente;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", assinatura="
                + assinatura + "]";
    }

}