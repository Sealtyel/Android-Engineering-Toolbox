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


public class ListRedesAdapter extends ArrayAdapter<ElementoRed> {
    
	
	
	 public ListRedesAdapter(Context context, ArrayList<ElementoRed> items) {
        super(context, 0, items);
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        
        final ElementoRed item = getItem(position);

        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_redes, parent, false);
        }
        
        final EditText host= (EditText) convertView.findViewById(R.id.editTextNoHost);
        final TextView titulo = (TextView) convertView.findViewById(R.id.textViewTituloRed);
        final TextView texto = (TextView) convertView.findViewById(R.id.textViewNoHost);
       
        titulo.setText(item.getTitulo());
        final int nohost= item.getHost();

        if(nohost!=-1)
            host.setText(item.getHost());
        
        texto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                	item.setHost(Integer.parseInt(texto.getText().toString()));
                    Log.d(null, "focus "+texto.getText().toString());
                }
            }
        });

        texto.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                item.setHost(Integer.parseInt(texto.getText().toString()));
                Log.d(null, "after "+texto.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                item.setHost(Integer.parseInt(texto.getText().toString()));
                Log.d(null, "before "+texto.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                item.setHost(Integer.parseInt(texto.getText().toString()));
                Log.d(null, "on "+texto.getText().toString());



            }

        });

        
        return convertView;
    }
     
 }