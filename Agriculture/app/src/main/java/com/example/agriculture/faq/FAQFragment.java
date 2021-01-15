package com.example.agriculture.faq;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.agriculture.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQFragment extends Fragment {

    int previousGroup = -1;
    boolean flag = false;
    private ExpandableListView expandableListView;

    private FaqListViewAdapter expandableListViewAdapter;

    private List<String> listDataGroup;

    private HashMap<String, List<String>> listDataChild;
    boolean mIsSaved=true;
    public FAQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_f_a_q, container, false);
        expandableListView = v.findViewById(R.id.expandableListView);


        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // preparing list data
        initListData();
        return  v;
    }

    private void initListeners() {

        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                /*Toast.makeText(
                        getContext(),
                        listDataGroup.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataGroup.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                return false;
            }
        });


        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();*/
                if (groupPosition != previousGroup && flag) {
                    expandableListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;

                flag = true;

            }
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();*/

            }
        });

    }

    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
        expandableListViewAdapter = new FaqListViewAdapter(getContext(), listDataGroup, listDataChild);
        //expandableListViewAdapter = new ExpandableListViewAdapter(getContext(), faqPojos);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }

    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {


        // Adding group data
        listDataGroup.add(getString(R.string.text_alcohol));
        listDataGroup.add(getString(R.string.text_coffee));
        listDataGroup.add(getString(R.string.text_pasta));
        listDataGroup.add(getString(R.string.text_cold_drinks));
        listDataGroup.add(getString(R.string.crop_insurance));
        listDataGroup.add(getString(R.string.land_cleaing));
/*        listDataGroup.add(getString(R.string.family_));
        listDataGroup.add(getString(R.string.khsarif));
        listDataGroup.add(getString(R.string.rabi));
        listDataGroup.add(getString(R.string.zaid));
        listDataGroup.add(getString(R.string.soil_sutable));*/

        // array of strings
        String[] array;

        /*0*/
        // list of alcohol
        List<String> alcoholList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_alcohol);
        for (String item : array) {
            alcoholList.add(item);
        }

        // list of coffee 1
        List<String> coffeeList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_coffee);
        for (String item : array) {
            coffeeList.add(item);
        }

        // list of pasta 2
        List<String> pastaList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_pasta);
        for (String item : array) {
            pastaList.add(item);
        }

        // list of cold drinks 3
        List<String> coldDrinkList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_cold_drinks);
        for (String item : array) {
            coldDrinkList.add(item);
        }
        // list of cold drinks 4
        List<String> cleing = new ArrayList<>();
        array = getResources().getStringArray(R.array.land_clean);
        for (String item : array) {
            cleing.add(item);
        }
        // list of cold drinks 5
        List<String> insurence = new ArrayList<>();
        array = getResources().getStringArray(R.array.crop_insurence);
        for (String item : array) {
            insurence.add(item);
        }


        // Adding child data
        listDataChild.put(listDataGroup.get(0), alcoholList);
        listDataChild.put(listDataGroup.get(1), coffeeList);
        listDataChild.put(listDataGroup.get(2), pastaList);
        listDataChild.put(listDataGroup.get(3), coldDrinkList);
        listDataChild.put(listDataGroup.get(4), cleing);
        listDataChild.put(listDataGroup.get(5), insurence);
       /* listDataChild.put(listDataGroup.get(6), familily);
        listDataChild.put(listDataGroup.get(7), karif);
        listDataChild.put(listDataGroup.get(8), rabi);
        listDataChild.put(listDataGroup.get(9), famzaidilily);
        listDataChild.put(listDataGroup.get(10), sutab);*/

        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }
}