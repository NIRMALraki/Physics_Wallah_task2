package com.example.physics_wallah_task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Try_adapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> arrayList;
    CheckBoxCheckedListener checkBoxCheckedListener;

    public Try_adapter(Context context, ArrayList<String> arraylist) {
        super(context,R.layout.single_row,R.id.single_row_text);
        this.context=context;
        this.arrayList=arraylist;
    }
    class myViewHolder{
        CheckBox checkBox;
        TextView textView;
        myViewHolder(View view)
        {
            textView=view.findViewById(R.id.checkBox1);
            checkBox=view.findViewById(R.id.checkBox1);
        }
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row=convertView;
        myViewHolder myViewHolder=null;
        if(row==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_row, parent,false);
            myViewHolder=new myViewHolder(row);
            row.setTag(myViewHolder);

        }
        else {
            myViewHolder= (myViewHolder) row.getTag();
        }
        myViewHolder.textView.setText(arrayList.get(position));
        myViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxCheckedListener != null)
                {
                    checkBoxCheckedListener.getcheckboxchecked(position);
                }
            }
        });
        return row;

    }
    public interface CheckBoxCheckedListener{

        void getcheckboxchecked(int position);
    }
    public void setCheckBoxCheckedListener(CheckBoxCheckedListener checkBoxCheckedListener)
    {
        this.checkBoxCheckedListener=checkBoxCheckedListener;
    }
}
