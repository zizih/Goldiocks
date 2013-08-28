package andr.lexibook.mylittlestory.gls.ui.widget;

import andr.lexibook.mylittlestory.gls.ui.R;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.gls.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Page09 extends PageView {

    private GifMovieView fa;
    private GifMovieView girl;
    private GifMovieView ma;
    private AbsoluteLayout bb;

    public Page09(Context context) {
        super(context, R.layout.page09);

        fa = (GifMovieView) page.findViewById(R.id.gif_p09_fa);
        girl = (GifMovieView) page.findViewById(R.id.gif_p09_girl);
        ma = (GifMovieView) page.findViewById(R.id.gif_p09_ma);
        bb = (AbsoluteLayout) page.findViewById(R.id.al_bb);

        fa.setMovieAsset(ctx.getString(R.string.p09_fa));
        girl.setMovieAsset(ctx.getString(R.string.p09_girl));
        ma.setMovieAsset(ctx.getString(R.string.p09_ma));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p09);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(8));

        //dynamic
        params = (AbsoluteLayout.LayoutParams) bb.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        bb.setLayoutParams(params);


        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_y));
            params.width = (int) (getWidthScale() * 45);
            params.height = (int) (getWidthScale() * 45);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        fa.Clear();
        girl.Clear();
        ma.Clear();
    }
}
