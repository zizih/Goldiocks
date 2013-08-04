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
public class Page07 extends PageView {

    private GifMovieView window;
    private GifMovieView girl;

    public Page07(Context context) {
        super(context, R.layout.page07);
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p07);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(6));

        //get view
        window = (GifMovieView) page.findViewById(R.id.gif_p07_window);
        girl = (GifMovieView) page.findViewById(R.id.gif_p07_girl);
        window.setMovieAsset(ctx.getString(R.string.p07_window));
        girl.setMovieAsset(ctx.getString(R.string.p07_girl));

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
        window.Clear();
        girl.Clear();
    }
}