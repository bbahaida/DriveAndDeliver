package net.bmbsolutions.driveanddeliver.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * BookingResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T21:23:56.778193300+02:00[Europe/Madrid]", comments = "Generator version: 7.5.0")
public class BookingResponseDTO {

  private Integer bookingId;

  private CustomerDTO customer;

  private TimeSlotDTO timeSlot;

  public BookingResponseDTO bookingId(Integer bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Unique identifier of the booking
   * @return bookingId
  */
  
  @JsonProperty("bookingId")
  public Integer getBookingId() {
    return bookingId;
  }

  public void setBookingId(Integer bookingId) {
    this.bookingId = bookingId;
  }

  public BookingResponseDTO customer(CustomerDTO customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @Valid 
  @JsonProperty("customer")
  public CustomerDTO getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerDTO customer) {
    this.customer = customer;
  }

  public BookingResponseDTO timeSlot(TimeSlotDTO timeSlot) {
    this.timeSlot = timeSlot;
    return this;
  }

  /**
   * Get timeSlot
   * @return timeSlot
  */
  @Valid 
  @JsonProperty("timeSlot")
  public TimeSlotDTO getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(TimeSlotDTO timeSlot) {
    this.timeSlot = timeSlot;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) o;
    return Objects.equals(this.bookingId, bookingResponseDTO.bookingId) &&
        Objects.equals(this.customer, bookingResponseDTO.customer) &&
        Objects.equals(this.timeSlot, bookingResponseDTO.timeSlot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, customer, timeSlot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingResponseDTO {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    timeSlot: ").append(toIndentedString(timeSlot)).append("\n");
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

