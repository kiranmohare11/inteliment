package com.example.kiran.testdemo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TabFragment1 extends Fragment implements View.OnClickListener{
    Button button;
    TextView itemText;
    Button rBtn,bBtn,gBtn;



    public TabFragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_fragment1, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       /*String[] sliderColor = {
               "#124064","#008274","#ACD48C","#497315"
        };*/

        //Drawable[] sliderColor
         Drawable[] sliderColor = {
            getActivity().getResources().getDrawable(R.drawable.android2),
            getActivity().getResources().getDrawable(R.drawable.blue1),
            getActivity().getResources().getDrawable(R.drawable.blue1),
            getActivity().getResources().getDrawable(R.drawable.android2)
        };
         ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity(),sliderColor);
        viewPager.setAdapter(viewPagerAdapter);


        LinearLayout buttonPanel = (LinearLayout) getActivity().findViewById(R.id.buttonPanel);
        itemText = (TextView) getActivity().findViewById(R.id.itemText);
        String[] color = {"#F44702","#DB6DA2","#D1C02E","#BF0F4F","#b12295"};
        for (int i = 1; i<6;i++){
            button = new Button(getActivity());
            button.setHeight(350);
            button.setWidth(450);
            button.setText("Item " + i);
            button.setBackgroundColor(Color.parseColor(color[i - 1]));
            button.setTag("item "+i);
            buttonPanel.addView(button);
            button.getTag();
            button.setOnClickListener(this);
        }
        LinearLayout buttonPanel2 = (LinearLayout) getActivity().findViewById(R.id.buttonPanel2);
        rBtn = (Button) getActivity().findViewById(R.id.button1);
        bBtn = (Button) getActivity().findViewById(R.id.button2);
        gBtn = (Button) getActivity().findViewById(R.id.button3);
        MyClickListener mClickListener = new MyClickListener(buttonPanel2);

        gBtn.setTag("#4CAF50");
        rBtn.setTag("#D50000");
        bBtn.setTag("#3F51B5");
        gBtn.setOnClickListener(mClickListener);
        rBtn.setOnClickListener(mClickListener);
        bBtn.setOnClickListener(mClickListener);
    }


    @Override
    public void onClick(View v) {
        doAction(v.getTag());
    }

    public void doAction(Object action){
        //Toast.makeText(getActivity(),"Hi "+action.toString(),Toast.LENGTH_LONG).show();
        if (action !=null){
            itemText.setText(action.toString());
        }

    }

    public class MyClickListener implements View.OnClickListener{
        LinearLayout linearLayout;
        MyClickListener(LinearLayout linearLayout){
            this.linearLayout = linearLayout;
        }

        @Override
        public void onClick(View v) {
            linearLayout.setBackgroundColor(Color.parseColor(v.getTag().toString()));
        }
    }
}
