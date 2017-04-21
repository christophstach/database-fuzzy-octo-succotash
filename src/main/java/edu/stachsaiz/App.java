package edu.stachsaiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import edu.stachsaiz.config.MainConfig;
import edu.stachsaiz.data.service.FlatService;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

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
      Scanner scanner = new Scanner(System.in);
      Properties props = new Properties();
      FlatService flatService;
      MainConfig mainConfig;
      ObjectMapper mapper;
      String url;
      int selection;

      mapper = new ObjectMapper(new YAMLFactory());
      mainConfig = mapper.readValue(new File("src/main/resources/config.yml"), MainConfig.class);

      url = mainConfig.getJdbc().getUrl();

      props.setProperty("user", mainConfig.getJdbc().getUsername());
      props.setProperty("password", mainConfig.getJdbc().getPassword());
      props.setProperty("ssl", mainConfig.getJdbc().isSsl() ? "true" : "false");

      Connection conn = DriverManager.getConnection(url, props);

      flatService = new FlatService(conn, scanner);

      System.out.println("1. Ausgabe der Tabelle");
      System.out.println("2. Eingabe eines neuen Datensatzes");
      System.out.println("3. Löschen eines Datensätzes");
      System.out.println("4. Durch Datensätze navigieren");
      System.out.println("5. Beenden");
      System.out.println();

      while (true) {
        System.out.print("Bitte geben Sie einen Wert zwischen 1 und 5 ein: ");

        try {
          selection = scanner.nextInt();

          if (selection < 1 || selection > 5) {
            continue;
          }

          switch (selection) {
            case 1: {
              flatService.displayAll();
              break;
            }
            case 2: {
              flatService.addOne();
              break;
            }
            case 3: {
              flatService.deleteOne();
              break;
            }
            case 4: {
              flatService.navigate();
              break;
            }
          }

        } catch (InputMismatchException exception) {
          scanner.next();
        }

        break;
      }

      conn.close();
    } catch (IOException | SQLException exception) {
      System.out.println(exception.getMessage());
    }


  }
}
