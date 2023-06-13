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
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Database.UpdateActivity;
import com.example.navigationsbar.R;

import java.util.ArrayList;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.MyViewHolder> {


    private Context context;
    private Activity activity;
    private ArrayList<String> bookIdList;
    private ArrayList<String> bookTitleList;
    private ArrayList<String> creatorList;


    public DatabaseAdapter(Activity activity, Context context, ArrayList<String> bookIdList, ArrayList<String> bookTitleList, ArrayList<String> creator) {
        this.activity = activity;
        this.context = context;
        this.bookIdList = bookIdList;           //  Id des Artikel
        this.bookTitleList = bookTitleList;     //  Titel des Artikel.
        this.creatorList = creator;                 //  String welcher entweder "creator" oder "user" ist.
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //  dem Adapter das layout: "my_row" zuweisen.
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            //  dem layout den Text zuweisen welcher in der Arrayliste ist.
        holder.bookIdTxt.setText(String.valueOf(bookIdList.get(position)));
        holder.bookTitleTxt.setText(String.valueOf(bookTitleList.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    // Beim click auf den Artikel neuen Intent mit Werten übergeben.
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(bookIdList.get(position)));
                intent.putExtra("title", String.valueOf(bookTitleList.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
            //  selbsterklärend.
        return bookIdList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bookIdTxt, bookTitleTxt, bookAuthorTxt, bookPagesTxt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
                //  Objekte der Elemente im Layout erstellen.
            bookIdTxt = itemView.findViewById(R.id.id_txt);
            bookTitleTxt = itemView.findViewById(R.id.title_txt);
            bookAuthorTxt = itemView.findViewById(R.id.schwierigkeit_txt);
            bookPagesTxt = itemView.findViewById(R.id.spieleranzahl_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

                //  Animation für die einzelnen Artikel meines layouts hinzufügen.
            Animation translateAnim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            mainLayout.setAnimation(translateAnim);
        }
    }
}