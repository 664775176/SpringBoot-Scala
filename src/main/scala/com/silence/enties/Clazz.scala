package com.silence.enties

import javax.persistence._
import javax.validation.constraints.NotNull
import org.hibernate.validator.constraints.NotBlank

import scala.beans.BeanProperty

@Table(name = "clazz")
@Entity
class Clazz(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BeanProperty
    var classId: Int = _
    
    @BeanProperty
    @NotBlank
    var className: String = _
    
    @BeanProperty
    @NotNull
    var gradeId: Int = _

    @BeanProperty
    @NotBlank
    var remark: String = _

    def this(p_classId : Int, p_className : String, p_grade_id : Int, p_remark : String) {
      this
      this.classId = p_classId
      this.className = p_className
      this.gradeId = p_grade_id
      this.remark = p_remark
    }
    /*override def toString = "studentId = " + studentId + ",studentName = " + studentName + ",classId = " + classId + ",chineseScore = " + chineseScore + "mathScore = " + mathScore + "englishScore = " + englishScore*/

}