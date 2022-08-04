package com.example.demouserloginapplication1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private ArrayList<User> userArrayList;
    public static Context context;

    // constructor
    public ListAdapter(ArrayList<User> courseModalArrayList, Context context) {
        this.userArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_design1, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user = userArrayList.get(position);
        holder.ListV_name.setText(user.getName());
        holder.ListV_surname.setText(user.getSurname());
        holder.ListV_Age.setText(user.getAge());
        holder.ListV_Phone.setText(user.getPhoneNo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdateUser.class);

                i.putExtra("name", user.getName());
                i.putExtra("surname", user.getSurname());
                i.putExtra("age", user.getAge());
                i.putExtra("phone_no", user.getPhoneNo());
                i.putExtra("address", user.getAddress());
                i.putExtra("job", user.getJob_details());
                i.putExtra("qualification", user.getQualification());
                i.putExtra("id", user.getId());
                context.startActivity(i);
            }
        });
    }

    public int getItemCount() {
        // returning the size of our array list
        return userArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private TextView ListV_name, ListV_surname, ListV_Age, ListV_Phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            ListV_name = itemView.findViewById(R.id.name_list);
            ListV_surname = itemView.findViewById(R.id.surname_list);
            ListV_Age = itemView.findViewById(R.id.age_list);
            ListV_Phone = itemView.findViewById(R.id.contact_list);
        }
    }

}
