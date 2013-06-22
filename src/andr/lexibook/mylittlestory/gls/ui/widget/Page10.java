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

        params = (AbsoluteLayout.LayoutParams) bb.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_bb_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_bb_y));
        bb.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) fa.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_fa_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_fa_y));
        fa.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) girl.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_girl_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_girl_y));
        girl.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) ma.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_ma_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_ma_y));
        ma.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p10);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(9));
    }
}
