package com.android.emerson;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.emerson.util.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consultarmarca extends AppCompatActivity {

    EditText nomconsultar;
    TextView idmarca,marca;
    ImageButton buscar;

    ConexionBD conexionBD = new ConexionBD();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarmarca);

        nomconsultar = (EditText) findViewById(R.id.txtconsultar);
        idmarca = (TextView) findViewById(R.id.txtidmarca);
        marca = (TextView) findViewById(R.id.txtmarca);
        buscar= findViewById(R.id.btnbuscar);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarmarca();
            }
        });
    }


    public void consultarmarca() {
        try {
            Statement stm = conexionBD.conexionBD().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tbl_marca WHERE marca ='" + nomconsultar.getText().toString() + "'");

            if (rs.next()) {

                idmarca.setText("Id de la Marca registrada: "+rs.getString(1));
                marca.setText("Nombre de la Marca registrada: "+rs.getString(2));


            }else{
                Toast.makeText(getApplicationContext(),"LA MARCA NO EXISTE" ,Toast.LENGTH_SHORT).show();
            }
            nomconsultar.setText(" ");


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}

