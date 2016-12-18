package perusu.mobolutions.com.resume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Song> songList;
    private SongAdapter songAdapter;

    String[] names = {"Periyanayagam.S", "St.Joseph's College,Trichy", "Bharathidasan College,Erode", "Amala School,Gobi", "Area of intrest", "technical Symposium", "techChips", "Mobolutions, Chennai", "periyamydell@gmail.com", "9500381349", "Gobi,Erode", "About Me"};

    String[] singers = {"App Developer", "M.Sc Computer Science", "B.Sc Information Technology", "IV - X||", "Java & Application Developement", "I - 5 & II - 7", "10,000 views", "Android app development", " ", " ", "Kallipatti - HomeTown", "tap me to know more"};

    String[] ranks = {"I'm", "PG", "UG", "School", "Love to work with", "Prices", "YouTube Channel", "Internship", "Gmail", "Contact", "Native", "About me"};

    String[] years = {"22", "2015-2017", "2012-2015", "2006-2012", "2 yrs", "2015-2016", "3 yrs", "6 Months", " ", " ", " ", " "};


//    int[] pics = {R.drawable.gmail, R.drawable.sjc, R.drawable.bcas, R.drawable.amala, R.drawable.intrest, R.drawable.gmail, R.drawable.gmail, R.drawable.company, R.drawable.gmail, R.drawable.airtel, R.drawable.gmail, R.drawable.about};


    int[] pics = {R.drawable.face, R.drawable.sjc, R.drawable.bcas, R.drawable.amala, R.drawable.intrest, R.drawable.a2, R.drawable.fk, R.drawable.company, R.drawable.gmail, R.drawable.airtel, R.drawable.erode, R.drawable.about};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //Use this setting to improve performance if you know that changes in
        //the content do not change the layout size of the RecyclerView
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }

//        //using a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        /*
        use this in case of gridlayoutmanager
        mLayoutManager = new GridLayoutManager(this,2);
         */
        /*
        use this in case of Staggered GridLayoutManager
         */
//        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);


        mRecyclerView.setLayoutManager(mLayoutManager);

        //intializing an arraylist called songlist
        songList = new ArrayList<>();

        //adding data from arrays to songlist
        for (int i = 0; i < 12; i++) {
            Song song = new Song(names[i], singers[i], ranks[i], pics[i], years[i]);
            songList.add(song);
        }
        //initializing adapter
        songAdapter = new SongAdapter(songList);

        //specifying an adapter to access data, create views and replace the content
        mRecyclerView.setAdapter(songAdapter);
        songAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position) {

                    case 0:
                        Toast.makeText(MainActivity.this, "I am " + names[position], Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        Toast.makeText(MainActivity.this, "I'm currently pursuing " + singers[position], Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, "My under graduation is " + singers[position], Toast.LENGTH_LONG).show();
                        break;

                    case 3:
                        Toast.makeText(MainActivity.this, "I completed my school in matriculation", Toast.LENGTH_LONG).show();
                        break;

                    case 4:
                        Toast.makeText(MainActivity.this, "My ambition is to be an application developer.", Toast.LENGTH_LONG).show();
                        break;

                    case 5:
                        Toast.makeText(MainActivity.this, "Participated in 11 symposium and won Ist price in 5 and IInd price in 7 events.", Toast.LENGTH_LONG).show();
                        break;

                    case 6:
                        Toast.makeText(MainActivity.this, "My hobby is to share technology videos through my channel. " + singers[position], Toast.LENGTH_LONG).show();
                        break;

                    case 7:
                        Toast.makeText(MainActivity.this, "Currently i'm doing internship @ mobolutions", Toast.LENGTH_LONG).show();
                        break;

                    case 8:
                        Toast.makeText(MainActivity.this, "This is my primary email", Toast.LENGTH_LONG).show();
                        break;

                    case 9:
                        Toast.makeText(MainActivity.this, "This is my primary contact number", Toast.LENGTH_LONG).show();
                        break;

                    case 10:
                        Toast.makeText(MainActivity.this, "This is my home town.. :-) ", Toast.LENGTH_LONG).show();
                        break;
                    case 11:
                        Toast.makeText(MainActivity.this, "Am a guy who never give up on the task assigned to me and put all my efforts to fulfill my duty.. ", Toast.LENGTH_LONG).show();
                        break;

                }

            }
        }));

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_grid:
                //use this in case of gridlayoutmanager; 2 indicates no. of columns
                mLayoutManager = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_staggered_grid:
                //use this in case of Staggered GridLayoutManager; 2 indicates no. of columns
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_horizontal:
                //horizontal linear layout
                mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}