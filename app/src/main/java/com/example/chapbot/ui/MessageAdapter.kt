package com.example.chapbot.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapbot.R
import com.example.chapbot.data.Message
import com.example.chapbot.databinding.MessageItemBinding
import com.example.chapbot.utils.Constants.RECEIVE_ID
import com.example.chapbot.utils.Constants.SEND_ID

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    inner class MessageViewHolder(val binding: MessageItemBinding): RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val curMessage = messagesList[position]

        when(curMessage.id){
            SEND_ID -> {
                holder.binding.tvMessage.apply {
                    text = curMessage.message
                    visibility = View.VISIBLE
                }
                holder.binding.tvBotMessage.visibility = View.GONE
            }

            RECEIVE_ID -> {
                holder.binding.tvBotMessage.apply {
                    text = curMessage.message
                    visibility = View.VISIBLE
                }
                holder.binding.tvMessage.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    fun insertMessage(message: Message){
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)

    }
}