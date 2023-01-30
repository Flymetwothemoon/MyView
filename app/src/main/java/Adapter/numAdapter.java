package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myview.R;

import java.util.List;

public class numAdapter extends RecyclerView.Adapter<numAdapter.adapterViewHolder> {
    public numAdapter(List<num> list) {
        mList = list;
    }

    private List<num>mList;
    @NonNull
    @Override
    public numAdapter.adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new adapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.numlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull numAdapter.adapterViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class adapterViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public adapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView =  itemView.findViewById(R.id.numText);
        }
    }
}
