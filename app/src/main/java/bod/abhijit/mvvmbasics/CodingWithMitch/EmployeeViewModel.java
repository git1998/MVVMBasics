package bod.abhijit.mvvmbasics.CodingWithMitch;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class EmployeeViewModel extends ViewModel {

    public MutableLiveData<List<CustomModal>> employeeList ;
    MutableLiveData<Boolean> isUpdating =new MutableLiveData<>();

    EmployeeRepo repo;

    public void init(){
        if(employeeList != null)
            return;

        repo =EmployeeRepo.getInstance();
        employeeList =repo.getEmployeeList();
    }

    LiveData<List<CustomModal>> getEmployeeList(){
        return employeeList;
    }

    public void addNewEmployee(CustomModal modal){

        isUpdating.setValue(true);

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                List<CustomModal> list = employeeList.getValue();
                list.add(modal);
                employeeList.postValue(list);
                isUpdating.postValue(false);

            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

        }.execute();

    }

    public LiveData<Boolean> getIsLoading(){
        return isUpdating;
    }

}
