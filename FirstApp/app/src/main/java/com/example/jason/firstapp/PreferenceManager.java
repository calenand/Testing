package com.example.jason.firstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Created by Jason on 9/8/2014.
 */
public class PreferenceManager {

        public static final String PREFS_KEY = "MY_PREFS" ;

        SharedPreferences sharedPreferences;

        public PreferenceManager(Context context) {
            sharedPreferences = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
        }

        public boolean getSavedPreference(String key){
           return  sharedPreferences.getBoolean(key, false);
        }

        public void saveSharedPreference(String key, boolean wouldLike){
            sharedPreferences.edit().putBoolean(key, wouldLike).commit();
        }

}
