package org.ljh.newsapp01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.ljh.newsapp01.databinding.FragmentRetrofitBinding
import org.ljh.newsapp01.model.PageListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RetrofitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RetrofitFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRetrofitBinding.inflate(inflater, container, false)
        //val networkService= MyApplication.networkService
        val call: Call<PageListModel> = MyApplication.networkService.getList(
            MyApplication.QUERY,
            MyApplication.API_KEY,
            1,
            10
        )
        call?.enqueue(object : Callback<PageListModel>{
            override fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {
                if(response.isSuccessful){
                    binding.retrofitRecyclerView.layoutManager=LinearLayoutManager(activity)
                    binding.retrofitRecyclerView.adapter=MyAdapter(activity as Context, response.body()?.articles)
                }
            }

            override fun onFailure(call: Call<PageListModel>, t: Throwable) {

            }
        })
        return binding.root
    }


}