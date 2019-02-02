package com.artefaktur.sample.j4.em;

import javax.persistence.EntityManager;

public interface EntityManagerCallable<V>
{

  /**
   * Call for using a jpa.
   *
   * @param emgr the emgr
   * @return the v
   */
  V call(final EntityManager emgr);
}
