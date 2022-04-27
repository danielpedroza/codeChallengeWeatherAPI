package fps.daniel.codechallengeweatherapi.utils

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import fps.daniel.codechallengeweatherapi.R

fun showAlert(context: Context?, view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
        .setBackgroundTint((ContextCompat.getColor(context!!, R.color.white)))
        .setTextColor((ContextCompat.getColor(context, R.color.black)))
        .show()
}