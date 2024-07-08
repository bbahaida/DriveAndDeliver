package net.bmbsolutions.driveanddeliver.service;

import net.bmbsolutions.driveanddeliver.model.Booking;
import net.bmbsolutions.driveanddeliver.model.Customer;
import net.bmbsolutions.driveanddeliver.model.TimeSlot;
import net.bmbsolutions.driveanddeliver.repository.BookingRepository;
import net.bmbsolutions.driveanddeliver.repository.CustomerRepository;
import net.bmbsolutions.driveanddeliver.repository.TimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private BookingService bookingService;


    @Test
    public void testBookTimeSlot() {
        // Input data
        Long userId = 1L;
        Long timeSlotId = 1L;

        // Mock data
        Customer customer = new Customer(userId, "john.doe", "password123");
        TimeSlot timeSlot = new TimeSlot(timeSlotId, LocalDateTime.now(), LocalDateTime.now().plusHours(1), false, null);
        Booking booking = new Booking(1L, customer, timeSlot);

        when(customerRepository.findById(userId)).thenReturn(Optional.of(customer));
        when(timeSlotRepository.findById(timeSlotId)).thenReturn(Optional.of(timeSlot));
        when(bookingRepository.save(new Booking(null, customer, timeSlot))).thenReturn(booking);

        // Call service method
        Booking result = bookingService.bookTimeSlot(userId, timeSlotId);

        // Verify the result
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getCustomer()).isNotNull();
        assertThat(result.getCustomer().getId()).isEqualTo(userId);
        assertThat(result.getTimeSlot()).isNotNull();
        assertThat(result.getTimeSlot().getId()).isEqualTo(timeSlotId);
    }

    @Test
    public void testGetBookingsByUser() {
        // Input data
        Long userId = 1L;

        // Mock data
        Customer customer = new Customer(userId, "john.doe", "password123");
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1L, customer, new TimeSlot(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1), false, null)));
        bookings.add(new Booking(2L, customer, new TimeSlot(2L, LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3), true, null)));

        when(customerRepository.findById(userId)).thenReturn(Optional.of(customer));
        when(bookingRepository.findByCustomer(customer)).thenReturn(bookings);

        // Call service method
        List<Booking> result = bookingService.getBookingsByUser(userId);

        // Verify the result
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getCustomer().getId()).isEqualTo(userId);
        assertThat(result.get(1).getCustomer().getId()).isEqualTo(userId);
    }

}