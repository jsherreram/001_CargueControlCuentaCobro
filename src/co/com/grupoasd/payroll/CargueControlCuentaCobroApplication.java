/**
 * Archivo: CargueControlCuentaCobroApplication.java
 * Fecha: 17/06/2022
 * Todos los derechos de propiedad intelectual e industrial sobre esta aplicacion son de propiedad exclusiva del GRUPO ASD
 * S.A.S. Su uso, alteracion, reproduccion o modificacion sin el debido consentimiento por escrito de GRUPO ASD S.A.S. quedan
 * totalmente prohibidos.
 *
 * Este programa se encuentra protegido por las disposiciones de la Ley 23 de 1982 y demas normas concordantes sobre derechos
 * de autor y propiedad intelectual. Su uso no autorizado dara lugar a las sanciones previstas en la Ley.
 */
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
