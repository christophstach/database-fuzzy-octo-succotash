package edu.stachsaiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import edu.stachsaiz.config.JdbcConfig;
import edu.stachsaiz.config.MainConfig;

import java.io.File;
import java.io.IOException;
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
    System.out.println("Hola mundo");

    String url = "jdbc:postgresql://localhost/test";
    Properties props = new Properties();
    props.setProperty("user", "fred");
    props.setProperty("password", "secret");
    props.setProperty("ssl", "true");


    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());



    try {
      MainConfig jdbcConfig = mapper.readValue(new File("src/main/resources/config.yml"), MainConfig.class);
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }

    /**

     try {
     Connection conn = DriverManager.getConnection(url, props);
     } catch (SQLException exception) {
     System.out.println(exception.getMessage());
     }*/


  }
}
