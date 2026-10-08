package org.example.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.example.Model.BookingDetails;
import org.example.Model.Ticket;

import java.io.FileWriter;
import java.io.IOException;

public class VelocityUtil {

    public static void generateTicket(BookingDetails ticket, String outputFile){
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("src/main/resources/booking.vm");
        VelocityContext context = new VelocityContext();
        context.put("movieName",ticket.getMovieName());
        context.put("customerName", ticket.getCustomerName());
        context.put("category", ticket.getCategory());
        context.put("status", ticket.getStatus());
        try(FileWriter writter = new FileWriter(outputFile)){
            template.merge(context,writter);
        }catch (IOException e){
              System.out.println(e.getMessage());
        }
    }
}
