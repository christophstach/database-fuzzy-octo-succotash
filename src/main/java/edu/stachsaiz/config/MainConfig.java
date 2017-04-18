package edu.stachsaiz.config;

/**
 * Created by Christoph Stach on 4/18/17.
 * Main config for the project
 */
public class MainConfig {
  private JdbcConfig jdbc;

  /**
   * Default constructor
   */
  public MainConfig() {
  }

  /**
   * Setter constructor
   *
   * @param jdbc value for jdbc
   */
  public MainConfig(JdbcConfig jdbc) {
    this.jdbc = jdbc;
  }

  /**
   * Gets jdbc
   *
   * @return value of jdbc
   */
  public JdbcConfig getJdbc() {
    return jdbc;
  }

  /**
   * Sets jdbc
   *
   * @param jdbc value for jdbc
   */
  public void setJdbc(JdbcConfig jdbc) {
    this.jdbc = jdbc;
  }
}
