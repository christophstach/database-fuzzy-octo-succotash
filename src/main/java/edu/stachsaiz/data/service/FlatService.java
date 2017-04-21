package edu.stachsaiz.data.service;

import edu.stachsaiz.data.entity.Flat;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Christoph Stach on 4/21/17.
 * <p>
 * A service for managing flats
 */
public class FlatService {
  private Connection connection;
  private Scanner scanner;

  /**
   * Constructor
   *
   * @param connection value of connection
   * @param scanner    value of scanner
   */
  public FlatService(Connection connection, Scanner scanner) {
    super();

    this.connection = connection;
    this.scanner = scanner;
  }

  /**
   * Displays all flats
   */
  public void displayAll() throws SQLException {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM flats");

    while (resultSet.next()) {
      Flat flat = new Flat(resultSet);
      System.out.println(flat.getString());
    }
  }

  /**
   * Adds a new flat
   */
  public void addOne() throws SQLException {
    String street;
    String postalCode;
    String city;
    String sql;
    int affectedRows;

    System.out.print("Bitte geben Sie die Straße ein: ");
    street = scanner.next();

    System.out.print("Bitte geben Sie die PLZ ein: ");
    postalCode = scanner.next();

    System.out.print("Bitte geben Sie die Stadt ein: ");
    city = scanner.next();

    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO flats(street, postal_code, city) VALUES (?, ?, ?)");
    preparedStatement.setString(1, street);
    preparedStatement.setString(2, postalCode);
    preparedStatement.setString(3, city);

    sql = preparedStatement.toString();
    affectedRows = preparedStatement.executeUpdate();

    System.out.println("SQL-Befehl wurde durchgeführt: " + sql);
    if (affectedRows == 1) {
      System.out.println("1 Zeile war betroffen.");
    } else {
      System.out.println(affectedRows + " Zeilen waren betroffen.");
    }
  }

  /**
   * Deletes a flat
   */
  public void deleteOne() throws SQLException {
    long flatId;
    String sql;
    int affectedRows;

    while (true) {
      System.out.print("Bitte geben Sie eine gültige FlatId > 0 ein: ");

      try {
        flatId = scanner.nextLong();

        if (flatId <= 0) {
          continue;
        }

        break;
      } catch (InputMismatchException exception) {
        scanner.next();
      }
    }

    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM flats WHERE flat_id = ?");
    preparedStatement.setLong(1, flatId);

    sql = preparedStatement.toString();
    affectedRows = preparedStatement.executeUpdate();

    System.out.println("SQL-Befehl wurde durchgeführt: " + sql);
    if (affectedRows == 1) {
      System.out.println("1 Zeile war betroffen.");
    } else {
      System.out.println(affectedRows + " Zeilen waren betroffen.");
    }
  }

  /**
   * Navigate through all flats
   */
  public void navigate() throws SQLException {
    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet = statement.executeQuery("SELECT * FROM flats");

    while (true) {
      boolean breakLoop = false;

      System.out.print("Bitte geben Sie nächste Operation ein (n=Vorwärts; p=Rückwärts; alles andere=Programm beenden): ");
      switch (scanner.next()) {
        case "p": {
          if(resultSet.isFirst() || resultSet.isBeforeFirst()) {
            resultSet.last();
          } else {
            resultSet.previous();
          }
          break;
        }
        case "n": {
          if (resultSet.isLast() || resultSet.isAfterLast()) {
            resultSet.first();
          } else {
            resultSet.next();
          }

          break;
        }
        default: {
          breakLoop = true;
        }
      }

      if (breakLoop) {
        break;
      }

      Flat flat = new Flat(resultSet);
      System.out.println(flat.getString());
    }
  }
}
