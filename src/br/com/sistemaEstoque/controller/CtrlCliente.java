package br.com.sistemaEstoque.controller;

import br.com.sistemaEstoque.model.bean.Cliente;
import br.com.sistemaEstoque.model.dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

public class CtrlCliente {

    public static void gravar(Cliente cliente) {
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.salvar(cliente);
    }

    public static List<Cliente> listar() {
        ClienteDAO cliDAO = new ClienteDAO();
        List<Cliente> lista = new ArrayList<>();

        for (Cliente cli : cliDAO.leitura()) {
            lista.add(cli);
        }
        return lista;
    }

    public static void delete(Cliente cliente) {
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.delete(cliente);
    }

    public static void editar(Cliente cliente) {
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.editar(cliente);
    }

}
