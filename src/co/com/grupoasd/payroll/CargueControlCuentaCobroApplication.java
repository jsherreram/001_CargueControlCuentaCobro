package co.com.grupoasd.payroll;

import co.com.grupoasd.payroll.data.ControlCuentaCobroJDBC;
import co.com.grupoasd.payroll.entity.ControlCuentaCobro;

/**
 * Date: 17/06/2022
 *
 * @author jsherreram
 * @version 1.0
 */
public class CargueControlCuentaCobroApplication {

    public static void main(String[] args) {

        ControlCuentaCobro controlCuentaCobro = new ControlCuentaCobro();
        ControlCuentaCobroJDBC.insert(controlCuentaCobro);
    }

}
