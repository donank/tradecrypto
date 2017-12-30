package donank.tradecrypto.tradecrypto.Common

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.donank.tradecrypto.Dagger.MainApplication
import com.donank.tradecrypto.R


fun Any.showAsToast(context: Context = MainApplication.instance) {
    if (this.toString().isNotEmpty()) Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT).show()
}

fun Fragment.showFragment(container: Int, fragmentManager: FragmentManager,
                          addToBackStack: Boolean = false, animate: Boolean = true) {
    val fm = fragmentManager.beginTransaction()
    if (animate) fm.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
            R.anim.enter_from_left, R.anim.exit_to_right)
    fm.replace(container, this, this.javaClass.simpleName)
    if (addToBackStack) fm.addToBackStack(null)
    fm.commit()
}