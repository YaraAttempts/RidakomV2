package com.appsfactory.ridakom

import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.appsfactory.ridakom.databinding.FragmentFirstBinding
import java.util.Calendar
import androidx.core.graphics.drawable.toDrawable

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.ads.setOnClickListener { adsDialog() }
        binding.complaintsAndSuggestion.setOnClickListener { complaintsAndSuggestionsDialog() }
        binding.register.setOnClickListener { registerDialog() }
        binding.fab.setOnClickListener { rateDialog() }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun registerDialog() {
        val context = context ?: return

        val dRegisterDialog = Dialog(context)
        dRegisterDialog.setContentView(R.layout.register)
        dRegisterDialog.setCancelable(false)
        dRegisterDialog.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        val submit =
            dRegisterDialog.findViewById<View>(R.id.Submit) as Button
        val close =
            dRegisterDialog.findViewById<View>(R.id.close) as ImageView
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val birthday =
            dRegisterDialog.findViewById<View>(R.id.et_birthday) as Button
        dRegisterDialog.show()
        birthday.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                context,
                { _, year, month, day ->
                    var month = month
                    month = month + 1
                    val date = "$day/$month/$year"
                    birthday.text = " $date"
                }, year, month, day
            )
            datePickerDialog.show()
        }
        close.setOnClickListener { dRegisterDialog.cancel() }
        submit.setOnClickListener { dRegisterDialog.cancel() }
    }

    private fun complaintsAndSuggestionsDialog() {
        val context = context ?: return

        val dComplaintsAndSuggestionsDialog = Dialog(context)
        dComplaintsAndSuggestionsDialog.setContentView(R.layout.complaints_and_suggestions)
        dComplaintsAndSuggestionsDialog.setCancelable(false)
        dComplaintsAndSuggestionsDialog.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        val submit =
            dComplaintsAndSuggestionsDialog.findViewById<View>(R.id.Submit) as Button
        val close =
            dComplaintsAndSuggestionsDialog.findViewById<View>(R.id.close) as ImageView
        dComplaintsAndSuggestionsDialog.findViewById<View>(R.id.et_report) as EditText
        dComplaintsAndSuggestionsDialog.findViewById<View>(R.id.et_name) as EditText
        dComplaintsAndSuggestionsDialog.findViewById<View>(R.id.et_phone) as EditText
        dComplaintsAndSuggestionsDialog.show()
        close.setOnClickListener { dComplaintsAndSuggestionsDialog.cancel() }
        submit.setOnClickListener { dComplaintsAndSuggestionsDialog.cancel() }
    }

    private fun adsDialog() {
        val context = context ?: return

        val dAdsDialog = Dialog(context)
        dAdsDialog.setContentView(R.layout.ads)
        dAdsDialog.setCancelable(false)
        dAdsDialog.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        val close =
            dAdsDialog.findViewById<View>(R.id.close) as ImageView
        dAdsDialog.findViewById<View>(R.id.adsImage) as ImageView
        dAdsDialog.show()
        close.setOnClickListener { dAdsDialog.cancel() }
    }

    private fun rateDialog() {
        val context = context ?: return

        val dRateDialog = Dialog(context)
        dRateDialog.setContentView(R.layout.rate)
        dRateDialog.setCancelable(false)
        dRateDialog.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        val submit =
            dRateDialog.findViewById<View>(R.id.Submit) as Button
        val close =
            dRateDialog.findViewById<View>(R.id.close) as ImageView
        dRateDialog.show()
        close.setOnClickListener { dRateDialog.cancel() }
        submit.setOnClickListener { dRateDialog.cancel() }
    }
}