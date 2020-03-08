package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumbersPresenter {
    NumbersView numbersView;
    private NumberModel nummberModel;

    public NumbersPresenter(NumbersView numbersView) {
        nummberModel=new DataBase().getNumbers();
        this.numbersView = numbersView;
    }
    public void getNumbers(){
       numbersView.onGetNumbers(nummberModel);
    }
}
