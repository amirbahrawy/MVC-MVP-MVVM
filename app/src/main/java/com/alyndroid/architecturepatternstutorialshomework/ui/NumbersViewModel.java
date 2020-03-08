package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumbersViewModel extends ViewModel {
    public MutableLiveData<NumberModel> modelMutableLiveData=new MutableLiveData<>();
    public void getNumbers(){
        NumberModel nummberModel=new DataBase().getNumbers();
         modelMutableLiveData.setValue(nummberModel);
    }
}
