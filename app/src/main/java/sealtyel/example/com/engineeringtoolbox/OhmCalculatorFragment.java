package sealtyel.example.com.engineeringtoolbox;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import sealtyel.example.com.engineeringtoolbox.ohmCalculator.Circuit;
public class OhmCalculatorFragment extends Fragment
{
    public OhmCalculatorFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View rootView=inflater.inflate(R.layout.fragment_ohm_calculator, container, false);
        // Inflate the layout for this fragment
        final Button buttonCalculate = (Button) rootView.findViewById(R.id.buttonCalcularCircuito);
        final EditText textResistance=(EditText) rootView.findViewById(R.id.editTextResistencia);
        final EditText textVoltage=(EditText) rootView.findViewById(R.id.editTextVoltaje);
        final EditText textCurrent=(EditText) rootView.findViewById(R.id.editTextCorriente);
        final TextView textPower=(TextView) rootView.findViewById(R.id.textViewEnergia);
        final Toast toast1 = android.widget.Toast.makeText(getActivity().getApplicationContext(),"Calcular",android.widget.Toast.LENGTH_SHORT);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                double resistencia=0.0;
                double voltaje=0.0;
                double corriente=0.0;
                Circuit c=new Circuit();

                if(!textResistance.getText().toString().isEmpty())
                {
                    resistencia=Double.parseDouble(textResistance.getText().toString());
                    c.setResistance(resistencia);
                }
                if(!textVoltage.getText().toString().isEmpty())
                {
                    voltaje=Double.parseDouble(textVoltage.getText().toString());
                    c.setVoltage(voltaje);
                }
                if(!textCurrent.getText().toString().isEmpty())
                {
                    corriente=Double.parseDouble(textCurrent.getText().toString());
                    c.setCurrent(corriente);
                }




                if (textResistance.getText().toString().isEmpty())
                {
                    toast1.setText("Resistencia=0");
                    textResistance.setText(String.format("%.2f",c.getResistance(corriente,voltaje))+"");
                }
                else
                {
                    if(textVoltage.getText().toString().isEmpty())
                    {
                        toast1.setText("Voltaje=0");
                        textVoltage.setText(String.format("%.2f",c.getVoltage(resistencia,corriente))+"");
                    }
                    else//corriente==0
                    {
                        if (textCurrent.getText().toString().isEmpty())
                        {
                            toast1.setText("Corriente=0");
                            textCurrent.setText(String.format("%.2f",c.getCurrent(voltaje,resistencia))+"");
                        }

                    }
                }

                textPower.setText(String.format("%.2f",c.getCurrent()*c.getVoltage())+"");







                toast1.show();
            }
        });



        return rootView;

    }





}
