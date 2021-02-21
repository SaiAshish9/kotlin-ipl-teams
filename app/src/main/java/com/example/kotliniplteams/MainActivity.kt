package com.example.kotliniplteams

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_card.view.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var teams = ArrayList<Team>()
    var adapter:TeamAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Collections.addAll(teams,
                Team("Srh", "Sunriser's Hyderabad", R.drawable.image),
                Team("DD", "Delhi Daredevil's", R.drawable.image),
                Team("Rcb", "Royal Challenger's Bangalore", R.drawable.image),
                Team("Kkr", "Kolkata Knight Rider's", R.drawable.image),
                Team("Csk", "Chennai Super King's", R.drawable.image),
                Team("RR", "Rajasthan Royal's", R.drawable.image),
                Team("MI", "Mumbai Indian's", R.drawable.image),
                Team("PK", "Punjab King's", R.drawable.image)
        )
        adapter = TeamAdapter(this,teams)
        list_view.adapter = adapter
    }

    class TeamAdapter:BaseAdapter{

        var teams = ArrayList<Team>()
        var context:Context? = null

        constructor(context: Context, teams:ArrayList<Team>):super(){
            this.teams=teams
            this.context=context
        }

        override fun getCount(): Int {
            return teams.size
        }

        override fun getItem(position: Int): Any {
            return teams[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var team = teams[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflater.inflate(R.layout.activity_card,null)
            view.tv.text = team.name!!
            view.tv1.text = team.desc!!
            view.img.setImageResource(team.image!!)
            return view
        }
    }


}