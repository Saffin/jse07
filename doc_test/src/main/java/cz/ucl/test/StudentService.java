package cz.ucl.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StudentService {

    private StudentDAO studentDAO;

    public int getNumberOfSemester(long studentId) {
        Student student = studentDAO.getById(studentId);

        LocalDate today = LocalDate.now();

        return (int) Math.ceil(ChronoUnit.MONTHS.between(student.getEnrolmentDate(), today) / 6.0) ;
    }


    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
