package br.com.thiengo.cinemalocalapp;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.thiengo.cinemalocalapp.data.Mock;
import br.com.thiengo.cinemalocalapp.util.CustomTypefaceSpan;
import br.com.thiengo.cinemalocalapp.util.Font;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        applyToolbarCustomFont();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration( MainActivity.this,DividerItemDecoration.VERTICAL) );
        customFontNavigationViewMenu();

        initRecycler();

        LinearLayout ll = (LinearLayout) navigationView.getHeaderView(0);
        TextView tvNavHeaderTitle = (TextView) ll.getChildAt(0);
        Font.setFascinateInline( tvNavHeaderTitle );
    }

    private void initRecycler(){
        RecyclerView rvFilmes = (RecyclerView) findViewById(R.id.rv_filmes);
        rvFilmes.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvFilmes.setLayoutManager( layoutManager );

        FilmesAdapter adapter = new FilmesAdapter( this, Mock.gerarFilmes() );
        rvFilmes.setAdapter( adapter );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void applyToolbarCustomFont(){
        for(int i = 0; i < toolbar.getChildCount(); i++){
            View view = toolbar.getChildAt(i);
            if(view instanceof TextView){
                TextView tv = (TextView) view;

                if(tv.getText().equals(toolbar.getTitle())){
                    Font.setFascinateInline( tv );
                    break;
                }
            }
        }
    }

    private void customFontNavigationViewMenu(){
        NavigationView navView = (NavigationView) findViewById( R.id.nav_view );
        Menu menu = navView.getMenu();

        for( int i = 0; i < menu.size(); i++ ) {
            MenuItem menuItem = menu.getItem(i);

            /*SubMenu subMenu = menuItem.getSubMenu();
            if( subMenu != null && subMenu.size() > 0 ) {
                for( int j = 0; j < subMenu.size(); j++ ) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    setCustomFontMenuItem(subMenuItem);
                }
            }*/

            setCustomFontMenuItem( menuItem );
        }
    }

    private void setCustomFontMenuItem(MenuItem menuItem) {
        Typeface font = Font.getAmaticSC( this );
        SpannableString textItem = new SpannableString( menuItem.getTitle() );

        textItem.setSpan(
                new CustomTypefaceSpan("" , font),
                0,
                textItem.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE );

        menuItem.setTitle(textItem);
    }
}
