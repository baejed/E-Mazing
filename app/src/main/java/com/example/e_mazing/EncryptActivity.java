package com.example.e_mazing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Conroller.Control;
import Conroller.Navigator;
import Resources.ColorString;
import Resources.Painter;

public class EncryptActivity extends AppCompatActivity {

    TextView txtAppName, txtMessage, txtKey, txtOutput;
    ImageView navHome, navDecrypt, navEncryptionList, navInfo, btnSpinner;
    Spinner spinnerEncrypt;
    LinearLayout btnEncode;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_encrypt);

        this.txtAppName = findViewById(R.id.txtAppName);
        this.txtMessage = findViewById(R.id.txtMessage);
        this.txtKey = findViewById(R.id.txtKey);
        this.txtOutput = findViewById(R.id.txtOutput);

        this.navHome = findViewById(R.id.navHome);
        this.navDecrypt = findViewById(R.id.navDecrypt);
        this.navEncryptionList = findViewById(R.id.navEncryptionList);
        this.navInfo = findViewById(R.id.navInfo);
        this.btnSpinner = findViewById(R.id.btnSpinner);

        this.btnEncode = findViewById(R.id.btnEncode);

        this.spinnerEncrypt = findViewById(R.id.spinnerEncrypt);

        //gi set ang destination sa navs
        this.navHome.setOnClickListener(Navigator.goToHome(EncryptActivity.this));
        this.navDecrypt.setOnClickListener(Navigator.goToDecryptActivity(EncryptActivity.this));
        this.navEncryptionList.setOnClickListener(Navigator.goToEncryptionListActivity(EncryptActivity.this));
        this.navInfo.setOnClickListener(Navigator.goToInfoActivity(EncryptActivity.this));

        // gi set ang design sa spinner (combo box), and gi initialize ang iyang contents
        this.adapter = ArrayAdapter.createFromResource(this, R.array.encryptions_algs, R.layout.spinner_item);

        this.adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        this.spinnerEncrypt.setAdapter(adapter);
        // end

        // para gradient ang color sa app name
        Painter.paintTxtGradient(txtAppName, ColorString.GREEN, ColorString.LIGHT_GREEN);

        this.btnEncode.setOnTouchListener(Painter.tapHighlightEffect(EncryptActivity.this, btnEncode));
        this.btnEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output = "enc: " + spinnerEncrypt.getSelectedItem() +
                        "\nmsg: " + txtMessage.getText() +
                        "\nkey: " + txtKey.getText();
                Log.d("HAHAHAHAHAHA", output);
                txtOutput.setText(output);
            }
        });

        this.btnSpinner.setOnClickListener(Control.activateSpinner(spinnerEncrypt));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}