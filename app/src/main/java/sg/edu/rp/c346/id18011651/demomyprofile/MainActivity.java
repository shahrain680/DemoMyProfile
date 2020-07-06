package sg.edu.rp.c346.id18011651.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);
        rgGender=findViewById(R.id.radioGroupGender);
        btnSave=findViewById(R.id.saveBtn);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor prefEdit =prefs.edit();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = etName.getText().toString();
                float gpa= Float.parseFloat(etGPA.getText().toString());
                Integer id=rgGender.getCheckedRadioButtonId();
                prefEdit.putString("name", strName);
                prefEdit.putFloat("gpa",gpa);
                prefEdit.putInt("gender",id);
                prefEdit.commit();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name= prefs.getString("name","");
        etName.setText(name);
        Float gpa=prefs.getFloat("gpa", 0);
        etGPA.setText(gpa.toString());
        Integer gender = prefs.getInt("gender",0);
        rgGender.check(gender);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

    }
}
