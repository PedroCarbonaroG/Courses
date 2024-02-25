package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;

public class Prompt {
    
    private static Scanner sc = new Scanner(System.in, "UTF-8");
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Order order = new Order();
    private OrderItem orderItem;

    public void startPrompt() throws ParseException {
        System.out.println("=======================================================");
        System.out.println("Enter Client data:");
        System.out.print("Name: "); order.getClient().setName(sc.nextLine());
        System.out.print("Email: "); order.getClient().setEmail(sc.nextLine());
        System.out.print("Birth date (DD/MM/YYYY): "); order.getClient().setBirthDate(sdf.parse(sc.nextLine()));
        System.out.println("Enter order data: ");
        System.out.println("Status avaliables->(PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED)");
        System.out.print("Current Status: "); order.setStatus(OrderStatus.valueOf(sc.nextLine().toUpperCase()));
        System.out.print("How many items to this order: "); short itemsNum = sc.nextShort();
        sc.nextLine(); //Cleaning the buffer
        for (short i = 0, j = 1; i < itemsNum; i++, j++) {
            orderItem = new OrderItem();
            System.out.println("Enter #" + j + " item data:");
            System.out.print("Product name: "); orderItem.getProduct().setName(sc.nextLine());
            System.out.print("Product price: "); orderItem.getProduct().setPrice(sc.nextDouble());
            System.out.print("Quantity: "); orderItem.setQuantity(sc.nextShort()); 
            sc.nextLine(); //Cleaning the buffer
            order.addItem(orderItem);
        }

        System.out.println("=======================================================");
        System.out.println("ORDER SUMMARY");
        System.out.println(order);

    }
}
