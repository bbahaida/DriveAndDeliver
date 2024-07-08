package net.bmbsolutions.driveanddeliver.repository;

import net.bmbsolutions.driveanddeliver.model.Booking;
import net.bmbsolutions.driveanddeliver.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer(Customer customer);
}
