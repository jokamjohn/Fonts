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
}
