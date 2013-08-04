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
public class Page01 extends PageView {

    private GifMovieView door;
    private GifMovieView flower;
    private GifMovieView girl;
    private GifMovieView tree;

    public Page01(Context context) {
        super(context, R.layout.page01);
        door = (GifMovieView) page.findViewById(R.id.gif_p01_door);
        flower = (GifMovieView) page.findViewById(R.id.gif_p01_flower);
        girl = (GifMovieView) page.findViewById(R.id.gif_p01_girl);
        tree = (GifMovieView) page.findViewById(R.id.gif_p01_tree);

        door.setMovieAsset(context.getString(R.string.p01_door));
        flower.setMovieAsset(context.getString(R.string.p01_flower));
        girl.setMovieAsset(context.getString(R.string.p01_girl));
        tree.setMovieAsset(context.getString(R.string.p01_tree));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p01);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(0));

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
        door.Clear();
        flower.Clear();
        girl.Clear();
        tree.Clear();
    }
}
