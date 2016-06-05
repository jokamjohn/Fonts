package johnkagga.me.fonts;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Apply Font awesome to text views
        Typeface fontAwesome = FontManager
                .getCachedFont(getApplicationContext(),FontManager.FONT_AWESOME);

        FontManager
                .markAsIconContainer(findViewById(R.id.icons_container),
                        fontAwesome);

    }

    /**
     * Adding a custom font to a button
     * 1. Add an attrs.xml file to the values folder.
     * 2. Add a style with an item name of the added attribute with the
     * full package name.
     * 3. Create a method that adds the custom font to the button (TextView) since
     * Button extends TextView from the attribute.
     * 4. Create a custom button class and extend the button class.
     * 5. Add the custom button to the xml layout and specify the
     * text (Font key).
     * 6. Done.
     */
}
