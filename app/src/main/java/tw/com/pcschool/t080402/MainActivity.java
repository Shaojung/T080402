package tw.com.pcschool.t080402;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File f = getCacheDir();
        Log.d("FILE", f.toString());
        String fName = "mydata.txt";
        FileOutputStream fOut = null;
        try {

            fOut = openFileOutput(fName, MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write("She sell sea shells on the sea shore .");
            osw.close();


            File readFile = new File(getFilesDir() + File.separator + fName);
            char[] buffer = new char[1];
            FileReader fr = null;
            StringBuilder sb = new StringBuilder();

            fr = new FileReader(readFile);
            while (fr.read(buffer)!= -1) {
                sb.append(new String(buffer));
            }
            fr.close();
            Log.d("FILE", sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StudentDAO dao = new StudentDAOImpl();
        dao.addStudent(new Student("John", "123", "123123"));

    }

    public void click1(View v)
    {

        JSONArray array = new JSONArray();
        JSONObject obj;
        try {
            obj = new JSONObject();
            obj.put("name", "John");
            obj.put("addr", "Taipei");
            obj.put("tel", "123456");
            array.put(obj);
            obj = new JSONObject();
            obj.put("name", "Mary");
            obj.put("addr", "Tainan");
            obj.put("tel", "654321");
            array.put(obj);

            Log.d("JSON", array.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void click2(View v)
    {

        ArrayList<Student> mylist = new ArrayList();

        Student s1 = new Student("John", "aaa", "123");
        Student s2 = new Student("Bob", "bbb", "222");

        mylist.add(s1);
        mylist.add(s2);

        Gson gson = new Gson();

        String str = gson.toJson(mylist, new TypeToken<ArrayList<Student>>() {}.getType());
        Log.d("JSON", str);
    }
}
