package com.silence.service

import com.silence.enties.Grade
import com.silence.repository.GradeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GradeService extends BaseService[Grade] {

    @Autowired var gradeRepository: GradeRepository = _

}