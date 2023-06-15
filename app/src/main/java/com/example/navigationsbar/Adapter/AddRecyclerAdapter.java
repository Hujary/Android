package com.example.navigationsbar.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Database.UpdateActivity;
import com.example.navigationsbar.R;

import java.util.ArrayList;

public class AddRecyclerAdapter extends RecyclerView.Adapter<AddRecyclerAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<String> idList, titleList, spielregelnList, benötigteKartenList, spieleranzahlMinList, spieleranzahlMaxList, spieldauerMinList, spieldauerMaxList, schwierigkeitsgradList, creatorList;


    public AddRecyclerAdapter(FragmentActivity activity, Context context, ArrayList game_id, ArrayList game_title, ArrayList game_spielregel, ArrayList game_benötigteKarten, ArrayList game_spieleranzahlMin, ArrayList game_spieleranzahlMax, ArrayList game_spieldauerMin, ArrayList game_spieldauerMax, ArrayList game_schwierigkeitsgrad, ArrayList game_creator) {
        this.activity = activity;
        this.context = context;
        this.idList = game_id;
        this.titleList = game_title;
        this.spielregelnList = game_spielregel;
        this.benötigteKartenList = game_benötigteKarten;
        this.spieleranzahlMinList = game_spieleranzahlMin;
        this.spieleranzahlMaxList = game_spieleranzahlMax;
        this.spieldauerMinList = game_spieldauerMin;
        this.spieldauerMaxList = game_spieldauerMax;
        this.schwierigkeitsgradList = game_schwierigkeitsgrad;
        this.creatorList = game_creator;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

            //  Setze dem View Inhalt -> User muss seine Spielinhalte nicht nochmal schreiben.
        holder.gameIdTxt.setText(String.valueOf(idList.get(position)));
        holder.gameTitleTxt.setText(String.valueOf(titleList.get(position)));
        holder.gameAuthorTxt.setText(String.valueOf(schwierigkeitsgradList.get(position)));
        holder.gamePagesTxt.setText(String.valueOf(creatorList.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.out.println("Working" + view);
                Intent updateIntent = new Intent(context, UpdateActivity.class);

                    //  übergebe alle inhalte als String
                updateIntent.putExtra("id", String.valueOf(idList.get(position)));
                updateIntent.putExtra("title", String.valueOf(titleList.get(position)));
                updateIntent.putExtra("spielregel", String.valueOf(spielregelnList.get(position)));
                updateIntent.putExtra("benötigteKarten", String.valueOf(benötigteKartenList.get(position)));
                updateIntent.putExtra("spieleranzahlMin", String.valueOf(spieleranzahlMinList.get(position)));
                updateIntent.putExtra("spieleranzahlMax", String.valueOf(spieleranzahlMaxList.get(position)));
                updateIntent.putExtra("spieldauerMin", String.valueOf(spieldauerMinList.get(position)));
                updateIntent.putExtra("spieldauerMax", String.valueOf(spieldauerMaxList.get(position)));
                updateIntent.putExtra("schwierigkeitsgrad", String.valueOf(schwierigkeitsgradList.get(position)));
                updateIntent.putExtra("creator", String.valueOf(creatorList.get(position)));
                activity.startActivityForResult(updateIntent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return idList.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView gameIdTxt, gameTitleTxt, gameAuthorTxt, gamePagesTxt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gameIdTxt = itemView.findViewById(R.id.id_txt);
            gameTitleTxt = itemView.findViewById(R.id.title_txt);
            gameAuthorTxt = itemView.findViewById(R.id.schwierigkeit_txt);
            gamePagesTxt = itemView.findViewById(R.id.spieleranzahl_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            Animation translateAnim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            mainLayout.setAnimation(translateAnim);
        }
    }
}