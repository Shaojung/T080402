package tw.com.pcschool.t080402;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 2016/8/4.
 */
public class StudentDAOImpl implements StudentDAO
{
    static ArrayList<Student> mylist;
    Context context;
    public StudentDAOImpl(Context context)
    {
        this.context = context;
        String fName = "student.json";
        File readFile = new File(context.getFilesDir() + File.separator + fName);
        char[] buffer = new char[1];
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        try {
            fr = new FileReader(readFile);
            while (fr.read(buffer)!= -1) {
                sb.append(new String(buffer));
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = sb.toString();
        if (data.length() == 0)
        {
            mylist = new ArrayList<>();
        }
        else
        {
            Gson gson = new Gson();
            mylist = gson.fromJson(data, new TypeToken<ArrayList<Student>>() {}.getType());
        }
    }

    @Override
    public void addStudent(Student s) {

    }

    @Override
    public void delStudent(Student s) {

    }

    @Override
    public void updateStudent(Student s) {

    }

    @Override
    public List getAllStudent() {
        return mylist;
    }
}
