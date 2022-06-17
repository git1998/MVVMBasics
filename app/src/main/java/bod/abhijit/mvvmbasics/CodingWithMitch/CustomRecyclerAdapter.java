package bod.abhijit.mvvmbasics.CodingWithMitch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bod.abhijit.mvvmbasics.R;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    LayoutInflater inflater;
    List<CustomModal> mData ;

    public CustomRecyclerAdapter(Context context,List<CustomModal> mData) {

        inflater =LayoutInflater.from(context);
        this.mData =mData;

    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =inflater.inflate(R.layout.main2_single_item,parent,false);

        CustomViewHolder viewHolder =new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.tvText1.setText(mData.get(position).getName());
        holder.tvText2.setText(String.valueOf(mData.get(position).getAge()));

    }

    @Override
    public int getItemCount() {
        if(mData == null)
            return 0;
        else
            return mData.size();
    }
}
