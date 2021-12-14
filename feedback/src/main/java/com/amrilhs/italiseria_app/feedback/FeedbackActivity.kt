package com.amrilhs.italiseria_app.feedback

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.amrilhs.italiseria_app.feedback.databinding.ActivityFeedbackBinding
import com.google.firebase.database.FirebaseDatabase
import com.jakewharton.rxbinding2.widget.RxTextView

class FeedbackActivity : AppCompatActivity() {
    private lateinit var feedbackBinding: ActivityFeedbackBinding


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedbackBinding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(feedbackBinding.root)
        supportActionBar?.title=resources.getString(R.string.SendFeedback)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        feedbackBinding.btSendFeedBack.isEnabled = false
        val descFeedbackStream = RxTextView.textChanges(feedbackBinding.editTextTextMultiLine)
            .skipInitialValue()
            .map { desc -> desc.length < 100 }
        descFeedbackStream.subscribe {

            showMinimalDescFeedback(it)
        }

        descFeedbackStream.subscribe { isInvalid ->
            if (isInvalid) {

                feedbackBinding.btSendFeedBack.isEnabled = false
                feedbackBinding.btSendFeedBack.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.greycolor
                    )
                )

            } else {
                feedbackBinding.btSendFeedBack.isEnabled = true
                feedbackBinding.btSendFeedBack.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primaryColor
                    )
                )
            }

        }

        feedbackBinding.btSendFeedBack.setOnClickListener {
            val ref = FirebaseDatabase.getInstance().getReference("FeedbackTable")
            val ids = ref.push().key
            val timestamp = System.currentTimeMillis()
            val feedData = feedbackBinding.editTextTextMultiLine.text.toString().trim()
            val hashMap = HashMap<String, Any?>()
            hashMap["ids"] = ids
            hashMap["timestamp"] = timestamp
            hashMap["feedData"] = feedData

            if (ids != null) {
                ref.child(ids).setValue(hashMap)
                    .addOnSuccessListener {
                        Toast.makeText(
                            applicationContext,
                            "Thanks for your feedback",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(
                            applicationContext,
                            "Failed adding to db due to ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
            }
        }

    }

    private fun showMinimalDescFeedback(isNotValid: Boolean) {
        feedbackBinding.editTextTextMultiLine.error =
            if (isNotValid) getString(R.string.maximum_feedback) else null

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}