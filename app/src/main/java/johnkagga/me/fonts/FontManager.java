package johnkagga.me.fonts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Hashtable;

public class FontManager {

    //Font directory
    public static final String ROOT = "fonts/";
    public static final String FONT_AWESOME = ROOT + "fontawesome-webfont.ttf";

    /**
     * Get the font file.
     *
     * @param context Application Context
     * @param font    Font Path
     * @return Typeface
     */
    public static Typeface getTypeFace(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

    /**
     * Apply a type face to all Text views in a view group.
     *
     * @param view     Android view resource
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

    //Cache Table for the fonts.
    public static final Hashtable<String, Typeface> fontCache = new Hashtable<>();

    /**
     * Get the font from the cache in order to avoid memory leaks.
     * Especially on older Android Devices.
     *
     * @param context
     * @param font
     * @return
     */
    public static Typeface getCachedFont(Context context, String font) {
        Typeface typeface = fontCache.get(font);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), font);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(font, typeface);
        }
        return typeface;
    }

    /**
     * Set a custom font for the text view.
     *
     * @param context
     * @param font
     * @param textView
     */
    public static void setFont(Context context, String font, TextView textView) {
        if (font == null) {
            return;
        }

        Typeface typeface = getCachedFont(context, font);

        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    /**
     * Sets a font on a text view based on the custom com.my.package:font attribute
     * If the custom font attribute isn't found in the attributes nothing happens
     *
     * @param context
     * @param textView
     * @param attr
     */
    public static void setCustomFont(Context context, TextView textView, AttributeSet attr) {
        TypedArray typedArray = context.obtainStyledAttributes(attr, R.styleable.fontAwesome);
        String font = typedArray.getString(R.styleable.fontAwesome_font);
        setFont(context, font, textView);
        typedArray.recycle();
    }
}
