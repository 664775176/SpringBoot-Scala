package com.silence.enties

import javax.persistence._
import org.hibernate.validator.constraints.NotBlank

import scala.beans.BeanProperty

@Table(name = "grade")
@Entity
class Grade(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BeanProperty
    var gradeId: Int = _
    
    @BeanProperty
    @NotBlank
    var gradeName: String = _
    
    def this(p_gradeId : Int, p_gradeName : String) {
      this
      this.gradeId = p_gradeId
      this.gradeName = p_gradeName
    }
    /*override def toString = "studentId = " + studentId + ",studentName = " + studentName + ",classId = " + classId + ",chineseScore = " + chineseScore + "mathScore = " + mathScore + "englishScore = " + englishScore*/

}