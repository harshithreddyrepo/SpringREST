package com.telusko.RestRepositoriesWeb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.RestRepositoriesWeb.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
