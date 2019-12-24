package pansong291.xposed.quickenergy.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pansong291.xposed.quickenergy.util.FriendIdMap;

public class AlipayUser extends AlipayId {
    private static List<AlipayUser> list;

    public AlipayUser(String i, String n) {
        id = i;
        name = n;
    }

    public static List<AlipayUser> getList() {
        if (list == null || FriendIdMap.shouldReload) {
            list = new ArrayList<AlipayUser>();
            Set<Map.Entry<String, String>> idSet = FriendIdMap.getIdMap().entrySet();
            for (Map.Entry entry : idSet) {
                list.add(new AlipayUser(entry.getKey().toString(), entry.getValue().toString()));
            }
        }
        return list;
    }

    public static void remove(String id) {
        getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equals(id)) {
                list.remove(i);
                break;
            }
        }
    }

}
