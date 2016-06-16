package techkids.mad3.learnmediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnReplay, btnAction, btnPrevious, btnNext, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        btnReplay = (Button) this.findViewById(R.id.btnReplay);
        btnAction = (Button) this.findViewById(R.id.btnAction);
        btnPrevious = (Button) this.findViewById(R.id.btnBack);
        btnNext = (Button) this.findViewById(R.id.btnNext);

        btnReplay.setOnClickListener(this);
        btnAction.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id)
        {
            case R.id.btnReplay:
                break;
            case R.id.btnAction:
                break;
            case R.id.btnBack:
                break;
            case R.id.btnNext:
                break;
        }
    }
}
