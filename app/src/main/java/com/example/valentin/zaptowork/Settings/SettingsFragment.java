package com.example.valentin.zaptowork.Settings;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.valentin.zaptowork.R;

import java.io.IOException;
import java.net.InetAddress;

import static com.google.common.base.Preconditions.checkNotNull;

public class SettingsFragment extends Fragment implements SettingsContract.View {

    SettingsContract.Presenter mPresenter;

    Button checkConnectivityButton;
    EditText addressServer;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      /*  View root = inflater.inflate(R.layout.content_setttings, container, false);

        addressServer = root.findViewById(R.id.editText);

        checkConnectivityButton =(Button) root.findViewById(R.id.button_id);
*/
        return null;
    }

    @Override
    public void setPresenter(SettingsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
