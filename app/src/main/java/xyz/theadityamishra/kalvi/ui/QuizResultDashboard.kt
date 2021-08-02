package xyz.theadityamishra.kalvi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.eazegraph.lib.models.BarModel
import xyz.theadityamishra.kalvi.R
import xyz.theadityamishra.kalvi.databinding.FragmentQuizResultDashboardBinding


class QuizResultDashboard : Fragment()
{
    private lateinit var binding: FragmentQuizResultDashboardBinding
    private var total: Int = -1

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_result_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizResultDashboardBinding.bind(view)
        val markList: HashMap<Int, Int> = MarkList.list

//        Toast.makeText(requireContext(), markList.toString(), Toast.LENGTH_SHORT).show()

        val barChart = binding.barChart
        for ((key,value) in markList)
        {
            barChart.addBar(BarModel(value.toFloat()))
//            Toast.makeText(requireContext(), key.toString(), Toast.LENGTH_SHORT).show()

        }

        binding.barChart.startAnimation()

    }

}