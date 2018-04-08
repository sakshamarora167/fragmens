package com.example.orangerabbit.fragmens;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import com.example.orangerabbit.fragmens.R;
import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;

public class TopSectionFragment extends Fragment{

    private static EditText topTextInp;
    private static EditText bottomTextInp;

    TopSectionListener activityCommander ;

    public interface TopSectionListener{
        void createMeme(String top, String bottom);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = null;

        if (context instanceof Activity){
            a = (Activity)context;
        }

        try{
            activityCommander = (TopSectionListener)a;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(a.toString());
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);

        topTextInp = (EditText)view.findViewById(R.id.topInput);
        bottomTextInp = (EditText)view.findViewById(R.id.bottomInput);
        final Button button = (Button)view.findViewById(R.id.midButton);

        button.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View view) {
                        buttonClicked(view);
                    }
                }
        );
        return view;
    }

    public void buttonClicked(View view){
        activityCommander.createMeme(topTextInp.getText().toString(),bottomTextInp.getText().toString());
    }
}
