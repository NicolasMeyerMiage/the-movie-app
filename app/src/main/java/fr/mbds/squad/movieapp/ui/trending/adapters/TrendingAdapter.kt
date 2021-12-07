package fr.mbds.squad.movieapp.ui.trending.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.mbds.squad.idbdata.data.Actor
import fr.mbds.squad.movieapp.databinding.ActorItemListBinding

class TrendingAdapter(
    private val items: List<Actor>
) :
    RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ActorItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val posterActor: ImageView = binding.actorPoster

        fun bind(item: Actor) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ActorItemListBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        val actor: Actor = items[position]

        Picasso.get()
            .load(actor.poster)
            .into(holder.posterActor)
    }
}
