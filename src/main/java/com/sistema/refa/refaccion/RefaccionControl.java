package com.sistema.refa.refaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.refa.almacen.Almacen;
import com.sistema.refa.almacen.AlmacenRepository;
import com.sistema.refa.proveedor.Proveedor;
import com.sistema.refa.proveedor.ProveedorRepository;

@Controller
public class RefaccionControl {

	@Autowired
	private RefaccionRepository refaccionRepository;
	
	@Autowired
	private AlmacenRepository almacenRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("refacciones/nuevo")
	public String mostrarFormularioDeNuevaRefaccion(Model modelo) {
		List<Almacen> listaAlmacenes=almacenRepository.findAll();
		List<Proveedor> listaProveedores=proveedorRepository.findAll();
		
		modelo.addAttribute("refaccion", new Refaccion());
		modelo.addAttribute("listaAlmacenes", listaAlmacenes);
		modelo.addAttribute("listaProveedores", listaProveedores);
		
		return "refaccion_formulario";
	}
	
	
	@PostMapping("/refacciones/guardar")
	public String guardarRefaccion(Refaccion refaccion) {
		refaccionRepository.save(refaccion);
		return "redirect:/";
	}
	
	@GetMapping("/refacciones")
	public String listarRefacciones(Model modelo) {
		List<Refaccion> listaRefacciones=refaccionRepository.findAll();
		modelo.addAttribute("listaRefacciones", listaRefacciones);
		
		return "refacciones";
	}
	
	@GetMapping("/refacciones/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer id,Model modelo) {
		Refaccion refaccion=refaccionRepository.findById(id).get();
		modelo.addAttribute("refaccion",refaccion);
		
		List<Almacen> listaAlmacenes=almacenRepository.findAll();
		List<Proveedor> listaProveedores=proveedorRepository.findAll();
		
		modelo.addAttribute("listaAlmacenes", listaAlmacenes);
		modelo.addAttribute("listaProveedores", listaProveedores);
		
		return "refaccion_formulario";
	}
	
	@GetMapping("/refacciones/eliminar/{id}")
	public String eliminarRefaccion(@PathVariable("id") Integer id, Model modelo) {
		refaccionRepository.deleteById(id);
		return "redirect:/refacciones";
	}
	
}












