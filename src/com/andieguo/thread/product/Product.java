package com.andieguo.thread.product;

public class Product {
	int id;
	private String producedBy = "N/A";
	private String consumedBy = "N/A";

	// 构造函数，指明产品ID以及生产者名字。
	Product(int id, String producedBy) {
		this.id = id;
		this.producedBy = producedBy;
	}

	// 消费，需要指明消费者名字
	public void consume(String consumedBy) {
		this.consumedBy = consumedBy;
	}

	public String toString() {
		return "Product : " + id + ", produced by " + producedBy
				+ ", consumed by " + consumedBy;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	public String getConsumedBy() {
		return consumedBy;
	}

	public void setConsumedBy(String consumedBy) {
		this.consumedBy = consumedBy;
	}
}
