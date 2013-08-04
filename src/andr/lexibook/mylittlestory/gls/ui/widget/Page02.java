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
public class Page02 extends PageView {

    private GifMovieView flower;
    private GifMovieView girl;

    @SuppressWarnings("deprecation")
    public Page02(Context context) {
        super(context, R.layout.page02);
        //abgout layout
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p02);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(1));

        //get View
        flower = (GifMovieView) page.findViewById(R.id.gif_p02_flower);
        girl = (GifMovieView) page.findViewById(R.id.gif_p02_girl);
        flower.setMovieAsset(ctx.getString(R.string.p02_flower));
        girl.setMovieAsset(ctx.getString(R.string.p02_girl));

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
        flower.Clear();
        girl.Clear();
    }
}
