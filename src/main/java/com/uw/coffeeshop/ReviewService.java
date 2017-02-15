/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uw.coffeeshop;

import data.Model;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import objects.Review;

/**
 *
 * @author ubuntu
 */
public class ReviewService {    
        @GET
    @Produces(MediaType.TEXT_HTML)
    public String getName() {
        //TODO return proper representation object
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><style>table, th, td {font-family:Arial,Verdana,sans-serif;font-size:16px;padding: 0px;border-spacing: 0px;}</style><b>USERS LIST:</b><br><br><table cellpadding=10 border=1><tr><td>Name</td><td>Age</td><td>userid</td></tr>");
        try
        {
            Model db = Model.singleton();
            Review[] message = db.getReview();
            for (int i=0;i<message.length;i++)
                sb.append("<tr><td>" + message[i].getRating()+ "</td><td>" + message[i].getReview()+ "</td><td>" + message[i].getName()+ "</td></tr>");
        }
        catch (Exception e)
        {
            sb.append("</table><br>Error getting users: " + e.toString() + "<br>");
        }
        sb.append("</table></body></html>");
        return sb.toString();
    }
}
