package com.example.nscpl_aqib.imagesharpenningex;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imViewAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imViewAndroid = (ImageView) findViewById(R.id.imViewAndroid);
        imViewAndroid.setImageBitmap(sharpenImage(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 12));
    }

    public Bitmap sharpenImage(Bitmap src, double weight) {
        // set sharpness configuration
        double[][] SharpConfig = new double[][]{
                {0, -2, 0},
                {-1, weight, -1},
                {0, -2, 0}
        };
        //create convolution matrix instance
        ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
        //apply configuration
        convMatrix.applyConfig(SharpConfig);
        //set weight according to factor
        convMatrix.Factor = weight - 8;
        return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);

    }
}