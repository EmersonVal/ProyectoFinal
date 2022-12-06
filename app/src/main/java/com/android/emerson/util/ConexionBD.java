package com.android.emerson.util;

import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    //esta clase la averigue : emerson.com.pe
    //esta clase funciona para realizar la conexion local con mi servidor SQL server

    public Connection conexionBD() {
        Connection cnn = null;

        try {
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.9;" +
                    "databaseName=bd_proyectofinal;user=sa;password=Fortnite.123;");

        } catch (Exception e) {
        }

        return cnn;
    }


}
