package de.eMark.presenter.activities.intro;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import de.eMark.R;
import de.eMark.databinding.ActivityIntroRecoverBinding;
import de.eMark.presenter.activities.InputWordsActivity;
import de.eMark.presenter.activities.callbacks.ActivityRecoverCallback;
import de.eMark.presenter.activities.util.BRActivity;

public class RecoverActivity extends BRActivity {

    ActivityRecoverCallback callback = () ->
            InputWordsActivity.open(RecoverActivity.this, InputWordsActivity.Type.RESTORE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIntroRecoverBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_intro_recover);
        binding.setCallback(callback);
        setupToolbar();
        setToolbarTitle(R.string.RecoverWallet_header);
    }
}