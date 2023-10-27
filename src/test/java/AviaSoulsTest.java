import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SAM", 200, 9, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 15);
        Ticket ticket3 = new Ticket("MSK", "SAM", 300, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "EKB", 500, 7, 10);
        Ticket ticket5 = new Ticket("MSK", "SAM", 100, 3, 5);
        Ticket ticket6 = new Ticket("MSK", "KZN", 400, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "SAM", 400, 5, 6);
        Ticket ticket8 = new Ticket("MSK", "SAM", 200, 18, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket5, ticket1, ticket8, ticket3, ticket7};
        Ticket[] actual = manager.search("MSK", "SAM");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsAbsent() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SAM", 200, 9, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 15);
        Ticket ticket3 = new Ticket("MSK", "SAM", 300, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "EKB", 500, 7, 10);
        Ticket ticket5 = new Ticket("MSK", "SAM", 100, 3, 5);
        Ticket ticket6 = new Ticket("MSK", "KZN", 400, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "SAM", 400, 5, 6);
        Ticket ticket8 = new Ticket("MSK", "SAM", 200, 18, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {};
        Ticket[] actual = manager.search("SAR", "KRS");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SAM", 200, 9, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 15);
        Ticket ticket3 = new Ticket("MSK", "SAM", 300, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "EKB", 500, 7, 10);
        Ticket ticket5 = new Ticket("MSK", "SAM", 100, 3, 5);
        Ticket ticket6 = new Ticket("MSK", "KZN", 400, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "SAM", 400, 5, 6);
        Ticket ticket8 = new Ticket("MSK", "SAM", 200, 18, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("MSK", "EKB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SAM", 200, 9, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 15);
        Ticket ticket3 = new Ticket("MSK", "SAM", 300, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "EKB", 500, 7, 10);
        Ticket ticket5 = new Ticket("MSK", "SAM", 100, 3, 7);
        Ticket ticket6 = new Ticket("MSK", "KZN", 400, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "SAM", 400, 5, 6);
        Ticket ticket8 = new Ticket("MSK", "SAM", 200, 16, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket1, ticket3, ticket5, ticket8};
        Ticket[] actual = manager.search("MSK", "SAM", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorAbsent() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SAM", 200, 9, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 15);
        Ticket ticket3 = new Ticket("MSK", "SAM", 300, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "EKB", 500, 7, 10);
        Ticket ticket5 = new Ticket("MSK", "SAM", 100, 3, 7);
        Ticket ticket6 = new Ticket("MSK", "KZN", 400, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "SAM", 400, 5, 6);
        Ticket ticket8 = new Ticket("MSK", "SAM", 200, 16, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "NSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SAM", 200, 9, 11);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 15);
        Ticket ticket3 = new Ticket("MSK", "SAM", 300, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "EKB", 500, 7, 10);
        Ticket ticket5 = new Ticket("MSK", "SAM", 100, 3, 7);
        Ticket ticket6 = new Ticket("MSK", "KZN", 400, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "SAM", 400, 5, 6);
        Ticket ticket8 = new Ticket("MSK", "SAM", 200, 16, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("MSK", "KZN", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
