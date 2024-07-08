package net.bmbsolutions.driveanddeliver.mappers;

import net.bmbsolutions.driveanddeliver.model.TimeSlot;
import net.bmbsolutions.driveanddeliver.model.dto.TimeSlotDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper extends EntityMapper<TimeSlotDTO, TimeSlot> {
}
