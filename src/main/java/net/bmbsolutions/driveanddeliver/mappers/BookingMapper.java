package net.bmbsolutions.driveanddeliver.mappers;

import net.bmbsolutions.driveanddeliver.model.Booking;
import net.bmbsolutions.driveanddeliver.model.dto.BookingResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<BookingResponseDTO, Booking> {
}
