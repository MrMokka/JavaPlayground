package Util;

import Adventure.Character.Character;

import java.util.*;

public class Calculate {
  
  
  public static int damage(Character attacker, int defenderArmour) {
    return Math.max(0, Random.range(attacker.getDamageRange()) - defenderArmour);
  }
  
  public static int getLevelFromXp(int xp) {
    if (xp == 0) return 1;
    int levelCheck = 5;
    List<Integer> table = XPConst.getXpTable(levelCheck);
    while (true) {
      if (table.get(table.size() - 1) < xp) {
        levelCheck += 5;
        table = XPConst.getXpTable(levelCheck);
        continue;
      }
      for (int i = levelCheck - 5; i < table.size(); i++) {
        if (xp < table.get(i))
          return i;
      }
    }
  }
  
  public static int getRemainingXpToNextLevel(int xp) {
    int level = getLevelFromXp(xp);
    int totalLevelXp = XPConst.totalXpAtLevel(level);
    int xpAtNextLevel = XPConst.getXpAtLevel(level + 1);
    return (xpAtNextLevel - totalLevelXp) - (xp - totalLevelXp);
  }
  
  public static int xpNeededForLevel(int level) {
    return XPConst.getXpTable(level).get(level - 1);
  }
  
}

class XPConst {
  protected static int diffStart = 6;
  protected static float diffFactor = 1.2f;
  
  private static List<Integer> xpTable = new ArrayList<>(Arrays.asList(0, diffStart));
  
  protected static void printTable(List<Integer> table) {
    for (int j : table) {
      System.out.println(j);
    }
  }
  
  protected static int getXpAtLevel(int level) {
    return xpTable.get(level - 1);
  }
  
  protected static int totalXpAtLevel(int level) {
    int totalXp = 0;
    for (int xp : getXpTable(level)) {
      totalXp += xp;
    }
    return totalXp;
  }
  
  protected static List<Integer> getXpTable(int levelLimit) {
    if (xpTable.size() >= levelLimit)
      return xpTable.subList(0, levelLimit);
    return updateXpTable(levelLimit).subList(0, levelLimit);
  }
  
  private static List<Integer> updateXpTable(int newLevelLimit) {
    for (int i = xpTable.size(); i < newLevelLimit; i++) {
      // this value = (last value + last diff) * factor
      xpTable.add(xpTable.get(i - 1) + Math.round((xpTable.get(i - 1) - xpTable.get(i - 2)) * diffFactor));
    }
    printTable(xpTable);
    return xpTable;
  }
  
}

