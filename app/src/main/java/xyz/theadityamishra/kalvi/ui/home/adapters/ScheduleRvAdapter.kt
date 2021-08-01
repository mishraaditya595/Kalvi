package xyz.theadityamishra.kalvi.ui.home

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xyz.theadityamishra.kalvi.databinding.LayoutScheduleListBinding
import xyz.theadityamishra.kalvi.ui.listeners.EventClickListener

class ScheduleAdapter(context: Context, scheduleTitle: ArrayList<String>, scheduleTime: ArrayList<String>, scheduleIV: ArrayList<String>, eventClickListener: EventClickListener): RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>()
{

    lateinit var context: Context
    lateinit var scheduleTitle: ArrayList<String>
    lateinit var scheduleTime: ArrayList<String>
    lateinit var scheduleIV: ArrayList<String>
    lateinit var binding: LayoutScheduleListBinding
    lateinit var eventClickListener: EventClickListener

    init
    {
        this.context = context
        this.scheduleTime = scheduleTime
        this.scheduleTitle = scheduleTitle
        this.scheduleIV = scheduleIV
        this.eventClickListener = eventClickListener
    }

    inner class ScheduleViewHolder(binding: LayoutScheduleListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder
    {
        binding = LayoutScheduleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ScheduleViewHolder(binding)
    }


    override fun getItemCount() = scheduleTitle.size


    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int)
    {
        binding.scheduleTitle.text = scheduleTitle[position]
        Glide.with(context)
            .asBitmap()
            .load(scheduleIV[position])
            .into(binding.scheduleIv)

        binding.scheduleIv.setOnClickListener {
            Toast.makeText(context, scheduleTitle[position], Toast.LENGTH_SHORT).show()
        }

        binding.scheduleTime.text = scheduleTime[position]

        if (binding.scheduleTime.text == "15s later")
        {
            binding.startEventCard.visibility = View.VISIBLE
            binding.startEventCard.setOnClickListener {
                eventClickListener.onEventClicked()
            }
        }
    }
}