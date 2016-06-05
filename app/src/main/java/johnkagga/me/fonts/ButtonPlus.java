package johnkagga.me.fonts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonPlus extends Button {

    public ButtonPlus(Context context) {
        super(context);
    }

    public ButtonPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontManager.setCustomFont(context,this,attrs);
    }

    public ButtonPlus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        FontManager.setCustomFont(context,this,attrs);
    }
}
