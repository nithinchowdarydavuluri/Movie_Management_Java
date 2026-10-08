package servlets;

import org.example.Model.BookingDetails;
import org.example.service.TicketServiceIml;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/getTicket/*")
public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String val = req.getPathInfo();
        int  c = Integer.parseInt(val.split("/")[1]);

        TicketServiceIml ts = new TicketServiceIml();
        List<BookingDetails > bs = ts.getByCustomerId(c);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/Ticket.jsp");
        req.setAttribute("bookings",bs);

        dispatcher.forward(req, resp);


    }
}
