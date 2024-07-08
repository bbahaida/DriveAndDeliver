package net.bmbsolutions.driveanddeliver.mappers;

import net.bmbsolutions.driveanddeliver.model.Customer;
import net.bmbsolutions.driveanddeliver.model.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
}
