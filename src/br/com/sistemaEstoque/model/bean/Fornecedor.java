package br.com.sistemaEstoque.model.bean;

public class Fornecedor {

    private int idFornecedor;
    private String nomeFornecedor;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String nomeFornecedor) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

}
