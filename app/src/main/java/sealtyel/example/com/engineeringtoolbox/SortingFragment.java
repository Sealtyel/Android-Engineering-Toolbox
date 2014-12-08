package sealtyel.example.com.engineeringtoolbox;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SortingFragment extends Fragment {

    View rView;
    public SortingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rView=inflater.inflate(R.layout.fragment_sorting, container, false);
        ListView sl=(ListView)rView.findViewById(R.id.sortingList);
        sl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle;
                Fragment fragment;
                bundle=new Bundle();
                bundle.putInt("algoritmo",i);
                fragment =new Sorting_viewFragment();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                Log.e("Sorting", "Error in creating fragment");

            }
        });

        return rView;
    }


}
