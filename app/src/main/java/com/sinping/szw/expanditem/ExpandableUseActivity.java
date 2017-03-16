package com.sinping.szw.expanditem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sinping.szw.expanditem.adapter.ExpandableItemAdapter;
import com.sinping.szw.expanditem.entity.Level0Item;
import com.sinping.szw.expanditem.entity.Level1Item;
import com.sinping.szw.expanditem.entity.MultiItemEntity;
import com.sinping.szw.expanditem.entity.Person;

import java.util.ArrayList;
import java.util.Random;

public class ExpandableUseActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_item_use);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<MultiItemEntity> list = generateData();
        ExpandableItemAdapter adapter = new ExpandableItemAdapter(list);


        mRecyclerView.setAdapter(adapter);

    }


    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 5;
        int lv1Count = 2;
        int personCount = 3;
        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i);
            if (lv1Count <= 0) {
                for (int k = 0; k < personCount; k++) {
                    lv0.addSubItem(new Person(nameList[k], random.nextInt(40)));
                }
            } else {
                for (int j = 0; j < lv1Count; j++) {
                    Level1Item lv1 = new Level1Item("Level 1 item: " + j, "(no animation)");
                    for (int k = 0; k < personCount; k++) {
                        lv1.addSubItem(new Person(nameList[k], random.nextInt(40)));
                    }
                    lv0.addSubItem(lv1);
                }
            }

            res.add(lv0);
        }
        return res;
    }
}
