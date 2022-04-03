package com.templar.javatraining;

import com.templar.javatraining.bean.Klass;
import com.templar.javatraining.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SchoolStarterTest {

    @Autowired
    private School school;

    @Test
    public void testSchoolStarter() {
        List<Klass> klassList = school.getKlassList();
        Assert.assertEquals(2, klassList.size());

        Klass aKlass = klassList.get(0);
        Klass bKlass = klassList.get(1);

        List<Student> aKlassStudents = aKlass.getStudentList();
        List<Student> bKlassStudents = bKlass.getStudentList();

        Student a100Stu = aKlassStudents.get(0);
        Student a101Stu = aKlassStudents.get(1);
        Assert.assertEquals(100, a100Stu.getId());
        Assert.assertEquals("ACLASS-100", a100Stu.getName());
        Assert.assertEquals(101, a101Stu.getId());
        Assert.assertEquals("ACLASS-101", a101Stu.getName());

        Student b200Stu = bKlassStudents.get(0);
        Student b201Stu = bKlassStudents.get(1);
        Assert.assertEquals(200, b200Stu.getId());
        Assert.assertEquals("BCLASS-200", b200Stu.getName());
        Assert.assertEquals(201, b201Stu.getId());
        Assert.assertEquals("BCLASS-201", b201Stu.getName());
    }
}
