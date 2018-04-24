CREATE TABLE `clazz` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `grade_id` int(11) NOT NULL COMMENT '年级ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `grade_name` varchar(255) NOT NULL COMMENT '年级名称',
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `statistics` (
  `statistics_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `statistics_type` varchar(255) DEFAULT '' COMMENT '统计类型，{语文、数学、英语、总分}',
  `score_ranking` text COMMENT '按分数排名的分数文本',
  `score_ranking_num` int(3) DEFAULT NULL COMMENT '按分数排名的分数文本个数',
  `average_score` int(11) DEFAULT NULL COMMENT '平均分',
  `level_radio` varchar(255) DEFAULT NULL COMMENT '等级比例',
  `student_ranking` text COMMENT '按分数排名后学生名称文本',
  `student_ranking_num` int(11) DEFAULT NULL COMMENT '按分数排名后学生名称个数',
  `highest_score_student` varchar(255) DEFAULT NULL COMMENT '最高分的学生名称',
  `highest_score` int(3) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL COMMENT '性别条件',
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`statistics_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chinese_score` int(11) DEFAULT NULL COMMENT '语文分数',
  `class_id` int(11) NOT NULL COMMENT '班级ID',
  `english_score` int(11) DEFAULT NULL COMMENT '英语分数',
  `math_score` int(11) DEFAULT NULL COMMENT '数学分数',
  `student_name` varchar(255) NOT NULL COMMENT '学生名称',
  `sex` varchar(5) NOT NULL COMMENT '性别',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;




