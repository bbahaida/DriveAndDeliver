package net.bmbsolutions.driveanddeliver.web;

import net.bmbsolutions.driveanddeliver.mappers.BookingMapper;
import net.bmbsolutions.driveanddeliver.mappers.TimeSlotMapper;
import net.bmbsolutions.driveanddeliver.model.*;
import net.bmbsolutions.driveanddeliver.model.dto.BookingRequestDTO;
import net.bmbsolutions.driveanddeliver.model.dto.BookingResponseDTO;
import net.bmbsolutions.driveanddeliver.model.dto.TimeSlotDTO;
import net.bmbsolutions.driveanddeliver.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingMapper mapper;
    private final TimeSlotMapper timeSlotMapper;

    @Autowired
    public BookingController(BookingService bookingService,
                             BookingMapper mapper,
                             TimeSlotMapper timeSlotMapper
    ) {
        this.bookingService = bookingService;
        this.mapper = mapper;
        this.timeSlotMapper = timeSlotMapper;
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(mapper.mapToDTO(booking));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingsByCustomerId(@PathVariable Long customerId) {
        List<Booking> bookings = bookingService.getBookingsByUser(customerId);
        return ResponseEntity.ok(mapper.mapToDTO(bookings));
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        Booking booking = bookingService.bookTimeSlot((long) bookingRequestDTO.getCustomerId(), (long) bookingRequestDTO.getTimeSlotId());
        BookingResponseDTO createdBooking = mapper.mapToDTO(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/time-slots")
    public ResponseEntity<List<TimeSlotDTO>> getAvailableTimeSlots(@RequestParam(name = "id") Long deliveryMethodId) {
        List<TimeSlot> timeSlots = bookingService.getAvailableTimeSlots(deliveryMethodId);
        List<TimeSlotDTO> availableTimeSlots = timeSlotMapper.mapToDTO(timeSlots);
        return ResponseEntity.ok(availableTimeSlots);
    }
}
