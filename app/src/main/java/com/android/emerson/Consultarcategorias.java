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

public class Consultarcategorias extends AppCompatActivity {
    EditText nomconsultar;
    TextView idcategoria,categoria,descripcion;
    ImageButton buscar;

    ConexionBD conexionBD = new ConexionBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarcategorias);
        nomconsultar = (EditText) findViewById(R.id.txtconsultar);
        idcategoria = (TextView) findViewById(R.id.txtidcat);
        categoria = (TextView) findViewById(R.id.txtcat);
        descripcion=(TextView)findViewById(R.id.txtdes);
        buscar= findViewById(R.id.btnbuscar);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarcategoria();
            }
        });
    }


    public void consultarcategoria() {
        try {
            Statement stm = conexionBD.conexionBD().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tbl_categoria WHERE categoria ='" + nomconsultar.getText().toString() + "'");

            if (rs.next()) {

                idcategoria.setText("Id de la categoria: "+rs.getString(1));
                categoria.setText("Nombre de la categoria: "+rs.getString(2));
                descripcion.setText("Descripcion de la categoria: "+rs.getString(3));


            }else{
                Toast.makeText(getApplicationContext(),"La categoria no existe" ,Toast.LENGTH_SHORT).show();
            }
            nomconsultar.setText(" ");


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



}
