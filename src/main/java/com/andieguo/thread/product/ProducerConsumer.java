package com.andieguo.thread.product;

public class ProducerConsumer {
	 public static void main(String[] args) {
         ProductStack ps = new ProductStack();
         Producer p = new Producer(ps, "������1");
         Consumer c = new Consumer(ps, "������1");
         new Thread(p).start();
         new Thread(c).start();
    }
}
