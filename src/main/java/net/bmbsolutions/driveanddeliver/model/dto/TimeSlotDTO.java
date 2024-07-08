package net.bmbsolutions.driveanddeliver.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * TimeSlotDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T21:23:56.778193300+02:00[Europe/Madrid]", comments = "Generator version: 7.5.0")
public class TimeSlotDTO {

  private Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime endTime;

  private Integer deliveryMethodId;

  private Boolean isBooked;

  public TimeSlotDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the time slot
   * @return id
  */
  
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TimeSlotDTO startTime(LocalDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Start time of the time slot
   * @return startTime
  */
  @Valid 
  @JsonProperty("startTime")
  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public TimeSlotDTO endTime(LocalDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * End time of the time slot
   * @return endTime
  */
  @Valid 
  @JsonProperty("endTime")
  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public TimeSlotDTO deliveryMethodId(Integer deliveryMethodId) {
    this.deliveryMethodId = deliveryMethodId;
    return this;
  }

  /**
   * Identifier of the associated delivery method
   * @return deliveryMethodId
  */
  
  @JsonProperty("deliveryMethodId")
  public Integer getDeliveryMethodId() {
    return deliveryMethodId;
  }

  public void setDeliveryMethodId(Integer deliveryMethodId) {
    this.deliveryMethodId = deliveryMethodId;
  }

  public TimeSlotDTO isBooked(Boolean isBooked) {
    this.isBooked = isBooked;
    return this;
  }

  /**
   * Indicates if the time slot is booked
   * @return isBooked
  */
  
  @JsonProperty("isBooked")
  public Boolean getIsBooked() {
    return isBooked;
  }

  public void setIsBooked(Boolean isBooked) {
    this.isBooked = isBooked;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeSlotDTO timeSlotDTO = (TimeSlotDTO) o;
    return Objects.equals(this.id, timeSlotDTO.id) &&
        Objects.equals(this.startTime, timeSlotDTO.startTime) &&
        Objects.equals(this.endTime, timeSlotDTO.endTime) &&
        Objects.equals(this.deliveryMethodId, timeSlotDTO.deliveryMethodId) &&
        Objects.equals(this.isBooked, timeSlotDTO.isBooked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startTime, endTime, deliveryMethodId, isBooked);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSlotDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    deliveryMethodId: ").append(toIndentedString(deliveryMethodId)).append("\n");
    sb.append("    isBooked: ").append(toIndentedString(isBooked)).append("\n");
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

