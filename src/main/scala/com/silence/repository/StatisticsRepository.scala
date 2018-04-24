package com.silence.repository

import com.silence.enties.Statistics
import org.springframework.data.jpa.repository.JpaRepository

trait StatisticsRepository extends JpaRepository[Statistics, Integer]