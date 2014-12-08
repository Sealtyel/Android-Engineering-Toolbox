package sealtyel.example.com.engineeringtoolbox;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sorting_viewFragment extends Fragment {

    AnimationDrawable animacion;
    View rView;
    public Sorting_viewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rView=inflater.inflate(R.layout.fragment_sorting_view, container, false);
        Bundle bundle=this.getArguments();
        TextView nombre=(TextView)rView.findViewById(R.id.nombre);
        ImageView code=(ImageView)rView.findViewById(R.id.code);
        ImageView anim=(ImageView)rView.findViewById(R.id.anim);


        switch (bundle.getInt("algoritmo")){
            case 0:
                nombre.setText("Burbuja");
                code.setBackgroundResource(R.drawable.burbuja);
                anim.setBackgroundResource(R.drawable.burbuja_anim);
                animacion = (AnimationDrawable) anim.getBackground();
                animacion.start();
                break;
            case 1:
                nombre.setText("Insercion");
                code.setBackgroundResource(R.drawable.insercion);
                anim.setBackgroundResource(R.drawable.insercion_anim);
                animacion = (AnimationDrawable) anim.getBackground();
                animacion.start();
                break;
            case 2:
                nombre.setText("QuickSort");
                code.setBackgroundResource(R.drawable.quicksort);
                anim.setBackgroundResource(R.drawable.quick_anim);
                animacion = (AnimationDrawable) anim.getBackground();
                animacion.start();
                break;
        }
        return rView;

    }




}
