package com.example.school.Controller;

import com.example.school.ApiResponse.ApiResponse;
import com.example.school.Model.Course;
import com.example.school.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/assign/{teacherId}/{courseId}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacherId ,@PathVariable Integer courseId){
        courseService.assignTeacherToCourse(teacherId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher assign to course"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }

    @GetMapping("/getTeacherNameByCourseId/{courseId}")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer courseId){

        return ResponseEntity.status(200).body(new ApiResponse("Teacher name of the course: "+courseService.getTeacherNameByCourseId(courseId)));
    }

}
