package servlets;

import org.example.Model.Movie;
import org.example.enums.TickectCategory;
import org.example.repository.CustomerRepositoryImpl;
import org.example.repository.MovieRepositoryImpl;
import org.example.service.BookingService;
import org.example.service.BookingServiceIml;
import org.example.service.CustomerService;
import org.example.service.MovieServiceIml;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/bookAmovie")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("got it");
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/Bookform.jsp");
        MovieRepositoryImpl mr = new MovieRepositoryImpl();
        MovieServiceIml ms = new MovieServiceIml(mr);
        req.setAttribute("movielist",ms.getAll());
        CustomerRepositoryImpl cr = new CustomerRepositoryImpl();
        CustomerService cs = new CustomerService(cr);
        req.setAttribute("customerlist",cs.getcustomers());

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int movieId = Integer.parseInt(req.getParameter("movie"));
       int CusotmerId = Integer.parseInt(req.getParameter("customer"));
        TickectCategory tc = TickectCategory.getById(Integer.parseInt(req.getParameter("category")));

        BookingServiceIml bs = new BookingServiceIml();
        bs.bookTicket(movieId,CusotmerId,tc);
//        resp.setContentType("text/html");
//        resp.getWriter().println("Ticket is Created");
        resp.sendRedirect(req.getContextPath() + "/getTicket/"+CusotmerId);
    }
}
