package ir.aid.library.pInterfaces;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import ir.aid.library.pFrameworks.pUtils.ToastUtils;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef(value = {ToastUtils.CIRCLE_MODE , ToastUtils.NORMAL_MODE})
public @interface ToastMode {

}
