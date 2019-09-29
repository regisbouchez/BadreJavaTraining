package com.bnpparibas.training.stream;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamReductionDemo2 {
    class Order {
        public int orderId;
        public double value;
        public LocalDate orderDate;
        public Order(int orderId, double value, 
                LocalDate orderDate) {
            this.orderId = orderId;
            this.value = value;
            this.orderDate = orderDate;
        }
    }
    
    public Order[] getOrders() {
        Order[] orders = { 
            new Order(1, 100.49,  
                    LocalDate.of(2014, Month.DECEMBER, 11)), 
            new Order(1, 88.09,  
                    LocalDate.of(2014, Month.DECEMBER, 29)), 
            new Order(1, 10.29,  
                    LocalDate.of(2014, Month.DECEMBER, 30)), 
            new Order(1, 100.49,
                    LocalDate.of(2014, Month.NOVEMBER, 22)) 
        };
        return orders;
    }
    
    public double calculateSalesTotal(Order[] orders, 
            YearMonth yearMonth) {
        Predicate<Order> orderInGivenMonth
                = (order) -> order.orderDate.getMonth() 
                        == yearMonth.getMonth()
                && order.orderDate.getYear() 
                        == yearMonth.getYear();
        
        Stream<Order> stream = Stream.of(orders);
        return stream.filter(orderInGivenMonth)
                .mapToDouble((order) -> order.value)
                .reduce(0, (a, b) -> a+b);
    }
    

    public static void main(String[] args) {
        StreamReductionDemo2 demo = new StreamReductionDemo2();
        Order[] orders = demo.getOrders();
        double totalSalesForMonth = demo.calculateSalesTotal(
                orders, YearMonth.of(2014, Month.NOVEMBER));
        System.out.printf("Sales for Nov 2014 : $%2.2f\n",
                totalSalesForMonth);

        totalSalesForMonth = demo.calculateSalesTotal(
                orders, YearMonth.of(2014, Month.DECEMBER));
        System.out.printf("Sales for Dec 2014 : $%2.2f\n",
                totalSalesForMonth);
    }
}