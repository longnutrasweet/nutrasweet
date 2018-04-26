package eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eureka.entity.Student;
import eureka.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/querystudentinfo", method = RequestMethod.GET)
	public Student queryStudentInfo(@RequestParam("id") Long id) {
		return studentService.queryStudentInfo(id);
	}

	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST)
	public void insertStudent(@RequestBody Student student) {
		studentService.insertStudent(student);
	}
}
