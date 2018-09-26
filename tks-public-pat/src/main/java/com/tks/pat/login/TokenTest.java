package com.tks.pat.login;

import com.tks.pat.common.utils.AccessToken;
import com.tks.pat.common.utils.AccessTokenTest;


public class TokenTest {
    public static void main(String[] args) {
       /* Map<String, Object> accessTokenAndJsapiTicket = Singleton.getInstance().getAccessTokenAndJsapiTicket();
        //String accessToken = AccessTokenUtil.getAccessToken();
        System.out.println(accessTokenAndJsapiTicket.get("access_token"));*/

        AccessToken accessToken = AccessTokenTest.getAccessToken();
        System.out.println(accessToken.getAccesstoken());
        System.out.print("111");
    }
}
