package net.furious.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.vetfurious.negocio.IDoctor;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class DoctorController {

	@Autowired
	private IDoctor Doctor;
	
	@RequestMapping(value="/listardoctor.jsp") 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {
					
		try {
			
			List<Doctor> personas = this.Doctor.listDoctores();
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("doctores",personas);
			return new ModelAndView("listardoctor", "model", myModel);
			//Persona.insertarPersona(oModelPersona);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}				            

    }
	
	@RequestMapping(value = "/verRegistroDoctor", method = RequestMethod.GET) 
	public ModelAndView ingresar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("nuevoDoctor");
	}
	
	@RequestMapping(value = "/registrarDoctor", method = RequestMethod.GET)
	public ModelAndView registroDoctor(HttpServletRequest request, HttpServletResponse response){
		System.out.println("registrarDoctor");
		
		Doctor oModelPersona = new Doctor();
		oModelPersona.setDoctorID(0);
		oModelPersona.setNombre(request.getParameter("txtnombre"));
		oModelPersona.setPaterno(request.getParameter("txtApellidoPaterno"));
		oModelPersona.setMaterno(request.getParameter("txtApellidoMaterno"));
		oModelPersona.setEmail(request.getParameter("txtEmail"));
		oModelPersona.setTelefono(request.getParameter("txtTelefono"));
		oModelPersona.setUsuario(request.getParameter("txtUsuario"));
		oModelPersona.setPassword(request.getParameter("txtPassword"));
		oModelPersona.setGrupoID(Integer.parseInt(request.getParameter("cboGrupo")));
		oModelPersona.setErrMensaje("");
		
		Doctor oDoctor = new Doctor();
		try {
			oDoctor = Doctor.insertar(oModelPersona);			
			if(!oDoctor.getErrMensaje().equals("")){				
				return new ModelAndView("/error", "mensaje", oDoctor.getErrMensaje());
			}
			
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listardoctor.jsp");
	}
	/*
*/
	@RequestMapping(value = "/editarDoctor", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Doctor oModelPersona = new Doctor();
		oModelPersona = Doctor.obtener(Integer.parseInt(request.getParameter("doctorID")));
		
		System.out.println("idPersona " + request.getParameter("doctorID"));
		return new ModelAndView("editarDoctor", "model", oModelPersona);
	}
	
	@RequestMapping(value = "/guardarModificacionDoctor", method = RequestMethod.GET)
	public ModelAndView modificarDoctor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registarDoctor");
		
		Doctor oModelPersona = new Doctor();
		oModelPersona.setDoctorID(Integer.parseInt(request.getParameter("id")));
		oModelPersona.setNombre(request.getParameter("txtNombre"));
		oModelPersona.setPaterno(request.getParameter("txtApellidoPaterno"));
		oModelPersona.setMaterno(request.getParameter("txtApellidoMaterno"));
		oModelPersona.setEmail(request.getParameter("txtEmail"));
		oModelPersona.setTelefono(request.getParameter("txtTelefono"));
		oModelPersona.setUsuario(request.getParameter("txtUsuario"));
		oModelPersona.setPassword(request.getParameter("txtPassword"));
		oModelPersona.setGrupoID(Integer.parseInt(request.getParameter("cboGrupo")));
		oModelPersona.setErrMensaje("");
		
		Doctor oDoctor = new Doctor();
		try {
			oDoctor = Doctor.actualizar(oModelPersona);
			System.out.println("Mensaje = " + oDoctor.getErrMensaje());
			if(!oDoctor.getErrMensaje().equals("")){				
				return new ModelAndView("/error", "mensaje", oDoctor.getErrMensaje());
			}
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listardoctor.jsp");
	}
	
	
	@RequestMapping(value = "/eliminarDoctor", method = RequestMethod.GET)
	public ModelAndView eliminarDoctor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarDoctor");
		
		Doctor oModelPersona = new Doctor();
		oModelPersona.setDoctorID(Integer.parseInt(request.getParameter("doctorID")));
		
		try {
			Doctor.eliminar(oModelPersona);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listardoctor.jsp");
	}
/*
*/
	
}
