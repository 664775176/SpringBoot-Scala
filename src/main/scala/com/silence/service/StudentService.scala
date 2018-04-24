package com.silence.service

import com.silence.enties.{Clazz, Grade, Statistics, Student}
import com.silence.repository.{ClassRepository, GradeRepository, StatisticsRepository, StudentRepository}
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters

@Service
class StudentService extends BaseService[Student] {

    @Autowired var studentRepository: StudentRepository = _
    @Autowired var classRepository: ClassRepository = _
    @Autowired var gradeRepository: GradeRepository = _
    @Autowired var statisticsRepository: StatisticsRepository = _
    @Transactional
    def init(): Unit ={
        val gradeId = 1
        val grade = new Grade(gradeId, "grade1")
        gradeRepository.save(grade)
        val classId1 = 1
        val classId2 = 2
        val clazz1 =new Clazz(classId1, "class1", gradeId, "c1")
        classRepository.save(clazz1)
        val clazz2 =new Clazz(classId2, "class2", gradeId,"c2")
        clazz2.setClassId(classId2)
        classRepository.save(clazz2)
        val student1 =  new Student(1, "Man", "S1", classId1, 90, 80, 82)
        val student2 =  new Student(2, "Woman", "S2", classId1, 52, 83, 56)
        val student3 =  new Student(3, "Man", "S3", classId1, 98, 64, 88)
        val student4 =  new Student(4, "Woman", "S4", classId1, 68, 45, 74)
        val student5 =  new Student(5, "Woman", "S5", classId1, 98, 56, 64)
        val student6 =  new Student(6, "Man", "S6", classId2, 90, 67, 64)
        val student7 =  new Student(7, "Woman", "S7", classId2, 78, 78, 88)
        val student8 =  new Student(8, "Man", "S8", classId2, 68, 89, 63)
        val student9 =  new Student(9, "Man", "S9", classId2, 88, 97, 67)
        val student10 = new Student(10, "Woman", "S10", classId2, 58, 86, 76)
        val student11 = new Student(11, "Man", "S11", classId2, 78, 75, 77)
        val student12 = new Student(12, "Man", "S12", classId1, 98, 46, 78)

        val student13 = new Student(13, "Man", "S13", classId1, 70, 90, 62)
        val student14 = new Student(14, "Woman", "S14", classId1, 55, 87, 76)
        val student15 = new Student(15, "Man", "S15", classId1, 98, 67, 88)
        val student16 = new Student(16, "Woman", "S16", classId1, 88, 55, 77)
        val student17 = new Student(17, "Woman", "S17", classId1, 88, 56, 64)
        val student18 = new Student(18, "Man", "S18", classId2, 99, 68, 64)
        val student19 = new Student(19, "Woman", "S19", classId2, 78, 75, 88)
        val student20 = new Student(20, "Man", "S20", classId2, 68, 86, 63)
        val student21 = new Student(21, "Man", "S21", classId2, 87, 96, 68)
        val student22 = new Student(22, "Woman", "S22", classId2, 55, 85, 73)
        val student23 = new Student(23, "Man", "S23", classId2, 78, 75, 70)
        val student24 = new Student(24, "Man", "S24", classId1, 90, 40, 75)
        val students: List[Student] = List(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11, student12,
            student13, student14, student15, student16, student17, student18, student19, student20, student21, student22, student23, student24)
        for(element <- students) {
            studentRepository.save(element)
        }
    }
    def statistics: String = {
        val students = JavaConverters.asScalaBuffer(findAll).toList
        statistics1(students)
    }
    private def statistics1(students : List[Student]):String = {
        val group = students.groupBy { (student) => student.classId }
        var list = List[Statistics]()
        var tmp : Statistics = null
        val sb = new StringBuilder
        group.keys.foreach { i =>
            val scoreList = group(i)
            //总分前5名
            val totalList = scoreListFun(scoreList, "Total")
            sb.append("班级：" + i + " 总分前5名为：")
            tmp = scoreSortFun(sb, totalList, 5, "Total", i)
            list :+= tmp
            //语文分前5名
            val chineseList = scoreListFun(scoreList, "Chinese")
            sb.append("班级：" + i + " 语文分前5名为：")
            tmp = scoreSortFun(sb, chineseList, 5, "Chinese", i)
            list :+= tmp
            //语文平均分
            tmp = averageFun(chineseList, "Chinese", i)
            sb.append("班级：" + i + " 语文平均分为：" + tmp.averageScore + "\n")
            list :+= tmp
            //语文等级比例
            sb.append("班级：" + i + " 语文各等级人数比例为：")
            tmp = subjectRadioFun(sb, chineseList, "Chinese", i)
            list :+= tmp
            //数学分前5名
            val mathList = scoreListFun(scoreList, "Math")
            sb.append("班级：" + i + " 数学分前5名为：")
            tmp = scoreSortFun(sb, mathList, 5, "Math", i)
            list :+= tmp
            //数学平均分
            tmp = averageFun(mathList, "Math", i)
            sb.append("班级：" + i + " 数学平均分为：" + tmp.averageScore + "\n")
            list :+= tmp
            //数学等级比例
            sb.append("班级：" + i + " 数学各等级人数比例为：")
            tmp = subjectRadioFun(sb, mathList, "Math", i)
            list :+= tmp
            //英语分前5名
            val englishList = scoreListFun(scoreList, "English")
            sb.append("班级：" + i + " 英语分前5名为：")
            tmp = scoreSortFun(sb, englishList, 5, "English", i)
            list :+= tmp
            //英语平均分
            tmp = averageFun(mathList, "English", i)
            sb.append("班级：" + i + " 英语平均分为：" + tmp.averageScore + "\n")
            list :+= tmp
            //英语等级比例
            sb.append("班级：" + i + " 英语各等级人数比例为：")
            tmp = subjectRadioFun(sb, englishList, "English", i)
            list :+= tmp
        }
        tmp = totalStatisticsFun(sb, students, "Total", 20)
        list :+= tmp

        val group1 = students.groupBy { case (student) => student.sex }
        group1.keys.foreach { i =>
            val scoreList = group1(i)
            //语文状元
            tmp = highestScoreFun(i, scoreList, "Chinese")
            list :+= tmp
            sb.append(i + "语文状元为：" + tmp.highestScoreStudent + ", 分数为：" + tmp.highestScore + "\n")
            //数学状元
            tmp = highestScoreFun(i, scoreList, "Math")
            list :+= tmp
            sb.append(i + "数学状元为：" + tmp.highestScoreStudent + ", 分数为：" + tmp.highestScore + "\n")
            //英语状元
            tmp = highestScoreFun(i, scoreList, "English")
            list :+= tmp
            sb.append(i + "英语状元为：" + tmp.highestScoreStudent + ", 分数为：" + tmp.highestScore + "\n")
        }
        saveStatistics(list)
        println(sb.toString())
        sb.toString()
    }
    private def highestScoreFun(sex: String, scoreList: List[Student], statisticsType :String):Statistics = {
        val list = nameListFun(scoreList, statisticsType)
        val score = list.maxBy({ case (name, score) => score })
        val tmp = new Statistics()
        tmp.setStatisticsType(statisticsType)
        tmp.setHighestScoreStudent(score._1)
        tmp.setHighestScore(score._2)
        tmp.setSex(sex)
        tmp
    }
    private def totalStatisticsFun(stringBuilder: StringBuilder, students: List[Student], statisticsType: String, num:Int):Statistics = {
        val totalList = nameListFun(students, statisticsType)
        print("全年级总分前20名为：")
        val score = totalList.sortWith({ case (s1, s2) => s1._2 > s2._2 })
        val slicedScore = score.slice(0, num)
        val sb = new StringBuilder
        for (elem <- slicedScore) {
            stringBuilder.append(elem._1 + ",总分:" + elem._2 + "; ")
            sb.append(elem._1 + " ")
        }
        stringBuilder.append("\n")
        val tmp = new Statistics()
        tmp.setStatisticsType(statisticsType)
        tmp.setStudentRanking(sb.toString())
        tmp.setStudentRankingNum(num)
        tmp
    }
    @Transactional
    def saveStatistics(list:List[Statistics]): Unit = {
        for(ele <- list) {
            statisticsRepository.save(ele)
        }
    }
    private def scoreListFun(students: List[Student], subjectName: String):  List[Int] = subjectName match {
        case "Total" =>
            students.map(e => e.chineseScore + e.mathScore + e.englishScore)
        case "Chinese" =>
            students.map(e => e.chineseScore)
        case "Math" =>
            students.map(e => e.mathScore)
        case "English" =>
            students.map(e => e.englishScore)
        case _ => throw new RuntimeException("错误的学科")
    }

    private def scoreSortFun(stringBuilder: StringBuilder, scoreList: List[Int], num: Int, statisticsType :String, classId :Int): Statistics = {
        val score = scoreList.sortWith { (s1, s2) => s1 > s2 }
        val slicedScore = score.slice(0, num)
        val sb = new StringBuilder
        for (elem <- slicedScore) {
            stringBuilder.append(elem + " ")
            sb.append(elem + " ")
        }
        val tmp = new Statistics()
        tmp.setStatisticsType(statisticsType)
        tmp.setScoreRanking(sb.toString())
        tmp.setScoreRankingNum(num)
        tmp.setClassId(classId)
        sb.append("\n")
        tmp
    }
    private def subjectRadioFun(stringBuilder: StringBuilder, scoreList: List[Int], statisticsType: String, classId :Int): Statistics ={
        val radio1 = scoreList.filter(_ >=90).length
        val radio2 = scoreList.filter(_ >=75).filter(_ <90).length
        val radio3 = scoreList.filter(_ >=60).filter(_ <75).length
        val radio4 = scoreList.filter(_ < 60).length
        val tmp = new Statistics()
        tmp.setStatisticsType(statisticsType)
        tmp.setClassId(classId)
        tmp.setLevelRadio(radio1 +":" +radio2 + ":" + radio3 +":" + radio4)
        stringBuilder.append( radio1 +":" +radio2 + ":" + radio3 +":" + radio4 + "\n")
        tmp
    }
    private def nameListFun(students: List[Student], subjectName: String):  List[(String, Int)] = subjectName match {
        case "Total" =>
            students.map(e => (e.studentName, e.chineseScore + e.mathScore + e.englishScore))
        case "Chinese" =>
            students.map(e => (e.studentName, e.chineseScore))
        case "Math" =>
            students.map(e => (e.studentName, e.mathScore))
        case "English" =>
            students.map(e => (e.studentName, e.englishScore))
        case _ => throw new RuntimeException("错误的学科")
    }
    private def averageFun(list :List[Int],statisticsType :String, classId :Int): Statistics = {
        val average = list.sum / list.size
        val tmp = new Statistics()
        tmp.setStatisticsType(statisticsType)
        tmp.setClassId(classId)
        tmp.setAverageScore(average)
        tmp
    }
}