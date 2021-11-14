package com.gokul;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokul.entity.ExceptionHandeler;
import com.gokul.entity.Student;
import com.gokul.entity.StudentDao;

@RestController
public class Contra {

	private final Logger log=LoggerFactory.getLogger(Contra.class);
	@Autowired
	StudentDao dao;
	@RequestMapping("/hi")
	public String dara()
	{
		
		return "hello";
	}
	@GetMapping("/data")
	public List<Student> dasssra()
	{
		log.info("fecting data");
		return dao.findAll();
	}
	@GetMapping("/single/{id}")
	public Student daa(@PathVariable int id) throws ExceptionHandeler
	{
		log.info("fecting data by id"+id);
		  Optional<Student>s=dao.findById(id);
		  if(!s.isPresent())
		  {
			  throw new ExceptionHandeler("depratment not found");
		  }
		  return s.get();
	}
}
