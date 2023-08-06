package com.paremskis.sms.service;

import java.util.List;
import java.util.Optional;

import com.paremskis.sms.model.Student;
import com.paremskis.sms.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
@Autowired
	private StudentRepository studentRepository;


	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		log.info("Find all products");
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(long id) {
		return Optional.ofNullable(studentRepository.findById(id).orElse(null));
	}

	@Override
	public Optional<Student> findByEmail(String email) {
		log.info("Searching student by Email: " + email );
		return studentRepository.findByEmail(email);
	}

	@Override
	public Student save(Student std) {
		log.debug("Save student: "+std);
		return studentRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		log.info("Deleted student by id--{}",id);
		studentRepository.deleteById(id);

	}

	@Override
	public void deleteById(Student std) {
		studentRepository.delete(std);
	}
}



