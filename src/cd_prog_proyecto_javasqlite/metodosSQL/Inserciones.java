package cd_prog_proyecto_javasqlite.metodosSQL;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author Alba
 */
public class Inserciones {
    
    /**
     * Método "insert": Como su nombre indica, el usuario puede insertar una
     * nueva fila en la tabla que se indique en la declaración SQL con sus
     * parámetros. En el caso de que la primary key (es decir, la referencia) ya
     * exista en la base de datos, saltará una excepción e instará al usuario a
     * introducir los parámetros de nuevo
     *
     * @param referencia referencia del alumno
     * @param nombre nombre del alumno
     * @param nota nota del alumno
     * @param id_pais id del pais del alumno
     */
    public void insert(int referencia, String nombre, int nota, int id_pais) {
        try {
            //Declarar consulta
            Conexion.s = Conexion.con.createStatement();
            //Ejecutar consulta
            Conexion.s.executeUpdate("INSERT INTO alumnos values (" + referencia + ",'" + nombre + "'," + nota + "," + id_pais + ")");
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("ERROR CLAVE REPETIDA ---> " + ex);
        } catch (SQLException ex) {
            System.out.println("ERROR ---> " + ex);
        }
    }
}