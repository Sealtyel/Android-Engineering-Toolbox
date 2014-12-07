package sealtyel.example.com.engineeringtoolbox;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class MathFFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public MathFFragment(){

    }


    /*
    \\
\frac{dc}{dx}=0\\
\\
\frac{dx}{dx}=1\\
\\
\frac{d}{dx}(u+v-w)=\frac{du}{dx}+\frac{dv}{dx}-\frac{dw}{dx}\\
\\
\frac{d}{dx}(cv)=c\frac{dv}{dx}
\\
\frac{d}{dx}(uv)=u\frac{dv}{dx}+v\frac{du}{dx}
\\
\frac{d}{dx}(v^{n})=nv^{n-1}\frac{dv}{dx}
\\
\frac{d}{dx}(x^{n})=nx^{n-1}
\\
\frac{d}{dx}(\frac{u}{v})=\frac{v\frac{du}{dx}-u\frac{dv}{dx}}{v^{2}}
\\
\frac{d}{dx}(\frac{u}{c})=\frac{\frac{du}{dx}}{c}
\\
\frac{d}{dx}(ln v)=\frac{\frac{dv}{dx}}{v}=\frac{1}{v}\frac{dv}{dx}
\\
\frac{d}{dx}(log v)=\frac{Log e}{v}\frac{dv}{dx}
\\
\frac{d}{dx}(a^{v})=a^{v}Ln a\frac{dv}{dx}
\\
\frac{d}{dx}(e^{v})=e^{v}\frac{dv}{dx}
\\
\frac{d}{dx}(u^{v})=vu^{v-1}\frac{du}{dx}+ Ln u^{v}\frac{dv}{dx}
\\
\frac{d}{dx}(sen v)=cos v\frac{dv}{dx}
\\
\frac{d}{dx}(cos v)=-sen v\frac{dv}{dx}
\\
\frac{d}{dx}(tan v)=sec v^{2}\frac{dv}{dx}
\\
\frac{d}{dx}(cotg v)=-csc v^{2}\frac{dv}{dx}
    */


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_math_f, container, false);
        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.expandableListViewMenu);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(rootView.getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView arg0,
                                        View arg1, int arg2, int arg3, long arg4) {
                // TODO Auto-generated method stub
                Log.d("ListMathFFragment", "parent " + arg2 + " child "+ arg3);
                Bundle bundle=new Bundle();
                bundle.putInt("parent",arg2);
                bundle.putInt("child",arg3);
                Fragment fragment =new Formularios_Fragment();
                fragment.setArguments(bundle);

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, fragment).commit();
                } else {
                    Log.e("FormulariosFragment", "Error in creating fragment");
                }


                return false;
            }
        });


        return rootView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Calculo");
        listDataHeader.add("Opcion 2");
        listDataHeader.add("Opcion 3");

        // Adding child data
        List<String> opcion1 = new ArrayList<String>();
        opcion1.add("Derivadas");
        opcion1.add("Integrales");


        List<String> opcion2 = new ArrayList<String>();
        opcion2.add("Child 1");
        opcion2.add("Child 2");

        List<String> opcion3 = new ArrayList<String>();
        opcion3.add("Child 1");
        opcion3.add("Child 2");

        listDataChild.put(listDataHeader.get(0), opcion1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), opcion2);
        listDataChild.put(listDataHeader.get(2), opcion3);
    }



}
