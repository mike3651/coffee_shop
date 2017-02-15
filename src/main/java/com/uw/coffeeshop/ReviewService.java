/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uw.coffeeshop;

import data.Model;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import objects.Review;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author ubuntu
 */
public class ReviewService {    
        @GET
    @Produces(MediaType.TEXT_HTML)
    public String getReviews() {
        //TODO return proper representation object
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><style>table, th, td {font-family:Arial,Verdana,sans-serif;font-size:16px;padding: 0px;border-spacing: 0px;}</style><b>USERS LIST:</b><br><br><table cellpadding=10 border=1><tr><td>Name</td><td>Age</td><td>userid</td></tr>");
        try
        {
            Model db = Model.singleton();
            Review[] message = db.getReviews();
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
    
    
     
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createReview(String jobj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Review user = mapper.readValue(jobj.toString(), Review.class);
        
        StringBuilder text = new StringBuilder();
        text.append("The JSON obj:" + jobj.toString() + "\n");
        text.append("Hello " + user.getName() + "\n");
        text.append("You're only " + user.getName()+ " Name.\n");
        text.append("Review:\n");
        for (Object msg : user.getReviews())
            text.append(msg.toString() + "\n");
        
        return text.toString();
    }
}
