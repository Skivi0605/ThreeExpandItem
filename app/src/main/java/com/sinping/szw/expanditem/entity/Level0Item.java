package com.sinping.szw.expanditem.entity;


import com.sinping.szw.expanditem.adapter.ExpandableItemAdapter;
public class Level0Item extends AbstractExpandableItem<Object> implements MultiItemEntity {
    public String title;
    public String subTitle;

    public Level0Item(String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
