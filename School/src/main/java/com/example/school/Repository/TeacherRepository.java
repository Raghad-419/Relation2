package com.example.school.Repository;

import com.example.school.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);

    @Query("select t from Teacher t where t.id=?1")
    Teacher getTeacherById(Integer id);
}
