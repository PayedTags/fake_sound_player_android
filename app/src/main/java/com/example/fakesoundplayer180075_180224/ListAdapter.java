package com.example.fakesoundplayer180075_180224;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Musica> playlist;


    public ListAdapter(Context context, ArrayList<Musica> arrayList)
    {
        this.context = context;
        this.playlist = arrayList;
    }

    @Override
    public int getCount() { return playlist.size(); }

    @Override
    public Musica getItem(int position) { return playlist.get(position); }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //@Override
    //public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_layout, parent, false);
        }

        ImageView imageViewCapa;

        if(playlist.get(position).getCapa() != 0)
        {
            imageViewCapa = convertView.findViewById(R.id.imgCapa);
            imageViewCapa.setImageResource(playlist.get(position).getCapa());
        }

        TextView textViewTitulo = convertView.findViewById(R.id.txtview_Titulo);
        TextView textViewAutor = convertView.findViewById(R.id.txtview_Autor);
        TextView textViewDuracao = convertView.findViewById(R.id.txtview_Duração);


        textViewTitulo.setText(playlist.get(position).getTitulo());
        textViewAutor.setText(playlist.get(position).getAutor());
        textViewDuracao.setText(String.valueOf( playlist.get(position).getSegundos()));

        return convertView;
    }
}
