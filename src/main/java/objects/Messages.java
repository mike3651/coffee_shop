/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Date;

/**
 *
 * @author ubuntu
 */
public class Messages {
    private int messageId;
    private int userId;
    private String message;
    private Date dateadded;

    public int getMessageId() {
        return messageId;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }
    
    
}
