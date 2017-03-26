package br.com.thiengo.cinemalocalapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import br.com.thiengo.cinemalocalapp.domain.Filme;

/**
 * Created by viniciusthiengo on 23/03/17.
 */

public class SPFilme {
    private static final String PREF = "pref";


    public static void saveFilmeVisualizado(Context context, String urlImagemFilme){
        SharedPreferences sp = context.getSharedPreferences( PREF, Context.MODE_PRIVATE );
        sp.edit().putBoolean( urlImagemFilme, true ).apply();
    }

    public static boolean hasFilmeAindaNaoVisualizado(Context context, List<Filme> filmes){
        SharedPreferences sp = context.getSharedPreferences( PREF, Context.MODE_PRIVATE );

        for( Filme f : filmes ){
            boolean status = sp.getBoolean( f.getUrlImagem(), false );
            if( !status ){
                return true;
            }
        }

        return false;
    }

    public static Filme getFilmeMaisAtualNaoVisualizado( Context context, List<Filme> filmes ){
        SharedPreferences sp = context.getSharedPreferences( PREF, Context.MODE_PRIVATE );

        for( Filme f : filmes ){
            boolean status = sp.getBoolean( f.getUrlImagem(), false );
            if( !status ){
                return f;
            }
        }

        return null;
    }
}
