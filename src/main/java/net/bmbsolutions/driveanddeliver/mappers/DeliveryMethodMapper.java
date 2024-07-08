package net.bmbsolutions.driveanddeliver.mappers;

import net.bmbsolutions.driveanddeliver.model.DeliveryMethod;
import net.bmbsolutions.driveanddeliver.model.dto.DeliveryMethodDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMethodMapper extends EntityMapper<DeliveryMethodDTO, DeliveryMethod> {
}
