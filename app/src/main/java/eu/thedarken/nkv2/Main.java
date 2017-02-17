package eu.thedarken.nkv2;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.view.View;


public class Main extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    @Override
    public boolean onEvaluateFullscreenMode() {
        return false;
    }

    @Override
    public int getCandidatesHiddenVisibility() {
        return View.GONE;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) { }

    @Override
    public void onPress(int primaryCode) { }

    @Override
    public void onRelease(int primaryCode) { }

    @Override
    public void onText(CharSequence text) { }

    @Override
    public void swipeDown() { }

    @Override
    public void swipeLeft() { }

    @Override
    public void swipeRight() { }

    @Override
    public void swipeUp() { }
}