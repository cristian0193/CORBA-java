package cliente_servidores2;


/**
* cliente_servidores2/Despachos_ProductosOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Despachos_Productos.idl
* s�bado 22 de abril de 2017 10:47:05 PM COT
*/

public interface Despachos_ProductosOperations 
{
  int insertarProductos (String codigo_producto, String descripcion, int cantidad_stock, String fecha_fabricacion, String fecha_vencimiento, String fecha_creacion);
  String consultaProductos_id (String id_producto);
  int validarUsuarioServidor2 (String usuario, String contrasena);
} // interface Despachos_ProductosOperations
