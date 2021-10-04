package fr.tncy.amio;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

import fr.tncy.amio.widget.LampView;

public class MainActivity extends Activity {


    private LampView viewLigh1;
    private LampView viewLigh2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewLigh1 = new LampView(1, this, R.id.imgLight1, R.id.txtLight1);
        viewLigh1.init();
        viewLigh2 = new LampView(2, this, R.id.imgLight2, R.id.txtLight2);
        viewLigh2.init();
    }
}
