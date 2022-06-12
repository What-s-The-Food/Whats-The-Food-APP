package xyz.heydarrn.whatsthefood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private var _bindingAbout:FragmentAboutBinding?=null
    private val bindingAbout get() = _bindingAbout!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingAbout= FragmentAboutBinding.inflate(inflater,container,false)
        return bindingAbout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}