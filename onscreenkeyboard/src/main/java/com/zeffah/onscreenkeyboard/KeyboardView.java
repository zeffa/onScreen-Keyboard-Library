package com.zeffah.onscreenkeyboard;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

public class KeyboardView extends ConstraintLayout {
    public KeyboardView(Context context) {
        super(context);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        inflate(context, R.layout.keyboard_view, this);
    }

}
