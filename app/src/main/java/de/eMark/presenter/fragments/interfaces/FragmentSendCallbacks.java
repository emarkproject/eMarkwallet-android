package de.eMark.presenter.fragments.interfaces;

import android.view.View;
import android.widget.TextView;

import de.eMark.presenter.customviews.BRKeyboard;

public interface FragmentSendCallbacks extends View.OnKeyListener, BRKeyboard.OnInsertListener,
        TextView.OnEditorActionListener {
    void onAmountClickListener();

    void onPasteClickListener();

    void onIsoButtonClickListener();

    void onScanClickListener();

    void onSendClickListener();

    void onCloseClickListener();

    void onMaxSendButtonClickListener();
}