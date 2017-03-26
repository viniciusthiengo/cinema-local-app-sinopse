package br.com.thiengo.cinemalocalapp.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;


public class CustomTypefaceSpan extends TypefaceSpan {

    private final Typeface newTypeFace;

    public CustomTypefaceSpan( String family, Typeface type ) {
        super(family);
        newTypeFace = type;
    }

    @Override
    public void updateDrawState( TextPaint paint ) {
        paint.setTypeface( newTypeFace );
        //applyCustomTypeFace( textPaint, newTypeFace );
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        paint.setTypeface( newTypeFace );
        //applyCustomTypeFace( paint, newTypeFace );
    }

    private static void applyCustomTypeFace(Paint paint, Typeface typeface) {
        int styleAnterior;
        Typeface typefaceAnterior = paint.getTypeface();

        if( typefaceAnterior == null ) {
            styleAnterior = 0;
        } else {
            styleAnterior = typefaceAnterior.getStyle();
        }

        // PARA VERIFICAR A COMPATIBILIDADE DE ESTILOS
        int fake = styleAnterior & ~typeface.getStyle();

        /*
         * VERIFICA SE A FONTE MAIS ATUAL JÁ ESTÁ DE ACORDO
         * COM A ANTERIOR EM TERMOS DE "TEXTO EM NEGRITO",
         * CASO NÃO, ATUALIZA.
         * */
        if ( (fake & Typeface.BOLD) != 0 ) {
            paint.setFakeBoldText(true);
        }

        /*
         * VERIFICA SE A FONTE MAIS ATUAL JÁ ESTÁ DE ACORDO
         * COM A ANTERIOR EM TERMOS DE "TEXTO EM ITÁLICO",
         * CASO NÃO, ATUALIZA.
         * */
        if ( (fake & Typeface.ITALIC) != 0 ) {
            paint.setTextSkewX(-0.25f);
        }

        // APLICA A FONTE
        paint.setTypeface( typeface );
    }
}
