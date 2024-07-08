package net.bmbsolutions.driveanddeliver.repository;

import net.bmbsolutions.driveanddeliver.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByDeliveryMethodId(Long methodId);
}
