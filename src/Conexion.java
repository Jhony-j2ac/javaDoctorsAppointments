import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    public static void main(String[] args) {
        // Configuración de la conexión
        String jdbcUrl = "jdbc:mysql://localhost:3306/bancotarea";
        String usuario = "root";
        String contraseña = "1234";

        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultados = null;

        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

            // Consulta SQL
            String sql = "SELECT * from cliente where CliClave = ? ";

            // Preparar la consulta
            consulta = conexion.prepareStatement(sql);
            consulta.setString(1,"1234abcd"); // Parámetro de la consulta

            // Ejecutar la consulta
            resultados = consulta.executeQuery();

            // Procesar los resultados
            while (resultados.next()) {
                String nombre = resultados.getString("CliNombre");
                int edad = resultados.getInt("CliEdad");
                System.out.println( "Nombre: " + nombre + ", Edad: " + edad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultados != null) {
                    resultados.close();
                }
                if (consulta != null) {
                    consulta.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}