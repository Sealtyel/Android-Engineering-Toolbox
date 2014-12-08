package sealtyel.example.com.engineeringtoolbox.subnetting;

import java.util.ArrayList;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import sealtyel.example.com.engineeringtoolbox.R;
import sealtyel.example.com.engineeringtoolbox.subnetting.ElementoRed;


public class ListRedesAdapter extends ArrayAdapter<ElementoRed>
{

	
	 public ListRedesAdapter(Context context, ArrayList<ElementoRed> items) {
        super(context, 0, items);
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        
        final ElementoRed item = getItem(position);

        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_redes, parent, false);
        }
        
        final EditText host = (EditText) convertView.findViewById(R.id.editTextNoHost);
        final TextView titulo = (TextView) convertView.findViewById(R.id.textViewTituloRed);
        final TextView texto = (TextView) convertView.findViewById(R.id.textViewNoHost);
       
        titulo.setText(item.getTitulo());
        if(item.getHost()!=-1)
            host.setText(""+item.getHost());

        host.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (host.getText().length() != 0)
                        item.setHost(Integer.parseInt(host.getText().toString()));
                    else {
                        item.setHost(-1);
                        host.setText("");
                    }
                    Log.d(null, "on " + host.getText().toString());
                }

            }

        });

        
        return convertView;
    }
     
 }