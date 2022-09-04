package com.sistema.refa.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.refa.refaccion.Refaccion;
import com.sistema.refa.refaccion.RefaccionRepository;


@Controller
public class ProveedorController {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private RefaccionRepository refaccionRepository;
	
	@GetMapping("/proveedores")
	public String listarProveedores(Model modelo) {
		
		List<Proveedor> listaProveedores=proveedorRepository.findAll();
		modelo.addAttribute("listaProveedores", listaProveedores);
		
		return "proveedores";
	}
	
	@GetMapping("/proveedores/nuevo")
	public String mostrarFormularioDeNuevoProveedor(Model modelo) {
		List<Refaccion> listaRefacciones=refaccionRepository.findAll();
		
		modelo.addAttribute("proveedor", new Proveedor());
		modelo.addAttribute("listaRefacciones", listaRefacciones);
		
		return "proveedor_formulario";
	}
	
	@PostMapping("/proveedores/guardar")
		public String guardarProveedor(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		return "redirect:/proveedores";			
	}
	
	@GetMapping("/proveedores/editar/{id}")
	public String mostrarFormularioDeModificarProveedor(@PathVariable("id") Integer id,Model modelo) {
		Proveedor proveedor=proveedorRepository.findById(id).get();
		modelo.addAttribute("proveedor",proveedor);
		
		List<Refaccion> listaRefacciones=refaccionRepository.findAll();

		modelo.addAttribute("listaRefacciones", listaRefacciones);	
		
		return "proveedor_formulario";
	}
	
	@GetMapping("/proveedores/eliminar/{id}")
	public String eliminarProveedor(@PathVariable("id") Integer id, Model modelo) {
		proveedorRepository.deleteById(id);
		return "redirect:/proveedores";
	}

}
