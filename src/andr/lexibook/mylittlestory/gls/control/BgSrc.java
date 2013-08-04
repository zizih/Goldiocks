package andr.lexibook.mylittlestory.gls.control;

import andr.lexibook.mylittlestory.gls.ui.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by rain on 5/20/13.
 */
public class BgSrc {

    private Activity ctx;
    private static BgSrc instance;
    private int langId;
    private WeakHashMap<String, SoftReference<Drawable>> drawableCache;
    private Drawable d;
    private Bitmap b;

    private int[] splashs = {R.drawable.eng_splash
            , R.drawable.fra_splash
            , R.drawable.deu_splash
            , R.drawable.esp_splash
            , R.drawable.ita_splash};

    private int[] engs = {R.drawable.p01_eng
            , R.drawable.p02_eng
            , R.drawable.p03_eng
            , R.drawable.p04_eng
            , R.drawable.p05_eng
            , R.drawable.p06_eng
            , R.drawable.p07_eng
            , R.drawable.p08_eng
            , R.drawable.p09_eng
            , R.drawable.p10_eng
            , R.drawable.p11_eng
            , R.drawable.p12_eng
    };

    private int[] fras = {R.drawable.p01_fra
            , R.drawable.p02_fra
            , R.drawable.p03_fra
            , R.drawable.p04_fra
            , R.drawable.p05_fra
            , R.drawable.p06_fra
            , R.drawable.p07_fra
            , R.drawable.p08_fra
            , R.drawable.p09_fra
            , R.drawable.p10_fra
            , R.drawable.p11_fra
            , R.drawable.p12_fra
    };

    private int[] deus = {R.drawable.p01_deu
            , R.drawable.p02_deu
            , R.drawable.p03_deu
            , R.drawable.p04_deu
            , R.drawable.p05_deu
            , R.drawable.p06_deu
            , R.drawable.p07_deu
            , R.drawable.p08_deu
            , R.drawable.p09_deu
            , R.drawable.p10_deu
            , R.drawable.p11_deu
            , R.drawable.p12_deu
    };

    private int[] esps = {R.drawable.p01_esp
            ,R.drawable.p02_esp
            ,R.drawable.p03_esp
            ,R.drawable.p04_esp
            ,R.drawable.p05_esp
            ,R.drawable.p06_esp
            ,R.drawable.p07_esp
            ,R.drawable.p08_esp
            ,R.drawable.p09_esp
            ,R.drawable.p10_esp
            ,R.drawable.p11_esp
            ,R.drawable.p12_esp
    };

    private int[] itas = {R.drawable.p01_ita
            ,R.drawable.p02_ita
            ,R.drawable.p03_ita
            ,R.drawable.p04_ita
            ,R.drawable.p05_ita
            ,R.drawable.p06_ita
            ,R.drawable.p07_ita
            ,R.drawable.p08_ita
            ,R.drawable.p09_ita
            ,R.drawable.p10_ita
            ,R.drawable.p11_ita
            ,R.drawable.p12_ita
    };

    private int[][] langPagesId = {engs, fras, deus, esps, itas};

    private BgSrc(Context ctx) {
        this.ctx = (Activity) ctx;
        drawableCache = new WeakHashMap<String, SoftReference<Drawable>>();
    }

    public static BgSrc getInstance(Context ctx) {
        if (instance == null)
            instance = new BgSrc(ctx);
        return instance;
    }

    public BgSrc setLang(int langId) {
        this.langId = langId;
        return this;
    }

    /**
     * get drawable
     */
    public Drawable getPageDrawable(int pageIndex) {
        if (!drawableCache.containsKey(this.langId + "" + pageIndex) || drawableCache.get(this.langId + "" + pageIndex) == null)
            return getDrawable(langPagesId[this.langId][pageIndex]);
        return drawableCache.get(this.langId + "" + pageIndex).get();
    }

    public Drawable getSplashDrawable() {
        if (!drawableCache.containsKey("splash" + this.langId) || drawableCache.get("splash" + this.langId) == null)
            return getDrawable(splashs[this.langId]);
        return drawableCache.get("splash" + this.langId).get();
    }

    private Drawable getDrawable(int drawableId) {
        return ctx.getResources().getDrawable(drawableId);
    }

    /**
     * get drawablw ID
     */
    public int getPageDrawableId(int pageIndex) {
        return langPagesId[this.langId][pageIndex];
    }

    public int getSplashDrawableId() {
        return splashs[this.langId];
    }

    public void Clear() {
        if (drawableCache == null || drawableCache.isEmpty())
            return;
        for (Map.Entry<String, SoftReference<Drawable>> entry : drawableCache.entrySet()) {
            d = entry.getValue().get();
            if (d != null) {
                b = ((BitmapDrawable) d).getBitmap();
                if (b != null && !b.isRecycled()) {
                    b.recycle();
                }
                b = null;
                d = null;
            }
        }
        drawableCache.clear();
        System.gc();
        System.gc();
    }


    private Drawable play;
    private Drawable pause;

    public Drawable getPlayDrawable() {
        if (play == null) {
            play = ctx.getResources().getDrawable(R.drawable.gdl_play);
        }
        return play;
    }

    public Drawable getPauseDrawable() {
        if (pause == null) {
            pause = ctx.getResources().getDrawable(R.drawable.gdl_pasue);
        }
        return pause;
    }
}
