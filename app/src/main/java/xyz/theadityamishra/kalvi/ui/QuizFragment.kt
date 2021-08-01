package xyz.theadityamishra.kalvi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import xyz.theadityamishra.kalvi.R
import xyz.theadityamishra.kalvi.databinding.FragmentHomeBinding
import xyz.theadityamishra.kalvi.databinding.FragmentQuizBinding


class QuizFragment : Fragment()
{

    private var _binding: FragmentQuizBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentQuizBinding.bind(view)
        Toast.makeText(requireContext(),"Quiz",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
}