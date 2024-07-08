package net.bmbsolutions.driveanddeliver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bmbsolutions.driveanddeliver.messaging.PublishAggregate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PublishAggregate(topic = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    private TimeSlot timeSlot;
}
