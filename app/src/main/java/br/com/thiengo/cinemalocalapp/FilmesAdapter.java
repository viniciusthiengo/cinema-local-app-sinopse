package br.com.thiengo.cinemalocalapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.thiengo.cinemalocalapp.data.Font;
import br.com.thiengo.cinemalocalapp.domain.Filme;


public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.ViewHolder> {
    private MainActivity activity;
    private ArrayList<Filme> filmes;

    public FilmesAdapter( MainActivity activity, ArrayList<Filme> filmes){
        this.activity = activity;
        this.filmes = filmes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from( parent.getContext() )
                .inflate(R.layout.item_filme, parent, false);
        ViewHolder viewHolder = new ViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setDados( filmes.get( position ) );
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivFilme;
        private TextView tvNome;
        private TextView tvQtdSalas;

        private ViewHolder(View itemView) {
            super(itemView);

            ivFilme = (ImageView) itemView.findViewById(R.id.iv_filme);
            tvNome = (TextView) itemView.findViewById(R.id.tv_nome);
            tvQtdSalas = (TextView) itemView.findViewById(R.id.tv_qtd_salas);
            Font.setFascinateInline( tvNome );
            Font.setAmaticSC( tvQtdSalas );

            itemView.setOnClickListener(this);
        }

        private void setDados( Filme filme ){
            Picasso.with( activity )
                    .load( filme.getUrlImagem() )
                    .into( ivFilme );

            tvNome.setText( filme.getNome() );
            tvQtdSalas.setText( "Salas com o filme: " + filme.getNumSalas() );
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent( activity, DetalhesActivity.class );
            intent.putExtra(Filme.KEY, filmes.get( getAdapterPosition() ));
            activity.startActivity( intent );
        }
    }
}
