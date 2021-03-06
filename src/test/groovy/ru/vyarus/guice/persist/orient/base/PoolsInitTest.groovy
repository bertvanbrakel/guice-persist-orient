package ru.vyarus.guice.persist.orient.base

import com.google.inject.Inject
import com.google.inject.persist.PersistService
import ru.vyarus.guice.persist.orient.support.modules.MockPoolsModule
import ru.vyarus.guice.persist.orient.support.pool.MockDocumentPool
import ru.vyarus.guice.persist.orient.support.pool.MockObjectPool
import spock.guice.UseModules
import spock.lang.Specification


/**
 * Check pools correctly init and stop by persist service
 *
 * @author Vyacheslav Rusakov 
 * @since 01.08.2014
 */
@UseModules(MockPoolsModule)
class PoolsInitTest extends Specification {

    @Inject
    PersistService persist
    @Inject
    MockDocumentPool documentPool
    @Inject
    MockObjectPool objectPool

    def "Check pools lifecycle"() {

        when: "starting db"
        persist.start()
        then: "pools initialized"
        documentPool.started
        objectPool.started

        when: "shutdown db"
        persist.stop()
        then: "pools closed"
        !documentPool.started
        !objectPool.started
    }
}