package com.walter.pokedata.util

import android.app.Dialog
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.walter.pokedata.R

fun Dialog.makeContentFullyDisplayed() {
    setOnShowListener {
        val dialog = it as BottomSheetDialog
        val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet)
        bottomSheet?.let { sheet ->
            dialog.behavior.peekHeight = sheet.height
            sheet.parent.parent.requestLayout()
        }
    }
}

fun Dialog.expandDialogCompletely() {
    val bottomSheet: FrameLayout =
        this.findViewById(com.google.android.material.R.id.design_bottom_sheet)
    val behavior = BottomSheetBehavior.from(bottomSheet)
    behavior.state = BottomSheetBehavior.STATE_EXPANDED
    behavior.peekHeight = 0
}
