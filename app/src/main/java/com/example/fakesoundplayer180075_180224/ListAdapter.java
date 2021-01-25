package com.example.fakesoundplayer180075_180224;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Musica> {

    Context context;
    ArrayList<Musica> playlist;

    ImageView imageViewCapa;
    TextView textViewTitulo;
    TextView textViewAutor;
    TextView textViewDuracao;

    public ListAdapter(Context context, ArrayList<Musica> list)
    {
        super(context, 0);
        this.context = context;
        playlist = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.item_layout, container, false);
        }

        Musica musica = playlist.get(position);

        TextView titulo = (TextView) listItem.findViewById(R.id.txtview_Titulo);
        titulo.setText(musica.getTitulo());

        TextView autor = listItem.findViewById(R.id.txtview_Autor);
        autor.setText(musica.getAutor());

        return listItem;
    }
}
