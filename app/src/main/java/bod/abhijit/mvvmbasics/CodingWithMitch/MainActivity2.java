package bod.abhijit.mvvmbasics.CodingWithMitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import bod.abhijit.mvvmbasics.R;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomRecyclerAdapter adapter;
    ProgressBar progressBar;

    EmployeeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView =findViewById(R.id.main2_rv_recyclerview);
        progressBar =findViewById(R.id.main2_pb_progressbar);
        Button btnAddEntry =findViewById(R.id.main2_btn_addEntry);

        viewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        viewModel.init();

        viewModel.getEmployeeList().observe(this, new Observer<List<CustomModal>>() {
            @Override
            public void onChanged(List<CustomModal> customModals) {

                adapter.notifyDataSetChanged();

            }});


        viewModel.isUpdating.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if(aBoolean)
                    showProgress();
                else{
                    hideProgress();
                    recyclerView.smoothScrollToPosition(viewModel.getEmployeeList().getValue().size()-1);
                }


            }});


        btnAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModel.addNewEmployee(new CustomModal("Gopal",28));


            }});


        initRecyclerView();


    }

    public void initRecyclerView(){

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter =new CustomRecyclerAdapter(this,viewModel.getEmployeeList().getValue());
        Log.d("kaka", String.valueOf(viewModel.getEmployeeList().getValue()));
        recyclerView.setAdapter(adapter);

    }

    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        progressBar.setVisibility(View.GONE);
    }
}