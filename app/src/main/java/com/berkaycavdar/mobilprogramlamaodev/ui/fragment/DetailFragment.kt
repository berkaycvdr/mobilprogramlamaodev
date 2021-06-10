package com.berkaycavdar.mobilprogramlamaodev.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.berkaycavdar.mobilprogramlamaodev.R
import com.berkaycavdar.mobilprogramlamaodev.data.modeldata.User
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment()
{
   private val args: DetailFragmentArgs by navArgs()
    private lateinit var userItem:User

    private lateinit var avatar: String
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       userItem = args.userItemDetail
        if (userItem != null) {
            avatar = userItem.avatar
            id = userItem.id
            name = userItem.name
            email = userItem.email
        } else {
            avatar = "drawable-v24"
            id = "181030050"
            name = "Berkay Çavdar"
            email = "cvdr.berkay@gmail.com"
        }

        Glide.with(requireContext()).load(avatar).into(userPicture)
        userId.text = id
        userName.text = name
        userEmail.text = email

    }


}

