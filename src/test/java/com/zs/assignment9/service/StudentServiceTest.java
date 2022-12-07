package com.zs.assignment9.service;

import com.zs.assignment9.dao.StudentDao;
import com.zs.assignment9.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDao studentDaoMock;
    @InjectMocks
    private StudentService studentService;

    @Test
    void createStudent() {
        Student expectedStudent = new Student(0,"random","name");
        try {
            Mockito.when(studentDaoMock.addStudent(Mockito.any(Student.class))).thenReturn(expectedStudent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Student actualStudent = studentService.createStudent("random","name");
        assertEquals(expectedStudent.toString(),actualStudent.toString());
    }

    @Test
    void getStudent() {
        Student expectedStudent= new Student(1,"random","name");
        try {
            Mockito.when(studentDaoMock.getStudent(Mockito.anyInt())).thenReturn(expectedStudent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Student actualStudent= studentService.getStudent(1);
        assertEquals(expectedStudent,actualStudent);
    }
}