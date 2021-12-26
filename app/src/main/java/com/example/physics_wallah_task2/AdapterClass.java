package com.example.physics_wallah_task2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends ArrayAdapter<String> {
    ArrayList<String> items;
    Context context;
    public AdapterClass(@NonNull Context context, @NonNull ArrayList<String> objects) {
        super(context,R.layout.listrow, objects);
        this.context=context;
        this.items=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listrow, null);
            TextView number=convertView.findViewById(R.id.number);
            number.setText(position+1+".");
            TextView name=convertView.findViewById(R.id.name1);
            name.setText(items.get(position));

            CheckBox checkBox=convertView.findViewById(R.id.remove);
            if(checkBox.isChecked())
            {
                System.out.println(items.get(position));
            }
        }
        return convertView;
    }
}
