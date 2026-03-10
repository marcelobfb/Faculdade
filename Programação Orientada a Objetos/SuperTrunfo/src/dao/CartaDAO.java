package dao;

import modelo.Carta;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CartaDAO {

    // Ajuste o caminho conforme a localização do seu arquivo CSV
    private static final String ARQUIVO_CARTAS = "database/cartas.csv";

    public List<Carta> listarTodas() {
        List<Carta> cartas = new ArrayList<>();
        File arquivo = new File(ARQUIVO_CARTAS);

        if (!arquivo.exists()) {
            System.err.println("Arquivo não encontrado: " + arquivo.getAbsolutePath());
            return cartas; // retorna vazio
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true; // pular cabeçalho

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(";");
                if (dados.length < 6) continue; // linha inválida

                Carta c = new Carta();
                c.setId(Integer.parseInt(dados[0]));
                c.setNome(dados[1]);
                c.setVelocidade(Integer.parseInt(dados[2]));
                c.setAceleracao(Integer.parseInt(dados[3]));
                c.setPotencia(Integer.parseInt(dados[4]));
                c.setSuperTrunfo(Boolean.parseBoolean(dados[5]));

                cartas.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartas;
    }
}