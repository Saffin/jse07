package cz.ucl.test;


import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class ServiceTest {

    ServiceForTest service;

    @Before
    public void init() {
        service = new ServiceForTest();
    }

    @Test
    public void getMinimalNumberFromArray() {

        int[] numbers = {10,1,0,9,8,-1,47,2,0};
        int[] numbers2 = {10,1,0,9,8,0,47,2,0};
        Assert.assertEquals(-1,  service.getMin(numbers));
        Assert.assertEquals(0,  service.getMin(numbers2));
        Assert.assertTrue(service.getMin(numbers) == -1 );
    }

    @Test//(expected = IllegalArgumentException.class)
    public void emptyArrayThrowsException() {
        int[] numbers = null;

        try {
            service.getMin(numbers);
        } catch (IllegalArgumentException ex) {
            // This exception is expected
            return;
        }
        Assert.fail("Should have thrown IllegalArgumentException");
    }

    @Test
    public void testGetNumberOfSemester(){
        Student firstYearStudent = new Student();
        firstYearStudent.setId(1);
        firstYearStudent.setEnrolmentDate(LocalDate.of(2018,9,1));

        Student secondYearStudent = new Student();
        secondYearStudent.setId(2);
        secondYearStudent.setEnrolmentDate(LocalDate.of(2017,9,1));

        StudentDAO dao = EasyMock.createMock(StudentDAO.class);
        EasyMock.expect(dao.getById(1)).andReturn(firstYearStudent);
        EasyMock.expect(dao.getById(2)).andReturn(secondYearStudent);
        EasyMock.replay(dao);

        StudentService service = new StudentService();
        service.setStudentDAO(dao);

        Assert.assertEquals(1,service.getNumberOfSemester(1));
        Assert.assertEquals(3,service.getNumberOfSemester(2));

        EasyMock.verify(dao);
    }
}
