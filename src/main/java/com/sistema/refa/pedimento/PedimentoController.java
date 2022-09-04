package com.sistema.refa.pedimento;

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
public class PedimentoController {
	
	@Autowired
	private PedimentoRepository pedimentoRepository;
	
	@Autowired
	private RefaccionRepository refaccionRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("/pedimentos")
	public String listarPedimentos(Model modelo) {
		
		List<Pedimento> listaPedimentos=pedimentoRepository.findAll();
		modelo.addAttribute("listaPedimentos", listaPedimentos);
		
		
		return "pedimentos";
	}
	
	@GetMapping("/pedimentos/nuevo")
	public String mostrarFormularioDeNuevoPedimento(Model modelo) {
		List<Refaccion> listaRefacciones=refaccionRepository.findAll();
		List<Proveedor> listaProveedores=proveedorRepository.findAll();
		
		
		
		modelo.addAttribute("pedimento", new Pedimento());
		modelo.addAttribute("listaRefacciones", listaRefacciones);
		modelo.addAttribute("listaProveedores", listaProveedores);
		
		return "pedimento_formulario";
	}
	
	@PostMapping("/pedimentos/guardar")
	public String guardarPedimento(Pedimento pedimento) {
	pedimentoRepository.save(pedimento);
	return "redirect:/pedimentos";			
}
	

}
