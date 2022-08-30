package dev.tanya.homeworkout.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.tanya.homeworkout.databinding.FragmentTrackBinding

class TrackFragment : Fragment() {
    private var _binding: FragmentTrackBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentTrackBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text="plan fragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}