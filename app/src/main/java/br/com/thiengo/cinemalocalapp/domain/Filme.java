package br.com.thiengo.cinemalocalapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by viniciusthiengo on 03/03/17.
 */

public class Filme implements Parcelable {
    public static final String KEY = "filme";

    private String nome;
    private String urlImagem;
    private int numSalas;
    private String sinopse;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public int getNumSalas() {
        return numSalas;
    }

    public void setNumSalas(int numSalas) {
        this.numSalas = numSalas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeString(this.urlImagem);
        dest.writeInt(this.numSalas);
        dest.writeString(this.sinopse);
    }

    public Filme() {
    }

    protected Filme(Parcel in) {
        this.nome = in.readString();
        this.urlImagem = in.readString();
        this.numSalas = in.readInt();
        this.sinopse = in.readString();
    }

    public static final Parcelable.Creator<Filme> CREATOR = new Parcelable.Creator<Filme>() {
        @Override
        public Filme createFromParcel(Parcel source) {
            return new Filme(source);
        }

        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };
}
