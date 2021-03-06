package ru.vyarus.guice.persist.orient.support.modules

import com.google.inject.AbstractModule
import ru.vyarus.guice.persist.orient.support.Config
import ru.vyarus.guice.persist.orient.support.PackageSchemeOrientModule

/**
 * Module with schema init from package but wrong package specified (no entities will be mapped)
 * @author Vyacheslav Rusakov 
 * @since 18.07.2014
 */
class EmptyPackageModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new PackageSchemeOrientModule(Config.DB, Config.USER, Config.PASS, "wrong.package"))
    }
}
