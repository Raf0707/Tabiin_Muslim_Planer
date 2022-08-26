package com.example.tabiin.adapters.names;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import com.example.tabiin.R;
import com.example.tabiin.objects.names.Name;
import com.example.tabiin.ui.zickr.names.AllahNamesFragment;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {

    public static final AllahNamesFragment MAIN = AllahNamesFragment.ctx.get();

    private LayoutInflater inflater;
    private List<Name> names;
    private TextView name;

    public NamesAdapter(Context context, List<Name> names) {
        this.names = names;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public NamesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final NamesAdapter.ViewHolder holder, int position) {
        Name name= names.get(position);
        holder.nameView.setText(name.getName());
        holder.nameView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.name1);
        }
    }




}