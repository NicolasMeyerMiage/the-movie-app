package fr.mbds.squad.movieapp.ui.tv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.mbds.squad.idbdata.data.Tv
import fr.mbds.squad.movieapp.databinding.TvItemListBinding
import fr.mbds.squad.movieapp.ui.tv.fragments.TvFragmentDirections

class TvAdapter(
    private val items: List<Tv>
) :
    RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TvItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val posterTv: ImageView = binding.tvPoster

        fun bind(item: Tv) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(TvItemListBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            val action =
                TvFragmentDirections.actionTvFragmentToTvFragmentDetail(
                    items[position].id.toString(),
                    items[position].name
                )
            Navigation.findNavController(it).navigate(action)
        }

        val tv: Tv = items[position]

        Picasso.get()
            .load(tv.poster)
            .into(holder.posterTv)
    }
}
