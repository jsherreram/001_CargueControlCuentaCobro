# 001_CargueControlCuentaCobro
Grupo ASD - Paris: Cargue cuenta de cobro para empleados que superan un salario mínimo.

Aplicación que se encarga de generar una consulta en la base de datos y encontrar los empleados que superan un salario mínimo legal vigente, los registros que den como resultado de la consulta se insertarán en la tabla cuentacobro_control para el pago de la nómina esto con el fin de evitar el pago de seguridad social.

El .jar se configura en el servidor como un job para que se ejectue cada 5 minutos y el reporte de cuenta de cobro para el área de contabilidad esté siempre actualizado.
