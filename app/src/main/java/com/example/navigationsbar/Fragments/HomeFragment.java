package com.example.navigationsbar.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigationsbar.Activitys.Games.Games_HoeherTiefer_Activity;
import com.example.navigationsbar.Activitys.Questions.QuestionOneActivity;
import com.example.navigationsbar.R;

public class HomeFragment extends Fragment {

    private static final long TOAST_COOLDOWN = 2000; // 2 seconds

    private Button buttonGame2;
    private boolean isButton2Clickable = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Object references
        Button myButton = root.findViewById(R.id.startSearchButton);
        TextView textView2 = root.findViewById(R.id.appTitle);
        Button buttonGame1 = root.findViewById(R.id.playButtonGame1);
        buttonGame2 = root.findViewById(R.id.playButtonGame2);

        buttonGame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Games_HoeherTiefer_Activity.class);
                startActivity(intent);
            }
        });

        buttonGame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButton2Clickable) {
                    String text = "Das Spiel kommt bald..";
                    makeToast(text);
                    disableButton2Temporarily();
                }
            }
        });

        // Intent for Question View -> Lambda Function
        Intent intent = new Intent(requireActivity(), QuestionOneActivity.class);
        myButton.setOnClickListener(v -> startActivity(intent));

        // Create the text content with the blue dot
        String text = "Party.Saver";
        SpannableString spannableString = new SpannableString(text);

        // Set the color of the dot to blue
        int dotIndex = text.indexOf(".");
        if (dotIndex != -1) {
            int colorLightBlue = getResources().getColor(R.color.lightblueButton);
            spannableString.setSpan(new ForegroundColorSpan(colorLightBlue), dotIndex, dotIndex + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // Set the formatted text in the TextView
        textView2.setText(spannableString);
        return root;
    }

    private void makeToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    private void disableButton2Temporarily() {
        isButton2Clickable = false;
        buttonGame2.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isButton2Clickable = true;
                buttonGame2.setEnabled(true);
            }
        }, TOAST_COOLDOWN);
    }
}