package andr.lexibook.mylittlestory.gls.ui;

import andr.lexibook.mylittlestory.gls.control.BgSrc;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

/**
 * @author hezi
 */
public class Splash extends BaseActivity implements View.OnClickListener {

    private Button btn_splash_bg;
    private boolean toMenued = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        bgSrc = BgSrc.getInstance(this);
        btn_splash_bg = (Button) findViewById(R.id.btn_splash_bg);
        btn_splash_bg.setOnClickListener(this);
        refreshBg();

        mPlayer = mediaFactory.getSplash();
        try {
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!toMenued)
                    toMenu();
            }
        }, 3000);

    }

    @Override
    public void onClick(View view) {
        if (!toMenued)
            toMenu();
    }

    private void toMenu() {
        toMenued = true;
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
        if (setting.isFirst()) {
            setting.setFirst(false);
            setting.save();
            toPage(LangSelect.class);
        } else {
            toPage(Menu.class);
        }
        finish();
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        refreshBg();
    }

    private void refreshBg() {
        Toast.makeText(this, "no splash image ..", 1000).show();
        //this.btn_splash_bg.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getSplashDrawable());
    }

}
