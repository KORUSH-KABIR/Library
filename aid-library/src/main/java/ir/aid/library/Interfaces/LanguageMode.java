package ir.aid.library.Interfaces;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import ir.aid.library.Frameworks.utils.LanguageUtils;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef(value = {LanguageUtils.ENGLISH , LanguageUtils.PERSIAN})
public @interface LanguageMode {

}
