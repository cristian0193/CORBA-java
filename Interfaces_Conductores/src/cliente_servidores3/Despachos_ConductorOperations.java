package cliente_servidores3;


/**
* cliente_servidores3/Despachos_ConductorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Despachos_Conductor.idl
* s�bado 22 de abril de 2017 10:46:39 PM COT
*/

public interface Despachos_ConductorOperations 
{
  int insertarConductores (String codigo_conductor, String nombre_completo, int edad, String direccion, String telefono, String experiencia, String fecha_creacion);
  String consultaConductor_id (String id_conductor);
  int validarUsuarioServidor3 (String usuario, String contrasena);
} // interface Despachos_ConductorOperations
