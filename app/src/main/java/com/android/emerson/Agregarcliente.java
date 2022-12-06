package com.android.emerson;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.emerson.util.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Agregarcliente extends AppCompatActivity {
    EditText dni,nombre,telefono,sexo,fechanac,direccion;
    Spinner s;
    Button guardar;

    ConexionBD conexionBD = new ConexionBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarcliente);

        dni = (EditText) findViewById(R.id.txtdni);
        nombre = (EditText) findViewById(R.id.txtcliente);
        telefono = (EditText) findViewById(R.id.txttelefono);
       // sexo = (EditText) findViewById(R.id.txtsexo);
        fechanac = (EditText) findViewById(R.id.txtfecnaci);
        direccion = (EditText) findViewById(R.id.txtdireccion);
        guardar = (Button) findViewById(R.id.btnagregarcliente);
        s=(Spinner) findViewById(R.id.spsexo) ;

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar_cliente();
            }
        });
    }



    public void guardar_cliente(){
        try{
            PreparedStatement stm= conexionBD.conexionBD().prepareStatement( "INSERT INTO tbl_cliente Values(?,?,?,?,?,?)");
            stm.setString(1,dni.getText().toString());
            stm.setString(2,nombre.getText().toString());
            stm.setString(3,telefono.getText().toString());
             // stm.setString(4,sexo.getText().toString());
            stm.setString(4,s.getSelectedItem().toString());
            stm.setString(5,fechanac.getText().toString());
            stm.setString(6,direccion.getText().toString());
            stm.executeUpdate();
            Toast.makeText(getApplicationContext(), " Cliente registrado exitosamente",Toast.LENGTH_SHORT).show();

            dni.setText("");
            nombre.setText("");
            telefono.setText("");
            fechanac.setText("");
            direccion.setText("");
        }

        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    }



