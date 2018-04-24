package com.silence.repository

import com.silence.enties.Clazz
import org.springframework.data.jpa.repository.JpaRepository

trait ClassRepository extends JpaRepository[Clazz, Integer]