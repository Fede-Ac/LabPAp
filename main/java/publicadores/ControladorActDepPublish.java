package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
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
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:1942/controladorActDep", this);
	    //endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorActDep", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorActDep");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	@WebMethod
	   public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha, String picture) {
	       
	   }
	   

}
