/**
 *
 */
package co.com.grupoasd.payroll.data;

import co.com.grupoasd.payroll.entity.ControlCuentaCobro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 17/06/2022
 *
 * @author jsherreram
 * @version 1.0
 */
public class ControlCuentaCobroJDBC {

    private static final int ID_PRUEBA = 48;
    private static final int MES = 7;
    private static final String SQL_SELECT = "SELECT MAX(id) + 1 AS siguiente FROM `tokio_test`.`cuentacobro_control` WHERE id BETWEEN 64287 AND 66382;";
    private static final String SQL_INSERT_CCC = "INSERT INTO `tokio_test`.`cuentacobro_control` (`id`, `idprueba`, `idempleado`, `mes`, `fecha_actualiza`) VALUES (?, " + ID_PRUEBA + ", ?, " + MES + ", CURRENT_TIMESTAMP);";
    private static final String SQL_SELECT_CCC = "SELECT idempleado\n"
            + "FROM   (SELECT DISTINCT e.fecha,\n"
            + "                        dcpe.codigoevento,\n"
            + "                        e.nombre AS nombre_evento,\n"
            + "                        emp.idempleado,\n"
            + "                        dcpe.codigocargo,\n"
            + "                        p.valor\n"
            + "        FROM   detalle_cargo_x_puesto_x_evento dcpe\n"
            + "               LEFT JOIN evento e\n"
            + "                      ON dcpe.codigoevento = e.codigoevento\n"
            + "               LEFT JOIN cargos c\n"
            + "                      ON dcpe.codigocargo = c.codigocargo\n"
            + "               LEFT JOIN pagoxsesion p\n"
            + "                      ON p.codigoevento = e.codigoevento\n"
            + "                         AND p.codigocargo = c.codigocargo\n"
            + "               LEFT JOIN divipol d\n"
            + "                      ON dcpe.iddivipol = d.iddivipol\n"
            + "               LEFT JOIN municipio m\n"
            + "                      ON dcpe.codigomunicipio = m.codigomunicipio\n"
            + "               LEFT JOIN empleado emp\n"
            + "                      ON dcpe.nrodoc = emp.nrodoc\n"
            + "               LEFT JOIN asistencia a\n"
            + "                      ON a.codigoevento = e.codigoevento\n"
            + "                         AND a.iddivipol = d.iddivipol\n"
            + "                         AND a.idempleado = emp.idempleado\n"
            + "        WHERE  dcpe.codigoevento IN (SELECT e.codigoevento\n"
            + "                                     FROM   evento e\n"
            + "                                     WHERE  idprueba = 48)\n"
            + "               AND a.idempleado IS NOT NULL\n"
            + "               AND e.tiposesion != 'CAPACITACION'\n"
            + "        UNION\n"
            + "        SELECT '2022-05-02'   AS fecha,\n"
            + "               910            AS codigoEvento,\n"
            + "               'CAPACITACION' AS nombre_evento,\n"
            + "               b.idempleado,\n"
            + "               ca.codigocargo AS codigoCargo,\n"
            + "               t.valor\n"
            + "        FROM   detalle_cargo_x_puesto_x_evento a\n"
            + "               JOIN empleado b\n"
            + "                 ON a.nrodoc = b.nrodoc\n"
            + "               JOIN departamento dep\n"
            + "                 ON a.codigodepartamento = dep.codigo\n"
            + "               JOIN municipio mun\n"
            + "                 ON a.codigodepartamento = mun.codigodepartamento\n"
            + "                    AND a.codigomunicipio = mun.codigomunicipio\n"
            + "               LEFT JOIN pagoxsesion t\n"
            + "                      ON t.codigoevento = 910\n"
            + "                         AND a.codigocargo = t.codigocargo\n"
            + "               JOIN cargos ca\n"
            + "                 ON a.codigocargo = ca.codigocargo\n"
            + "               JOIN evento ev\n"
            + "                 ON a.codigoevento = ev.codigoevento\n"
            + "               JOIN (SELECT nrodoc,\n"
            + "                            Max(codigoevento) AS codigoevento\n"
            + "                     FROM   (SELECT e.nrodoc,\n"
            + "                                    dcpe.codigoevento\n"
            + "                             FROM   detalle_cargo_x_puesto_x_evento dcpe\n"
            + "                                    JOIN empleado e\n"
            + "                                      ON dcpe.nrodoc = e.nrodoc\n"
            + "                             WHERE  dcpe.codigoevento IN\n"
            + "                                    (SELECT codigoevento\n"
            + "                                     FROM   evento\n"
            + "                                     WHERE  idprueba = 48\n"
            + "                                            AND eseleccion = 1\n"
            + "                                            AND requiereasistenciactacobro = 0)\n"
            + "                             UNION\n"
            + "                             SELECT e.nrodoc,\n"
            + "                                    dcpe.codigoevento\n"
            + "                             FROM   detalle_cargo_x_puesto_x_evento dcpe\n"
            + "                                    JOIN empleado e\n"
            + "                                      ON dcpe.nrodoc = e.nrodoc\n"
            + "                                    LEFT JOIN asistencia asis\n"
            + "                                           ON asis.codigoevento = dcpe.codigoevento\n"
            + "                                              AND asis.idempleado = e.idempleado\n"
            + "                                              AND asis.iddivipol = dcpe.iddivipol\n"
            + "                             WHERE  dcpe.codigoevento IN( 9002 )\n"
            + "                             UNION\n"
            + "                             SELECT e.nrodoc,\n"
            + "                                    dcpe.codigoevento\n"
            + "                             FROM   detalle_cargo_x_puesto_x_evento dcpe\n"
            + "                                    JOIN empleado e\n"
            + "                                      ON dcpe.nrodoc = e.nrodoc\n"
            + "                                    LEFT JOIN asistencia asis\n"
            + "                                           ON asis.codigoevento = dcpe.codigoevento\n"
            + "                                              AND asis.idempleado = e.idempleado\n"
            + "                                              AND asis.iddivipol = dcpe.iddivipol\n"
            + "                             WHERE  dcpe.codigoevento IN(SELECT codigoevento\n"
            + "                                                         FROM   evento\n"
            + "                                                         WHERE  idprueba = 48\n"
            + "                                                                AND nombre LIKE 'E11%')\n"
            + "                                    AND asis.estado IS NOT NULL) AS cedula_eventos\n"
            + "                     GROUP  BY nrodoc) AS ultimo_evento\n"
            + "                 ON a.nrodoc = ultimo_evento.nrodoc\n"
            + "                    AND a.codigoevento = ultimo_evento.codigoevento) AS total\n"
            + "WHERE  idempleado NOT IN(SELECT idempleado\n"
            + "                         FROM   cuentacobro_control\n"
            + "                         WHERE  idprueba = 48\n"
            + "                                AND mes = 7)\n"
            + "GROUP  BY idempleado\n"
            + "HAVING Sum(valor) > 1000000;";

    public static int insert(ControlCuentaCobro controlCuentaCobro) {

        Connection c = null;
        PreparedStatement psConsultar = null;
        PreparedStatement psInsertar = null;
        ResultSet rsConsultar = null;
        ResultSet rsInsertar = null;
        int numeroRegistros = 0;
        long siguienteId;
        final Object idEmpleados[] = new Object[1];
        idEmpleados[0] = 0;

        try {
            c = Conexion.getConnection();
            psConsultar = c.prepareStatement(SQL_SELECT_CCC);
            rsConsultar = psConsultar.executeQuery();
            if (rsConsultar != null) {
                while (rsConsultar.next()) {
                    idEmpleados[0] = rsConsultar.getInt("idempleado");
                    System.out.println("Ejecutando query de consulta de idEmpleados para los que superan el salario mínimo:\n" + SQL_SELECT_CCC);
                    System.out.println("idEmpleado = " + idEmpleados[0]);
                    try {
                        psInsertar = c.prepareStatement(SQL_INSERT_CCC, PreparedStatement.RETURN_GENERATED_KEYS);

                        siguienteId = ControlCuentaCobroJDBC.siguiente();
                        psInsertar.setLong(1, siguienteId);
                        psInsertar.setInt(2, (int) idEmpleados[0]);

                        System.out.println("Ejecutando query de insercción:\n" + SQL_INSERT_CCC);
                        numeroRegistros = psInsertar.executeUpdate();

                        rsInsertar = psInsertar.getGeneratedKeys();
                        while (rsInsertar.next()) {
                            siguienteId = rsInsertar.getLong(1);
                            System.out.println("Clave generada = " + siguienteId);
                        }
                        System.out.println("Registros insertados exitosamente: " + numeroRegistros);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    } finally {
                        Conexion.close(rsInsertar);
                        Conexion.close(psInsertar);
                    }
                }
            } else {
                idEmpleados[0] = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rsConsultar);
            Conexion.close(psConsultar);
            Conexion.close(c);
        }
        return numeroRegistros;
    }

    public static long siguiente() {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final Object idControlCuentasCobro[] = new Object[1];
        idControlCuentasCobro[0] = 0;

        try {
            c = Conexion.getConnection();
            ps = c.prepareStatement(SQL_SELECT);
            System.out.println("Ejecutando query de consulta consecutivo para id de la tbl cuentacobro_control para los que superan el salario mínimo:\n" + SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                idControlCuentasCobro[0] = rs.getLong("siguiente");
                System.out.println("idControlCuentasCobro[0] = " + idControlCuentasCobro[0]);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(c);
        }
        return (long) idControlCuentasCobro[0];
    }

}
