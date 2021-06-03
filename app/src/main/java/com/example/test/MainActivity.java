package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.test.adapter.BannerMoviesPageAdapter;
import com.example.test.adapter.MainRecyclerAdapter;
import com.example.test.model.AllCategory;
import com.example.test.model.BannerMovies;
import com.example.test.model.Categoryitem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPageAdapter bannerMoviesPageAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> OriginalsBannerList;
    List<BannerMovies> MoviesBannerList;
    List<BannerMovies> VideosBannerList;
    Timer sliderTimer;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tableLayout);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "Detective Pikachu", "https://images-na.ssl-images-amazon.com/images/I/71+PKDjuooL.jpg", ""));
        homeBannerList.add(new BannerMovies(2, "The Lord of the Rings", "https://www.closeup-shop.com/media/oart_0/oart_h/oart_92448/thumbs/961564_2574676.jpg", ""));

        OriginalsBannerList = new ArrayList<>();
        OriginalsBannerList.add(new BannerMovies(1, "Z43", "https://pbs.twimg.com/media/EpP3-z5VgAAAPmz.jpg", ""));
        OriginalsBannerList.add(new BannerMovies(2, "Shepherds From Hell", "https://m.media-amazon.com/images/M/MV5BNWIzNjQyOTAtNDk4Ni00OWU2LTk5YjctZjY1N2I5ODQ2M2NhXkEyXkFqcGdeQXVyODY5MDc4OTg@._V1_.jpg", ""));

        MoviesBannerList = new ArrayList<>();
        MoviesBannerList.add(new BannerMovies(1, "Sherlock Holmes", "https://images-na.ssl-images-amazon.com/images/I/71aUiyD1y5L._SY606_.jpg", ""));
        MoviesBannerList.add(new BannerMovies(2, "Silence Of Sleep", "https://m.media-amazon.com/images/M/MV5BM2U1MWE3ZmQtZDUwNi00YTgxLTk5M2QtMDk3ZWNiMDkyYjc2XkEyXkFqcGdeQXVyMjAzMDA2Njc@._V1_.jpg", ""));

        VideosBannerList= new ArrayList<>();
        VideosBannerList.add(new BannerMovies(1, "KhushFemiyaan", "https://assets-news-bcdn.dailyhunt.in/cmd/resize/400x400_80//fetchdata15/images/17/84/24/178424f94aefb4a7e9af099c9cc81a8d.jpg", ""));
        VideosBannerList.add(new BannerMovies(2, "Hunting the KennyS Stickers", "https://i.ytimg.com/vi/OiPKtx-OS3g/maxresdefault.jpg", ""));

        setBannerMoviesPageAdapter(homeBannerList);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerMoviesPageAdapter(OriginalsBannerList);
                        return;
                    case 2:
                        setBannerMoviesPageAdapter(MoviesBannerList);
                        return;

                    case 3:
                        setBannerMoviesPageAdapter(VideosBannerList);
                        return;
                    default:
                        setBannerMoviesPageAdapter(homeBannerList);

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<Categoryitem> homeCatListItem1= new ArrayList<>();
        homeCatListItem1.add(new Categoryitem(1,"SuperNatural","https://i.pinimg.com/736x/75/e5/4c/75e54cabfb389c4397f981ca99ed6db6.jpg",""));
        homeCatListItem1.add(new Categoryitem(2,"JL50","data:image/jpeg;base64,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",""));
        homeCatListItem1.add(new Categoryitem(3,"Jamtara","data:image/jpeg;base64,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",""));

        List<Categoryitem> homeCatListItem2= new ArrayList<>();
        homeCatListItem2.add(new Categoryitem(1,"Detective Pikachu","https://images-na.ssl-images-amazon.com/images/I/71+PKDjuooL.jpg",""));
        homeCatListItem2.add(new Categoryitem(2,"The Lord of the Rings","https://www.closeup-shop.com/media/oart_0/oart_h/oart_92448/thumbs/961564_2574676.jpg",""));
        homeCatListItem2.add(new Categoryitem(3,"Sherlock Holmes","https://images-na.ssl-images-amazon.com/images/I/71aUiyD1y5L._SY606_.jpg",""));

        List<Categoryitem> homeCatListItem3= new ArrayList<>();
        homeCatListItem3.add(new Categoryitem(1,"KhushFemiyaan","https://assets-news-bcdn.dailyhunt.in/cmd/resize/400x400_80//fetchdata15/images/17/84/24/178424f94aefb4a7e9af099c9cc81a8d.jpg",""));
        homeCatListItem3.add(new Categoryitem(2,"Hunting the KennyS Stickers","https://i.ytimg.com/vi/OiPKtx-OS3g/maxresdefault.jpg",""));
        homeCatListItem3.add(new Categoryitem(3,"Z43","https://pbs.twimg.com/media/EpP3-z5VgAAAPmz.jpg",""));


        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Originals",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Non Fiction",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Exclusive",homeCatListItem3));


        setMainRecycler(allCategoryList);
    }

    private void setBannerMoviesPageAdapter(List<BannerMovies>bannerMoviesList){

        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPageAdapter = new BannerMoviesPageAdapter(this,bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPageAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3500, 6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesViewPager.getCurrentItem() < (bannerMoviesViewPager.getCurrentItem() - 1)){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem()+1);
                    }
                    else
                    bannerMoviesViewPager.setCurrentItem(0);
                }
            });
        }
    }
    public void setMainRecycler(List<AllCategory>allCategoryList){

        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);

    }
}