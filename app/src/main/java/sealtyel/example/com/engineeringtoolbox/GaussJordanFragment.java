package sealtyel.example.com.engineeringtoolbox;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sealtyel.example.com.engineeringtoolbox.GaussJordan.GaussJordan;

/**
 * Created by Kenia on 07/dic/2014.
 */
public class GaussJordanFragment extends Fragment
{
    public GaussJordanFragment(){}
    public double[][] matrix=new double[4][3];

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gauss, container, false);

        final EditText text00=(EditText) rootView.findViewById(R.id.editText00);
        final EditText text10=(EditText) rootView.findViewById(R.id.editText10);
        final EditText text20=(EditText) rootView.findViewById(R.id.editText20);
        final EditText text30=(EditText) rootView.findViewById(R.id.editText30);
        final EditText text01=(EditText) rootView.findViewById(R.id.editText01);
        final EditText text11=(EditText) rootView.findViewById(R.id.editText11);
        final EditText text21=(EditText) rootView.findViewById(R.id.editText21);
        final EditText text31=(EditText) rootView.findViewById(R.id.editText31);
        final EditText text02=(EditText) rootView.findViewById(R.id.editText02);
        final EditText text12=(EditText) rootView.findViewById(R.id.editText12);
        final EditText text22=(EditText) rootView.findViewById(R.id.editText22);
        final EditText text32=(EditText) rootView.findViewById(R.id.editText32);

        final TextView result=(TextView) rootView.findViewById(R.id.textMatrizA);





        Button boton= (Button) rootView.findViewById(R.id.buttonResolver);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                matrix[0][0]=Double.parseDouble(text00.getText().toString());
                matrix[1][0]=Double.parseDouble(text10.getText().toString());
                matrix[2][0]=Double.parseDouble(text20.getText().toString());
                matrix[3][0]=Double.parseDouble(text30.getText().toString());

                matrix[0][1]=Double.parseDouble(text01.getText().toString());
                matrix[1][1]=Double.parseDouble(text11.getText().toString());
                matrix[2][1]=Double.parseDouble(text21.getText().toString());
                matrix[3][1]=Double.parseDouble(text31.getText().toString());

                matrix[0][2]=Double.parseDouble(text02.getText().toString());
                matrix[1][2]=Double.parseDouble(text12.getText().toString());
                matrix[2][2]=Double.parseDouble(text22.getText().toString());
                matrix[3][2]=Double.parseDouble(text32.getText().toString());
                double[][] array1 = {
                        {matrix[0][0],matrix[1][0],matrix[2][0],matrix[3][0]},
                        {matrix[0][1],matrix[1][1],matrix[2][1],matrix[3][1]},
                        {matrix[0][2],matrix[1][2],matrix[2][2],matrix[3][2]}
                };
                GaussJordan ob=new GaussJordan(array1);
                ob.eliminate();
                result.setText(ob.toString());
            }


        });

        return rootView;
    }
}
