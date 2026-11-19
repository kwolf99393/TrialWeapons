package com.trialweapons.utils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> colorList(List<String> list) {
        List<String> colored = new ArrayList<>();
        for (String s : list) {
            colored.add(color(s));
        }
        return colored;
    }

    public static boolean isCustomItem(ItemStack item, String id) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasLore()) return false;
        List<String> lore = meta.getLore();
        if (lore == null || lore.isEmpty()) return false;
        String last = ChatColor.stripColor(lore.get(lore.size() - 1));
        return last.equalsIgnoreCase("ID:" + id);
    }

    public static String getCustomId(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return null;
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasLore()) return null;
        List<String> lore = meta.getLore();
        if (lore == null || lore.isEmpty()) return null;
        String last = ChatColor.stripColor(lore.get(lore.size() - 1));
        if (last.startsWith("ID:")) {
            return last.substring(3);
        }
        return null;
    }

    public static int getEnchantLevel(ItemStack item, String enchantName) {
        if (item == null || !item.hasItemMeta()) return 0;
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasLore()) return 0;
        for (String line : meta.getLore()) {
            String stripped = ChatColor.stripColor(line).toLowerCase();
            if (stripped.startsWith(enchantName.toLowerCase() + " ")) {
                String[] parts = stripped.split(" ");
                if (parts.length >= 2) {
                    try {
                        return romanToInt(parts[1]);
                    } catch (Exception ignored) {}
                }
            }
        }
        return 0;
    }

    private static int romanToInt(String roman) {
        switch (roman.toUpperCase()) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            default: return 0;
        }
    }

    public static String toRoman(int num) {
        switch (num) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            default: return String.valueOf(num);
        }
    }
}
