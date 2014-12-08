package sealtyel.example.com.engineeringtoolbox;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import sealtyel.example.com.engineeringtoolbox.converter.Converter;
public class ConverterFragment extends Fragment {
    public ConverterFragment() {
        // Required empty public constructor
    }
    int posicion,posicionCat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rView=inflater.inflate(R.layout.fragment_converter, container, false);
        final Spinner categorias= (Spinner) rView.findViewById(R.id.spinner);
        final Spinner unidades=(Spinner)rView.findViewById(R.id.spinner2);
        final Button botonOk=(Button)rView.findViewById(R.id.button);
        final ListView lista= (ListView) rView.findViewById(R.id.listView);
        final EditText txt= (EditText) rView.findViewById(R.id.editText2);
        final Converter convertidor=new Converter();
        final ArrayList<String> conv=new ArrayList<String>();
        final ArrayAdapter<String> convAdp=new ArrayAdapter<String>(rView.getContext(),android.R.layout.simple_list_item_1,android.R.id.text1,conv);
        lista.setAdapter(convAdp);
        unidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                posicion =i;
                conv.clear();
                txt.setText("");
                convAdp.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        categorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adp = null;
                posicionCat=i;
                switch (i){
                    case 0:
                        adp = new ArrayAdapter<String>(rView.getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Temperatura));
                        break;
                    case 1:
                        adp = new ArrayAdapter<String>(rView.getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Longitud));
                        break;
                    case 2:
                        adp = new ArrayAdapter<String>(rView.getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Peso));
                        break;
                    case 3:
                        adp = new ArrayAdapter<String>(rView.getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Velocidad));
                        break;
                }
                unidades.setAdapter(adp);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        botonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.clearFocus();
                conv.clear();
                convAdp.notifyDataSetChanged();
                if(!txt.getText().toString().isEmpty()) {
                    double valor = Double.parseDouble(txt.getText().toString());
                    switch (posicionCat){
                        case 0:
                            switch (posicion) {
                                case 0:
                                    conv.add(String.format("%.2f",convertidor.CtF(valor))+" ºF");
                                    conv.add(String.format("%.2f",convertidor.CtK(valor))+" ºK");
                                    break;
                                case 1:
                                    conv.add(String.format("%.2f",convertidor.FtC(valor))+" ºC");
                                    conv.add(String.format("%.2f",convertidor.FtK(valor))+" ºK");
                                    break;
                                case 2:
                                    conv.add(String.format("%.2f",convertidor.KtC(valor))+" ºC");
                                    conv.add(String.format("%.2f",convertidor.KtF(valor))+" ºF");
                                    break;
                            }
                            break;
                        case 1:
                            switch (posicion){
                                case 0:
                                    conv.add(String.format("%.2f",convertidor.metroToMilimetro(valor))+" mm");
                                    conv.add(String.format("%.2f",convertidor.metroToPulgada(valor))+" in");
                                    conv.add(String.format("%.2f",convertidor.metroToPie(valor))+" ft");
                                    conv.add(String.format("%.2f",convertidor.metroToYarda(valor))+" yd");
                                    break;
                                case 1:
                                    conv.add(String.format("%.2f",convertidor.milimetroToMetro(valor))+" m");
                                    conv.add(String.format("%.2f",convertidor.milimetroToPulgada(valor))+" in");
                                    conv.add(String.format("%.2f",convertidor.milimetroToPie(valor))+" ft");
                                    conv.add(String.format("%.2f",convertidor.milimetroToYarda(valor))+" yd");
                                    break;
                                case 2:
                                    conv.add(String.format("%.2f",convertidor.pulgadaToMetro(valor))+" m");
                                    conv.add(String.format("%.2f",convertidor.pulgadaToMilimetro(valor))+" mm");
                                    conv.add(String.format("%.2f",convertidor.pulgadaToPie(valor))+" ft");
                                    conv.add(String.format("%.2f",convertidor.pulgadaToYarda(valor))+" yd");
                                    break;
                                case 3:
                                    conv.add(String.format("%.2f",convertidor.pieToMetro(valor))+" m");
                                    conv.add(String.format("%.2f",convertidor.pieToMilimetro(valor))+" mm");
                                    conv.add(String.format("%.2f",convertidor.pieToPulgada(valor))+" in");
                                    conv.add(String.format("%.2f",convertidor.pieToYarda(valor))+" yd");
                                    break;
                                case 4:
                                    conv.add(String.format("%.2f",convertidor.yardaToMetro(valor))+" m");
                                    conv.add(String.format("%.2f",convertidor.yardaToMilimetro(valor))+" mm");
                                    conv.add(String.format("%.2f",convertidor.yardaToPulgada(valor))+" in");
                                    conv.add(String.format("%.2f",convertidor.yardaToPie(valor))+" ft");
                                    break;
                            }
                            break;
                        case 2:
                            switch (posicion){
                                case 0:
                                    conv.add(String.format("%.2f",convertidor.kilogramoToGramo(valor))+" gr");
                                    conv.add(String.format("%.2f",convertidor.kilogramoToLibra(valor))+" lb");
                                    conv.add(String.format("%.2f",convertidor.kilogramoToOnza(valor))+" oz");
                                    break;
                                case 1:
                                    conv.add(String.format("%.2f",convertidor.gramoToKilogramo(valor))+" kg");
                                    conv.add(String.format("%.2f",convertidor.gramoToLibra(valor))+" lb");
                                    conv.add(String.format("%.2f",convertidor.gramoToOnza(valor))+" oz");
                                    break;
                                case 2:
                                    conv.add(String.format("%.2f",convertidor.libraToKilogramo(valor))+" kg");
                                    conv.add(String.format("%.2f",convertidor.libraToGramo(valor))+" gr");
                                    conv.add(String.format("%.2f",convertidor.libraToOnza(valor))+" oz");
                                    break;
                                case 3:
                                    conv.add(String.format("%.2f",convertidor.onzaToKilogramo(valor))+" kg");
                                    conv.add(String.format("%.2f",convertidor.onzaToGramo(valor))+" gr");
                                    conv.add(String.format("%.2f",convertidor.onzaToLibra(valor))+" lb");
                                    break;
                            }
                            break;
                        case 3:
                            switch (posicion)
                            {
                                case 0:
                                    conv.add(String.format("%.2f",convertidor.mpsToKms(valor))+" km/s");
                                    conv.add(String.format("%.2f",convertidor.mpsToKmh(valor))+" km/h");
                                    conv.add(String.format("%.2f",convertidor.mpsToMph(valor))+" mph");
                                    break;
                                case 1:
                                    conv.add(String.format("%.2f",convertidor.kmsToMps(valor))+" m/s");
                                    conv.add(String.format("%.2f",convertidor.kmsToKmh(valor))+" km/h");
                                    conv.add(String.format("%.2f",convertidor.kmsToMph(valor))+" mph");
                                    break;
                                case 2:
                                    conv.add(String.format("%.2f",convertidor.kmhToMps(valor))+" m/s");
                                    conv.add(String.format("%.2f",convertidor.kmhToKms(valor))+" km/s");
                                    conv.add(String.format("%.2f",convertidor.kmhToMph(valor))+" mph");
                                    break;
                                case 3:
                                    conv.add(String.format("%.2f",convertidor.mphToMps(valor))+" m/s");
                                    conv.add(String.format("%.2f",convertidor.mphToKms(valor))+" km/s");
                                    conv.add(String.format("%.2f",convertidor.mphToKmh(valor))+" km/h");
                                    break;
                            }
                            break;
                    }
                    convAdp.notifyDataSetChanged();
                }
                else
                    Toast.makeText(rView.getContext(),"El cuadro de texto esta vacio",Toast.LENGTH_SHORT).show();
            }
        });
        return rView;
    }
}
