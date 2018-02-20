package com.kubik.roman.mypokemon.app.presentation;

import android.app.Activity;
import android.content.Intent;

import com.kubik.roman.mypokemon.app.presentation.main.MainActivity;

/**
 * Created by kubik on 2/20/18.
 */

public class Navigate {

    public static void toMainActivity(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.finish();
    }
}
