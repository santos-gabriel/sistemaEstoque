package br.com.sistemaEstoque.model;

public class Cliente {

    private int idCliente;
    private String nomeCliente;

    public Cliente() {
    }

    public Cliente(int id_cli, String nome_cli) {
        this.idCliente = id_cli;
        this.nomeCliente = nome_cli;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
