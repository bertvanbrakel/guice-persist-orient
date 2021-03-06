package ru.vyarus.guice.persist.orient.db.pool;

import com.orientechnologies.orient.core.db.ODatabasePoolBase;
import com.orientechnologies.orient.object.db.OObjectDatabasePool;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import ru.vyarus.guice.persist.orient.db.DbType;
import ru.vyarus.guice.persist.orient.db.transaction.TransactionManager;

import javax.inject.Inject;

/**
 * Object connection pool.
 *
 * @author Vyacheslav Rusakov
 * @since 24.07.2014
 */
public class ObjectPool extends AbstractPool<OObjectDatabaseTx> {

    @Inject
    public ObjectPool(final TransactionManager transactionManager) {
        super(transactionManager);
    }


    @Override
    protected ODatabasePoolBase createPool(final String uri, final String user, final String pass) {
        return new OObjectDatabasePool(uri, user, pass);
    }

    @Override
    public DbType getType() {
        return DbType.OBJECT;
    }
}
