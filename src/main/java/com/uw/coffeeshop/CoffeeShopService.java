/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uw.coffeeshop;

/**
 *
 * @author ubuntu
 */
public class CoffeeShopService {
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createShop(String job) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Review shop = mapper.readValue(job.toString(), CoffeeShop.class);
        
        StringBuilder text = new StringBuilder();
        text.append("The JSON obj:" + job.toString() + "\n");
        text.append("The shop's title is " + shop.getName() + "\n");
        text.append("The address of this shop is " + shop.getAddress()+ " Name.\n");
        text.append("Coffee Shop:\n");
        for (Object msg : shop.getShops())
            text.append(msg.toString() + "\n");
        
        return text.toString();
    }
    
}
