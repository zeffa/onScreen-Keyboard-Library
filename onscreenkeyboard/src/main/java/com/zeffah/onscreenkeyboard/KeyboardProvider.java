package com.zeffah.onscreenkeyboard;

import android.content.Context;
import android.widget.Toast;

public class KeyboardProvider {
    public static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
