package publicadores;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import interfaces.Fabrica;
import interfaces.IControladorActividadDeportiva;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorActDepPublish {
	private Fabrica fabrica;
	private IControladorActividadDeportiva iConActDep;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorActDepPublish() {
		fabrica = Fabrica.getInstancia();
		iConActDep = fabrica.getIControladorActividadDeportiva();
		
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:1890/controladorActDep", this);
	    //endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorActDep", this);
		//System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorActDep");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	@WebMethod
	   public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha, String picture) {
	        try {
	            iConActDep.AltaActividadDeportiva(nombre, nombreInst, descripcion, duracion, costo, fecha, picture);
	        }catch(Exception ex) {
	        	ex.printStackTrace();
	        }   
	     }
	@WebMethod
	public boolean existeInstitucionD(String nombreInst) {
       return iConActDep.existeInstitucionD(nombreInst);
	}
	
	@WebMethod
	public String[] listarInstituciones() {
	    ArrayList<String> inst = iConActDep.listarInstituciones();    
	    String[] retorno = new String[inst.size()];
	    int i = 0;
	    for(String s : inst) {
	        retorno[i]=s;
	        i++;
	    }
	    return retorno;
	}
	
	@WebMethod
	public String[] listarActividadesDeportivas(String institucion) {
	    ArrayList<String> acts = iConActDep.listarActividadesDeportivas(institucion);
	    String[] retorno = new String[acts.size()];
	    int i = 0;
	    for(String s:acts) {
	        retorno[i]=s;
	        i++;
	    }
	    return retorno;
	}
	@WebMethod
	public DtActividadDeportiva consultaActividadDeportiva(String nombreAct) {
	    DtActividadDeportiva ret = null;
	    try {
	        ret = iConActDep.ConsultaActividadDeportiva(nombreAct);
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }
	    
	    return ret;
	}
	@WebMethod
	public DtActividadDeportiva registoDictadoDeClase(String regClase) {
	    DtActividadDeportiva ret = null;
	    try {
	        ret = iConActDep.RegistroDictadoDeClase(regClase);
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return ret;
	}
	@WebMethod
	public void altaRegistroDictadoDeClase(String socio, String clase) {
	    try {
	        iConActDep.altaRegistroDictadoDeClase(socio, clase);
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	@WebMethod
	public void eliminarRegistroClase(String socio, String clase) {
	    try {
	        iConActDep.eliminarRegistro(socio, clase);
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	@WebMethod
	public String[] listarClases(String ActDeportiva) {
	    ArrayList<String> clases = iConActDep.listarClases(ActDeportiva);
	    int i = 0;
	    String [] ret = new String[clases.size()];
	    for(String s: clases) {
	        ret[i]=s;
	        i++;
	    }
	    return ret;
	}
	@WebMethod
	public DtClase getDtClase(String clase) {
	    return iConActDep.getDtClase(clase);
	}
	@WebMethod
	public String[] getSocios() {
	   ArrayList<String> socios = null; 
	   try { 
	    socios = iConActDep.getSocios();
	       }catch (Exception ex) {
	    	   ex.printStackTrace();
	       } 
	   String[] ret = new String[socios.size()];
	   int i = 0;
	   for(String s: socios) {
	       ret[i] = s;
	       i++;
	   }
	   return ret;
 	}
	@WebMethod
	public String[] getActividadesDeportivas() {
	   ArrayList<String> acts = iConActDep.getActividadesDeportivas();
	   String[] ret = new String[acts.size()];
	   int i = 0;
	   for(String s: acts) {
	       ret[i]=s;
	       i++;
	   }
	   return ret;
	}
	@WebMethod
	public DtActividadDeportiva getDtActividadDeportiva(String actDep) {
	    return iConActDep.getDtActividadDeportiva(actDep);
	}
	@WebMethod
	public void modificarActividadDeportiva(DtActividadDeportiva dta) {
	    iConActDep.modificarActividadDeportiva(dta);
	}
	
}
