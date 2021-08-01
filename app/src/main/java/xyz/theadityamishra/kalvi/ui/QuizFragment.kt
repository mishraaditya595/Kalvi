package xyz.theadityamishra.kalvi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.theadityamishra.kalvi.R
import xyz.theadityamishra.kalvi.databinding.FragmentHomeBinding


class QuizFragment : Fragment()
{

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
}