package lazycoder21.droid.myapplication.presentation.showListings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import lazycoder21.droid.myapplication.R
import lazycoder21.droid.myapplication.domain.modal.Data
import lazycoder21.droid.myapplication.domain.modal.Users
import lazycoder21.droid.myapplication.util.loadImage

class UsersAdapter(
    private val onItemClick: (Data) -> Unit
) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private val list = mutableListOf<Data>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.image)
        private val text: TextView = view.findViewById(R.id.tvName)


        fun bind(data: Data) {
            text.text = data.firstName
            image.loadImage(data.avatar)

            itemView.setOnClickListener { onItemClick.invoke(data) }
        }
    }

    fun addItems(items: List<Data>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_rv_users, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}