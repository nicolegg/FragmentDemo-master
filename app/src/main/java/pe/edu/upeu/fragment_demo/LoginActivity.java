package pe.edu.upeu.fragment_demo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    EditText usu,pass;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usu = (EditText) findViewById(R.id.txtuser);
        pass = (EditText) findViewById(R.id.txtpass);
    }

    public void ingresar (View v){
        BDHelper admin = new BDHelper(this,"login",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario = usu.getText().toString();
        String contrasena = pass.getText().toString();
        fila = db.rawQuery("select usuario, contrasena from usuarios where usuario ='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String contra =fila.getString(1);
            if(usuario.equals(usua)&&contrasena.equals(contra)){
                Intent ven = new Intent(this,MainActivity.class);
                startActivity(ven);
                usu.setText("");
                pass.setText("");
            }
            else
                Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_LONG).show();
        }
    }

}
