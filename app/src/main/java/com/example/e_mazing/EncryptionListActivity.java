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

public class EncryptionListActivity extends AppCompatActivity {

    TextView txtAppName, txtEncName1, txtEncName2, txtEncName3, txtEncName4, txtEncName5;
    ImageView navHome, navEncrypt, navDecrypt, navInfo;
    LinearLayout encryption1, encryption2, encryption3, encryption4, encryption5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_encryption_list);

        this.txtAppName = findViewById(R.id.txtAppName);
        this.txtEncName1 = findViewById(R.id.txtEncName1);
        this.txtEncName2 = findViewById(R.id.txtEncName2);
        this.txtEncName3 = findViewById(R.id.txtEncName3);
        this.txtEncName4 = findViewById(R.id.txtEncName4);
        this.txtEncName5 = findViewById(R.id.txtEncName5);

        this.navHome = findViewById(R.id.navHome);
        this.navEncrypt = findViewById(R.id.navEncrypt);
        this.navDecrypt = findViewById(R.id.navDecrypt);
        this.navInfo = findViewById(R.id.navInfo);

        this.encryption1 = findViewById(R.id.encryption1);
        this.encryption2 = findViewById(R.id.encryption2);
        this.encryption3 = findViewById(R.id.encryption3);
        this.encryption4 = findViewById(R.id.encryption4);
        this.encryption5 = findViewById(R.id.encryption5);

        // gi gradient ang ilang background
        Painter.paintTxtGradient(txtAppName, ColorString.GREEN, ColorString.LIGHT_GREEN);
        Painter.paintTxtGradient(txtEncName1, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtEncName2, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtEncName3, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtEncName4, ColorString.GREEN, ColorString.DARK_GREEN);
        Painter.paintTxtGradient(txtEncName5, ColorString.GREEN, ColorString.DARK_GREEN);

        //gi set ang destination sa navs
        this.navHome.setOnClickListener(Navigator.goToHome(EncryptionListActivity.this));
        this.navEncrypt.setOnClickListener(Navigator.goToEncryptActivity(EncryptionListActivity.this));
        this.navDecrypt.setOnClickListener(Navigator.goToDecryptActivity(EncryptionListActivity.this));
        this.navInfo.setOnClickListener(Navigator.goToInfoActivity(EncryptionListActivity.this));

        //gi set ang modals
        this.encryption1.setOnClickListener(Navigator.showDialog(EncryptionListActivity.this, EncryptionDetails.aesTitle(), EncryptionDetails.aesDescription(), EncryptionDetails.aesFeatures()));
        this.encryption2.setOnClickListener(Navigator.showDialog(EncryptionListActivity.this, EncryptionDetails.rsaTitle(), EncryptionDetails.rsaDescription(), EncryptionDetails.rsaFeatures()));
        this.encryption3.setOnClickListener(Navigator.showDialog(EncryptionListActivity.this, EncryptionDetails.desTitle(), EncryptionDetails.desDescription(), EncryptionDetails.desFeatures()));
        this.encryption4.setOnClickListener(Navigator.showDialog(EncryptionListActivity.this, EncryptionDetails.blowfishTitle(), EncryptionDetails.blowfishDescription(), EncryptionDetails.blowfishFeatures()));
        this.encryption5.setOnClickListener(Navigator.showDialog(EncryptionListActivity.this, EncryptionDetails.v64Title(), EncryptionDetails.v64Description(), EncryptionDetails.v64Features()));

        // gi set ang highlight tap effect
        this.encryption1.setOnTouchListener(Painter.tapHighlightEffect(EncryptionListActivity.this, encryption1, getDrawable(R.color.light_green)));
        this.encryption2.setOnTouchListener(Painter.tapHighlightEffect(EncryptionListActivity.this, encryption2, getDrawable(R.color.light_green)));
        this.encryption3.setOnTouchListener(Painter.tapHighlightEffect(EncryptionListActivity.this, encryption3, getDrawable(R.color.light_green)));
        this.encryption4.setOnTouchListener(Painter.tapHighlightEffect(EncryptionListActivity.this, encryption4, getDrawable(R.color.light_green)));
        this.encryption5.setOnTouchListener(Painter.tapHighlightEffect(EncryptionListActivity.this, encryption5, getDrawable(R.color.light_green)));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}