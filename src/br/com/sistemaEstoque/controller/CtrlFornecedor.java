package br.com.sistemaEstoque.controller;

import br.com.sistemaEstoque.model.bean.Fornecedor;
import br.com.sistemaEstoque.model.dao.FornecedorDAO;
import java.util.ArrayList;
import java.util.List;

public class CtrlFornecedor {

    public static void inserir(Fornecedor fornecedor) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.salvar(fornecedor);
    }

    public static void editar(Fornecedor fornecedor) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.editar(fornecedor);
    }

    public static void excluir(Fornecedor fornecedor) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.delete(fornecedor);
    }

    public static List<Fornecedor> list() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> lista = new ArrayList<>();
        for (Fornecedor f : fornecedorDAO.leitura()) {
            lista.add(f);
        }
        return lista;
    }

}
