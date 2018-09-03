package id.revze.androidmvpkotlinsample.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import id.revze.androidmvpkotlinsample.R
import id.revze.androidmvpkotlinsample.model.AnimeCharacter

class AnimeCharacterAdapter(val animeCharacters: ArrayList<AnimeCharacter>) : RecyclerView.Adapter<AnimeCharacterAdapter.AnimeCharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeCharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_character, parent, false)
        return AnimeCharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeCharacterViewHolder, position: Int) {
        val animeCharacter = animeCharacters.get(position)
        holder.ivCharacter.setImageURI(animeCharacter.imageUrl)
        holder.tvName.text = animeCharacter.name
        holder.tvRole.text = animeCharacter.role
    }

    override fun getItemCount(): Int {
        return animeCharacters.size
    }

    class AnimeCharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivCharacter: SimpleDraweeView = view.findViewById(R.id.iv_character)
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val tvRole: TextView = view.findViewById(R.id.tv_role)
    }
}