package com.silence.enties

import javax.persistence._
import javax.validation.constraints.NotNull
import org.hibernate.validator.constraints.NotBlank

import scala.beans.BeanProperty

@Table(name = "statistics")
@Entity
class Statistics(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BeanProperty
    var statisticsId: Int = _
    
    @BeanProperty
    @NotBlank
    var statisticsType: String = _

    @BeanProperty
    /*@NotBlank*/
    var scoreRanking: String = _

    @BeanProperty
    /*@NotNull*/
    var scoreRankingNum: Int = _

    @BeanProperty
    /*@NotNull*/
    var averageScore: Int = _

    @BeanProperty
    /*@NotBlank*/
    var levelRadio: String = _

    @BeanProperty
    /*@NotBlank*/
    var studentRanking: String = _

    @BeanProperty
    /*@NotNull*/
    var studentRankingNum: Int = _

    @BeanProperty
    /*@NotBlank*/
    var highestScoreStudent: String = _

    @BeanProperty
    /*@NotBlank*/
    var highestScore: Int = _

    @BeanProperty
    /*@NotBlank*/
    var sex: String = _

    @BeanProperty
    /*@NotNull*/
    var classId: Int = _

    def this( p_statisticsType : String, p_scoreRanking: String, p_scoreRanking_num : Int, p_averageScore : Int, p_levelRadio : String,
             p_studentRanking: String, p_studentRanking_num: Int, p_highestScore_student:String, p_highestScore :Int, p_sex :String, p_classId:Int) {
      this
      /*this.statisticsId = p_statisticsId*/
      this.statisticsType = p_statisticsType
      this.scoreRanking = p_scoreRanking
      this.scoreRankingNum = p_scoreRanking_num
      this.averageScore = p_averageScore
      this.levelRadio = p_levelRadio
      this.studentRanking = p_studentRanking
      this.studentRankingNum = p_studentRanking_num
      this.highestScoreStudent = p_highestScore_student
      this.highestScore = p_highestScore
      this.sex = p_sex
      this.classId = p_classId
    }
    /*override def toString = "studentId = " + studentId + ",studentName = " + studentName + ",classId = " + classId + ",chineseScore = " + chineseScore + "mathScore = " + mathScore + "englishScore = " + englishScore*/

}