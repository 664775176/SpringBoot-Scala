package com.silence.repository

import com.silence.enties.Student
import org.springframework.data.jpa.repository.JpaRepository

trait StudentRepository extends JpaRepository[Student, Integer]