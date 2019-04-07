package com.example.peter.pryanikchallenge;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.peter.pryanikchallenge.Network.InternetConnection;
import com.example.peter.pryanikchallenge.Network.RetrofitClient;
import com.example.peter.pryanikchallenge.models.Base;

import rx.Observable;
import rx.Observer;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class Presenter extends MvpPresenter<IMainView> implements IPresenter {
    @Override
    public void showProgress() {
    getViewState().showProgress();
    }

    @Override
    public void getNews() {

        Single<Base> observable = RetrofitClient.getApiService().getBase();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Base>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    getViewState().showError();
                    }

                    @Override
                    public void onNext(Base base) {
                        hideProgress();
                        getViewState().showSelect(base);
                    }
                });
    }

    @Override
    public void hideProgress() {
    getViewState().hideProgress();
    }


}
