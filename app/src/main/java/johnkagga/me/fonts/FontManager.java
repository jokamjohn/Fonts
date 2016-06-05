package johnkagga.me.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontManager {

    //Font directory
    public static final String ROOT = "fonts/";
    public static final String FONT_AWESOME = ROOT + "fontawesome-webfont.ttf";

    /**
     * Get the font file.
     *
     * @param context Application Context
     * @param font Font Path
     * @return Typeface
     */
    public static Typeface getTypeFace(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

    /**
     * Apply a type face to all Text views in a view group.
     *
     * @param view Android view resource
     * @param typeface Typeface
     */
    public static void markAsIconContainer(View view, Typeface typeface) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                markAsIconContainer(child, typeface);
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setTypeface(typeface);
        }
    }
}
