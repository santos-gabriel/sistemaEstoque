package br.com.sistemaEstoque.model.dao;

import br.com.sistemaEstoque.connection.ConexaoMysql;
import br.com.sistemaEstoque.model.bean.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FornecedorDAO {

    private Connection conexao = null;

    public FornecedorDAO() {
        conexao = ConexaoMysql.getConnection();
    }

    public void salvar(Fornecedor fornecedor) {
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO TB_fornecedores (desNome) VALUES (?)");
            stmt.setString(1, fornecedor.getNomeFornecedor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public void editar(Fornecedor fornecedor) {

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE TB_Fornecedores SET desNome = ? WHERE idFornecedor = ?");
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setInt(2, fornecedor.getIdFornecedor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar!");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public void delete(Fornecedor fornecedor) {

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM TB_fornecedores WHERE idFornecedor = ?");
            stmt.setInt(1, fornecedor.getIdFornecedor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(conexao, stmt);
        }

    }

    public List<Fornecedor> leitura() {
        Connection con = ConexaoMysql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM TB_fornecedores");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("desNome"));

                listaFornecedor.add(fornecedor);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados! ");
            System.out.println(ex);
        } finally {
            ConexaoMysql.closeConnection(con, stmt, rs);
        }

        return listaFornecedor;
    }

}
