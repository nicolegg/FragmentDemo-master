package pe.edu.upeu.fragment_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {
    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(idusu integer primary key , usuario text, contrasena text)");
        db.execSQL("insert into usuarios values(01,'nicole','123')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("create table usuarios(idusu integer primary key , usuario text, contrasena text)");
        db.execSQL("insert into usuarios values(01,'nicole','123')");
    }
}
