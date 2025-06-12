import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o texto que deseja salvar em 'texto.txt':");
        String textoDigitado = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("texto.txt"))) {
            writer.write(textoDigitado);
            System.out.println("Texto salvo com sucesso em 'texto.txt'.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }

        System.out.println("\nLendo o conteúdo de 'texto.txt':");
        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}