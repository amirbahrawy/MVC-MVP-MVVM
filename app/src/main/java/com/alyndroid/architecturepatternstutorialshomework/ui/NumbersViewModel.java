package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumbersViewModel extends ViewModel {
    public MutableLiveData<String> modelMutableLiveData=new MutableLiveData<>();
    public void getNumbers(){
        NumberModel nummberModel=new DataBase().getNumbers();
        String result=nummberModel.getFirstNum()*nummberModel.getSecondNum()+"";
        modelMutableLiveData.setValue(result);
    }
}
