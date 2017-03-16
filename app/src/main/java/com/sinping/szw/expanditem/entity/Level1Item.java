package com.sinping.szw.expanditem.entity;


import com.sinping.szw.expanditem.adapter.ExpandableItemAdapter;

public class Level1Item extends AbstractExpandableItem<Object> implements MultiItemEntity {
    public String title;
    public String subTitle;

    public Level1Item(String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}