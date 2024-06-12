package Util;

import Adventure.Character.Character;
import Adventure.Character.Hero;

import javax.xml.xpath.XPathConstants;
import java.util.Arrays;

public class Calculate {


    public static int damage(Character attacker, int defenderArmour) {
        return Math.min(0, Random.range(attacker.getDamageRange()) - defenderArmour);
    }

    public static int level(Hero hero) {
        return 0;
    }

    public static int xp(int level) {
        int[] table = XPConst.getXpTable(level);
        for (int j : table) {
            System.out.println(j);
        }
        return 0;
    }

}

class XPConst {
    protected static int diffStart = 6;
    protected static float diffFactor = 1.2f;

    static int[] xpTable = new int[0];

    protected static int[] getXpTable(int levelLimit) {
        if(xpTable.length <= levelLimit)
            return Arrays.copyOfRange(xpTable, 0, levelLimit);
        int[] table = new int[levelLimit];
        table[0] = 0;
        table[1] = diffStart;
        for (int i = 2; i < levelLimit; i++) {
            // this value = last value + last diff * factor
            table[i] = table[i-1] + Math.round((table[i-1]-table[i-2]) * diffFactor);
        }
        xpTable = table.clone();
        return table;
    }

}

