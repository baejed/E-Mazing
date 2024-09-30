package com.example.e_mazing;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

import java.security.KeyPair;

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
                String output = "";
                String key = txtKey.getText().toString();
                String message = txtMessage.getText().toString();
                txtOutput.setTextColor(Color.BLACK);
                int errorColor = Color.parseColor("#AA0000");

                switch ((int) spinnerEncrypt.getSelectedItemId()) {
                    case 0:
                        try {
                            if (key.isEmpty()) {
                                key = AES.generateAESKey();
                                txtKey.setText(key);
                            }

                            output = AES.encrypt(key, message);
                        } catch (Exception e) {
                            output = e.getMessage();
                            txtOutput.setTextColor(errorColor);
                        }

                        txtOutput.setText(output);
                        break;
                    case 1:
                        try {
                            KeyPair keyPair = RSA.generateRSAKeyPair();
                            String keyInfo = "";

                            if (key.isEmpty()) {
                                key = RSA.publicKeyToString(keyPair.getPublic());
                                String decryptKey = RSA.privateKeyToString(keyPair.getPrivate());
                                txtKey.setText(key);
                                keyInfo = "\n\nDECRYPT KEY:\n" + decryptKey;
                            }

                            output = RSA.encrypt(key, message);
                            output += keyInfo;
                        } catch (Exception e) {
                            output = e.getMessage();
                            txtOutput.setTextColor(errorColor);
                        }

                        txtOutput.setText(output);
                        break;
                    case 2:
                        try {
                            if (key.isEmpty()) {
                                key = DES.generateDESKey();
                                txtKey.setText(key);
                            }

                            output = DES.encrypt(key, message);
                        } catch (Exception e) {
                            output = e.getMessage();
                            txtOutput.setTextColor(errorColor);
                        }

                        txtOutput.setText(output);
                        break;
                    case 3:
                        try {
                            if (key.isEmpty()) {
                                key = Blowfish.generateBlowfishKey();
                                txtKey.setText(key);
                            }

                            output = Blowfish.encrypt(key, message);
                        } catch (Exception e) {
                            output = e.getMessage();
                            txtOutput.setTextColor(errorColor);
                        }

                        txtOutput.setText(output);
                        break;
                    case 4:
                        try {
                            if (key.isEmpty()) {
                                key = Vigenere64.generateKey();
                                txtKey.setText(key);
                            }

                            output = Vigenere64.encrypt(key, message);
                        } catch (Exception e) {
                            output = e.getMessage();
                            txtOutput.setTextColor(errorColor);
                        }

                        txtOutput.setText(output);
                        break;
                }
            }
        });

        // these additions below make it so that input data persists after navigation -ionvop
        this.spinnerEncrypt.setSelection(Session.encryptMode);
        this.txtMessage.setText(Session.encryptMessage);
        this.txtKey.setText(Session.encryptKey);
        this.txtOutput.setText(Session.encryptOutput);

        this.spinnerEncrypt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Session.encryptMode = (int) id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        this.txtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Session.encryptMessage = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        this.txtKey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Session.encryptKey = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        this.txtOutput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Session.encryptOutput = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        // -ionvop

        this.btnSpinner.setOnClickListener(Control.activateSpinner(spinnerEncrypt));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}