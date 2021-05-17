package com.example.roaddefect.userCompleteFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.roaddefect.R;
import com.google.android.material.textfield.TextInputLayout;

public class DefectAddFragment extends Fragment {
    private TextInputLayout defectSelection, defectSubSelection;
    private TextInputLayout defectLength, defectWidth, defectDepth, defectDesc;
    private RadioGroup severityRadioGrp;
    private AutoCompleteTextView defectAutoComp1, defectAutoComp2;
    private Button insertRecord;
    String[] parentDefectItem, subDefectItem1, subDefectItem2;
    ArrayAdapter<String> adapter1, adapter2, adapter3;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_defect_add, container, false);
        defectSelection = v.findViewById(R.id.defectSelection);
        defectSubSelection = v.findViewById(R.id.defectSubSelection);
        defectAutoComp1 = v.findViewById(R.id.defectAutoComp1);
        defectAutoComp2 = v.findViewById(R.id.defectAutoComp2);
        defectLength = v.findViewById(R.id.defectLength);
        defectWidth = v.findViewById(R.id.defectWidth);
        defectDepth = v.findViewById(R.id.defectDepth);
        defectDesc = v.findViewById(R.id.defectDesc);
        severityRadioGrp = v.findViewById(R.id.severityRadioGrp);
        insertRecord = v.findViewById(R.id.insertRecord);

        parentDefectItem = new String[]{"Crack", "Pothole"};
        subDefectItem1 = new String[]{"Item1", "Item2", "Item3"};
        subDefectItem2 = new String[]{"Item4", "Item5", "Item6"};

        adapter1 = new ArrayAdapter<>(getActivity(), R.layout.defect_list_dropdown, parentDefectItem);
        adapter2 = new ArrayAdapter<>(getActivity(), R.layout.defect_list_dropdown, subDefectItem1);
        adapter3 = new ArrayAdapter<>(getActivity(), R.layout.defect_list_dropdown, subDefectItem2);
        defectAutoComp1.setThreshold(0);
        defectAutoComp1.setAdapter(adapter1);

        /* implement this below at the end for changing the subdefect based upon the parent defect selected dynamically
        defectAutoComp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    defectAutoComp2.setVisibility(View.VISIBLE);
                }
                else
                    defectAutoComp2.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        defectAutoComp1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parentDefectItem[position].equals("Crack")) {
                    defectAutoComp2.setThreshold(0);
                    defectAutoComp2.setAdapter(adapter2);
                } else {
                    defectAutoComp2.setThreshold(0);
                    defectAutoComp2.setAdapter(adapter3);
                }
            }
        });

        insertRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Defect Successfully recorded!", Toast.LENGTH_LONG).show();
                defectAutoComp1.getText().clear();
                defectAutoComp2.getText().clear();
                defectLength.getEditText().getText().clear();
                defectDepth.getEditText().getText().clear();
                defectWidth.getEditText().getText().clear();
                defectDesc.getEditText().getText().clear();
            }
        });

        return v;
    }

}