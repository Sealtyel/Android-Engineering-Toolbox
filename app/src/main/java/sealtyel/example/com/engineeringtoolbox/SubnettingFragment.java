package sealtyel.example.com.engineeringtoolbox;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.*;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SubnettingFragment extends Fragment {

    public SubnettingFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_subnetting, container, false);

        Button botonCalcular = (Button) rootView.findViewById(R.id.buttonCalcularRed);
        final EditText red = (EditText) rootView.findViewById(R.id.editTextRed);
        final EditText mascara = (EditText) rootView.findViewById(R.id.editTextMask);
        Button botonAgregar = (Button) rootView.findViewById(R.id.buttonAgregarRed);
        ListView listaRedes = (ListView) rootView.findViewById(R.id.listViewRedes);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast1 = android.widget.Toast.makeText(getActivity().getApplicationContext(),"Add",android.widget.Toast.LENGTH_SHORT);
                toast1.show();
            }


        });

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast1 = android.widget.Toast.makeText(getActivity().getApplicationContext(),"Calcular",android.widget.Toast.LENGTH_SHORT);
                toast1.show();
            }


        });

        red.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {

                    String myPattern = "()|((([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]).){3})([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
                    Pattern p = Pattern.compile(myPattern);
                    Matcher m = p.matcher(red.getText().toString());
                    if (!m.matches())
                        red.setError("Formato de ip incorrecto");

                }
            }
        });


        return rootView;
    }
}