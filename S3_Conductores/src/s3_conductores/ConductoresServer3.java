package s3_conductores;

import cliente_servidores3.Despachos_Conductor;
import cliente_servidores3.Despachos_ConductorHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class ConductoresServer3 {

    public static void main(String args[]) {

        try {
            //crea instancua al ORB
            ORB orb = ORB.init(args, null);
            //crea instancia a POA 
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            //activa POA Manager
            rootpoa.the_POAManager().activate();
            //instancia de clase Despachos
            ConductoresImplementacion conductoresImpl = new ConductoresImplementacion();
            //obtiene la referencia de la clase filialesImpl (servant)
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(conductoresImpl);
            Despachos_Conductor href = Despachos_ConductorHelper.narrow(ref);

            //obtiene referencia
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt rootContext = NamingContextExtHelper.narrow(objRef);

            NameComponent nameComponent[] = rootContext.to_name("Despachos_Conductor");
            rootContext.rebind(nameComponent, href);

            int opcion = 0;
            
                opcion = Integer.parseInt(JOptionPane.showInputDialog("-------- SERVER 3 --------- \n 1 - Ingresar Modo Ejecucion \n 2 - Ingresar Modo Administrador \n 0 - Salir"));

                if (opcion == 1) {
                    System.out.println("Servidor 3 Listo .......");
                    orb.run();                                        
                } else if (opcion == 2) {
                    frm_login ventanas = new frm_login();
                    ventanas.setVisible(true);
                     System.out.println("Servidor 3 Listo .......");
                    orb.run();
                } else {
                    System.out.println("Servidor 3 Apagado .......");
                    System.exit(0);
                }


        } catch (AdapterInactive e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InvalidName e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ServantNotActive e) {
            System.err.println("Error: " + e.getMessage());
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NotFound e) {
            System.err.println("Error: " + e.getMessage());
        } catch (CannotProceed e) {
            System.err.println("Error: " + e.getMessage());
        } catch (WrongPolicy ex) {
            Logger.getLogger(ConductoresServer3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
