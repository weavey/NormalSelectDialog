package com.wevey.selector.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;

/**
 * Created by Weavey on 2016/12/4.
 */

public interface DialogInterface {

    interface OnLeftAndRightClickListener<T> {

        void clickLeftButton(T dialog, View view);

        void clickRightButton(T dialog, View view);
    }

    interface OnSingleClickListener<T> {

        void clickSingleButton(T dialog, View view);
    }

    interface OnItemClickListener<T> {

        void onItemClick(T dialog, View button, int position);
    }
}
