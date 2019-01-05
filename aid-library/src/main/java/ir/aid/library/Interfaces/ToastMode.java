package ir.aid.library.Interfaces;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import ir.aid.library.Frameworks.utils.ToastBuilder;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef(value = {ToastBuilder.CIRCLE_MODE , ToastBuilder.NORMAL_MODE})
public @interface ToastMode {

}
