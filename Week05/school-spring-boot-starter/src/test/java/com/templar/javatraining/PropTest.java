package com.templar.javatraining;

import com.templar.javatraining.bean.Klass;
import com.templar.javatraining.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PropTest.class)
@SpringBootApplication
public class PropTest {

    @Autowired
    private School school;

    @Test
    public void testProp() {
        List<Klass> klassList = school.getKlassList();
        System.out.println(school);
        System.out.println(klassList.size());

        Klass klassA = klassList.get(0);
        System.out.println(klassA.toString());
        List<Student> studentList = klassA.getStudentList();
        System.out.println(studentList.size());

        Student stuA100 = studentList.get(0);
        System.out.println(stuA100.getId() + ", " + stuA100.getName());

    }

}
