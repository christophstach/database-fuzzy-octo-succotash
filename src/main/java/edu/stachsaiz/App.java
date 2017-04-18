package edu.stachsaiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import edu.stachsaiz.config.MainConfig;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Christoph Stach on 17/4/17.
 * Mainprogramm für shared-flat-organiser.
 */
public class App {
  /**
   * Main
   *
   * @param args CMD args
   */
  public static void main(String[] args) {
    try {
      Properties props = new Properties();
      MainConfig mainConfig;
      ObjectMapper mapper;
      String url;

      mapper = new ObjectMapper(new YAMLFactory());
      mainConfig = mapper.readValue(new File("src/main/resources/config.yml"), MainConfig.class);

      url = mainConfig.getJdbc().getUrl();

      props.setProperty("user", mainConfig.getJdbc().getUsername());
      props.setProperty("password", mainConfig.getJdbc().getPassword());
      props.setProperty("ssl", mainConfig.getJdbc().isSsl() ? "true" : "false");

      Connection conn = DriverManager.getConnection(url, props);
      conn.close();
    } catch (IOException | SQLException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
