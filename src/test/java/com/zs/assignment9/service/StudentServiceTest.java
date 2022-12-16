package com.zs.assignment9.service;

import com.zs.assignment9.dao.StudentDao;
import com.zs.assignment9.exception.InvalidNameExcetion;
import com.zs.assignment9.exception.StudentNotFoundException;
import com.zs.assignment9.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDao studentDaoMock;
    @InjectMocks
    private StudentService studentService;

    @Test
    void createStudent() throws SQLException, InvalidNameExcetion {

        Student expectedStudent = new Student("random","name");
        Mockito.when(studentDaoMock.addStudent(Mockito.any(Student.class))).thenReturn(expectedStudent);
        assertEquals(expectedStudent,studentService.createStudent("random","name"));
    }

    @Test
    void createNullStudent() {

        assertThrows(InvalidNameExcetion.class, () -> studentService.createStudent(null,"q"));
    }

    @Test
    void getStudent() throws SQLException, StudentNotFoundException {

        Student expectedStudent= new Student("random","name");
        expectedStudent.setId(1);
        try {
            Mockito.when(studentDaoMock.getStudent(1)).thenReturn(expectedStudent);
        } catch (SQLException | StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
        Student actualStudent= studentService.getStudent(1);
        assertEquals(expectedStudent,actualStudent);
    }

    @Test
    void getNonExistingStudent() throws SQLException, StudentNotFoundException {

        Mockito.when(studentDaoMock.getStudent(1)).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class,() -> studentService.getStudent(1));
    }

}