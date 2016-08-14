package com.andieguo.thread.product;
public class ProductStack {
	int index = 0;

	Product[] arrProduct = new Product[6];

	public synchronized void push(Product product) {
		while (index == arrProduct.length) 
		{
			try {

				System.out.println(product.getProducedBy() + " is waiting.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(product.getProducedBy() + " sent a notifyAll().");

		notifyAll();
		arrProduct[index] = product;
		index++;
		System.out.println(product.getProducedBy() + " ������: " + product);
	}

	public synchronized Product pop(String consumerName) {
		while (index == 0) {
			try {
				System.out.println(consumerName + " is waiting.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(consumerName + " sent a notifyAll().");
		notifyAll();
		index--;
		Product product = arrProduct[index];
		product.consume(consumerName);
		System.out.println(product.getConsumedBy() + " : " + product);
		return product;
	}
}
