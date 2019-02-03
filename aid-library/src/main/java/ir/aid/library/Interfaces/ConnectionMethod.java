package ir.aid.library.Interfaces;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import ir.aid.library.Frameworks.helper.ConnectionHelper;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef(value = {ConnectionHelper.METHOD_GET , ConnectionHelper.METHOD_HEAD , ConnectionHelper.METHOD_POST})
public @interface ConnectionMethod {}
