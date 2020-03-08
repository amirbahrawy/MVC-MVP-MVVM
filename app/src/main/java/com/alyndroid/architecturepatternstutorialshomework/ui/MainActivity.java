package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumbersView {
    //MVC
    private NumberModel nummberModel;
    private int plusResult;
    //MVP
    private NumbersPresenter numbersPresenter;
    //MVVM
    private NumbersViewModel numbersViewModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        initView();
        binding.setViewModel(numbersViewModel);
        binding.setLifecycleOwner(this);
    }

    private void initView() {
        //MVC
        binding.plusButton.setOnClickListener(this);
        nummberModel = new DataBase().getNumbers();
        plusResult = nummberModel.getFirstNum() + nummberModel.getSecondNum();
        //MVP
        numbersPresenter = new NumbersPresenter(this);
        binding.divButton.setOnClickListener(this);
        //MVVM
        binding.mulButton.setOnClickListener(this);
        numbersViewModel = ViewModelProviders.of(this).get(NumbersViewModel.class);

    }

    @Override
    public void onClick(View v) {
        //MVC
        if (v==binding.plusButton)
            binding.plusResultTextView.setText(plusResult + "");
        //MVP
        if (v == binding.divButton)
            numbersPresenter.getNumbers();
        //MVVM
        if (v==binding.mulButton)
               numbersViewModel.getNumbers();
    }
    //MVP
    @Override
    public void onGetNumbers(NumberModel numberModel) {
        int divResult = numberModel.getFirstNum() / numberModel.getSecondNum();
        binding.divResultTextView.setText(divResult + "");
    }
}
