package de.eMark.tools.list.items;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import de.eMark.DigiByte;
import de.eMark.R;
import de.eMark.presenter.customviews.BRText;
import de.eMark.tools.list.ListItemData;
import de.eMark.tools.list.ListItemViewHolder;
import de.eMark.tools.manager.SyncManager;
import de.eMark.tools.util.Utils;

public class ListItemSyncingViewHolder extends ListItemViewHolder {
    private final TextView date;
    private final ProgressBar progress;
    private View progressBar;

    public ListItemSyncingViewHolder(View anItemView) {
        super(anItemView);
        date = anItemView.findViewById(R.id.sync_date);
        progress = anItemView.findViewById(R.id.sync_progress);
        progressBar = anItemView.findViewById(R.id.progress_bar);
    }

    @Override
    public void process(ListItemData aListItemData) {
        super.process(aListItemData);
        itemView.setBackgroundResource(R.drawable.tx_rounded);
        progress.setProgress((int) (SyncManager.getInstance().getProgress() * 100));
        progressBar.setVisibility(
                SyncManager.getInstance().getLastBlockTimestamp() == 0 ? View.VISIBLE
                        : View.INVISIBLE);
        date.setText(SyncManager.getInstance().getLastBlockTimestamp() == 0
                ? DigiByte.getContext().getString(R.string.NodeSelector_statusLabel) + ": "
                + DigiByte.getContext().getString(R.string.SyncingView_connecting)
                : Utils.formatTimeStamp(SyncManager.getInstance().getLastBlockTimestamp() * 1000,
                        "MMM. dd, yyyy 'at' hh:mm a"));
    }
}