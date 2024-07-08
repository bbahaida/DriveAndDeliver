package net.bmbsolutions.driveanddeliver.web;

import net.bmbsolutions.driveanddeliver.mappers.DeliveryMethodMapper;
import net.bmbsolutions.driveanddeliver.model.dto.DeliveryMethodDTO;
import net.bmbsolutions.driveanddeliver.service.DeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/delivery-methods")
public class DeliveryMethodController {
    private final DeliveryMethodService deliveryMethodService;
    private final DeliveryMethodMapper mapper;

    @Autowired
    public DeliveryMethodController(DeliveryMethodService deliveryMethodService, DeliveryMethodMapper mapper) {
        this.deliveryMethodService = deliveryMethodService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryMethodDTO>> getAllDeliveryMethods() {
        List<DeliveryMethodDTO> deliveryMethods = mapper.mapToDTO(deliveryMethodService.getAllDeliveryMethods());
        return ResponseEntity.ok(deliveryMethods);
    }
}
