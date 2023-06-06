package com.example.navigationsbar.Fragments.Games;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationsbar.Activitys.Games.Games_HoeherTiefer_Activity;
import com.example.navigationsbar.R;
import com.example.navigationsbar.databinding.FragmentGamesBinding;

public class GamesFragment extends Fragment {

    private FragmentGamesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GamesViewModel dashboardViewModel =
                new ViewModelProvider(this).get(GamesViewModel.class);

        binding = FragmentGamesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button buttonGame1 = root.findViewById(R.id.button3);
        buttonGame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Games_HoeherTiefer_Activity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}