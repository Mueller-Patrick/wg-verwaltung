package beans;

import utilities.*;

import java.util.ArrayList;

public class SettingsBean {
    /**
     * Create a wg
     * Automatically set wgId of user to created wgId
     *
     * @param userId the ID of the user who creates a wg
     * @param nameWg the name of the wg
     * @return If created successfully
     */
    public static ErrorCodes createWg(String userId, String nameWg) {
        if (RegexHelper.checkString(nameWg)) {
            ArrayList<String> stringList = SQLDCSettings.getAccessKeyList();
            String accessKey = new RandomStringGenerator(20).nextString();
            while (stringList.contains(accessKey)) {
                accessKey = new RandomStringGenerator(20).nextString();
            }
            if (SQLDCSettings.createWg(nameWg, accessKey)) {
                String wgId = SQLDCSettings.getWgId(accessKey);
                if (!wgId.equals("")) {
                    if (SQLDCSettings.setWgId(wgId, userId) && SQLDCSettings.setUserRights(userId, UserRights.WG_ADMIN.getSqlKey())) {
                        return ErrorCodes.SUCCESS;
                    }
                    return ErrorCodes.FAILURE;
                }
            }
        }
        return ErrorCodes.WRONGENTRY;
    }

    /**
     * Get the ID of a wg via access key
     *
     * @param accessKey the access key for the wg
     * @return the wgId
     */
    public static String getWgId(String accessKey) {
        if (RegexHelper.checkString(accessKey)) {
            return SQLDCSettings.getWgId(accessKey);
        }
        return "";
    }

    /**
     * Set the ID of the wg for a user
     *
     * @param userId    the user who changes wg
     * @param accessKey the access key of the wg
     * @return If set was successful
     */
    public static ErrorCodes setWgId(String userId, String accessKey) {
        if (RegexHelper.checkString(accessKey)) {
            String wgId = SQLDCSettings.getWgId(accessKey);
            if (!wgId.equals("")) {
                return SQLDCSettings.setWgId(wgId, userId) ? ErrorCodes.SUCCESS : ErrorCodes.FAILURE;
            }
        }
        return ErrorCodes.WRONGENTRY;
    }
}
