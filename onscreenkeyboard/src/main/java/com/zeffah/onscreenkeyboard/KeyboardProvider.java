package com.zeffah.onscreenkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;

public class KeyboardProvider extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    public static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateInputView() {
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int primaryCode) {
        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;
        switch (primaryCode){
            case Keyboard.KEYCODE_DELETE:
                CharSequence charSequence = ic.getSelectedText(0);
                if (TextUtils.isEmpty(charSequence)){
                    //No selection: delete previous character
                    ic.deleteSurroundingText(1,0);
                }else {
                    //Delete selection
                    ic.commitText("", 1);
                }
                ic.deleteSurroundingText(1,0);
                break;

            default:
                char code = (char) primaryCode;
                ic.commitText(String.valueOf(code), 1);
                break;
        }
    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
