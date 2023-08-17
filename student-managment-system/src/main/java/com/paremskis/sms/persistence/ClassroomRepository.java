package com.paremskis.sms.persistence;

import com.paremskis.sms.model.Classroom;
import com.paremskis.sms.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    Optional<Classroom> findByName(String name);

}
