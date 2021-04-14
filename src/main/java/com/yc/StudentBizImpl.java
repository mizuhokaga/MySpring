package com.yc;

import com.yc.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentBizImpl {
    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentBizImpl() {

    }

    public int add(String name) {
        int result = studentDao.add(name);
        return result;

    }

    public void update(String name) {
        studentDao.update(name);
    }
}
