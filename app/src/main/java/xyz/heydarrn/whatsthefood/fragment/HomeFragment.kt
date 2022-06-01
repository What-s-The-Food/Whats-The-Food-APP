package xyz.heydarrn.whatsthefood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _bindingHome:FragmentHomeBinding?=null
    private val bindHome get() = _bindingHome!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingHome= FragmentHomeBinding.inflate(inflater,container,false)
        return bindHome.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindHome.apply {
            imageButtonCamera.setImageResource(R.drawable.camera_icon)
            imgIllustration.setImageResource(R.drawable.undraw_cookie_love_re_lsjh_1)
            imgSnapSnack.setImageResource(R.drawable.snap_your_snack)
            imgTextFill.setImageResource(R.drawable.text_home_scren)

        }
    }

    companion object
}