package br.com.crudspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.crudspring.model.Courses;
import br.com.crudspring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	
	private final CourseService cs;
	
	public CourseController( CourseService cs) {
		this.cs = cs;
	}

	@GetMapping
	public @ResponseBody List<Courses> list(){
		return cs.list();
	}
	
	@GetMapping("/{id}")
	public Courses findById(@PathVariable @NotNull @Positive Long id) {
		return cs.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Courses> createCourse(@RequestBody @Valid Courses course) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(cs.createCourse(course));
	}
	
	@PutMapping("/{id}")
	public Courses update(@PathVariable @NotNull @Positive Long id, 
			@RequestBody @Valid Courses course) {
		
		return cs.update(id, course);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable  @NotNull @Positive Long id) {
		cs.delete(id);
	}
	
}
