package net.furious.controllers;

import java.io.IOException;
import net.vetfurious.excepcion.DAOExcepcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vetfurious.negocio.IPaciente;
import net.vetfurious.negocio.ICombo;
import net.vetfurious.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PacienteController {

	@Autowired
	private IPaciente iPaciente;
	@Autowired
	private ICombo iCombo;
	
	
	@RequestMapping(value="/listarpaciente.jsp")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOExcepcion {
		
		List<Paciente> pacientes = iPaciente.listarPacientes();
				
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("pacientes",pacientes);
		
        return new ModelAndView("listarpaciente", "model", myModel);

    }
	
	@RequestMapping(value = "/verRegistroPaciente", method = RequestMethod.GET)
	public ModelAndView ingresar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//return new ModelAndView("nuevoPaciente");
		
		List<Control> ListaEspecie = iCombo.GetDataCombo("ESPECIE");
		List<Control> ListaRaza = iCombo.GetDataCombo("RAZA");
		List<Control> ListaGenero = iCombo.GetDataCombo("GENERO");
		List<Control> ListaTipoSangre = iCombo.GetDataCombo("TIPOSANGRE");
		List<Control> ListaTamano = iCombo.GetDataCombo("TAMANO");
		List<Control> ListaActividad = iCombo.GetDataCombo("ACTIVIDAD");
		
		
		HttpSession session = request.getSession();

		session.setAttribute("ESPECIE", ListaEspecie);
		session.setAttribute("RAZA", ListaRaza);
		session.setAttribute("GENERO", ListaGenero);
		session.setAttribute("TIPOSANGRE", ListaTipoSangre);
		session.setAttribute("TAMANO", ListaTamano);
		session.setAttribute("ACTIVIDAD", ListaActividad);
		
		return new ModelAndView("registrarPaciente");
	}
	
	@RequestMapping(value = "/registrarPaciente", method = RequestMethod.POST)
	public ModelAndView registroPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarPaciente");
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigoDueno(Integer.parseInt(request.getParameter("hiddencliente")));
		oModelPaciente.setCodigoPaciente(0);
		oModelPaciente.setespecieid(Integer.parseInt(request.getParameter("cboEspecie")));
		oModelPaciente.setrazaid(Integer.parseInt(request.getParameter("cboRaza")));
		oModelPaciente.setgeneroid(Integer.parseInt(request.getParameter("cboGenero")));
		oModelPaciente.settipoSangreid(Integer.parseInt(request.getParameter("cboTipoSangre")));
		oModelPaciente.setEsterilizado(request.getParameter("cboEsterilizado"));
		oModelPaciente.settamanoid(Integer.parseInt(request.getParameter("cboTamano")));
		oModelPaciente.setactividadid(Integer.parseInt(request.getParameter("cboActividad")));
		oModelPaciente.setPeso(request.getParameter("txtPeso"));
		oModelPaciente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
		oModelPaciente.setNotasMedicas(request.getParameter("txtNotasMedicas"));
		oModelPaciente.setCondicionesEspeciales(request.getParameter("txtCondicionesEspeciales"));
		
		try {
			iPaciente.insertarPaciente(oModelPaciente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarpaciente.jsp");
	}
	
	@RequestMapping(value = "/editarPaciente", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Paciente oModelPaciente = new Paciente();
		List<Control> ListaEspecie = iCombo.GetDataCombo("ESPECIE");
		List<Control> ListaRaza = iCombo.GetDataCombo("RAZA");
		List<Control> ListaGenero = iCombo.GetDataCombo("GENERO");
		List<Control> ListaTipoSangre = iCombo.GetDataCombo("TIPOSANGRE");
		List<Control> ListaTamano = iCombo.GetDataCombo("TAMANO");
		List<Control> ListaActividad = iCombo.GetDataCombo("ACTIVIDAD");
		
		
		HttpSession session = request.getSession();

		session.setAttribute("ESPECIE", ListaEspecie);
		session.setAttribute("RAZA", ListaRaza);
		session.setAttribute("GENERO", ListaGenero);
		session.setAttribute("TIPOSANGRE", ListaTipoSangre);
		session.setAttribute("TAMANO", ListaTamano);
		session.setAttribute("ACTIVIDAD", ListaActividad);
		
		
		//System.out.println("idPaciente "+request.getParameter("codigoPaciente"));
		System.out.println("idPaciente "+request.getParameter("id"));
		
		oModelPaciente = iPaciente.obtenerPaciente(Integer.parseInt(request.getParameter("id")));
		System.out.println("id "+oModelPaciente.getCondicionesEspeciales());
	
		return new ModelAndView("editarPaciente", "modelo", oModelPaciente);
	}
	
	//@RequestMapping(value = "/guardarModificacionPaciente", method = RequestMethod.POST)
	@RequestMapping(value = "/modificarPaciente", method = RequestMethod.POST)
	public ModelAndView modificarPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("registrarPaciente");
		System.out.println(request.getParameter("txtDueno"));
		System.out.println(request.getParameter("txtPaciente"));
		System.out.println(request.getParameter("cboEspecie"));
		System.out.println(request.getParameter("cboRaza"));
		System.out.println(request.getParameter("cboGenero"));
		System.out.println(request.getParameter("cboTipoSangre"));
		System.out.println(request.getParameter("cboTamano"));
		System.out.println(request.getParameter("cboActividad"));
		
		
		
		Paciente oModelPaciente = new Paciente();
		oModelPaciente.setCodigoDueno(Integer.parseInt(request.getParameter("txtDueno")));

		oModelPaciente.setCodigoPaciente(Integer.parseInt(request.getParameter("txtPaciente")));

		oModelPaciente.setespecieid(Integer.parseInt(request.getParameter("cboEspecie")));

		oModelPaciente.setrazaid(Integer.parseInt(request.getParameter("cboRaza")));

		oModelPaciente.setgeneroid(Integer.parseInt(request.getParameter("cboGenero")));

		oModelPaciente.settipoSangreid(Integer.parseInt(request.getParameter("cboTipoSangre")));

		oModelPaciente.setEsterilizado(request.getParameter("cboEsterilizado"));
		oModelPaciente.settamanoid(Integer.parseInt(request.getParameter("cboTamano")));

		oModelPaciente.setactividadid(Integer.parseInt(request.getParameter("cboActividad")));

		oModelPaciente.setPeso(request.getParameter("txtPeso"));
		oModelPaciente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
		oModelPaciente.setNotasMedicas(request.getParameter("txtNotasMedicas"));
		oModelPaciente.setCondicionesEspeciales(request.getParameter("txtCondicionesEspeciales"));
		
		try {
			iPaciente.GrabarModificarPaciente(oModelPaciente);
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarpaciente.jsp");
	}
	
	@RequestMapping(value = "/eliminarPaciente", method = RequestMethod.GET)
	public ModelAndView eliminarPaciente(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("eliminarPaciente");
		
		try {
			iPaciente.deletepaciente(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			return new ModelAndView("/error", "mensaje", e.getMessage());
		}

		return new ModelAndView("redirect:listarpaciente.jsp");
	}

	
	/*@RequestMapping(value = "/Menu", method = RequestMethod.GET)
	public ModelAndView IrMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Menu");
		return new ModelAndView("index");
	}*/

}
