/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample_maven_web_app;

import static com.mycompany.sample_maven_web_app.UserService.logger;
import data.Model;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import objects.Messages;
import objects.User;
import org.codehaus.jackson.map.ObjectMapper;

@Path("Message")

/**
 *
 * @author ubuntu
 */
public class MessageService {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessages() {
        //TODO return proper representation object
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><style>table, th, td {font-family:Arial,Verdana,sans-serif;font-size:16px;padding: 0px;border-spacing: 0px;}</style><b>USERS LIST:</b><br><br><table cellpadding=10 border=1><tr><td>Name</td><td>Age</td><td>userid</td></tr>");
        try
        {
            Model db = Model.singleton();
            Messages[] message = db.getMessage();
            for (int i=0;i<message.length;i++)
                sb.append("<tr><td>" + message[i].getDateadded() + "</td><td>" + message[i].getMessageId() + "</td><td>" + message[i].getUserId() + "</td></tr>");
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
    public String createUser(String jobj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(jobj.toString(), User.class);
        
        StringBuilder text = new StringBuilder();
        text.append("The JSON obj:" + jobj.toString() + "\n");
        text.append("Hello " + user.getName() + "\n");
        text.append("You're only " + user.getAge() + " years old.\n");
        text.append("Messages:\n");
        for (Object msg : user.getMessages())
            text.append(msg.toString() + "\n");
        
        try {
            Model db = Model.singleton();
            int userid = db.newUser(user);
            logger.log(Level.INFO, "user persisted to db as userid=" + userid);
            text.append("User id persisted with id=" + userid);
        }
        catch (SQLException sqle)
        {
            String errText = "Error persisting user after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
        }
        
        
        return text.toString();
    }
}
