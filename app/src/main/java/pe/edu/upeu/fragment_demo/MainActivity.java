package pe.edu.upeu.fragment_demo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Fragment01 fragment01;
    private Button btn1, btn2, btn3;
    EditText usu,pass,idu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btnfragment1);
        btn2 = (Button) findViewById(R.id.btnfragment2);
        btn3 = (Button) findViewById(R.id.btnfragment3);
        usu= (EditText)findViewById(R.id.txtusuario);
        pass = (EditText) findViewById(R.id.txtpassword);
        idu = (EditText) findViewById(R.id.txtid);
        fragment01 = new Fragment01();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Fragment01()).disallowAddToBackStack().commit();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Fragment01()).disallowAddToBackStack().commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Fragment02()).disallowAddToBackStack().commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Fragment03()).disallowAddToBackStack().commit();
            }
        });

    }

    //INSERTAR
   public void insertar(View v){
        BDHelper admin = new BDHelper(this,"login",null,1);
       SQLiteDatabase db = admin.getWritableDatabase();
       String codigo = idu.getText().toString();
       String user = usu.getText().toString();
       String contra = pass.getText().toString();

       ContentValues values = new ContentValues();
       values.put("idusu",codigo);
       values.put("usuario",user);
       values.put("contrasena",contra);

       db.insert("usuarios",null,values);
       db.close();

       Intent ven = new Intent(this,LoginActivity.class);
       startActivity(ven);
   }

   public void  cancelar(View view){
        finish();
   }


}
