package com.android.emerson;

import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consultarproductos extends AppCompatActivity {
    EditText nomconsultar;
    EditText nom, precio, stock, marca, categoria;
    ImageButton buscar, btnactualizar, btneliminar;

    ConexionBD conexionBD = new ConexionBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarproductos);


        nomconsultar = (EditText) findViewById(R.id.txtconsultar);
        nom = findViewById(R.id.txtnombre);
        precio = findViewById(R.id.txtprecio);
        stock = findViewById(R.id.txtstock);
        marca = findViewById(R.id.txtmarca);
        categoria = findViewById(R.id.txtcategoria);
        buscar = findViewById(R.id.btnbuscar);
        btnactualizar = findViewById(R.id.btnactualizar);
        btneliminar = findViewById(R.id.btneliminar);

        btnactualizar.setVisibility(View.INVISIBLE);
        btneliminar.setVisibility(View.INVISIBLE);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarproducto();
            }
        });


        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar();
            }
        });

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });

    }


    public void consultarproducto() {
        try {
            Statement stm = conexionBD.conexionBD().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  tbl_producto WHERE nombre_producto ='" + nomconsultar.getText().toString() + "'");

            if (rs.next()) {

                btnactualizar.setVisibility(View.VISIBLE);
                btneliminar.setVisibility(View.VISIBLE);

                nom.setText(rs.getString(1));
                precio.setText(rs.getString(3));
                stock.setText(rs.getString(4));
                marca.setText(rs.getString(5));
                categoria.setText(rs.getString(6));

                Toast.makeText(this, "Registro Encontrado, Ya puede Modificar y/o Eliminar si así lo necesite", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "EL PRODUCTO NO EXISTE", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void actualizar() {


        Connection connection = conexionBD.conexionBD();

        try {

            if (connection != null) {

                PreparedStatement stm = connection.prepareStatement("UPDATE tbl_producto set nombre_producto = '" + nom.getText().toString() +
                        "',precio_unitario='" + precio.getText().toString() +
                        "',stock_producto='" + stock.getText().toString() +
                        "',marca_producto='" + marca.getText().toString() +
                        "',categoria_producto='" + categoria.getText().toString() +
                        "' WHERE nombre_producto = '" + nomconsultar.getText().toString() + "'");
                stm.executeUpdate();

                Toast.makeText(Consultarproductos.this, "Registro modificado correcto", Toast.LENGTH_SHORT).show();


            }


        } catch (Exception e) {
            Log.e("Error", e.getMessage());

        }


    }

    public void eliminar() {


        Connection connection = conexionBD.conexionBD();

        try {

            if (connection != null) {

                PreparedStatement stm = connection.prepareStatement("DELETE FROM tbl_producto WHERE nombre_producto = '" + nomconsultar.getText().toString() + "'");
                stm.executeUpdate();

                Toast.makeText(Consultarproductos.this, "Registro Eliminado correctamente", Toast.LENGTH_SHORT).show();

            }

            nomconsultar.setText("");
            nom.setText("");
            precio.setText("");
            stock.setText("");
            marca.setText("");
            categoria.setText("");


        } catch (Exception e) {
            Log.e("Error", e.getMessage());

        }


    }

}


