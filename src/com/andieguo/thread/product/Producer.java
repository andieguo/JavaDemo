package com.andieguo.thread.product;

public class Producer implements Runnable {
	String name;

	ProductStack ps = null;

	Producer(ProductStack ps, String name) {
		this.ps = ps;
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			Product product = new Product(i, name);
			ps.push(product);
			try {
				Thread.sleep((int) (Math.random() * 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
