/**
 *
 */
package co.com.grupoasd.payroll.entity;

import java.util.Date;

/**
 * Date: 17/06/2022
 *
 * @author jsherreram
 * @version 1.0
 */
public class ControlCuentaCobro {

    private long id;
    private int idPrueba;
    private int idEmpleado;
    private int mes;
    private Date fechaActualiza;

    public ControlCuentaCobro() {
    }

    public ControlCuentaCobro(long id, int idPrueba, int idEmpleado, int mes, Date fechaActualiza) {
        this.id = id;
        this.idPrueba = idPrueba;
        this.idEmpleado = idEmpleado;
        this.mes = mes;
        this.fechaActualiza = fechaActualiza;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Date getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(Date fechaActualiza) {
        this.fechaActualiza = fechaActualiza;
    }

    @Override
    public String toString() {
        return "ControlCuentaCobro{" + "id=" + id + ", idPrueba=" + idPrueba + ", idEmpleado=" + idEmpleado + ", mes=" + mes + ", fechaActualiza=" + fechaActualiza + '}';
    }

}
