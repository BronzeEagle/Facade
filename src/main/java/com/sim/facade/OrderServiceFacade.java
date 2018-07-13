package com.sim.facade;

import Subsystem.InventoryService;
import Subsystem.PaymentService;
import Subsystem.ShippingService;

public class OrderServiceFacade implements IOrderServiceFacade  {
	
    public boolean placeOrder(int pId){

        boolean orderFulfilled=false;

        Product product=new Product();

        product.productId=pId;

        if(InventoryService.isAvailable(product))
        {
            System.out.println("Product with ID: "+ product.productId+" is available.");
            boolean paymentConfirmed= PaymentService.makePayment();

            if(paymentConfirmed){

                System.out.println("Payment confirmed...");

                ShippingService.shipProduct(product);

                System.out.println("Product shipped...");

                orderFulfilled=true;
            }
        }
        return orderFulfilled;
    }
}
