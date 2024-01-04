package com.example.fruitidentifier;

import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView questionImage;
    private Button option1, option2, option3, option4, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionImage = findViewById(R.id.questionImage);
        // Load image from the web URL using Glide

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);

        // Set up click listeners
        option1.setOnClickListener(v -> checkAnswer(option1));
        option2.setOnClickListener(v -> checkAnswer(option2));
        option3.setOnClickListener(v -> checkAnswer(option3));
        option4.setOnClickListener(v -> checkAnswer(option4));

        nextButton.setOnClickListener(v -> loadNextQuestion());
    }

    private void checkAnswer(Button selectedOption) {
        // Logic to check if the answer is correct and change color
        selectedOption.setBackgroundColor(Color.GREEN); // Turn button green

        // Handler to introduce a delay
        new Handler().postDelayed(() -> {
            // Reset the color after 3 seconds (3000ms)
            selectedOption.setBackgroundColor(Color.LTGRAY); // Reset to default or another color
            // Optionally, you can also disable the buttons here and re-enable them after the delay
        }, 3000); // 3000 milliseconds delay
    }

    private void loadNextQuestion() {
        // Logic to load the next question
    }
}
