package Conroller;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.e_mazing.DecryptActivity;
import com.example.e_mazing.EncryptActivity;
import com.example.e_mazing.EncryptionListActivity;
import com.example.e_mazing.HomeActivity;
import com.example.e_mazing.InfoActivity;
import com.example.e_mazing.R;

import Resources.ColorString;
import Resources.Painter;

public class Navigator {

    public static View.OnClickListener goToHome(android.content.Context context){

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, HomeActivity.class);
                context.startActivity(in);
            }
        };

    }

    public static View.OnClickListener goToEncryptActivity(android.content.Context context){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, EncryptActivity.class);
                context.startActivity(in);
            }
        };
    }

    public static View.OnClickListener goToDecryptActivity(android.content.Context context){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, DecryptActivity.class);
                context.startActivity(in);
            }
        };
    }

    public static View.OnClickListener goToEncryptionListActivity(android.content.Context context){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, EncryptionListActivity.class);
                context.startActivity(in);
            }
        };
    }

    public static View.OnClickListener goToInfoActivity(android.content.Context context){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, InfoActivity.class);
                context.startActivity(in);
            }
        };
    }

    public static View.OnClickListener showDialog(android.content.Context context, String title, String description, String features){

        return new View.OnClickListener() {

            Dialog dialog;
            Window window;
            ImageView btnClose;
            TextView txtTitle, txtDesc, txtFeat;

            @Override
            public void onClick(View v){

                dialog = new Dialog(context);
                window = dialog.getWindow();

                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setDimAmount(0.5f);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                btnClose = dialog.findViewById(R.id.btnClose);
                txtTitle = dialog.findViewById(R.id.txtTitle);
                txtDesc = dialog.findViewById(R.id.txtDescription);
                txtFeat = dialog.findViewById(R.id.txtFeatures);

                Painter.paintTxtGradient(txtTitle, ColorString.GREEN, ColorString.DARK_GREEN);

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                txtTitle.setText(title);
                txtDesc.setText(description);
                txtFeat.setText(features);

                dialog.setCanceledOnTouchOutside(true);
                dialog.show();

            }
        };
    }

    // gina open lang ang url
    public static View.OnClickListener openUrl(android.content.Context context, String url){

        String finalUrl = (!url.startsWith("http://") && !url.startsWith("https://"))
                ? "http://" + url
                : url;

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalUrl));
                context.startActivity(browserIntent);
            }
        };
    }

    // gina open niya ang url and gina highlight ang ma click nga textview
    @SuppressLint("ClickableViewAccessibility")
    public static View.OnClickListener openUrl(android.content.Context context, TextView textView, String url){

        String finalUrl = (!url.startsWith("http://") && !url.startsWith("https://"))
                ? "http://" + url
                : url;

        textView.setOnTouchListener(Painter.tapHighlightEffect(context, textView));

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textView.setBackground(context.getDrawable(R.color.gray));
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalUrl));
                context.startActivity(browserIntent);
//                textView.setBackground(context.getDrawable(R.color.white));
            }
        };
    }

}
