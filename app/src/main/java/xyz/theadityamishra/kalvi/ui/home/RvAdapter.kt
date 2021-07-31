package xyz.theadityamishra.kalvi.ui.home

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.coroutineScope
import xyz.theadityamishra.kalvi.databinding.LayoutSubjectListBinding

class SubjectsAdapter(context: Context, subjectList: ArrayList<String>, imageList: ArrayList<String>): RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder>()
{

    lateinit var context: Context
    lateinit var subjectList: ArrayList<String>
    lateinit var imageList: ArrayList<String>
    lateinit var binding: LayoutSubjectListBinding

    init
    {
        this.context = context
        this.imageList = imageList
        this.subjectList = subjectList
    }

    inner class SubjectsViewHolder(binding: LayoutSubjectListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder
    {
        binding = LayoutSubjectListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SubjectsViewHolder(binding)
    }


    override fun getItemCount() = subjectList.size


    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int)
    {
        binding.subjectText.text = subjectList[position]
        Glide.with(context)
            .asBitmap()
            .load(imageList[position])
            .into(binding.subjectImage)

        binding.subjectImage.setOnClickListener {
            Toast.makeText(context, subjectList[position], Toast.LENGTH_SHORT).show()
        }

        val bitmapDrawable = binding.subjectImage.drawable as BitmapDrawable?
        val bitmap = bitmapDrawable?.bitmap

        if (bitmap != null)
        {
            Palette.from(bitmap).generate {
                val intColor = it?.dominantSwatch?.rgb ?: 0
                binding.subjecsCard.setCardBackgroundColor(intColor)
            }
        }
    }
}