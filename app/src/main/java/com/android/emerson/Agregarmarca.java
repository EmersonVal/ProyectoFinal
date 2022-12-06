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

public class Agregarmarca extends AppCompatActivity {
    EditText marca;
    Button guardarmarca;

    ConexionBD conexionBD = new ConexionBD();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarmarca);

        marca=(EditText)findViewById(R.id.txtmarca);
        guardarmarca=(Button)findViewById(R.id.btnagregarmarca);

        guardarmarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar_marca();
            }
        });

    }


    public  void guardar_marca(){
        try{
            PreparedStatement stm= conexionBD.conexionBD().prepareStatement( "INSERT INTO tbl_marca Values(?)");
            stm.setString(1,marca.getText().toString());
            stm.executeUpdate();
            Toast.makeText(getApplicationContext(), " Marca registrada exitosamente",Toast.LENGTH_SHORT).show();
            marca.setText("");
        }
        catch (Exception e){

        }
    }
}