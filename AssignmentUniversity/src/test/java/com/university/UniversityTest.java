package com.university;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityTest {

    private static UniversityService service;
    private static InstructorDAO instructorDAO;
    private static CourseDAO courseDAO;
    private static EnrollmentDAO enrollmentDAO;

    @BeforeAll
    static void setup() {

        instructorDAO = new InstructorDAO();
        courseDAO = new CourseDAO();
        enrollmentDAO = new EnrollmentDAO();

        service = new UniversityService(
                instructorDAO,
                courseDAO,
                enrollmentDAO);
    }
    @Test
    @Order(1)
    void oneToOneMappingTest() {

        Instructor instructor = new Instructor();
        instructor.setId(1);
        instructor.setName("Dr Rao");
        instructor.setDepartment("CSE");

        InstructorProfile profile = new InstructorProfile();
        profile.setId(101);
        profile.setOfficeRoom("A-302");
        profile.setPhone("9999999999");

        service.createInstructorWithProfile(instructor, profile);

        Instructor fetched =
                instructorDAO.findInstructorWithCourses(1);

        assertNotNull(fetched);
        assertNotNull(fetched.getProfile());
    }

    @Test
    @Order(2)
    void oneToManyMappingTest() {

        Course c1 = new Course();
        c1.setId(201);
        c1.setTitle("Data Structures");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setId(202);
        c2.setTitle("Operating Systems");
        c2.setCredits(3);

        List<Course> courses = Arrays.asList(c1, c2);

        service.addCoursesToInstructor(1, courses);

        Instructor fetched =
                service.fetchInstructorWithCourses(1);

        assertNotNull(fetched.getCourses());
        assertEquals(2, fetched.getCourses().size());
    }

    @Test
    @Order(3)
    void manyToOneMappingTest() {

        Enrollment enrollment = new Enrollment();
        enrollment.setId(301);
        enrollment.setSemester("Fall 2025");
        enrollment.setGrade("B");

        service.addEnrollmentToCourse(enrollment, 201);

        List<Enrollment> enrollments =
                enrollmentDAO.findByCourse(201);

        assertFalse(enrollments.isEmpty());
        assertEquals(201,
                enrollments.get(0).getCourse().getId());
    }

    @Test
    @Order(4)
    void daoUpdateTest() {

        service.updateEnrollmentGrade(301, "A");

        List<Enrollment> enrollments =
                enrollmentDAO.findByCourse(201);

        assertEquals("A",
                enrollments.get(0).getGrade());
    }

    @Test
    @Order(5)
    void daoDeleteTest() {

        service.deleteInstructorAndDependencies(1);

        Instructor deleted =
                instructorDAO.findInstructorWithCourses(1);

        assertNull(deleted);
    }
    @Test
    @Order(6)
    void fullServiceIntegrationTest() {

        Instructor instructor = new Instructor();
        instructor.setId(2);
        instructor.setName("Dr Mehta");
        instructor.setDepartment("IT");

        InstructorProfile profile = new InstructorProfile();
        profile.setId(102);
        profile.setOfficeRoom("B-101");
        profile.setPhone("8888888888");

        service.createInstructorWithProfile(instructor, profile);

        Course course = new Course();
        course.setId(203);
        course.setTitle("DBMS");
        course.setCredits(4);

        service.addCoursesToInstructor(2, Arrays.asList(course));

        Enrollment enrollment = new Enrollment();
        enrollment.setId(302);
        enrollment.setSemester("Spring 2026");
        enrollment.setGrade("B");

        service.addEnrollmentToCourse(enrollment, 203);

        service.updateEnrollmentGrade(302, "A");

        Instructor fetched =
                service.fetchInstructorWithCourses(2);

        assertNotNull(fetched);
        assertEquals(1, fetched.getCourses().size());
    }
}

