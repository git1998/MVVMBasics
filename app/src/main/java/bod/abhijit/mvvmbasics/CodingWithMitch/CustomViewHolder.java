package bod.abhijit.mvvmbasics.CodingWithMitch;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bod.abhijit.mvvmbasics.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    public TextView tvText1,tvText2;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        tvText1 =itemView.findViewById(R.id.main2_single_item_tv_text1);
        tvText2 =itemView.findViewById(R.id.main2_single_item_tv_text2);
    }
}
