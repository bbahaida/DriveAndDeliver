package net.bmbsolutions.driveanddeliver.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * AuthRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T21:23:56.778193300+02:00[Europe/Madrid]", comments = "Generator version: 7.5.0")
public class AuthRequestDTO {

  private String username;

  private String password;

  public AuthRequestDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Username of the user
   * @return username
  */
  
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AuthRequestDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of the user
   * @return password
  */
  
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthRequestDTO authRequestDTO = (AuthRequestDTO) o;
    return Objects.equals(this.username, authRequestDTO.username) &&
        Objects.equals(this.password, authRequestDTO.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthRequestDTO {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

