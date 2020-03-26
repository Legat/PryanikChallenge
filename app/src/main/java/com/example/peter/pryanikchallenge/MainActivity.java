package com.example.peter.pryanikchallenge;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.peter.pryanikchallenge.models.Base;
import com.example.peter.pryanikchallenge.models.DataStruct;
import com.example.peter.pryanikchallenge.utils.DataUtils;



public class MainActivity extends MvpAppCompatActivity implements Adapter.OnItemClickListener, IMainView {
    @NonNull
    private ProgressBar progress;
    @NonNull
    private RecyclerView recyclerView;

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = findViewById(R.id.progress_list);
        recyclerView = findViewById(R.id.list);

        if (checkInternetConnection()){
        showProgress();
        presenter.getNews();
        }



    }

    private Boolean checkInternetConnection() {
    return DataUtils.internetConnection(this);
    }


    @Override
    public void onItemClick(View view, DataStruct dataStr) {

       String infoData = dataStr.getData().getText();
       Snackbar.make(view, "Object type: " + dataStr.getName() + " " + infoData, Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onItemSelect(View view, DataStruct data, int position) {

        String selectInfo = data.getData().getSelectedId() + ": " + DataUtils.getVariant(data,position);
        Snackbar.make(view, "Object type " + data.getName()+ " : " + selectInfo, Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void showProgress() {
     progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSelect(Base base) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this,base,this);
        recyclerView.setAdapter(adapter);  // DataAdapter
    }

    @Override
    public void hideProgress() {
     progress.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Internet connection is disabled at the moment", Toast.LENGTH_LONG);
    }
}
