package roger_sample_j4com.artefaktur.sample.j4.controller;

import org.junit.BeforeClass;

import de.micromata.genome.util.runtime.LocalSettingsEnv;

public class BaseTest
{
  @BeforeClass
  public static void initJndi()
  {
    LocalSettingsEnv.get();
  }
}
