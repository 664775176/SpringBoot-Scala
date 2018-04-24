package com.silence.repository

import com.silence.enties.Grade
import org.springframework.data.jpa.repository.JpaRepository

trait GradeRepository extends JpaRepository[Grade, Integer]