package net.bmbsolutions.driveanddeliver.repository;

import net.bmbsolutions.driveanddeliver.model.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryMethodRepository extends JpaRepository<DeliveryMethod, Long> {
    Optional<DeliveryMethod> findByMethodName(String name);
}
