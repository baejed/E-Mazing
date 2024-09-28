package com.example.e_mazing;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Conroller.Navigator;
import Resources.ColorString;
import Resources.EncryptionDetails;
import Resources.Painter;

public class HomeActivity extends AppCompatActivity {


    TextView txtAppName, txtEncName1, txtEncName2;
    ImageView navEncrypt, navDecrypt, navEncryptionList, navInfo;
    LinearLayout btnEncrypt, btnSeeMore, encryption1, encryption2, underline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        this.txtAppName = findViewById(R.id.txtAppName);
        this.txtEncName1 = findViewById(R.id.txtEncName1);
        this.txtEncName2 = findViewById(R.id.txtEncName2);

        this.navEncrypt = findViewById(R.id.navEncrypt);
        this.navDecrypt = findViewById(R.id.navDecrypt);
        this.navEncryptionList = findViewById(R.id.navEncryptionList);
        this.navInfo = findViewById(R.id.navInfo);

        this.btnEncrypt = findViewById(R.id.btnStartEncrypting);
        this.btnSeeMore = findViewById(R.id.btnSeeMore);
        this.encryption1 = findViewById(R.id.encryption1);
        this.encryption2 = findViewById(R.id.encryption2);
        this.underline = findViewById(R.id.btnStartEncryptingUnderline);

        Painter.paintTxtGradient(txtAppName, ColorString.GREEN, ColorString.LIGHT_GREEN);
        Painter.paintTxtGradient(txtEncName1, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtEncName2, ColorString.GREEN, ColorString.DARK_GREEN);

        this.navEncrypt.setOnClickListener(Navigator.goToEncryptActivity(HomeActivity.this));
        this.navDecrypt.setOnClickListener(Navigator.goToDecryptActivity(HomeActivity.this));
        this.navEncryptionList.setOnClickListener(Navigator.goToEncryptionListActivity(HomeActivity.this));
        this.navInfo.setOnClickListener(Navigator.goToInfoActivity(HomeActivity.this));

        this.btnEncrypt.setOnTouchListener(Painter.tapHighlightEffect(HomeActivity.this, underline, getDrawable(R.color.light_green)));
        this.btnEncrypt.setOnClickListener(Navigator.goToEncryptActivity(HomeActivity.this));

        this.btnSeeMore.setOnTouchListener(Painter.tapHighlightEffect(HomeActivity.this, btnSeeMore, getDrawable(R.color.light_green)));
        this.btnSeeMore.setOnClickListener(Navigator.goToEncryptionListActivity(HomeActivity.this));

        this.encryption1.setOnTouchListener(Painter.tapHighlightEffect(HomeActivity.this, encryption1, getDrawable(R.color.light_green)));
        this.encryption1.setOnClickListener(Navigator.showDialog(HomeActivity.this, EncryptionDetails.aesTitle(), EncryptionDetails.aesDescription(), EncryptionDetails.aesFeatures()));

        this.encryption2.setOnTouchListener(Painter.tapHighlightEffect(HomeActivity.this, encryption2, getDrawable(R.color.light_green)));
        this.encryption2.setOnClickListener(Navigator.showDialog(HomeActivity.this, EncryptionDetails.aesTitle(), EncryptionDetails.aesDescription(), EncryptionDetails.aesFeatures()));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}