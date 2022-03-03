package com.example.demo.rest;

import org.hibernate.query.criteria.internal.expression.function.LocateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.productos;
import com.example.demo.service.productosService;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/Productos/")
public class ProductosRest {

	@Autowired
	private productosService productoService; 
	
	@GetMapping
	private ResponseEntity<List<productos>> getAllproductos(){
		return ResponseEntity.ok(productoService.findAll());
	}
@PostMapping
private ResponseEntity<productos> saveProductos (@RequestBody productos producto){
	try {
	productos productoGuardado = productoService.save(producto);
	
	return ResponseEntity.created(new URI("/Productos/"+productoGuardado.getId())).body(productoGuardado);

	}catch(Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}


