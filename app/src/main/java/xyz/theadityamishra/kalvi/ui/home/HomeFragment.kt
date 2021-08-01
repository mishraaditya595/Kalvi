package xyz.theadityamishra.kalvi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.theadityamishra.kalvi.R
import xyz.theadityamishra.kalvi.databinding.FragmentHomeBinding
import xyz.theadityamishra.kalvi.ui.listeners.EventClickListener

class HomeFragment : Fragment(), EventClickListener {

  private lateinit var homeViewModel: HomeViewModel
  private var _binding: FragmentHomeBinding? = null

  private val binding get() = _binding!!

  lateinit var subjectImageList: ArrayList<String>
  lateinit var subjectNameList: ArrayList<String>
  lateinit var scheduleTitleList: ArrayList<String>
  lateinit var scheduleTimeList: ArrayList<String>
  lateinit var scheduleIVList: ArrayList<String>


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    getDataForSubjectsRV()
    getDataForScheduleRV()
  }

  private fun getDataForSubjectsRV()
  {
    subjectImageList = arrayListOf()
    subjectNameList = arrayListOf()
    subjectImageList.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
    subjectNameList.add("Havasu Falls")
    subjectImageList.add("https://i.redd.it/tpsnoz5bzo501.jpg")
    subjectNameList.add("Trondheim")
    subjectImageList.add("https://i.redd.it/qn7f9oqu7o501.jpg")
    subjectNameList.add("Portugal")
    subjectImageList.add("https://i.redd.it/j6myfqglup501.jpg")
    subjectNameList.add("Rocky Mountain National Park")
    subjectImageList.add("https://i.redd.it/0h2gm1ix6p501.jpg")
    subjectNameList.add("Mahahual")
    subjectImageList.add("https://i.redd.it/k98uzl68eh501.jpg")
    subjectNameList.add("Frozen Lake")
    subjectImageList.add("https://i.redd.it/glin0nwndo501.jpg")
    subjectNameList.add("White Sands Desert")
    subjectImageList.add("https://i.redd.it/obx4zydshg601.jpg")
    subjectNameList.add("Austrailia")
    subjectImageList.add("https://i.imgur.com/ZcLLrkY.jpg")
    subjectNameList.add("Washington")
    initSubjectsRecyclerView()
  }

  private fun initSubjectsRecyclerView()
  {
    var layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    binding.allsubjectsRV.layoutManager = layoutManager
    val adapter = SubjectsAdapter(requireContext(), subjectNameList, subjectImageList)
    binding.allsubjectsRV.adapter = adapter
  }

  private fun getDataForScheduleRV()
  {
    scheduleIVList = arrayListOf()
    scheduleTimeList = arrayListOf()
    scheduleTitleList = arrayListOf()

    scheduleTitleList.add("Master Quiz")
    scheduleTimeList.add("15s later")
    scheduleIVList.add("https://i.redd.it/j6myfqglup501.jpg")

    scheduleTitleList.add("Biology Class")
    scheduleTimeList.add("1h later")
    scheduleIVList.add("https://i.redd.it/qn7f9oqu7o501.jpg")

    scheduleTitleList.add("Physics Lab")
    scheduleTimeList.add("2h later")
    scheduleIVList.add("https://i.redd.it/qn7f9oqu7o501.jpg")

    scheduleTitleList.add("Chemistry Class")
    scheduleTimeList.add("3h later")
    scheduleIVList.add("https://i.redd.it/tpsnoz5bzo501.jpg")

    scheduleTitleList.add("English Quiz")
    scheduleTimeList.add("4h later")
    scheduleIVList.add("https://i.redd.it/obx4zydshg601.jpg")

    initScheduleRecyclerView()
  }

  private fun initScheduleRecyclerView()
  {
    var layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    binding.scheduleRV.layoutManager = layoutManager
    val adapter = ScheduleAdapter(requireContext(), scheduleTitleList, scheduleTimeList, scheduleIVList, this)
    binding.scheduleRV.adapter = adapter
  }

  override fun onEventClicked()
  {
    val action = HomeFragmentDirections.actionNavigationHomeToQuizFragment()
    findNavController().navigate(action)
  }
}
