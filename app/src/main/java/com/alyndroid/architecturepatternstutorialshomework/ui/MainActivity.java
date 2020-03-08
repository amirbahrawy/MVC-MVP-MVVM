package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumbersView {
    //MVC
    private Button plusButton;
    private TextView plusResultTextView;
    private NumberModel nummberModel;
    private int plusResult;
    //MVP
    private NumbersPresenter numbersPresenter;
    private Button divButton;
    private TextView divResultTextView;
    //MVVM
    private NumbersViewModel numbersViewModel;
    private Button mulButton;
    private TextView mulResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //MVC
        plusButton = (Button) findViewById(R.id.plus_button);
        plusButton.setOnClickListener(this);
        plusResultTextView = (TextView) findViewById(R.id.plus_result_textView);
        nummberModel = new DataBase().getNumbers();
        plusResult = nummberModel.getFirstNum() + nummberModel.getSecondNum();
        //MVP
        numbersPresenter = new NumbersPresenter(this);
        divButton = (Button) findViewById(R.id.div_button);
        divButton.setOnClickListener(this);
        divResultTextView = (TextView) findViewById(R.id.div_result_textView);
        //MVVM
        mulButton = (Button) findViewById(R.id.mul_button);
        mulButton.setOnClickListener(this);
        mulResultTextView = (TextView) findViewById(R.id.mul_result_textView);
        numbersViewModel = ViewModelProviders.of(this).get(NumbersViewModel.class);
        numbersViewModel.modelMutableLiveData.observe(this, new Observer<NumberModel>() {
            @Override
            public void onChanged(NumberModel numberModel) {
                int divResult = numberModel.getFirstNum() * numberModel.getSecondNum();
                mulResultTextView.setText(divResult+"");
            }
        });

    }

    @Override
    public void onClick(View v) {
        //MVC
        if (v == plusButton)
            plusResultTextView.setText(plusResult + "");
        //MVP
        if (v.getId() == R.id.div_button)
            numbersPresenter.getNumbers();
        //MVVM
        if (v==mulButton)
               numbersViewModel.getNumbers();
    }

    @Override
    public void onGetNumbers(NumberModel numberModel) {
        int divResult = numberModel.getFirstNum() / numberModel.getSecondNum();
        divResultTextView.setText(divResult + "");
    }
}
