package xyz.heydarrn.whatsthefood.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import xyz.heydarrn.whatsthefood.CameraActivity
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _bindingHome: FragmentHomeBinding? = null
    private val bindHome get() = _bindingHome!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingHome = FragmentHomeBinding.inflate(inflater, container, false)
        return bindHome.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindHome.apply {
            imageButtonCamera.setImageResource(R.drawable.ic_camera_button_inkscape)
            imageButtonCamera.setOnClickListener {
                Snackbar.make(requireContext(), it, "Kamera telah diklik!", Snackbar.LENGTH_SHORT)
                    .show()
                val intent = Intent(context, CameraActivity::class.java)
                startActivity(intent)
            }
            imageView3.setImageResource(R.drawable.undraw_cookie_love_re_lsjh)
        }
    }
}