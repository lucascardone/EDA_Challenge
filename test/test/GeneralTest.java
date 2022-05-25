
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    AITest.class,
    ActionMoveTest.class,
    ActionWallTest.class})
public class GeneralTest {}
