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
public class Page05 extends PageView {

    private GifMovieView chair;
    private GifMovieView girl;
    private GifMovieView smoke;

    public Page05(Context context) {
        super(context, R.layout.page05);

        chair = (GifMovieView) page.findViewById(R.id.gif_p05_chair);
        girl = (GifMovieView) page.findViewById(R.id.gif_p05_girl);
        smoke = (GifMovieView) page.findViewById(R.id.gif_p05_smoke);

        chair.setMovieAsset(ctx.getString(R.string.p05_chair));
        girl.setMovieAsset(ctx.getString(R.string.p05_girl));
        smoke.setMovieAsset(ctx.getString(R.string.p05_smoke));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p05);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(4));

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
        chair.Clear();
        girl.Clear();
        smoke.Clear();
    }
}
