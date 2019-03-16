package com.example.day5.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.day5.Fragments.Fragment_A;
import com.example.day5.Fragments.Fragment_B;
import com.example.day5.R;

public class Main2Activity extends AppCompatActivity {


    Fragment_A mFragment_a = new Fragment_A();
    Fragment_B mFragment_b = new Fragment_B();
    Button mBtAdd,mBtRemove,mBtReplace, mBtShow, mBtHide;
    FragmentManager mFragmentManager = getSupportFragmentManager();
    FragmentTransaction mFragmentTransaction;
    final int VISIBLE = 2 ;
    final int ADD = 1 ;
    final int HIDE = -2 ;
    final int ADD_VISIBLE = 3 ;
    final int REMOVED = 0 ;
    int mFlag = 0;
//    final int show = 3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtAdd = findViewById(R.id.bt_add);
        mBtHide = findViewById(R.id.bt_hide);
        mBtRemove = findViewById(R.id.bt_remove);
        mBtReplace = findViewById(R.id.bt_replace);
        mBtShow = findViewById(R.id.bt_show);

        mBtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlag == REMOVED) {
                    mFlag = mFlag+ADD+VISIBLE;
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.add(R.id.layout_replacable,mFragment_a);
                    mFragmentTransaction.addToBackStack("Add stack");
                    mFragmentTransaction.commit();
                }
                else{
                    Toast.makeText(Main2Activity.this, "Already There     "+mFlag, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mFlag>REMOVED){
                    mFlag = REMOVED;
                    mFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
                else{
                    Toast.makeText(Main2Activity.this, "      "+mFlag, Toast.LENGTH_SHORT).show();
                }

            }
        });

        mBtShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlag==ADD){
                    mFlag = mFlag + VISIBLE;
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.show(mFragmentManager.getFragments()
                            .get(getSupportFragmentManager().getFragments().size() - 1));
                    mFragmentTransaction.commit();
                }
                else{
                    Toast.makeText(Main2Activity.this, "Already shown or no fragment present      "+mFlag, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlag == ADD_VISIBLE){
                    mFlag = mFlag + HIDE;
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.hide(mFragmentManager.getFragments()
                            .get(getSupportFragmentManager().getFragments().size() - 1));
                    mFragmentTransaction.commit();
                }
                else {
                    Toast.makeText(Main2Activity.this, "Nothing to Hide       "+mFlag, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlag == ADD_VISIBLE){
                    if(mFragmentManager.getFragments()
                            .get(getSupportFragmentManager().getFragments().size() - 1)!=mFragment_a){
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        mFragmentTransaction.replace(R.id.layout_replacable,mFragment_a);
                        mFragmentTransaction.commit();
                    }
                    else if(mFragmentManager.getFragments()
                            .get(getSupportFragmentManager().getFragments().size() - 1)!=mFragment_b){
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        mFragmentTransaction.replace(R.id.layout_replacable,mFragment_b);
                        mFragmentTransaction.commit();
                    }

                }
                else {
                    Toast.makeText(Main2Activity.this, "No visible fragment or no present fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
