package Resources;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.e_mazing.R;

public class Painter {

    // para sa gradient sa mga texts
    public static void paintTxtGradient(TextView textView, String colorString1, String colorString2){
        TextPaint paint = textView.getPaint();
        float width = paint.measureText("E-Mazing Encryption");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor(colorString1),
                        Color.parseColor(colorString2)
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }

    // this functions is weird (tanan tapHighlightEffect), mubalik sya sa iyang dating color pag naa syay onclicklistener nga naka apply (ang Painter.tapHighLightEffect)
    public static View.OnTouchListener tapHighlightEffect(android.content.Context context, TextView textView) {

        Drawable originalBackground = textView.getBackground();
        Drawable highlightBackground = context.getDrawable(R.color.light_gray);

        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Set the background to light gray when the touch starts
                        textView.setBackground(highlightBackground);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // Check if the touch is still inside the bounds of the view
                        if (isTouchInsideView(v, event)) {
                            textView.setBackground(highlightBackground);
                        } else {
                            textView.setBackground(originalBackground);
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Set the background back to white when the touch ends or is cancelled
                        textView.setBackground(originalBackground);
                        break;
                }
                return false; // Return true to consume the touch event (gi false para maka listen sya og click
            }

            // Helper method to check if the touch is inside the view bounds
            private boolean isTouchInsideView(View view, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                return x >= 0 && x <= view.getWidth() && y >= 0 && y <= view.getHeight();
            }
        };
    }

    public static View.OnTouchListener tapHighlightEffect(android.content.Context context, LinearLayout linearLayout) {

        Drawable originalBackground = linearLayout.getBackground();
        Drawable highlightBackground = context.getDrawable(R.color.dark_green);
        int paddingLeft = linearLayout.getPaddingLeft();
        int paddingRight = linearLayout.getPaddingRight();
        int paddingTop = linearLayout.getPaddingTop();
        int paddingBottom = linearLayout.getPaddingBottom();

        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Set the background to light gray when the touch starts
                        linearLayout.setBackground(highlightBackground);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // Check if the touch is still inside the bounds of the view
                        if (isTouchInsideView(v, event)) {
                            linearLayout.setBackground(highlightBackground);
                        } else {
                            revert();
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Set the background back to white when the touch ends or is cancelled
                        revert();
                        break;
                }

                return false; // Return true to consume the touch event (gi false para maka listen sya og click)
            }

            // Helper method to check if the touch is inside the view bounds
            private boolean isTouchInsideView(View view, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                return x >= 0 && x <= view.getWidth() && y >= 0 && y <= view.getHeight();
            }

            public void revert(){
                linearLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                linearLayout.setBackground(originalBackground);
            }
        };
    }

    public static View.OnTouchListener tapHighlightEffect(android.content.Context context, LinearLayout linearLayout, Drawable highlightColor) {

        Drawable originalBackground = linearLayout.getBackground();
        Drawable highlightBackground = highlightColor;
        int paddingLeft = linearLayout.getPaddingLeft();
        int paddingRight = linearLayout.getPaddingRight();
        int paddingTop = linearLayout.getPaddingTop();
        int paddingBottom = linearLayout.getPaddingBottom();

        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Set the background to light gray when the touch starts
                        linearLayout.setBackground(highlightBackground);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // Check if the touch is still inside the bounds of the view
                        if (isTouchInsideView(v, event)) {
                            linearLayout.setBackground(highlightBackground);
                        } else {
                            revert();
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Set the background back to white when the touch ends or is cancelled
                        revert();
                        break;
                }

                return false; // Return true to consume the touch event (gi false para maka listen sya og click)
            }

            // Helper method to check if the touch is inside the view bounds
            private boolean isTouchInsideView(View view, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                return x >= 0 && x <= view.getWidth() && y >= 0 && y <= view.getHeight();
            }

            public void revert(){
                linearLayout.setBackground(originalBackground);
                linearLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                Log.d("TAGTAGTAGTAGTAG", "revert: ");
            }
        };
    }

}
