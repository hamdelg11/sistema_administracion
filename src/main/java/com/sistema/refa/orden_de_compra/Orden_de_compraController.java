package com.sistema.refa.orden_de_compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.refa.proveedor.Proveedor;
import com.sistema.refa.proveedor.ProveedorRepository;
import com.sistema.refa.refaccion.Refaccion;
import com.sistema.refa.refaccion.RefaccionRepository;

@Controller
public class Orden_de_compraController {
	
	
	@Autowired
	private Orden_de_compraRepository ordenRepository;
	
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private RefaccionRepository refaccionRepository;
	
	
	@GetMapping("/ordenes_de_compra")
	public String listarOrdenes(Model modelo) {
		
		List<Orden_de_compra> listaOrdenes=ordenRepository.findAll();
		modelo.addAttribute("listaOrdenes", listaOrdenes);
		
		return "ordenes";
	}
	
	@GetMapping("/ordenes_de_compra/nuevo")
	public String mostrarFormularioDeNuevaOrden(Model modelo) {
		List<Proveedor> listaProveedores=proveedorRepository.findAll();
		List<Refaccion> listaRefacciones=refaccionRepository.findAll();
		
		modelo.addAttribute("orden_de_compra", new Orden_de_compra());
		modelo.addAttribute("listaProveedores", listaProveedores);
		modelo.addAttribute("listaRefacciones", listaRefacciones);
		
		return "orden_formulario";
	}
	
	@PostMapping("/ordenes_de_compra/guardar")
	public String guardarOrden(Orden_de_compra orden) {
	ordenRepository.save(orden);
	return "redirect:/ordenes_de_compra";			
	}
	

}
