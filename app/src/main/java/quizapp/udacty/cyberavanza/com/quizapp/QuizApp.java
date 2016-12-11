package quizapp.udacty.cyberavanza.com.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);

        Button resultBtn = (Button) findViewById(R.id.showResultBtn);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizApp.this,"Your Result Is : "+getResult()+" out of 8",Toast.LENGTH_LONG).show();
            }
        });

    }

    private int getResult(){
        int scores = 0;
        int[] correctAnswers = {0,1,1,2,2,3,2,3,1};
        for (int i = 1; i <= 8; i++) {
            int radioGroupId = getResources().getIdentifier("q" + i + "_answers", "id", getApplicationContext().getPackageName());
            RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);
            for(int ri =1;ri<=3;ri++){
                int radioBtnId = getResources().getIdentifier("q" + i + "_ans"+ri, "id", getApplicationContext().getPackageName());
                if(radioGroup.getCheckedRadioButtonId() == radioBtnId){
                    if(ri == correctAnswers[i]){
                        scores++;
                    }
                }
            }
        }
        return scores;
    }
}
