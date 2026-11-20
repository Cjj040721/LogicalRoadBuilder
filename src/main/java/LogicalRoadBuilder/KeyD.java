package LogicalRoadBuilder;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
/**
 * the enumaration of different keys to check whether it used or not
 *
 * @author BJTU course team (public release anonymized)
 *
 */
public enum KeyD
{
    Attack(KeyEvent.VK_SPACE),
    LEFT(KeyEvent.VK_A),
    RIGHT(KeyEvent.VK_D),
    UP(KeyEvent.VK_W),
    DOWN(KeyEvent.VK_S);

    private final static Set<Integer> keySet = new HashSet<>();//press the button

    KeyD(int keyValue) {
        this.keyValue = keyValue;
    }

    private int keyValue;//the value of the key

    /**
     * whether one key is used or not
     *
     * @return
     */
    public boolean use() {
        return keySet.contains(keyValue);
    }

    /**
     * add the key into the list
     *
     * @param keyCode
     */
    public static void add(int keyCode) {
        keySet.add(keyCode);
    }

    /**
     * delete the key from the list
     *
     * @param keyCode
     */
    public static void remove(int keyCode) {
        keySet.remove(keyCode);
    }
}
