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
import datatypes.DtInstitucionDeportiva;
import datatypes.DtUsuario;
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
			ex.printStackTrace();
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
	public void altaUsuario(DtUsuario dtU) {
		try {
			iConUsuario.altaUsuario(dtU);
		}catch(Exception ex) {
        	ex.printStackTrace();
        }   
	   
	}
	@WebMethod
	public void modificarUsuario(DtUsuario dtU) {
		iConUsuario.modificarUsuario(dtU);
	}
	@WebMethod
	public String[] mostrarUsuarios(){
        /*ArrayList<String> usuarios = iConUsuario.mostrarUsuarios();
        String[] ret = new String[usuarios.size()];
        int i = 0;
        for(String d: usuarios) {
            ret[i]=d;
            i++;
        }*/
		return iConUsuario.mostrarUsuarios();
	}
	@WebMethod
	public DtUsuario consultaUsuario(String nick) {
		return iConUsuario.consultaUsuario(nick);
	}
	@WebMethod
	public String[] listarInstituciones() {
	    ArrayList<String> inst = iConUsuario.listarInstituciones();    
	    String[] retorno = new String[inst.size()];
	    int i = 0;
	    for(String s : inst) {
	        retorno[i]=s;
	        i++;
	    }
	    return retorno;
	}
	@WebMethod
	public DtInstitucionDeportiva getDtinstitucionDeportiva(String institucion) {
		return iConUsuario.getDtinstitucionDeportiva(institucion);
	}
	@WebMethod
	public DtUsuario existeUsuario(String nickname, String pass) {
		DtUsuario us = null;
		    try {
		    	us = iConUsuario.existeUsuario(nickname, pass);
		    }catch(Exception ex) {
		    	ex.printStackTrace();
		    }
		    
		    return us;
	}
}
