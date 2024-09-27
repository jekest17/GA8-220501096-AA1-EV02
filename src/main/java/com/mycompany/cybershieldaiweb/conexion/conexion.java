package com.mycompany.cybershieldaiweb.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos MySQL.
 * Proporciona métodos para establecer y obtener la conexión a la base de datos
 * utilizada por la aplicación CyberShield AI.
 */
public class conexion {

    // Objeto Connection para manejar la conexión a la base de datos
    Connection con;

    /**
     * Constructor de la clase que inicializa la conexión a la base de datos.
     * Intenta cargar el driver de MySQL y establecer una conexión utilizando
     * los parámetros de la base de datos.
     */
    public conexion() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cybershield_ai", "root", "Je3471296++");
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            // Manejar excepción si el driver no es encontrado
            System.out.println("Error al cargar el controlador de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            // Manejar excepciones si falla la conexión
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    /**
     * Método que devuelve la conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     */
    public Connection getConection() {
        return con;
    }
}
