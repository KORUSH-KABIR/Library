package ir.aid.library.pInterfaces;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import ir.aid.library.pFrameworks.pHelper.DialogHelper;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef(value = {DialogHelper.MODE_1ST , DialogHelper.MODE_2ND})
public @interface DialogMode {

}
