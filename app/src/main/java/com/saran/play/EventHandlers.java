package com.saran.play;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.saran.play.data.User;

/**
 * Created by core I5 on 10/30/2017.
 */

public class EventHandlers {
    public static String LOGTAG = EventHandlers.class.getSimpleName();
    public void showToast(View view, User user) {
        if (view!=null){
            Context context = view.getContext();
            Intent intent = new Intent(context,BsociableTourPromptActivity.class);
            context.startActivity(intent);
        }
    }
}
