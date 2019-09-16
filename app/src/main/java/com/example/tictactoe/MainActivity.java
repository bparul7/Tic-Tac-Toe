package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int user;
    int[] grid = new int[15];
    int[][] winning = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1,4,7}, {2,5,8}, {3,6,9},{1,5,9},{3,5,7}};
    int cnt;
    //String ida[] = {"imageView1", "imageView2", "imageView3", "imageView4", "imageView5", "imageView6", "imageView7", "imageView8", "imageView9"};
    public void make (String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

        public void translate1 () {
//        GridLayout el = (GridLayout)findViewById(R.id.grid1);
//        for (int i=1; i<=el.getChildCount(); i++) {
//            ImageView el1 = ((ImageView)el.getChildAt(i));
//           // el1.setImageResource(R.drawable.yellow);
//            el1.setAlpha(0f);
            ImageView el = (ImageView)findViewById(R.id.imageView1);
            el.setImageResource(R.drawable.plain);
            ImageView el1 = (ImageView)findViewById(R.id.imageView2);
            el1.setImageResource(R.drawable.plain);
            ImageView el2 = (ImageView)findViewById(R.id.imageView3);
            el2.setImageResource(R.drawable.plain);
            ImageView el3 = (ImageView)findViewById(R.id.imageView4);
            el3.setImageResource(R.drawable.plain);
            ImageView el4 = (ImageView)findViewById(R.id.imageView5);
            el4.setImageResource(R.drawable.plain);
            ImageView el5 = (ImageView)findViewById(R.id.imageView6);
            el5.setImageResource(R.drawable.plain);
            ImageView el6 = (ImageView)findViewById(R.id.imageView7);
            el6.setImageResource(R.drawable.plain);
            ImageView el8 = (ImageView)findViewById(R.id.imageView8);
            el8.setImageResource(R.drawable.plain);
            ImageView el9 = (ImageView)findViewById(R.id.imageView9);
            el9.setImageResource(R.drawable.plain);
        }

    public int check () {
        int ans = 0;
        for (int[] arr : winning) {
            int flg = 0;
            int el = -1;
            int ok = 1;
            for (int i : arr) {
                if (flg == 1) {
                    if (grid[i] != el) {
                        ok = 0;
                        break;
                    }
                }
                else {
                    el = grid[i];
                    flg = 1;
                }
            }
            if (ok==1 && el!=2) {
                //make("yes");
                ans = 1;
                return ans;
            }
        }
        return ans;
    }

    public void game (View view) {
        int st = 0;
        ImageView el = (ImageView)view;
        int indx = Integer.parseInt(el.getTag().toString());
        //checking invalid click
       // make("1");
        if (grid[indx] != 2) {
            make ("Invalid Click");
        }
        else {
           // Log.i ("test", "I ENter");
            if (user == 0) {
                grid[indx] = user;
            }
            else {
                grid[indx] = user;
            }
            st = 1;
        }
        //updating image
        if (st == 1) {
            cnt++;
            if (user == 1) {
               // el.setTranslationY(-1000f);
                el.setAlpha(0f);
                el.setImageResource(R.drawable.red);
                el.animate().alphaBy(1f).rotation(1800f).setDuration(1000);
            }
            else {
                //el.setTranslationY(-1000f);
                el.setAlpha(0f);
                el.setImageResource(R.drawable.yellow);
                el.animate().alphaBy(1f).rotation(1800f).setDuration(1000);
            }
            //check whether user has won or not
            st = check();
            //make( "yes:" + st );
            if (st == 1) {
                make("Winner" + user);
                //make previous state
                //translate1();
                start();
                return;
            }
            user = user ^ 1;
            //draw
            if (cnt == 9) {
                make ("DRAW");
                //make previous state
               // translate1();

                start();
            }
        }
    }
    public void start () {
        for (int i=0; i<grid.length; i++)
            grid[i] = 2;
        user = 0;
        cnt = 0;
        //translate each image by some y
        translate1();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }
}
