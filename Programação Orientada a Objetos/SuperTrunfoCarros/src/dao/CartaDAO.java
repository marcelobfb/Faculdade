package dao;

import model.Carta;
import util.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO — Acesso a dados das cartas no banco MySQL.
 */
public class CartaDAO {

    /** Lista todas as cartas ordenadas pelo código. */
    public List<Carta> listarTodas() throws SQLException {
        List<Carta> lista = new ArrayList<>();
        String sql = "SELECT * FROM cartas ORDER BY codigo";

        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    /** Busca carta pelo código (ex.: "1A", "ST"). */
    public Carta buscarPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM cartas WHERE codigo = ?";

        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        }
        return null;
    }

    // ──────────── helper privado ────────────

    private Carta mapear(ResultSet rs) throws SQLException {
        return new Carta(
            rs.getInt("id"),
            rs.getString("codigo"),
            rs.getString("nome"),
            rs.getString("tipo"),
            rs.getInt("velocidade"),
            rs.getInt("potencia"),
            rs.getInt("peso"),
            rs.getInt("tanque"),
            rs.getInt("popularidade"),
            rs.getInt("vitorias"),
            rs.getBoolean("super_trunfo")
        );
    }
}
