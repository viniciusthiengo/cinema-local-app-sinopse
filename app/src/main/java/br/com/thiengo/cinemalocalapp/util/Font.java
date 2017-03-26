package br.com.thiengo.cinemalocalapp.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;


public class Font {

    /*public static void setFFDinBold(TextView tv){
        Typeface face = Typeface.createFromAsset( tv.getContext().getAssets(), "font/FF_DIN_Condensed_Bold.ttf");
        tv.setTypeface( face );
    }

    public static void setFFDinMedium(TextView tv, int... style){
        Typeface face = Typeface.createFromAsset( tv.getContext().getAssets(), "font/FF_DIN_Condensed_Medium.otf");

        if( style.length > 0 ){
            tv.setTypeface( face, style[0] );
        }
        else{
            tv.setTypeface( face );
        }
    }*/

    public static void setFascinateInline(TextView tv){
        Typeface face = Typeface.createFromAsset( tv.getContext().getAssets(), "FascinateInline.ttf");
        tv.setTypeface( face );
    }

    public static Typeface getFascinateInline(Context context){
        return Typeface.createFromAsset( context.getAssets(), "FascinateInline.ttf");
    }

    public static void setAmaticSC(TextView tv){
        Typeface face = Typeface.createFromAsset( tv.getContext().getAssets(), "AmaticSC.ttf");
        tv.setTypeface( face );
    }

    public static Typeface getAmaticSC(Context context){
        return Typeface.createFromAsset( context.getAssets(), "AmaticSC.ttf");
    }
}
