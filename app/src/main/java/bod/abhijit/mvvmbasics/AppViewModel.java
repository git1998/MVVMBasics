package bod.abhijit.mvvmbasics;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AppViewModel extends BaseObservable {

    Model model;

    String successMessage ="Login successful";
    String errorMessage ="Email or password is not valid";

    @Bindable
    String toastMessage =null;


    public AppViewModel(){
        model =new Model("","");
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }



    @Bindable
    public String getUserEmail(){
        return model.getEmail();
    }

    public void setUserEmail(String email){
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword(){
        return model.getPassword();
    }

    public void setUserPassword(String password){
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }


    public void onButtonClicked(){

        if(isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);


    }


    public boolean isValid(){
        return  !(TextUtils.isEmpty(getUserEmail())) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }




}
