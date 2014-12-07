package sealtyel.example.com.engineeringtoolbox.subnetting;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import sealtyel.example.com.engineeringtoolbox.R;

/**
 * Created by mayra.
 */
public class ListRedesResultadosAdapter extends ArrayAdapter<ElementoRedResultados> {



    public ListRedesResultadosAdapter(Context context, ArrayList<ElementoRedResultados> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ElementoRedResultados item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_display_redes, parent, false);
        }

        final TextView titulo = (TextView) convertView.findViewById(R.id.textViewTituloRed);
        final TextView red = (TextView) convertView.findViewById(R.id.redResult);
        final TextView longitud = (TextView) convertView.findViewById(R.id.longitudResult);
        final TextView hostMinimo = (TextView) convertView.findViewById(R.id.hostMinimoResult);
        final TextView hostMaximo = (TextView) convertView.findViewById(R.id.hostMaximoResult);
        final TextView subred = (TextView) convertView.findViewById(R.id.mascaraResult);

        titulo.setText(item.getTitulo());
        red.setText(item.getRed());
        longitud.setText(item.getLongitud());
        hostMinimo.setText(item.getHostMinimo());
        hostMaximo.setText(item.getHostMaximo());
        subred.setText(item.getSubmascara());



        return convertView;
    }

}