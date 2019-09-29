package com.bnpparibas.training.stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReductionDemo1 {
	class Order {
		public int orderId;
		public double value;
		public LocalDate orderDate;

		public Order(int orderId, double value, LocalDate orderDate) {
			this.orderId = orderId;
			this.value = value;
			this.orderDate = orderDate;
		}
	}

	public Order[] getOrders() {
		Order[] orders = {
				new Order(1, 100.49, LocalDate.of(2014, Month.DECEMBER, 11)),
				new Order(1, 88.09, LocalDate.of(2014, Month.DECEMBER, 29)),
				new Order(1, 10.29, LocalDate.of(2014, Month.DECEMBER, 30)),
				new Order(1, 100.49, LocalDate.of(2014, Month.NOVEMBER, 22)) };
		return orders;
	}

	public Optional<Order> getLatestLargestOrder(Order[] orders) {
		Stream<Order> stream = Stream.of(orders);
		Optional<Order> theOrder = stream.reduce((a, b) -> {
			if (a.value > b.value) {
				return a;
			} else if (a.value < b.value) {
				return b;
			} else if (a.orderDate.isAfter(b.orderDate)) {
				return a;
			} else {
				return b;

			}
		});
		return theOrder;
	}

	public static void main(String[] args) {
		StreamReductionDemo1 demo = new StreamReductionDemo1();
		Order[] orders = demo.getOrders();
		Optional<Order> latestLargest = demo.getLatestLargestOrder(orders);
		if (latestLargest.isPresent()) {
			Order order = latestLargest.get();
			System.out.printf("Latest largest order value: $%2.2f,",
					order.value);
			System.out.println(" date : " + order.orderDate);
		} else {
			System.out.println("No order found");
		}

	}
}