package servlets;

import org.example.Model.BookingDetails;
import org.example.service.TicketServiceIml;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;
import org.example.util.VelocityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/payNow/*")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ticketId"));
        float amount = Float.parseFloat(req.getParameter("price"));
        int Customerid  = Integer.parseInt(req.getParameter("CustomerId"));
        TicketServiceIml ts = new TicketServiceIml();
        ts.paynow(id,Customerid,amount);
        resp.setContentType("text/html");
        BookingDetails bs = ts.getByTicketId(id);
//        VelocityUtil.generateTicket(bs,"ticket.html");
        String val = JsonUtil.ObjectToJson(bs);
        System.out.println(val);
        FileUtil.writeToFile("application.txt",bs.toString());
        resp.getWriter().println("<p>Payed Sucessfully</p>");


    }
}
