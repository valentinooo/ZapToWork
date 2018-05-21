package com.example.valentin.zaptowork.Settings;

import com.example.valentin.zaptowork.BasePresenter;
import com.example.valentin.zaptowork.BaseView;

public interface SettingsContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter{
        void checkConnectivity();
    }
}
