package net.bmbsolutions.driveanddeliver.service;

import net.bmbsolutions.driveanddeliver.model.DeliveryMethod;
import net.bmbsolutions.driveanddeliver.model.TimeSlot;
import net.bmbsolutions.driveanddeliver.repository.DeliveryMethodRepository;
import net.bmbsolutions.driveanddeliver.repository.TimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeliveryMethodServiceTest {
    @Mock
    private DeliveryMethodRepository deliveryMethodRepository;

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @InjectMocks
    private DeliveryMethodService deliveryMethodService;


    @Test
    public void testGetAllDeliveryMethods() {
        // Mock data
        List<DeliveryMethod> mockDeliveryMethods = new ArrayList<>();
        mockDeliveryMethods.add(new DeliveryMethod(1L, "DRIVE"));
        mockDeliveryMethods.add(new DeliveryMethod(2L, "DELIVERY"));

        when(deliveryMethodRepository.findAll()).thenReturn(mockDeliveryMethods);

        List<DeliveryMethod> result = deliveryMethodService.getAllDeliveryMethods();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);

        assertThat(result.get(0).getMethodName()).isEqualTo("DRIVE");
        assertThat(result.get(1).getMethodName()).isEqualTo("DELIVERY");
    }

    @Test
    public void testGetTimeSlotsByDeliveryMethod() {
        // Mock data
        Long deliveryMethodId = 1L;
        DeliveryMethod mockDeliveryMethod = new DeliveryMethod(deliveryMethodId, "DRIVE");
        List<TimeSlot> mockTimeSlots = new ArrayList<>();
        mockTimeSlots.add(new TimeSlot(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1), false, mockDeliveryMethod));
        mockTimeSlots.add(new TimeSlot(2L, LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3), true, mockDeliveryMethod));

        when(timeSlotRepository.findByDeliveryMethodId(deliveryMethodId)).thenReturn(mockTimeSlots);

        // Call service method
        List<TimeSlot> result = deliveryMethodService.getTimeSlotsByDeliveryMethod(deliveryMethodId);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);

        assertThat(result.get(0).getDeliveryMethod().getId()).isEqualTo(deliveryMethodId);
        assertThat(result.get(1).getDeliveryMethod().getId()).isEqualTo(deliveryMethodId);
    }
}