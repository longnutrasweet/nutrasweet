package eureka.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import eureka.entity.Student;

@Mapper
public interface IStudentDao {

	Student queryStudentInfo(@Param("id") Long id);

	void insertStudent(@Param("student") Student student);
}
