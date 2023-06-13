package com.example.navigationsbar.Fragments.HomeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationsbar.Activitys.Games.Games_HoeherTiefer_Activity;
import com.example.navigationsbar.Activitys.Questions.QuestionOneActivity;
import com.example.navigationsbar.R;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Objekte erzeugen
        Button myButton = root.findViewById(R.id.button);
        TextView textView2 = root.findViewById(R.id.textView2);
        Button buttonGame1 = root.findViewById(R.id.button6);

        buttonGame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Games_HoeherTiefer_Activity.class);
                startActivity(intent);
            }
        });

        // Intent für Question View -> Lambda Function
        Intent intent = new Intent(requireActivity(), QuestionOneActivity.class);
        myButton.setOnClickListener(v -> startActivity(intent));

            // Erstelle den Textinhalt mit dem blauen Punkt
        String text = "Party.Saver";
        SpannableString spannableString = new SpannableString(text);

            // Setze die Farbe des Punkts auf blau
        int dotIndex = text.indexOf(".");
        if (dotIndex != -1) {
            int colorLightBlue = getResources().getColor(R.color.lightblueButton);
            spannableString.setSpan(new ForegroundColorSpan(colorLightBlue), dotIndex, dotIndex + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
            // Setze den formatierten Text im TextView
        textView2.setText(spannableString);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
