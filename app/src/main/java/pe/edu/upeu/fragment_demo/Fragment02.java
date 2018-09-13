package pe.edu.upeu.fragment_demo;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment02 extends Fragment {

MainActivity m = new MainActivity();
    public Fragment02() {
        // Required empty public constructor

    }
    View vista;
Button  cancelar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista =inflater.inflate(R.layout.fragment_fragment02, container, false);
        cancelar = (Button) vista.findViewById(R.id.btncancelar);

        return vista;


    }
    public void  registrar(View v){
      m.insertar(v);
    }

    public void  salir(View v){
        m.cancelar(v);
    }

}
