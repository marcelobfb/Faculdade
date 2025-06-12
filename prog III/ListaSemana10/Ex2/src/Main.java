import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String nomeArquivo = "dados.txt";
        int contadorPalavras = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.trim().split("\\s+");
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        contadorPalavras++;
                    }
                }
            }
            System.out.println("O arquivo '" + nomeArquivo + "' contém " + contadorPalavras + " palavras.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo '" + nomeArquivo + "': " + e.getMessage());
        }
    }
}