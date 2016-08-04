package tw.com.pcschool.t080402;

import java.util.List;

/**
 * Created by Student on 2016/8/4.
 */
public interface StudentDAO {
    public void addStudent(Student s);
    public void delStudent(Student s);
    public void updateStudent(Student s);
    public List getAllStudent();
}
