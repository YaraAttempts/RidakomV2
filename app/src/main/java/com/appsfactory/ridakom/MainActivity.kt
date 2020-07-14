package com.appsfactory.ridakom

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    var RegisterDialog: Dialog? = null
    var Complaints_and_SuggestionsDialog: Dialog? = null
    var AdsDialog: Dialog? = null
    var RateDialog: Dialog? = null
    var Register: Button? = null
    var Complaints_and_Suggestions: Button? = null
    var Ads: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Register = findViewById<View>(R.id.register) as Button
        Complaints_and_Suggestions =
            findViewById<View>(R.id.CS) as Button
        Ads = findViewById<View>(R.id.ads) as Button
        Ads!!.setOnClickListener { AdsDialog() }
        Complaints_and_Suggestions!!.setOnClickListener { Complaints_and_SuggestionsDialog() }
        Register!!.setOnClickListener { RegisterDialog() }
    }

    private fun RegisterDialog() {
        RegisterDialog = Dialog(this)
        RegisterDialog!!.setContentView(R.layout.register)
        RegisterDialog!!.setCancelable(false)
        RegisterDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val submit =
            RegisterDialog!!.findViewById<View>(R.id.Submit) as Button
        val close =
            RegisterDialog!!.findViewById<View>(R.id.close) as ImageView
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val report =
            RegisterDialog!!.findViewById<View>(R.id.et_report) as EditText
        val name =
            RegisterDialog!!.findViewById<View>(R.id.et_name) as EditText
        val phone =
            RegisterDialog!!.findViewById<View>(R.id.et_phone) as EditText
        val email =
            RegisterDialog!!.findViewById<View>(R.id.et_email) as EditText
        val birthday =
            RegisterDialog!!.findViewById<View>(R.id.et_birthday) as Button
        RegisterDialog!!.show()
        birthday.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this@MainActivity,
                OnDateSetListener { view, year, month, day ->
                    var month = month
                    month = month + 1
                    val date = "$day/$month/$year"
                    birthday.text = " $date"
                }, year, month, day
            )
            datePickerDialog.show()
        }
        close.setOnClickListener { RegisterDialog!!.cancel() }
        submit.setOnClickListener { RegisterDialog!!.cancel() }
    }

    private fun Complaints_and_SuggestionsDialog() {
        Complaints_and_SuggestionsDialog = Dialog(this)
        Complaints_and_SuggestionsDialog!!.setContentView(R.layout.complaints_and_suggestions)
        Complaints_and_SuggestionsDialog!!.setCancelable(false)
        Complaints_and_SuggestionsDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val submit =
            Complaints_and_SuggestionsDialog!!.findViewById<View>(R.id.Submit) as Button
        val close =
            Complaints_and_SuggestionsDialog!!.findViewById<View>(R.id.close) as ImageView
        val report =
            Complaints_and_SuggestionsDialog!!.findViewById<View>(R.id.et_report) as EditText
        val name =
            Complaints_and_SuggestionsDialog!!.findViewById<View>(R.id.et_name) as EditText
        val phone =
            Complaints_and_SuggestionsDialog!!.findViewById<View>(R.id.et_phone) as EditText
        Complaints_and_SuggestionsDialog!!.show()
        close.setOnClickListener { Complaints_and_SuggestionsDialog!!.cancel() }
        submit.setOnClickListener { Complaints_and_SuggestionsDialog!!.cancel() }
    }

    private fun AdsDialog() {
        AdsDialog = Dialog(this)
        AdsDialog!!.setContentView(R.layout.ads)
        AdsDialog!!.setCancelable(false)
        AdsDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val close =
            AdsDialog!!.findViewById<View>(R.id.close) as ImageView
        val ads =
            AdsDialog!!.findViewById<View>(R.id.adsImage) as ImageView
        AdsDialog!!.show()
        close.setOnClickListener { AdsDialog!!.cancel() }
    }

    private fun RateDialog() {
        RateDialog = Dialog(this)
        RateDialog!!.setContentView(R.layout.complaints_and_suggestions)
        RateDialog!!.setCancelable(false)
        RateDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val submit =
            RateDialog!!.findViewById<View>(R.id.Submit) as Button
        val close =
            RateDialog!!.findViewById<View>(R.id.close) as ImageView
        val report =
            RateDialog!!.findViewById<View>(R.id.et_feedback) as EditText
        RateDialog!!.show()
        close.setOnClickListener { RateDialog!!.cancel() }
        submit.setOnClickListener { RateDialog!!.cancel() }
    }
}