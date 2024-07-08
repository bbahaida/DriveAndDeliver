package net.bmbsolutions.driveanddeliver.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * BookingRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T21:23:56.778193300+02:00[Europe/Madrid]", comments = "Generator version: 7.5.0")
public class BookingRequestDTO {

  private Integer customerId;

  private Integer timeSlotId;

  public BookingRequestDTO customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Unique identifier of the customer
   * @return customerId
  */
  
  @JsonProperty("customerId")
  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public BookingRequestDTO timeSlotId(Integer timeSlotId) {
    this.timeSlotId = timeSlotId;
    return this;
  }

  /**
   * Unique identifier of the time slot to be booked
   * @return timeSlotId
  */
  
  @JsonProperty("timeSlotId")
  public Integer getTimeSlotId() {
    return timeSlotId;
  }

  public void setTimeSlotId(Integer timeSlotId) {
    this.timeSlotId = timeSlotId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingRequestDTO bookingRequestDTO = (BookingRequestDTO) o;
    return Objects.equals(this.customerId, bookingRequestDTO.customerId) &&
        Objects.equals(this.timeSlotId, bookingRequestDTO.timeSlotId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, timeSlotId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequestDTO {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    timeSlotId: ").append(toIndentedString(timeSlotId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

