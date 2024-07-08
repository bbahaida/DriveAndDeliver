package net.bmbsolutions.driveanddeliver.service;

import net.bmbsolutions.driveanddeliver.model.Booking;
import net.bmbsolutions.driveanddeliver.model.Customer;
import net.bmbsolutions.driveanddeliver.model.TimeSlot;
import net.bmbsolutions.driveanddeliver.repository.BookingRepository;
import net.bmbsolutions.driveanddeliver.repository.CustomerRepository;
import net.bmbsolutions.driveanddeliver.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final TimeSlotRepository timeSlotRepository;

    private final CustomerRepository customerRepository;

    public BookingService(BookingRepository bookingRepository, TimeSlotRepository timeSlotRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.customerRepository = customerRepository;
    }

    public Booking bookTimeSlot(Long userId, Long timeSlotId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(RuntimeException::new);
        TimeSlot slot = timeSlotRepository.findById(timeSlotId).orElseThrow(RuntimeException::new);
        slot.setBooked(true);
        return bookingRepository.save(new Booking(null, customer, slot));
    }

    public List<Booking> getBookingsByUser(Long userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(RuntimeException::new);

        return bookingRepository.findByCustomer(customer);
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow();
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<TimeSlot> getAvailableTimeSlots(Long deliveryMethodId) {
        return timeSlotRepository.findByDeliveryMethodId(deliveryMethodId);
    }
}
