package com.example.peter.pryanikchallenge;

import com.arellomobile.mvp.MvpView;

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.peter.pryanikchallenge.models.Base;

@StateStrategyType(SingleStateStrategy.class)
public interface IMainView extends MvpView {
    void showProgress();
    void showSelect(Base base);
    void hideProgress();
    void showError();
}
