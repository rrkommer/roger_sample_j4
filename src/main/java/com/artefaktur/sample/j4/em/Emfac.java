package com.artefaktur.sample.j4.em;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.micromata.genome.util.runtime.LocalSettings;

public class Emfac
{
  static Emfac emfac = new Emfac();

  /**
   * The unit name.
   */
  protected String unitName = "rogmn";

  /**
   * The entity manager factory.
   */
  public EntityManagerFactory entityManagerFactory;
  /**
   * The thread emgr.
   */
  private final ThreadLocal<Em> threadEmgr = new ThreadLocal<Em>();

  public Emfac()
  {
    this.entityManagerFactory = createEntityManagerFactory(unitName);
  }

  private EntityManagerFactory createEntityManagerFactory(String unitName2)
  {
    Map<String, Object> lsMap = getInitEntityManagerFactoryProperties();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitName, lsMap);
    return emf;
  }

  public Tx tx()
  {
    return new Tx(this);
  }

  protected Em createEmgr(EntityManager entityManager, Tx emgrTx)
  {
    return new Em(entityManager, this, emgrTx);
  }

  private Map<String, Object> getInitEntityManagerFactoryProperties()
  {
    //    Map<String, Object> res = Application.applicationContext.getProperties("jpa");
    Map<String, Object> res = new HashMap<>();
    res.putAll(LocalSettings.get().getMap());
    return res;
  }

  public static Emfac getEmfac()
  {
    return emfac;
  }

  public EntityManagerFactory getEntityManagerFactory()
  {
    return entityManagerFactory;
  }

  /**
   * Gets the thread emgr.
   *
   * @return the thread emgr
   */
  public ThreadLocal<Em> getThreadEmgr()
  {
    return threadEmgr;
  }
}
