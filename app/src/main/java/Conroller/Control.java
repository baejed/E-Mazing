package Conroller;

import android.view.View;
import android.widget.Spinner;

public class Control {

    public static View.OnClickListener activateSpinner(Spinner spinner){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.performClick();
            }
        };
    }

}
