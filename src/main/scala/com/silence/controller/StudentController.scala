package com.silence.controller

import java.util.List

import com.silence.enties.Student
import com.silence.service.StudentService
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.domain.Page
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation._

@ComponentScan
@Controller
@ResponseBody
@RequestMapping(value = Array("/student"))
/*
@SpringBootApplication
*/
class StudentController @Autowired()(private val studentService : StudentService){
  
  	@RequestMapping(value = Array("/list"), method = Array(RequestMethod.GET))
    def list() : List[Student] = {
        studentService.findAll
    }
    
    @RequestMapping(value = Array("save"), method = Array(RequestMethod.POST))
    def save(@Valid student : Student) : Student = {
        studentService.save(student)
    }
    
  	@RequestMapping(value = Array("/find/{id}"), method = Array(RequestMethod.GET))
    def find(@PathVariable(value = "id") id: Integer) : Student = {
        studentService.find(id)
    }
    
    @RequestMapping(value = Array("delete/{id}"), method = Array(RequestMethod.POST))
    def delete(@PathVariable(value = "id") id: Integer) : Unit = {
        studentService.delete(id)
    }
    
    @RequestMapping(value = Array("update"), method = Array(RequestMethod.POST))
    def update(@Valid student : Student, bindingResult : BindingResult) : Student = {
        studentService.update(student)
    }
    
    @RequestMapping(value = Array("page"), method = Array(RequestMethod.GET))
    def page(@RequestParam("page") page : Int, @RequestParam("pageSize") pageSize : Int) : Page[Student] = {
        studentService.page(page, pageSize)
    }
    @RequestMapping(value = Array("init"), method = Array(RequestMethod.GET))
    def init()={
      studentService.init()
      "init success !!!"
    }
    @RequestMapping(value = Array("statistics"), method = Array(RequestMethod.GET))
    def statistics()= {
      studentService.statistics
    }

  }