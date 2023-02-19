package es.studium.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second_Activity extends AppCompatActivity {

    Button button2;

    public static final String MyPREFERENCES ="MyPrefs";
    public static final String Switch ="SINO";

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                editor = sharedPreferences.edit();

                editor.putString(Switch,"NO");
                editor.commit();

                Intent intent2 = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent2);

            }
        });
    }
}