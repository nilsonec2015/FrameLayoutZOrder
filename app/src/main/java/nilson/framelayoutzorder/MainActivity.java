package nilson.framelayoutzorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    FrameLayout grupo;
    Button bt;
    ImageView iv1, iv2, iv3, iv4;

    final long TEMPO = 500;
    ArrayList<Integer> indexes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grupo = (FrameLayout) findViewById(R.id.grupo);
        bt = (Button) findViewById(R.id.button);
        iv1 = (ImageView) findViewById(R.id.imageView);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv4 = (ImageView) findViewById(R.id.imageView4);

        indexes.add(grupo.indexOfChild(iv1));
        indexes.add(grupo.indexOfChild(iv2));
        indexes.add(grupo.indexOfChild(iv3));
        indexes.add(grupo.indexOfChild(iv4));

        iv1.setAlpha(0f);
        iv2.setAlpha(0f);
        iv3.setAlpha(0f);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(indexes);

                grupo.bringChildToFront(grupo.getChildAt(indexes.get(0)));

                for(int i = 0;i<indexes.size()-1;i++){
                    grupo.getChildAt(indexes.get(i))
                            .animate()
                            .translationX(0)
                            .alpha(0)
                            .setDuration(TEMPO)
                            .setListener(null).setStartDelay(0);
                }

                grupo.getChildAt(indexes.get(indexes.size()-1))
                        .animate()
                        .translationX(0)
                        .alpha(1)
                        .setDuration(TEMPO)
                        .setListener(null).setStartDelay(TEMPO-TEMPO/3);
            }
        });
    }

    public void jillian(View v){
        Toast.makeText(this,"Jillian Janson",Toast.LENGTH_SHORT).show();
    }

    public void elsa(View v){
        Toast.makeText(this,"Elsa Jean",Toast.LENGTH_SHORT).show();
    }

    public void timea(View v){
        Toast.makeText(this,"Timea Bella",Toast.LENGTH_SHORT).show();
    }

    public void linda(View v){
        Toast.makeText(this,"Linda Sweet",Toast.LENGTH_SHORT).show();
    }
}
