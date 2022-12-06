package com.android.emerson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.emerson.util.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Agregarusuario extends AppCompatActivity {

    private EditText etemail, etpassword, etdni, etnombre, ettelefono, etfechanacimiento,etdireccion;
    private Spinner sp_sexousuario;
    private Button btn_guardar;

    ConexionBD conexionBD = new ConexionBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarusuario);


        etemail = findViewById(R.id.etemailusuario);
        etpassword = findViewById(R.id.etpasswordusuario);
        etdni = findViewById(R.id.etdniusuario);
        etnombre = findViewById(R.id.etdniusuario);
        ettelefono = findViewById(R.id.ettelefonousuario);
        etfechanacimiento = findViewById(R.id.etfechanacimientousuario);
        etdireccion = findViewById(R.id.etdireccionusuario);

        btn_guardar = findViewById(R.id.btnagregarusuario);

        sp_sexousuario = findViewById(R.id.spsexousuario);


   btn_guardar.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           guardar_usuario();
       }
   });

    }



    public void guardar_usuario(){
        try{
            PreparedStatement stm= conexionBD.conexionBD().prepareStatement( "INSERT INTO tbl_usuarios Values(?,?,?,?,?,?,?,?)");
            stm.setString(1,etemail.getText().toString());
            stm.setString(2,etpassword.getText().toString());
            stm.setString(3,etdni.getText().toString());
            stm.setString(4,etnombre.getText().toString());
            stm.setString(5,ettelefono.getText().toString());
            // stm.setString(4,sexo.getText().toString());
            stm.setString(6,sp_sexousuario.getSelectedItem().toString());
            stm.setString(7,etfechanacimiento.getText().toString());
            stm.setString(8,etdireccion.getText().toString());
            stm.executeUpdate();
            Toast.makeText(getApplicationContext(), " Usuario registrado exitosamente...",Toast.LENGTH_SHORT).show();

            new Handler(Looper.getMainLooper()).postDelayed(()->{
                Intent i = new Intent(Agregarusuario.this,LoginActivity.class);
                startActivity(i);
                finish();
            },2500);

            etemail.setText("");
            etpassword.setText("");
            etdni.setText("");
            etnombre.setText("");
            ettelefono.setText("");
            etfechanacimiento.setText("");
            etdireccion.setText("");


        }

        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }










}