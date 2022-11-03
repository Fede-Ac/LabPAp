package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorUsuarioPublish {
	private Fabrica fabrica;
	private IControladorUsuario iConUsuario;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iConUsuario = fabrica.getIControladorUsuario();
		
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
	    endpoint = Endpoint.publish("http://127.0.0.1:1890/controladorUsuario", this);
	    //endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario", this);
		//System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	@WebMethod
	public void prueba() {
	    
	}
	

}
