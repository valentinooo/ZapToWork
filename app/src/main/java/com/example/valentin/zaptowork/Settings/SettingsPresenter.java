package com.example.valentin.zaptowork.Settings;

import android.support.annotation.NonNull;


public class SettingsPresenter implements SettingsContract.Presenter {

    @NonNull
    private SettingsContract.View mView;

    public SettingsPresenter(@NonNull SettingsContract.View mView) {
        mView.setPresenter(this);
    }

    @Override
    public void checkConnectivity() {

    }

    @Override
    public void start() {

    }
}
