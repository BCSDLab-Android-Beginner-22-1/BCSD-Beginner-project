package com.example.bcsd_weather.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.bcsd_weather.databinding.DialogGeocoderBinding

class GeocoderDialog : DialogFragment() {
    private var _binding: DialogGeocoderBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogGeocoderBinding.inflate(inflater, container, false)
        val view = binding.root
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        initDialog()
        return view
    }

    private fun initDialog() {
        binding.dialogAddButton.setOnClickListener {
            buttonClickListener.onButtonClicked()
        }
    }

    interface OnButtonClickListener {
        fun onButtonClicked()
    }

    override fun onStart() {
        super.onStart()
        val layoutParams: WindowManager.LayoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog!!.window!!.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
        val window: Window = dialog!!.window!!
        window.attributes = layoutParams
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setButtonClickListener(buttonClickListener: OnButtonClickListener) {
        this.buttonClickListener = buttonClickListener
    }

    private lateinit var buttonClickListener: OnButtonClickListener
}