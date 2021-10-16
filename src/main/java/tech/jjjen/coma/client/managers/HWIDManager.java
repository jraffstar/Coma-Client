package tech.jjjen.coma.client.managers;

import tech.jjjen.coma.api.util.DisplayUtil;
import tech.jjjen.coma.api.util.NoStackTraceThrowable;
import tech.jjjen.coma.api.util.SystemUtil;
import tech.jjjen.coma.api.util.URLReader;

import java.util.ArrayList;
import java.util.List;

// was lazy to delete it before putting on github just ignore this pls

public class HWIDManager {

    public static final String pastebinURL = "";

    public static List<String> hwids = new ArrayList<>();

    public static void hwidCheck() {
        hwids = URLReader.readURL();
        boolean isHwidPresent = hwids.contains(SystemUtil.getSystemInfo());
        if (!isHwidPresent) {
            DisplayUtil.Display();
            throw new NoStackTraceThrowable("");
        }
    }
}
