package com.example.saad1.helloworld;


import android.media.Image;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;
import static java.lang.Math.floor;



public class MainActivity extends AppCompatActivity {


    int count=0;
    int sum1=0;
    int sum2=0;
    int[] xArray=new int[10];
    int[] yArray=new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setArrays();
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void roll(View view) {

        Random rand = new Random();
        int roll = /*rand.nextInt(6) + */1;
        Button b = (Button) findViewById(R.id.button2);
        TextView twin=(TextView)findViewById(R.id.textView2);
        b.setText(Integer.toString(roll));


        if (count == 0)
        {
            sum1 = sum1 + roll;
            if(sum1>100)
            {
                sum1=sum1-roll;
                return;
            }
            ImageView img1 = (ImageView) findViewById(R.id.imageView4);
            move(sum1, img1);

         }

        if(count == 1)
        {
            sum2 = sum2 + roll;
            if(sum2>100)
            {
                sum2=sum2-roll;
                return;
            }
            ImageView img2 = (ImageView) findViewById(R.id.imageView6);
            move(sum2, img2);

        }

        if(roll!=6 && count==0)
        {
            count = 1;
            b.setBackgroundResource(R.drawable.redroundbutton);
            return;
        }
        if(roll!=6 && count==1)
        {
            count = 0;
            b.setBackgroundResource(R.drawable.roundbutton);
            return;
        }
        if(sum1==100)
        {
            twin.setText("You Won");
            return;
        }
        if(sum2==100)
        {
            twin.setText("CPU Won");
            return;
        }
    }


    public void setArrays()
    {

        for(int i=0;i<10;i++)
        {
            xArray[i]=0;
        }
        for(int i=0;i<10;i++)
        {
            yArray[i]=0;
        }

        xArray[0] = 10;
        yArray[0] = 500;

        for(int i=1;i<10;i++)
        {
            xArray[i]=xArray[i-1]+100;
        }

        for(int i=1;i<10;i++)
        {
            yArray[i]=yArray[i-1]-120;
        }

    }

    public void move(int sum,ImageView image)
    {
        if(sum==100&&count==0)
            sum1=100;
        if(sum==100&&count==1)
            sum2=100;
        if(count==0) {
            //ladders
            if(sum == 3)
                sum1 = sum = 21;
            if(sum == 8)
                sum1 = sum = 30;
            if(sum == 28)
                sum1 = sum = 84;
            if(sum == 58)
                sum1 = sum = 77;
            if(sum == 75)
                sum1 = sum = 86;
            if(sum == 90)
                sum1 = sum = 91;
            if(sum == 80) {
                sum1 = sum = 100;
                return;
            }
            //snakes

            if(sum==27)
                sum1= sum =12;
            if(sum==52)
                sum1= sum =29;
            if(sum==57)
                sum1= sum =40;
            if(sum==62)
                sum1= sum =22;
            if(sum==88)
                sum1= sum =18;
            if(sum==95)
                sum1= sum =51;
            if(sum==97)
                sum1= sum =79;

        }

        if(count==1) {
            //ladders
            if(sum == 3)
                sum2 = sum = 21;
            if(sum == 8)
                sum2 = sum = 30;
            if(sum == 28)
                sum2 = sum = 84;
            if(sum == 58)
                sum2 = sum = 77;
            if(sum == 75)
                sum2 = sum = 86;
            if(sum == 90)
                sum2 = sum = 91;
            if(sum == 80) {
                sum2 = sum = 100;
                return;
            }
            //snakes

            if(sum==27)
                sum2= sum =12;
            if(sum==52)
                sum2= sum =29;
            if(sum==57)
                sum2= sum =40;
            if(sum==62)
                sum2= sum =22;
            if(sum==88)
                sum2= sum =18;
            if(sum==95)
                sum2= sum =51;
            if(sum==97)
                sum2= sum =79;

        }





        int one=sum%10;
        int ten=sum/10;

        if(one==0)
        {
            if(ten%2==0)
                image.setX(xArray[0]);
            else
                image.setX(xArray[9]);
        }
        else
        {
            if(ten%2==0)
                 image.setX(xArray[one - 1]);
            else
                image.setX(xArray[10 - one]);
        }
        if(ten==0)
            image.setY(yArray[0]);
        else
        {
            if(one==0)
                image.setY(yArray[ten - 1]);
            else
                image.setY(yArray[ten]);
        }


    }

}
