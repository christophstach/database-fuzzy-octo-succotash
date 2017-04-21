package edu.stachsaiz.data.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Christoph Stach on 4/21/17.
 * <p>
 * The Flat Entity
 */
public class Flat {
  private ResultSet rs;

  /**
   * Constructor
   *
   * @param rs value of rs
   */
  public Flat(ResultSet rs) {
    this.rs = rs;
  }

  /**
   * Gets flatId
   *
   * @return value of flatId
   * @throws SQLException on SQL error
   */
  public long getFlatId() throws SQLException {
    return rs.getLong("flat_id");
  }

  /**
   * Gets street
   *
   * @return value of street
   * @throws SQLException on SQL error
   */
  public String getStreet() throws SQLException {
    return rs.getString("street");
  }

  /**
   * Gets postalCode
   *
   * @return value of postalCode
   * @throws SQLException on SQL error
   */
  public String getPostalCode() throws SQLException {
    return rs.getString("postal_code");
  }

  /**
   * Gets city
   *
   * @return value of city
   * @throws SQLException on SQL error
   */
  public String getCity() throws SQLException {
    return rs.getString("city");
  }


  /**
   * Convert the record set to a string
   *
   * @return Flat as a string
   * @throws SQLException on SQL error
   */
  public String getString() throws SQLException {
    return "Flat{" +
            "flatId=" + getFlatId() +
            ", street='" + getStreet() + '\'' +
            ", postalCode='" + getPostalCode() + '\'' +
            ", city='" + getCity() + '\'' +
            '}';
  }
}
