package com.codingassignment7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelecombhaartiController {
	
	@Autowired
	private TelecombhaartiRepository TeleRepository;

	// get all employees
	@GetMapping("/getdata")
	public List<Telecombhaarti> getAll() {
		List<Telecombhaarti> t1 = TeleRepository.findAll();
		System.out.println("::::::::::::::::::::Filter Method::::::::::::::::::::");
		List<Telecombhaarti> filter =  t1.stream().filter(f -> f.getCity().equals("hyderabad")).collect(Collectors.toList());
        System.out.println(filter);
        System.out.println("::::::::::::::::::::ForEach Method:::::::::::::::::::");
		TeleRepository.findAll().stream().forEach(s ->System.out.println(s));
		System.out.println("::::::::::::::::::::Map Method:::::::::::::::::::");
		t1.stream().map(x -> x.getCname()).forEach(System.out::println);
		return TeleRepository.findAll();
	}

	// create operation
	

	// create employee rest api
	@PostMapping("/adddata")
	public Telecombhaarti createdata(@RequestBody Telecombhaarti c) {
		return TeleRepository.save(c);
	}
//
//	// update data
	@PutMapping("/updatedata/{id}") //
	public ResponseEntity<Telecombhaarti> updatedata(@PathVariable int id, @RequestBody Telecombhaarti pd) {
		Telecombhaarti p = TeleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not exist with id :" + id));
		p.setId(pd.getId());
		p.setCname(pd.getCname());
		p.setPlan(pd.getPlan());
		p.setMobiNo(pd.getMobiNo());

		Telecombhaarti pd2 = TeleRepository.save(p);
		return ResponseEntity.ok(pd2);
	}
//
//	// delete item in cart
	@DeleteMapping("/deletedata/{id}")
	public void deleteitem(@PathVariable("id") int id) {
		TeleRepository.deleteById(id);
	}

}
