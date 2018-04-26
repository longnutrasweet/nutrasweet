package eureka.service;

import org.apache.ibatis.annotations.Param;

import eureka.entity.Student;

public interface IStudentService {

	Student queryStudentInfo(@Param("id") Long id);

	void insertStudent(@Param("student") Student student);

}
