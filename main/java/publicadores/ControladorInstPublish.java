package publicadores;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtInstitucionDeportiva;
import interfaces.Fabrica;
import interfaces.IControladorInstitucionDep;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorInstPublish {
	private Fabrica fabrica;
	private IControladorInstitucionDep iConInstDep;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorInstPublish() {
		fabrica = Fabrica.getInstancia();
		iConInstDep = fabrica.getIControladorInstitucionDep();
		
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
	    endpoint = Endpoint.publish("http://127.0.0.1:1890/controladorInst", this);
	    //endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInst", this);
		//System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInst");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	@WebMethod
	public void addInstitucionDep(String nombre, String descripcion, String URL) {
		 try {
			 iConInstDep.addInstitucionDep(nombre, descripcion, URL);
	        }catch(Exception ex) {
	        	ex.printStackTrace();
	        }  
	
	}
	
	@WebMethod
	public String[] listarInstituciones() {
	    ArrayList<String> inst = iConInstDep.listarInstituciones();    
	    String[] retorno = new String[inst.size()];
	    int i = 0;
	    for(String s : inst) {
	        retorno[i]=s;
	        i++;
	    }
	    return retorno;
	}
	
	@WebMethod
	public void updateInstDep(DtInstitucionDeportiva dtInstDep) {
		try {
			 iConInstDep.updateInstDep(dtInstDep);
	        }catch(Exception ex) {
	        	ex.printStackTrace();
	        }  
	}
	

}
