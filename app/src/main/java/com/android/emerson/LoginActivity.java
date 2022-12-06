package com.android.emerson;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.android.emerson.util.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {


private AppCompatEditText et_usuario, et_clave;
private Button btnlogin, btnregistrarnuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btnlogearse);
        btnregistrarnuevo = findViewById(R.id.btnnuevacuenta);
        et_usuario = findViewById(R.id.etusuario);
        et_clave = findViewById(R.id.etclave);

        ConexionBD conexionBD = new ConexionBD();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Connection connection = conexionBD.conexionBD();

                try {

                    if(conexionBD!=null) {

                        Statement stm = connection.createStatement();
                        ResultSet rs = stm.executeQuery("select * from tbl_usuarios where usuario='"
                                + et_usuario.getText().toString() + "' and clave='" + et_clave.getText().toString() + "'");

                        if (rs.next()) {

                            Toast.makeText(LoginActivity.this, " Bienvenido: "+ " " + et_usuario.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, menu_opciones.class);
                            startActivity(i);
                            finish();

                        }else {

                            Toast.makeText(LoginActivity.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                        }

                    }

                }catch (Exception e) {

                    Log.e("ERROR", e.getMessage());

                }

            }
        });

        btnregistrarnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,Agregarusuario.class);
                startActivity(i);
            }
        });


    }





}
