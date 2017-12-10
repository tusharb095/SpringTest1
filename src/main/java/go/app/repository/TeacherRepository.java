package go.app.repository;

import go.app.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Modifying
    @Query( "DELETE FROM Teacher WHERE id = :id" )
    void deleteTeacherById(@Param("id") long id);

    @Modifying
    @Query( "DELETE FROM Teacher WHERE name = :name" )
    void deleteTeacherByName(@Param("name") String name);

    @Query( "SELECT t FROM Teacher t WHERE t.id = :id" )
    Teacher getTeacherById(@Param("id") Long id);

}
