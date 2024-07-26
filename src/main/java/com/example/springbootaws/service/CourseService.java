package com.example.springbootaws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootaws.dto.Course;

@Service
public class CourseService {
    List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Optional<Course> getCourseById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst();
    }

    public Boolean updateCourse(int id, Course course) {
        return getCourseById(id).map(existingCourse -> {
                courses.remove(existingCourse);
                courses.add(course);
                return true;
            }).orElse(false);
    }

    public Boolean deleteCourse(int id) {
        return getCourseById(id).map(existingCourse -> {
                courses.remove(existingCourse);
                return true;
            }).orElse(false);
    }
}
