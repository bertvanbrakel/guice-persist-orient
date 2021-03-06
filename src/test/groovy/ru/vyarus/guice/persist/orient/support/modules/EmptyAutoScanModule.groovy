package ru.vyarus.guice.persist.orient.support.modules

import com.google.inject.AbstractModule
import ru.vyarus.guice.persist.orient.support.Config
import ru.vyarus.guice.persist.orient.support.AutoScanSchemeOrientModule

/**
 * Module with schema init from classpath scanned objects but with wrong package configured (no objects will be found)
 * @author Vyacheslav Rusakov 
 * @since 18.07.2014
 */
class EmptyAutoScanModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new AutoScanSchemeOrientModule(Config.DB, Config.USER, Config.PASS, "wrong.package"))
    }
}
