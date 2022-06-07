package xyz.heydarrn.whatsthefood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentFoodsListBinding
import xyz.heydarrn.whatsthefood.viewmodel.DummyFoodsViewModel

class FoodsListFragment : Fragment() {
    private var _bindingFood:FragmentFoodsListBinding?=null
    private val bindingFood get() = _bindingFood!!
    private val viewModelDummy by viewModels<DummyFoodsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingFood=FragmentFoodsListBinding.inflate(inflater,container,false)
        return bindingFood.root
    }


}