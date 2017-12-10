package go.app.controller;

import go.app.model.Address;
import go.app.model.Student;
import go.app.model.Teacher;
import go.app.repository.StudentRepository;
import go.app.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;

@Transactional
@RestController("/")
public class HelloController {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public HelloController(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("test")
    public String test(){
        return "testing !!!";
    }

    @RequestMapping("add")
    public String add(){

        Student student = new Student();
        Address address = new Address();
        address.setCity("Pune");

        student.setName("AAA");
        student.setAddress(address);

        Student studentAdded = studentRepository.save(student);
        System.out.println("student = " + student);
        System.out.println("student added = " + studentAdded);
        return "added = " + student;
    }

    @RequestMapping("delete/{studentId}")
    public String delete(@PathVariable Long studentId){

        Teacher teacher = new Teacher();
        teacher.setName("teacher1");
        teacher.setSal(123);
        teacherRepository.save(teacher);
        studentRepository.delete(studentId);

        return "added = "+ teacher + " deleted = " + studentId;
    }

    @RequestMapping("addTeacher/{teacherName}")
    public String addTeacher(@PathVariable("teacherName") String teacherName){
        Teacher teacher = new Teacher();
        teacher.setName(teacherName);
        teacher.setSal(123);
        teacherRepository.save(teacher);
        return "added teacher = " + teacher;
    }

    @RequestMapping("deleteTeacherById/{teacherId}")
    public String deleteTeacher(@PathVariable(name = "teacherId") Long teacherId){
        teacherRepository.deleteTeacherById(teacherId);
        return "Teacher deleted = " + teacherId;
    }

    @RequestMapping("deleteTeacherByName/{teacherName}")
    public String deleteTeacherByName(@PathVariable(name = "teacherName") String teacherName){
        teacherRepository.deleteTeacherByName(teacherName);
        return "deleted = " + teacherName;
    }

    @RequestMapping("getTeacherById/{teacherId}")
    public Teacher getTeacherById(@PathVariable Long teacherId){
        return teacherRepository.getTeacherById(teacherId);
    }
}
