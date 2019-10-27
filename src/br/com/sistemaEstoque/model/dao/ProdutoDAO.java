package br.com.sistemaEstoque.model.dao;

import br.com.sistemaEstoque.connection.ConexaoMysql;
import br.com.sistemaEstoque.model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    Connection conexao = null;

    public ProdutoDAO() {
        conexao = ConexaoMysql.getConnection();
    }

    public void salvar(Produto produto) {
        String sql = "INSERT INTO TB_produtos (desNome, vlQuantidade, vlPreco) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getQuantidadeProduto());
            stmt.setDouble(3, produto.getPrecoProduto());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public void editar(Produto produto) {

        String sql = "UPDATE TB_produtos SET desNome = ?, vlQuantidade = ?, vlPreco = ? WHERE idProduto = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getQuantidadeProduto());
            stmt.setDouble(3, produto.getPrecoProduto());
            stmt.setInt(4, produto.getIdProduto());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public void delete(Produto produto) {

        String sql = "DELETE FROM TB_produtos WHERE idProduto = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getIdProduto());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public List<Produto> leitura() {
        Connection conexao = ConexaoMysql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> listaProduto = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement("SELECT * FROM TB_produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("desNome"));
                produto.setPrecoProduto(rs.getDouble("vlPreco"));
                produto.setQuantidadeProduto(rs.getInt("vlQuantidade"));

                listaProduto.add(produto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivos");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt, rs);
        }
        return listaProduto;
    }

}
