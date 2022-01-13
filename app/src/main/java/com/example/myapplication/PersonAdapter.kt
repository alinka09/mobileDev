package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemBinding

class PersonAdapter(private val clickPicture: (name: String) -> Unit,
                    private val clickLike: (name: String) -> Unit)
    : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var persons = mutableListOf<Person>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater,parent, false)
        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int = persons.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        var person = persons[position]
        holder.bind(person, clickPicture, clickLike)
    }

    fun addNewPerson(person: Person) {
        persons.add(person)
        notifyDataSetChanged()
    }

    fun getPreviousPersons(prevPersons: MutableList<Person>)
    {
        for (person in prevPersons)
            persons.add(person)
        notifyDataSetChanged()
    }

    class PersonViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(person: Person, clickPicture: (name: String) -> Unit, clickLike: (name: String) -> Unit){
            itemView.setOnClickListener{
                clickPicture(person.name)
            }
            binding.run{
                like.setOnClickListener{
                    clickLike(person.name)
                }
                name.text = person.name
                date.text = person.date
                info.text = person.info
                sex.text = person.sex
                photo.setImageResource(person.image)
            }
        }
    }
}
