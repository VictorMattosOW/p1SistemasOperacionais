package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class Main {
	public static void main(String[] args) {
		int permissao = 1;
		Semaphore porta = new Semaphore(permissao);
		
		for(int pessoa=1;pessoa<5;pessoa++) {
			Thread port�o = new ThreadCorredor(pessoa, porta);
			port�o.start();
		}
	}
}