package de.eMark.presenter.activities.settings;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import de.eMark.R;
import de.eMark.presenter.activities.util.BRActivity;

public class AboutActivity extends BRActivity {
    private TextView policyText;
    private TextView fontAwesomeText;
    private TextView infoText;
    private ImageView redditShare;
    private ImageView twitterShare;
    private ImageView blogShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setupToolbar();
        setToolbarTitle(R.string.Settings_about);
        infoText = findViewById(R.id.info_text);
        policyText = findViewById(R.id.policy_text);
        fontAwesomeText = findViewById(R.id.font_awesome_license);

        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int verCode = pInfo != null ? pInfo.versionCode : 0;

        infoText.setText(
                String.format(Locale.getDefault(), getString(R.string.About_footer), verCode));

        redditShare = findViewById(R.id.reddit_share_button);
        twitterShare = findViewById(R.id.twitter_share_button);
        blogShare = findViewById(R.id.blog_share_button);

        redditShare.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://reddit.com/r/DeutscheeMark/"));
            startActivity(browserIntent);
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.empty_300);
        });

        twitterShare.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/deutsche_emark"));
            startActivity(browserIntent);
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.empty_300);
        });
        blogShare.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://deutsche-emark.org/"));
            startActivity(browserIntent);
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.empty_300);
        });
        policyText.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/emarkproject/eMarkwallet-android/"));
            startActivity(browserIntent);
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.empty_300);
        });
        fontAwesomeText.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://fontawesome.com/license"));
            startActivity(browserIntent);
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.empty_300);
        });
    }
}
