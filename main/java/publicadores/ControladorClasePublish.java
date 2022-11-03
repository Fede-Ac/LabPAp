package publicadores;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;
import interfaces.Fabrica;
import interfaces.IControladorClase;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorClasePublish {
	private Fabrica fabrica;
	private IControladorClase iConClase;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorClasePublish() {
		fabrica = Fabrica.getInstancia();
		iConClase = fabrica.getIControladorClase();
		
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
	    endpoint = Endpoint.publish("http://127.0.0.2:1890/controladorClase", this);
	    //endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorClase", this);
		//System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorClase");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	@WebMethod
	public void addClase(String actDep,String nombreClase, DtFechaHora fechaInicio, String nomProf, String URL, DtFecha fechaReg, String picture) {
	  try {
	      iConClase.addClase(actDep, nombreClase, fechaInicio, nomProf, URL, fechaReg, picture);   
	  }catch (Exception ex) {
		  ex.printStackTrace();
	  }  
	}
	@WebMethod
	public String[] listarInstituciones() {
	    ArrayList<String> inst = null;
	    try {
	       inst = iConClase.listarInstituciones();
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    String [] ret = new String[inst.size()];
	    int i = 0;
	    for (String s : inst) {
	        ret[i]=s;
	        i++;
	    }
	    return ret;	    
	}
	@WebMethod
	public String[] listarActividadesDeportivas(String nombreInst) {
	    ArrayList<String> inst = iConClase.listarActividadesDeportivas(nombreInst);
	    String [] ret = new String[inst.size()];
	    int i = 0;
	    for(String s:inst) {
	        ret[i]= s;
	        i++;
	    }
	    return ret;    
	}
	@WebMethod
    public String[] listarProfesores(String nombreInst) {
	    ArrayList<String> profs = iConClase.listarProfesores(nombreInst);
	    String[] ret = new String[profs.size()];
	    int i = 0;
	    for(String s:profs) {
	        ret[i]=s;
	        i++;
	    }
	    return ret;
	    
	}
	@WebMethod
	public String[] listarClases(String actividad) {
	    ArrayList<String> clases = iConClase.listarClases(actividad);
	    String[] ret = new String[clases.size()];
	    int i = 0;
	    for(String s: clases) {
	        ret[i]=s;
	        i++;
	    }
	    return ret;
	}
	@WebMethod
    public DtClase[] rankingClases() {
        ArrayList<DtClase> clases = iConClase.rankingClases();
        DtClase[] ret = new DtClase[clases.size()];
        int i = 0;
        for(DtClase d: clases) {
            ret[i]=d;
            i++;
        }
        return ret;
    }
}
