package br.com.sistemaEstoque.model.dao;

import br.com.sistemaEstoque.connection.ConexaoMysql;
import br.com.sistemaEstoque.model.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conexao = null;

    public ClienteDAO() {
        conexao = ConexaoMysql.getConnection();
    }

    public void salvar(Cliente cliente) {

        String sql = "INSERT INTO TB_clientes (desNome) VALUES (?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public void editar(Cliente cliente) {

        String sql = "UPDATE TB_clientes SET desNome = ? WHERE idCliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setInt(2, cliente.getIdCliente());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public void delete(Cliente cliente) {

        String sql = "DELETE FROM TB_clientes WHERE idCliente = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public List<Cliente> leitura() {
        Connection conexao = ConexaoMysql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> listaCliente = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT * FROM TB_clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("desNome"));

                listaCliente.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivos");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt, rs);
        }
        return listaCliente;
    }

}
