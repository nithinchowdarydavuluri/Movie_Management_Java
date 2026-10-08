

import mockit.Mocked;
import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.TickectCategory;
import org.example.exception.InvalidBookingException;
import org.example.serviceIn.BookingServiceIml;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingServiceImlTest {

    @Mocked
    Movie movie;

    @Mocked
    Customer customer;

    @Test
    public void testBookTicket() {

        BookingServiceIml service = new BookingServiceIml();

        Ticket ticket = service.bookTicket(
                movie,
                customer,
                TickectCategory.VIP
        );

        Assert.assertNotNull(ticket);
        Assert.assertEquals(ticket.getMovie(), movie);
        Assert.assertEquals(ticket.getCustomer(), customer);
        Assert.assertEquals(
                ticket.getCategory(),
                TickectCategory.VIP
        );
    }

    @Test(
            expectedExceptions = InvalidBookingException.class
    )
    public void testBookTicketWithNullMovie() {

        BookingServiceIml service = new BookingServiceIml();


        service.bookTicket(
                null,
                customer,
                TickectCategory.VIP
        );
    }
}