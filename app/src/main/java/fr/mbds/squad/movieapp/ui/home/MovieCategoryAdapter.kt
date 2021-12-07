package fr.mbds.squad.movieapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import fr.mbds.squad.idbdata.data.Category
import fr.mbds.squad.movieapp.databinding.CategoryItemListBinding

class MovieCategoryAdapter(private val items: List<Category>) :
    RecyclerView.Adapter<MovieCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CategoryItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CategoryItemListBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToMovieFragment(items[position].id.toString(), items[position].name)
            findNavController(it).navigate(action)
        }
    }
}
