import mockit.Expectations;
import mockit.Mocked;
import org.example.Model.Ticket;
import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;
import org.example.repository.BookingRepositoryImpl;
import org.example.service.BookingServiceIml;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImlTest {

    @Mocked
    BookingRepositoryImpl bookingRepository;

    @Test
    public void testBookTicket() {

        new Expectations() {{
            bookingRepository.createTicket(
                    1,
                    2,
                    TickectCategory.VIP,
                    BookingStatus.CREATED
            );
            times = 1;
        }};

        BookingServiceIml service = new BookingServiceIml();

        service.bookTicket(1, 2, TickectCategory.VIP);
    }

    @Test
    public void testHistory() {

        List<Ticket> tickets = new ArrayList<>();

        new Expectations() {{
            bookingRepository.getAllTickets();
            result = tickets;
        }};

        BookingServiceIml service = new BookingServiceIml();

        List<Ticket> result = service.history();

        Assert.assertNotNull(result);
        Assert.assertEquals(result, tickets);
    }
}