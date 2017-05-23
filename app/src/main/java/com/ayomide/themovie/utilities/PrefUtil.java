package com.ayomide.themovie.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;



public class PrefUtil {

    public static final String PREF_MOVIES_MODE = "pref_movies_mode";

    public static String getMoviesMode(final Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_MOVIES_MODE, Sort.MOVIES_POPULAR);
    }

    public static void setMoviesMode(final Context context, String mode) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);

        sharedPreferences.edit().putString(PREF_MOVIES_MODE, mode).apply();
    }
}
