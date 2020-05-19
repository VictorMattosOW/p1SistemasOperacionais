package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	private int pessoa;
	private Semaphore porta;

	public ThreadCorredor(int pessoa, Semaphore porta) {
		this.pessoa = pessoa;
		this.porta = porta;
	}

	@Override
	public void run() {
		PessoaCorrendo();
		try {
			System.out.println("pessoa #" + pessoa + " chegou até a porta");
			porta.acquire();
			Thread.sleep((int) (Math.random() * 1000) + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			porta.release();
			System.out.println("pessoa #" + pessoa + " saiu pela porta");
		}
	}

	public void PessoaCorrendo() {
		int distancia = 0;
		System.out.println("Pessoa #" + pessoa + " começou a correr");
		while (distancia < 200) {
			distancia += (int) (Math.random() * 2) + 4;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
