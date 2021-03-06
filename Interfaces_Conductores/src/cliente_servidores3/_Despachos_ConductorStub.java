package cliente_servidores3;


/**
* cliente_servidores3/_Despachos_ConductorStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Despachos_Conductor.idl
* s�bado 22 de abril de 2017 10:46:39 PM COT
*/

public class _Despachos_ConductorStub extends org.omg.CORBA.portable.ObjectImpl implements cliente_servidores3.Despachos_Conductor
{

  public int insertarConductores (String codigo_conductor, String nombre_completo, int edad, String direccion, String telefono, String experiencia, String fecha_creacion)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("insertarConductores", true);
                $out.write_wstring (codigo_conductor);
                $out.write_wstring (nombre_completo);
                $out.write_long (edad);
                $out.write_wstring (direccion);
                $out.write_wstring (telefono);
                $out.write_wstring (experiencia);
                $out.write_wstring (fecha_creacion);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return insertarConductores (codigo_conductor, nombre_completo, edad, direccion, telefono, experiencia, fecha_creacion        );
            } finally {
                _releaseReply ($in);
            }
  } // insertarConductores

  public String consultaConductor_id (String id_conductor)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultaConductor_id", true);
                $out.write_wstring (id_conductor);
                $in = _invoke ($out);
                String $result = $in.read_wstring ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultaConductor_id (id_conductor        );
            } finally {
                _releaseReply ($in);
            }
  } // consultaConductor_id

  public int validarUsuarioServidor3 (String usuario, String contrasena)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("validarUsuarioServidor3", true);
                $out.write_wstring (usuario);
                $out.write_wstring (contrasena);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return validarUsuarioServidor3 (usuario, contrasena        );
            } finally {
                _releaseReply ($in);
            }
  } // validarUsuarioServidor3

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:cliente_servidores3/Despachos_Conductor:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _Despachos_ConductorStub
