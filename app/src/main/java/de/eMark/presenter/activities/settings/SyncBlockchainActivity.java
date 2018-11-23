package de.eMark.presenter.activities.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import de.eMark.R;
import de.eMark.databinding.ActivitySyncBlockchainBinding;
import de.eMark.presenter.activities.callbacks.ActivitySyncCallback;
import de.eMark.presenter.activities.util.BRActivity;
import de.eMark.tools.animation.BRAnimator;
import de.eMark.tools.animation.BRDialog;
import de.eMark.wallet.BRWalletManager;


public class SyncBlockchainActivity extends BRActivity {

    private ActivitySyncCallback callback = () -> BRDialog.showCustomDialog(SyncBlockchainActivity.this,
            getString(R.string.ReScan_alertTitle),
            getString(R.string.ReScan_footer), getString(R.string.ReScan_alertAction),
            getString(R.string.Button_cancel),
            brDialogView -> {
                brDialogView.dismissWithAnimation();
                BRWalletManager.getInstance().wipeBlockAndTrans(SyncBlockchainActivity.this,
                        () -> BRAnimator.startBreadActivity(SyncBlockchainActivity.this,
                                false));
            }, brDialogView -> brDialogView.dismissWithAnimation(), null, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySyncBlockchainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sync_blockchain);
        setupToolbar();
        setToolbarTitle(R.string.Settings_sync);
        binding.setCallback(callback);
    }
}