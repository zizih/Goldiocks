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
public class Page10 extends PageView {

    private GifMovieView bb;
    private GifMovieView fa;
    private GifMovieView girl;
    private GifMovieView ma;

    public Page10(Context context) {
        super(context, R.layout.page10);

        bb = (GifMovieView) page.findViewById(R.id.gif_p10_bb);
        fa = (GifMovieView) page.findViewById(R.id.gif_p10_fa);
        girl = (GifMovieView) page.findViewById(R.id.gif_p10_girl);
        ma = (GifMovieView) page.findViewById(R.id.gif_p10_ma);

        bb.setMovieAsset(ctx.getString(R.string.p10_bb));
        fa.setMovieAsset(ctx.getString(R.string.p10_fa));
        girl.setMovieAsset(ctx.getString(R.string.p10_girl));
        ma.setMovieAsset(ctx.getString(R.string.p10_ma));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p10);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(9));

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
        bb.Clear();
        fa.Clear();
        girl.Clear();
        ma.Clear();
    }
}
