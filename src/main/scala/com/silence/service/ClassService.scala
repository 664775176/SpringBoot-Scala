package com.silence.service

import com.silence.enties.Clazz
import com.silence.repository.{ClassRepository, StudentRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClassService extends BaseService[Clazz] {

    @Autowired var classRepository: ClassRepository = _

}