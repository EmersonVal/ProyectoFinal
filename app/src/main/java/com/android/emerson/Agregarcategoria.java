package com.android.emerson;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.emerson.util.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Agregarcategoria extends AppCompatActivity {
    EditText categoria,desc;
    Button guardar;

    ConexionBD conexionBD = new ConexionBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarcategoria);
        categoria = (EditText) findViewById(R.id.txtcategoria);
        desc = (EditText) findViewById(R.id.txtdescripcion);
        guardar = (Button) findViewById(R.id.btnagregarcategoria);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grabarcategoria();
            }
        });
    }


    public  void grabarcategoria(){
        try {

            PreparedStatement stm= conexionBD.conexionBD().prepareStatement( "INSERT INTO tbl_categoria Values(?,?)");
            stm.setString(1,categoria.getText().toString().toUpperCase());
            stm.setString(2,desc.getText().toString().toUpperCase());
            stm.executeUpdate();
            Toast.makeText(getApplicationContext(), " Categoria registrada exitosamente",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        categoria.setText(" ");
        desc.setText(" ");

    }
}
