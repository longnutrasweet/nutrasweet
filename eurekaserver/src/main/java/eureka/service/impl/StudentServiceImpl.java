package eureka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eureka.dao.IStudentDao;
import eureka.entity.Student;
import eureka.service.IStudentService;

@Service
//@Transactional(propagation = Propagation.REQUIRED, timeout = 120000, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	public Student queryStudentInfo(Long id) {
		return studentDao.queryStudentInfo(id);
	}

	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}

}
