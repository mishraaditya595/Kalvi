package xyz.theadityamishra.kalvi.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.eazegraph.lib.models.BarModel
import org.eazegraph.lib.models.PieModel
import xyz.theadityamishra.kalvi.R
import xyz.theadityamishra.kalvi.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

  private lateinit var dashboardViewModel: DashboardViewModel
  private var _binding: FragmentDashboardBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root
    return root
  }

  override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)

    makeStatsGraph()
    makePercentGraph()
  }

  private fun makePercentGraph()
  {
    val pieChart = binding.percentPieChart
    pieChart.addPieSlice(PieModel("Percentage",69.73F, Color.parseColor("#FE6DA8")))
    pieChart.addPieSlice(PieModel(100F-69.73F, Color.parseColor("#FFFFFF")))
    pieChart.startAnimation()
  }

  private fun makeStatsGraph()
  {
    val barChart = binding.statisticsBarchart
    barChart.addBar(BarModel("Bio",78.2f, 0xFF123456.toInt()))
    barChart.addBar(BarModel("Eng",67.78f, 0xFF1FF4AC.toInt()))
    barChart.addBar(BarModel("Phy",77.78f, 0xFF563456.toInt()))
    barChart.addBar(BarModel("His",43.38f, 0xFF873F56.toInt()))
    barChart.addBar(BarModel("Geo",57.78f, 0xFF56B7F1.toInt()))
    barChart.addBar(BarModel("Maths",62.4f, 0xFF343456.toInt()))
    barChart.addBar(BarModel("Chem",81.5f, 0xFF1BA4E6.toInt()))

    barChart.startAnimation()
  }
}