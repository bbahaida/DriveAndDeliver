package net.bmbsolutions.driveanddeliver.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * DeliveryMethodDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T21:23:56.778193300+02:00[Europe/Madrid]", comments = "Generator version: 7.5.0")
public class DeliveryMethodDTO {

  private Integer id;

  private String methodName;

  public DeliveryMethodDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the delivery method
   * @return id
  */
  
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DeliveryMethodDTO methodName(String methodName) {
    this.methodName = methodName;
    return this;
  }

  /**
   * Name of the delivery method
   * @return methodName
  */
  
  @JsonProperty("methodName")
  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryMethodDTO deliveryMethodDTO = (DeliveryMethodDTO) o;
    return Objects.equals(this.id, deliveryMethodDTO.id) &&
        Objects.equals(this.methodName, deliveryMethodDTO.methodName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, methodName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryMethodDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
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

