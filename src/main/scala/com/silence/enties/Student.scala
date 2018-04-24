package com.silence.enties

import javax.persistence._
import javax.validation.constraints.NotNull
import org.hibernate.validator.constraints.NotBlank

import scala.beans.BeanProperty

@Table(name = "student")
@Entity
class Student (){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BeanProperty
    var studentId: Int = _
    
    @BeanProperty
    @NotBlank
    var studentName: String = _
    
    @BeanProperty
    @NotNull
    var classId: Int = _
    
    @BeanProperty
    @NotNull
    var chineseScore: Int = _

    @BeanProperty
    @NotNull
    var mathScore: Int = _

    @BeanProperty
    @NotNull
    var englishScore: Int = _

    @BeanProperty
    @NotBlank
    var sex: String = _

    def this(p_id : Int, p_sex : String, p_name: String, p_class_id : Int,
             p_chineseScore : Int, p_mathScore : Int, p_englishScore :Int) {
      this
      this.studentId = p_id
      this.studentName = p_name
      this.sex = p_sex
      this.classId = p_class_id
      this.chineseScore = p_chineseScore
      this.mathScore = p_mathScore
      this.englishScore = p_englishScore
    }
    /*override def toString = "studentId = " + studentId + ",studentName = " + studentName + ",classId = " + classId + ",chineseScore = " + chineseScore + "mathScore = " + mathScore + "englishScore = " + englishScore*/

}