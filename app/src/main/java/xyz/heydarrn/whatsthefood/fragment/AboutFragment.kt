package xyz.heydarrn.whatsthefood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentAboutBinding
import xyz.heydarrn.whatsthefood.model.Developers
import xyz.heydarrn.whatsthefood.model.DevelopersListAdapter
import xyz.heydarrn.whatsthefood.model.DummyFoodListAdapter

class AboutFragment : Fragment() {
    private var _bindingAbout:FragmentAboutBinding?=null
    private val bindingAbout get() = _bindingAbout!!
    private val listDev=ArrayList<Developers>()
    private val adapterDevs by lazy { DevelopersListAdapter() }

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
        listDev.addAll(listFromArray)
        setDevRV()
    }

    private val listFromArray:ArrayList<Developers> get() {
        this.resources.apply {
            val devName=getStringArray(R.array.developer_name)
            val devPath=getStringArray(R.array.developer_learning_path)
            val devPics=obtainTypedArray(R.array.developer_photo)
            val devPathIcon=obtainTypedArray(R.array.learning_path_icon)

            val listPerDev=ArrayList<Developers>()
            for (devs in devName.indices){
                val devs=Developers(
                    name = devName[devs],
                    photoProfile = devPics.getResourceId(devs,-1),
                    learningPath = devPath[devs],
                    learningPathIcon = devPathIcon.getResourceId(devs,-1),
                )
                listPerDev.add(devs)
            }
            devPics.recycle()
            devPathIcon.recycle()
            return listPerDev
        }
    }

    private fun setDevRV(){
        bindingAbout.recyclerViewDeveloper.layoutManager=LinearLayoutManager(context)
        adapterDevs.submitList(listDev)
        bindingAbout.recyclerViewDeveloper.adapter=adapterDevs
    }
}