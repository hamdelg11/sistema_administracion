package com.sistema.refa.garantia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.refa.almacen.Almacen;
import com.sistema.refa.almacen.AlmacenRepository;




@Controller
public class GarantiaController {
	
	@Autowired
	private GarantiaRepository garantiaRepository;
	
	@Autowired
	private AlmacenRepository almacenRepository;
	
	@GetMapping("/garantias")
	public String listarGarantias(Model modelo) {
		
		List<Garantia> listaGarantias=garantiaRepository.findAll();
		modelo.addAttribute("listaGarantias", listaGarantias);
		
		return "garantias";
	}
	
	@GetMapping("/garantias/nuevo")
	public String mostrarFormularioDeNuevaGarantia(Model modelo) {
		List<Almacen> listaAlmacenes=almacenRepository.findAll();
		
		modelo.addAttribute("garantia", new Garantia());
		modelo.addAttribute("listaAlmacenes", listaAlmacenes);
		
		return "garantia_formulario";
	}
	
	@PostMapping("/garantias/guardar")
	public String guardarGarantia(Garantia garantia) {
	garantiaRepository.save(garantia);
	return "redirect:/garantias";			
	}
	
	@GetMapping("/garantias/editar/{id}")
	public String mostrarFormularioDeModificarGarantia(@PathVariable("id") Integer id,Model modelo) {
		Garantia garantia=garantiaRepository.findById(id).get();
		modelo.addAttribute("garantia",garantia);
		
		List<Almacen> listaAlmacenes=almacenRepository.findAll();

		modelo.addAttribute("listaAlmacenes", listaAlmacenes);
		
		return "garantia_formulario";
	}
	
	@GetMapping("/garantias/eliminar/{id}")
	public String eliminarGarantia(@PathVariable("id") Integer id, Model modelo) {
		garantiaRepository.deleteById(id);
		return "redirect:/garantias";
	}

}
