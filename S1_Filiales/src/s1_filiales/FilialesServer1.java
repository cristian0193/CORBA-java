package s1_filiales;

import cliente_servidores1.Despachos_Filial;
import cliente_servidores1.Despachos_FilialHelper;
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

public class FilialesServer1 {

    public static void main(String args[]) {

        try {
            //crea instancua al ORB
            ORB orb = ORB.init(args, null);
            //crea instancia a POA 
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            //activa POA Manager
            rootpoa.the_POAManager().activate();
            //instancia de clase Despachos
            FilialesImplentacion filialesImpl = new FilialesImplentacion();
            //obtiene la referencia de la clase filialesImpl (servant)
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(filialesImpl);
            Despachos_Filial href = Despachos_FilialHelper.narrow(ref);

            //obtiene referencia
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt rootContext = NamingContextExtHelper.narrow(objRef);

            NameComponent nameComponent[] = rootContext.to_name("Despachos_Filial");
            rootContext.rebind(nameComponent, href);

            int opcion = 0;
            
    
                opcion = Integer.parseInt(JOptionPane.showInputDialog("-------- SERVER 1 --------- \n 1 - Ingresar Modo Ejecucion \n 2 - Ingresar Modo Administrador \n 0 - Salir"));

                if (opcion == 1) {
                    System.out.println("Servidor 1 Listo .......");
                    orb.run();                                        
                } else if (opcion == 2) {
                    frm_login ventanas = new frm_login();
                    ventanas.setVisible(true);
                     System.out.println("Servidor 1 Listo .......");
                    orb.run();
                } else {
                    System.out.println("Servidor 1 Apagado .......");
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
            Logger.getLogger(FilialesServer1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
