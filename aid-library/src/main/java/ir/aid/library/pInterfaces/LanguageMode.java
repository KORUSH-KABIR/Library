package ir.aid.library.pInterfaces;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import ir.aid.library.pFrameworks.pUtils.LanguageUtils;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef(value = {LanguageUtils.ENGLISH , LanguageUtils.PERSIAN})
public @interface LanguageMode {

}
