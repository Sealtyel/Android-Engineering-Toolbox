package sealtyel.example.com.engineeringtoolbox;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import sealtyel.example.com.engineeringtoolbox.ExpandableListAdapter;
import sealtyel.example.com.engineeringtoolbox.R;

public class Formularios_Fragment extends Fragment {


    public Formularios_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.formularios_layout, container, false);
        Bundle bundle=this.getArguments();

        TextView texto= (TextView) rootView.findViewById(R.id.textViewFormularios);

        ImageView imgIcon = (ImageView) rootView.findViewById(R.id.imageViewFormularios);



        switch (bundle.getInt("parent")){
            case 0 :    switch (bundle.getInt("child")){
                            case 0 :    texto.setText("Derivadas");
                                        imgIcon.setImageResource(R.drawable.derivadas);
                                        break;
                            case 1 :    texto.setText("Integrales");
                                        imgIcon.setImageResource(R.drawable.integrales);
                                        break;
                        }
                        break;
            case 1 :    switch (bundle.getInt("child")){
                            case 0 :    texto.setText("Operaciones con matrices");
                                        imgIcon.setImageResource(R.drawable.matrices);
                                        break;
                        }
                        break;
        }


        return rootView;
    }
}
