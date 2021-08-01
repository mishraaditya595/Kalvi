package xyz.theadityamishra.kalvi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import xyz.theadityamishra.kalvi.databinding.FragmentQuizBinding

class QuizFragment : Fragment()
{
    private var _binding: FragmentQuizBinding? = null

    private val binding get() = _binding!!

    private var c = 0

    private lateinit var questionsList: ArrayList<String>
//    private lateinit var optionsMap: HashMap<Int, ArrayList<String>>
    private lateinit var scoreList: ArrayList<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
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

        var optionsMap = setupQuestions()
        scoreList = arrayListOf()

        binding.QuestionTV.text = questionsList[c]
        binding.QText.text = "Question ${c+1}"
//        Toast.makeText(requireContext(),"${optionsMap.size}, $c",Toast.LENGTH_SHORT).show()
        val options = optionsMap[2]!!
        binding.optionText1.text = options[0]
        binding.optionText2.text = options[1]
        binding.optionText3.text = options[2]
        binding.optionText4.text = options[3]

        binding.navigateAfter.setOnClickListener {
            c+=1
            if (c<=questionsList.size-1)
            {
                binding.QuestionTV.text = questionsList[c]
                binding.QText.text = "Question ${c+1}"

                val options = optionsMap[c]!!
                binding.optionText1.text = options[0]
                binding.optionText2.text = options[1]
                binding.optionText3.text = options[2]
                binding.optionText4.text = options[3]

                answerCheck(optionsMap)

            }
            else
            {
                var total: Int = 0
                for (i in scoreList)
                    total+=i
                Toast.makeText(requireContext(),"$total",Toast.LENGTH_LONG).show()
            }
        }

        binding.navigateBefore.setOnClickListener {
            c-=1
            if (c>=0)
            {
                binding.QuestionTV.text = questionsList[c]
                binding.QText.text = "Question ${c+1}"

                val options = optionsMap[c]!!
                binding.optionText1.text = options[0]
                binding.optionText2.text = options[1]
                binding.optionText3.text = options[2]
                binding.optionText4.text = options[3]
            }
        }


    }

    private fun setupQuestions(): ArrayList<ArrayList<String>>
    {
        questionsList = arrayListOf()
        var optionsMap = arrayListOf<ArrayList<String>>()
        var options0 = arrayListOf<String>()
        questionsList.add("The correct sequence of reproductive stages seen in flowering plants is")
        options0.add("gametes, zygote, embryo, seedling")
        options0.add("seedling, embryo, zygote, gametes")
        options0.add("gametes, embryo, zygote, seedling")
        options0.add("gametes, zygote, embryo, seedling")
        options0.add("gametes, zygote, embryo, seedling")
        optionsMap.add(options0)


        var options1 = arrayListOf<String>()
        questionsList.add("Keeping the potential difference constant, the resistance of the circuit is halved. The current will become:")
        options1.add("One-fourth")
        options1.add("four times")
        options1.add("half")
        options1.add("double")
        options1.add("double")
        optionsMap.add(options1)

        var options2 = arrayListOf<String>()
        questionsList.add("It is necessary to balance a chemical equation in order to satisfy the law of:")
        options2.add("Conservation of motion")
        options2.add("Conservation of momentum")
        options2.add("Conservation of energy")
        options2.add("Conservation of mass")
        options2.add("Conservation of mass")
        optionsMap.add(options2)

        var options = arrayListOf<String>()
        questionsList.add("In human males, the testes lie in the scrotum, because it helps in the")
        options.add("process of mating")
        options.add("formation of sperm")
        options.add("easy transfer of gametes")
        options.add("all of these")
        options.add("formation of sperm")
        optionsMap.add(options)


        return optionsMap
    }

    private fun answerCheck(optionsMap: ArrayList<ArrayList<String>>)
    {
        val ans = (optionsMap.get(c))
        var answer: String = ""
        Toast.makeText(requireContext(),"${ans.size}",Toast.LENGTH_SHORT).show()
        if (!ans.isNullOrEmpty())
            answer = ans[4-1]
        binding.cardOption1.setOnClickListener {
            if (binding.optionText1.text.equals(answer))
            {
                scoreList.add(1)
                Toast.makeText(requireContext(),"true",Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardOption2.setOnClickListener {
            if (binding.optionText2.text.equals(answer))
            {
                scoreList.add(1)
                Toast.makeText(requireContext(),"true",Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardOption3.setOnClickListener {
            if (binding.optionText3.text.equals(answer))
            {
                scoreList.add(1)
                Toast.makeText(requireContext(),"true",Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardOption4.setOnClickListener {
            if (binding.optionText4.text.equals(answer))
            {
                scoreList.add(1)
                Toast.makeText(requireContext(),"true",Toast.LENGTH_SHORT).show()

            }
        }

    }

}