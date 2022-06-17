package bod.abhijit.mvvmbasics.CodingWithMitch;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {

    static EmployeeRepo instance;
    ArrayList<CustomModal> dataSet=new ArrayList<>();

    public static EmployeeRepo getInstance(){

        if(instance==null){
            instance =new EmployeeRepo();
        }

        return instance;
    }

    public MutableLiveData<List<CustomModal>> getEmployeeList(){

        setEmployeeList();
        MutableLiveData<List<CustomModal>> data =new MutableLiveData<>();
        data.setValue(dataSet);

        return data;
    }

    public void setEmployeeList(){

        dataSet.add(new CustomModal("Abhijit",23));
        dataSet.add(new CustomModal("Shubham",24));
        dataSet.add(new CustomModal("Harsh",77));
        dataSet.add(new CustomModal("Shivam",22));

    }



}
