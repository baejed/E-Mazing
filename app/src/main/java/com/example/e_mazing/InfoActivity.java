package com.example.e_mazing;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Conroller.Navigator;
import Resources.ColorString;
import Resources.Painter;

public class InfoActivity extends AppCompatActivity {

    TextView txtAppName, txtRef1, txtRef2, txtRef3, txtRef4, txtCreator1,txtCreator2,txtCreator3;
    ImageView navHome, navEncrypt, navDecrypt, navEncryptionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);

        this.txtAppName = findViewById(R.id.txtAppName);
        this.txtRef1 = findViewById(R.id.txtRef1);
        this.txtRef2 = findViewById(R.id.txtRef2);
        this.txtRef3 = findViewById(R.id.txtRef3);
        this.txtRef4 = findViewById(R.id.txtRef4);
        this.txtCreator1 = findViewById(R.id.txtCreator1);
        this.txtCreator2 = findViewById(R.id.txtCreator2);
        this.txtCreator3 = findViewById(R.id.txtCreator3);

        this.navHome = findViewById(R.id.navHome);
        this.navEncrypt = findViewById(R.id.navEncrypt);
        this.navDecrypt = findViewById(R.id.navDecrypt);
        this.navEncryptionList = findViewById(R.id.navEncryptionList);

        // gi set ang destination sa mga navs
        this.navHome.setOnClickListener(Navigator.goToHome(InfoActivity.this));
        this.navEncrypt.setOnClickListener(Navigator.goToEncryptActivity(InfoActivity.this));
        this.navDecrypt.setOnClickListener(Navigator.goToDecryptActivity(InfoActivity.this));
        this.navEncryptionList.setOnClickListener(Navigator.goToEncryptionListActivity(InfoActivity.this));

        // destination sa mga links (references and creators)
        this.txtRef1.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtRef1, "https://en.wikipedia.org/wiki/Advanced_Encryption_Standard"));
        this.txtRef2.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtRef2, "https://learn.microsoft.com/en-us/windows/win32/seccrypto/data-encryption-and-decryption"));
        this.txtRef3.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtRef3, "https://en.wikipedia.org/wiki/Encryption"));
        this.txtRef4.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtRef4, "https://cloudian.com/guides/data-protection/data-encryption-the-ultimate-guide/#:~:text=Data%20encryption%20is%20a%20security,a%20secret%20key%20or%20password."));
        this.txtCreator1.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtCreator1, "https://github.com/baejed"));
        this.txtCreator2.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtCreator2, "https://github.com/vincealwynsibay"));
        this.txtCreator3.setOnClickListener(Navigator.openUrl(InfoActivity.this, txtCreator3, "https://github.com/ionvop"));

        Painter.paintTxtGradient(txtAppName, ColorString.GREEN, ColorString.LIGHT_GREEN);
        Painter.paintTxtGradient(txtRef1, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtRef2, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtRef3, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtRef4, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtCreator1, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtCreator2, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtCreator3, ColorString.GREEN, ColorString.DARK_GREEN);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}