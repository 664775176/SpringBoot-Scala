package com.silence

import com.silence.repository.StudentRepository
import com.silence.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
class Config


object SpringBootScalaApplication extends App {
    SpringApplication.run(classOf[Config])
  
}
