package com.sim.facade;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderFulfillmentControllerTest {
   
	@Test
    public void testOrderProduct() throws Exception {

        OrderFulfillmentController controller=new OrderFulfillmentController();

        controller.facade=new OrderServiceFacade();

        controller.orderProduct(18);

        boolean result=controller.orderFulfilled;

        assertTrue(result);

    }
}
