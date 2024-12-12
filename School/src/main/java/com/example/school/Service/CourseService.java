package com.example.school.Service;

import com.example.school.ApiResponse.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }


    public void assignTeacherToCourse(Integer teacherId,Integer courseId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course =courseRepository.findCourseById(courseId);
        if(teacher==null||course==null){
            throw new ApiException("Teacher or course not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    public void updateCourse(Integer courseId,Course course){
        Course oldCourse = courseRepository.findCourseById(courseId);
        if(oldCourse==null){
            throw new ApiException("Course not found");
        }
        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);

    }


    public void deleteCourse(Integer id){
        Course course =courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }


    public String getTeacherNameByCourseId(Integer courseId){
        Course course =courseRepository.findCourseById(courseId);
        if(course==null){
            throw new ApiException("Course not found");
        }
        return course.getTeacher().getName();
    }

}
