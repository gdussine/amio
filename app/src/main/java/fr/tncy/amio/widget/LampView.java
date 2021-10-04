package fr.tncy.amio.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import fr.tncy.amio.R;

public class LampView {

    private ImageView im;
    private int id;
    private TextView txt;
    private Activity activity;

    private final Bitmap PNG_OFF;
    private final Bitmap PNG_ON;

    public LampView(int id, Activity activity, ImageView im, TextView txt) {
        this.im = im;
        this.id = id;
        this.txt = txt;
        this.activity = activity;
        this.PNG_OFF = getBitmapFromAsset("images/lightOff.png");
        this.PNG_ON = getBitmapFromAsset("images/lightOn.png");
    }

    public void init(){
        toogleImage(0);
        txt.setText("Lampe " + id);
    }

    public LampView(int id, Activity activity, int idImage, int idText) {
        this(id, activity, activity.findViewById(idImage), activity.findViewById(idText));
    }


    public ImageView getIm() {
        return im;
    }

    public void setIm(ImageView im) {
        this.im = im;
    }

    public int getId() {
        return id;
    }

    public TextView getTxt() {
        return txt;
    }

    public void setTxt(TextView txt) {
        this.txt = txt;
    }

    public void toogleImage(double value){
        im.setImageBitmap(value<90?PNG_OFF:PNG_ON);
    }

    private Bitmap getBitmapFromAsset(String strName) {
        try {
            AssetManager assetManager = activity.getAssets();
            return BitmapFactory.decodeStream(assetManager.open(strName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
