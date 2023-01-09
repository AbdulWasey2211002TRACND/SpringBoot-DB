package com.example.demo.Repository;

import com.example.demo.models.Enrolled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnrolledRepository extends JpaRepository<Enrolled, Long> {
}