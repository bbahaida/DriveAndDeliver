package net.bmbsolutions.driveanddeliver.service;

import net.bmbsolutions.driveanddeliver.model.DeliveryMethod;
import net.bmbsolutions.driveanddeliver.model.TimeSlot;
import net.bmbsolutions.driveanddeliver.repository.DeliveryMethodRepository;
import net.bmbsolutions.driveanddeliver.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryMethodService {
    private final TimeSlotRepository timeSlotRepository;
    private final DeliveryMethodRepository deliveryMethodRepository;

    public DeliveryMethodService(TimeSlotRepository timeSlotRepository, DeliveryMethodRepository deliveryMethodRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.deliveryMethodRepository = deliveryMethodRepository;
    }

    public List<TimeSlot> getTimeSlotsByDeliveryMethod(Long deliveryMethodId) {
        return timeSlotRepository.findByDeliveryMethodId(deliveryMethodId);
    }

    public List<DeliveryMethod> getAllDeliveryMethods() {
        return deliveryMethodRepository.findAll();
    }
}
