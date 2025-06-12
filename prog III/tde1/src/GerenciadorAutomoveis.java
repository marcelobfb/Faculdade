import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class GerenciadorAutomoveis {
    private ArrayList<Automovel> automoveis;
    private static final String NOME_ARQUIVO = "automoveis.txt";

    public GerenciadorAutomoveis() {
        automoveis = new ArrayList<>();
        carregarDados(); // Load data when the manager is initialized
    }

    /**
     * Includes a new car in the list.
     *
     * @param automovel The Automovel object to be included.
     * @return true if the car was successfully included, false if the license plate already exists.
     */
    public boolean incluirAutomovel(Automovel automovel) {
        for (Automovel a : automoveis) {
            if (a.getPlaca().equalsIgnoreCase(automovel.getPlaca())) {
                return false; // License plate already exists
            }
        }
        automoveis.add(automovel);
        System.out.println("Automóvel incluído com sucesso!");
        return true;
    }

    /**
     * Removes a car based on its license plate.
     *
     * @param placa The license plate of the car to be removed.
     * @return true if the car was successfully removed, false if not found.
     */
    public boolean removerAutomovel(String placa) {
        Iterator<Automovel> iterator = automoveis.iterator();
        while (iterator.hasNext()) {
            Automovel a = iterator.next();
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                iterator.remove();
                System.out.println("Automóvel removido com sucesso!");
                return true;
            }
        }
        return false; // Car not found
    }

    /**
     * Alters the data of an existing car.
     *
     * @param placa The license plate of the car to be altered.
     * @param novoModelo The new model.
     * @param novaMarca The new brand.
     * @param novoAno The new year.
     * @param novoValor The new value.
     * @return true if the car was successfully altered, false if not found.
     */
    public boolean alterarAutomovel(String placa, String novoModelo, String novaMarca, int novoAno, double novoValor) {
        for (Automovel a : automoveis) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                a.setModelo(novoModelo);
                a.setMarca(novaMarca);
                a.setAno(novoAno);
                a.setValor(novoValor);
                System.out.println("Automóvel alterado com sucesso!");
                return true;
            }
        }
        return false; // Car not found
    }

    /**
     * Consults and displays the data of a car by its license plate.
     *
     * @param placa The license plate of the car to be consulted.
     * @return The Automovel object if found, otherwise null.
     */
    public Automovel consultarAutomovel(String placa) {
        for (Automovel a : automoveis) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                return a;
            }
        }
        return null; // Car not found
    }

    /**
     * Lists all cars, ordered by the specified criteria.
     *
     * @param criterioDeOrdenacao The sorting criterion ("placa", "modelo", or "marca").
     * @return A sorted ArrayList of Automovel objects.
     */
    public ArrayList<Automovel> listarAutomoveis(String criterioDeOrdenacao) {
        ArrayList<Automovel> listaOrdenada = new ArrayList<>(automoveis); // Create a copy to sort

        switch (criterioDeOrdenacao.toLowerCase()) {
            case "placa":
                Collections.sort(listaOrdenada, Comparator.comparing(Automovel::getPlaca));
                break;
            case "modelo":
                Collections.sort(listaOrdenada, Comparator.comparing(Automovel::getModelo));
                break;
            case "marca":
                Collections.sort(listaOrdenada, Comparator.comparing(Automovel::getMarca));
                break;
            default:
                System.out.println("Critério de ordenação inválido. Listando por placa por padrão.");
                Collections.sort(listaOrdenada, Comparator.comparing(Automovel::getPlaca));
                break;
        }
        return listaOrdenada;
    }

    /**
     * Saves the current list of cars to a text file.
     */
    public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Automovel a : automoveis) {
                writer.write(a.toCSV());
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso no arquivo: " + NOME_ARQUIVO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    /**
     * Loads car data from a text file into the ArrayList.
     */
    private void carregarDados() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) {
            System.out.println("Arquivo de dados não encontrado. Iniciando com lista vazia.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) { // CORRECTED LINE HERE
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    try {
                        String placa = dados[0];
                        String modelo = dados[1];
                        String marca = dados[2];
                        int ano = Integer.parseInt(dados[3]);
                        double valor = Double.parseDouble(dados[4]);
                        automoveis.add(new Automovel(placa, modelo, marca, ano, valor));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro de formato de número na linha: " + linha + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Linha com formato inválido (esperado 5 campos): " + linha);
                }
            }
            System.out.println("Dados carregados com sucesso do arquivo: " + NOME_ARQUIVO);
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}