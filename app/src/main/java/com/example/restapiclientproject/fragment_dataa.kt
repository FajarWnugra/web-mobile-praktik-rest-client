package com.example.restapiclientproject

import MovieAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapiclientproject.databinding.FragmentDataaBinding
import com.example.restapiclientproject.modeldata.MovieData
import com.example.restapiclientproject.modeldata.SearchData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.CacheResponse


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_dataa.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_dataa : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding:FragmentDataaBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<MovieData>()

    override fun  onCreateView(
      inflater: LayoutInflater,container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)

        RClient.instances.getMovies().enqueue(object : Callback<SearchData> {
            override fun onResponse(call: Call<SearchData>, response: Response<SearchData>) {
                val responseCode = response.code()

                response.body()?.let { list.addAll(it.data) }
                val adapter = MovieAdapter(list)
                binding.rvData.adapter = adapter
            }
            override fun onFailure(call: Call<SearchData>, t:Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}