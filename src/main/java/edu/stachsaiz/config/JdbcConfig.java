package edu.stachsaiz.config;

/**
 * Created by Christoph Stach on 4/18/17.
 * MainConfig file for JDBC
 */
public class JdbcConfig {
  private String url;
  private String username;
  private String password;
  private boolean ssl;

  /**
   * Default constructor
   */
  public JdbcConfig() {
  }

  /**
   * Setter constructor
   *
   * @param url      value for url
   * @param username value for username
   * @param password value for password
   * @param ssl      value for ssl
   */
  public JdbcConfig(String url, String username, String password, boolean ssl) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.ssl = ssl;
  }

  /**
   * Gets url
   *
   * @return value of url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets url
   *
   * @param url value for url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Gets username
   *
   * @return value of username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username
   *
   * @param username value for username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets password
   *
   * @return value of password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets password
   *
   * @param password value for password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets ssl
   *
   * @return value of ssl
   */
  public boolean isSsl() {
    return ssl;
  }

  /**
   * Sets ssl
   *
   * @param ssl value for ssl
   */
  public void setSsl(boolean ssl) {
    this.ssl = ssl;
  }
}
