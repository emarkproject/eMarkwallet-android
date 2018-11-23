package de.eMark.presenter.fragments.interfaces;

import de.eMark.presenter.customviews.BRKeyboard;

public interface PinFragmentCallback extends BRKeyboard.OnInsertListener {
    void onCancelClick();
}
