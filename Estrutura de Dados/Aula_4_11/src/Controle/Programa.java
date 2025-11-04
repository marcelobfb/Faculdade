package Controle;

import java.util.Scanner;

public class Programa {
	
	public static int pesquisar(int[] numeros, int num) {
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] == num) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numeros = {3, 17, 25, 38, 68, 79, 94, 1, 5, 23, 26, 42, 70, 83};
		
		System.out.print("Digite um numero para pesquisar: ");
		int num = input.nextInt();
		
		int indiceEncontrado = pesquisar(numeros, num);
		
		if (indiceEncontrado != -1) {
            System.out.println("O número " + num + " foi encontrado no índice: " + indiceEncontrado);
        } else {
            System.out.println("O número " + num + " não foi encontrado no array.");
        }
		
		input.close();
	}
}