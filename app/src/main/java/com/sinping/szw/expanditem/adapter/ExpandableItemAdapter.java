package com.sinping.szw.expanditem.adapter;

import android.view.View;
import android.widget.Toast;

import com.sinping.szw.expanditem.BaseViewHolder;
import com.sinping.szw.expanditem.R;
import com.sinping.szw.expanditem.entity.Level0Item;
import com.sinping.szw.expanditem.entity.Level1Item;
import com.sinping.szw.expanditem.entity.MultiItemEntity;
import com.sinping.szw.expanditem.entity.Person;

import java.util.List;

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = ExpandableItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_PERSON, R.layout.item_expandable_lv2);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                holder.setImageResource(R.id.iv_head, R.mipmap.head_img);
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.title, lv0.title)
                        .setText(R.id.sub_title, lv0.subTitle)
                        .setImageResource(R.id.iv, lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Toast.makeText(mContext, "Level 0 item pos: " + pos, Toast.LENGTH_SHORT).show();
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.title, lv1.title)
                        .setText(R.id.sub_title, lv1.subTitle)
                        .setImageResource(R.id.iv, lv1.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Toast.makeText(mContext, "Level 1 item pos: " + pos, Toast.LENGTH_SHORT).show();
                        if (lv1.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });
                break;
            case TYPE_PERSON:
                final Person person = (Person) item;
                holder.setText(R.id.tv, person.name + " parent pos: " + getParentPosition(person));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Toast.makeText(mContext, "Level 2 item pos: " + person.name + pos, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
