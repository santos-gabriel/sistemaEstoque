package br.com.sistemaEstoque.controller;

import br.com.sistemaEstoque.model.bean.Produto;
import br.com.sistemaEstoque.model.dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;

public class CtrlProduto {

    public static void inserir(Produto produto) {
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.salvar(produto);
    }

    public static void excluir(Produto produto) {
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.delete(produto);
    }

    public static void editar(Produto produto) {
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.editar(produto);
    }

    public static List<Produto> list() {
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> lista = new ArrayList<>();
        for (Produto p : prodDAO.leitura()) {
            lista.add(p);
        }
        return lista;
    }

}
