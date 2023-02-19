package es.studium.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre,dni;
    Button button;
    Switch guardar;
    String guardarSINO = "";
    public static final String MyPREFERENCES ="MyPrefs";
    public static final String Nombre ="Nombre";
    public static final String Dni ="Apellido";
    public static final String Switch ="SINO";

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Second_Activity.class);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String isSwitch = sharedPreferences.getString(Switch,"");
        if (isSwitch.equals("YES"))
        {
            startActivity(intent);
        }
        nombre = findViewById(R.id.nombre);
        dni = findViewById(R.id.dni);
        guardar = findViewById(R.id.switch1);
        button = findViewById(R.id.button);

        editor = sharedPreferences.edit();

        editor.putString(Nombre,"Manuel");
        editor.putString(Dni, "123456789A");
        editor.commit();

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String n = nombre.getText().toString();
                String d = dni.getText().toString();

                String isName = sharedPreferences.getString(Nombre,"");
                String isDNI = sharedPreferences.getString(Dni,"");
                if (n.equals(isName) && d.equals(isDNI) )
                {
                    if (guardar.isChecked())
                    {
                        guardarSINO = "SI";
                    }else
                    {
                        guardarSINO = "NO";
                    }

                    editor.putString(Switch,guardarSINO);
                    editor.commit();

                    System.out.println("Yes" + isSwitch);

                    startActivity(intent);

                }else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Has introducido mal el Nombre o el DNI";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                   // System.out.println("Nombre: " + isName + "Nom " + n);
                   // System.out.println("DNI: " + isDNI);
                   // System.out.println(isSwitch);

                }
            }
        });

    }
}