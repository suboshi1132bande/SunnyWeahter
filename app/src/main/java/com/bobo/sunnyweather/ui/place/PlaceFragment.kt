package com.bobo.sunnyweather.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bobo.sunnyweather.R

/**
 * Creat by  BoBo on 2021/8/6
 */
class PlaceFragment : Fragment(){

    val viewModel by lazy { ViewModelProviders.of(this).get(PlaceViewModel::class.java) }

    private lateinit var adapter: PlaceAdapter

    private var mrecyc: RecyclerView? = null
    private var searchPlaceEdit: EditText? = null
    private var bgimg: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_place,container,false)
        initview(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager =LinearLayoutManager(activity)
        mrecyc!!.layoutManager = layoutManager
        adapter = PlaceAdapter(this,viewModel.placeList)
        mrecyc!!.adapter = adapter
        searchPlaceEdit!!.addTextChangedListener { edit ->

            var content = edit.toString()
            if (content.isNotEmpty()){
                viewModel.searchPlace(content)
            }else{
                mrecyc?.visibility = View.GONE
                bgimg?.visibility = View.VISIBLE
                viewModel.placeList.clear()
                adapter.notifyDataSetChanged()
            }
        }
        viewModel.placeLiveData.observe(this, Observer { resoult ->
            val place =resoult.getOrNull()
            if (place !=null){
                mrecyc?.visibility = View.VISIBLE
                bgimg?.visibility = View.GONE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(place)
                adapter.notifyDataSetChanged()
            }else{

                Toast.makeText(activity,"未能查询到任何地点",Toast.LENGTH_LONG).show()
                resoult.exceptionOrNull()?.printStackTrace()
            }
        })
    }

    private fun initview(view: View){
        mrecyc = view.findViewById(R.id.recyclerView)
        searchPlaceEdit = view.findViewById(R.id.searchPlaceEdit)
        bgimg = view.findViewById(R.id.bgImageView)
    }

}