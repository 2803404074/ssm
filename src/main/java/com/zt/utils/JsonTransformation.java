package com.zt.utils;

/**
 * 内嵌json的key的字符转义工具类
 */

public class JsonTransformation {
    private String keyName;
    //胜平负赔率key的转义
    public String changeKeyName(String key){
        switch (key){
            case "0":{keyName="loss";break;}
            case "1":{keyName="draw";break;}
            case "3":{keyName="win";break;}
        }
        return keyName;
    }

    //比分赔率key的转义
    public String bfKeyName(String key){
        switch (key){
            case "1":{keyName="1-0";break;}
            case "2":{keyName="2-0";break;}
            case "3":{keyName="2-1";break;}
            case "4":{keyName="3-0";break;}
            case "5":{keyName="3-1";break;}
            case "6":{keyName="3-2";break;}
            case "7":{keyName="4-0";break;}
            case "8":{keyName="4-1";break;}
            case "9":{keyName="4-2";break;}
            case "10":{keyName="5-0";break;}
            case "11":{keyName="5-1";break;}
            case "12":{keyName="5-2";break;}
            case "13":{keyName="W+";break;}
            case "14":{keyName="0-0";break;}
            case "15":{keyName="1-1";break;}
            case "16":{keyName="2-2";break;}
            case "17":{keyName="3-3";break;}
            case "18":{keyName="D+";break;}
            case "19":{keyName="0-1";break;}
            case "20":{keyName="0-2";break;}
            case "21":{keyName="1-2";break;}
            case "22":{keyName="0-3";break;}
            case "23":{keyName="1-3";break;}
            case "24":{keyName="2-3";break;}
            case "25":{keyName="0-4";break;}
            case "26":{keyName="1-4";break;}
            case "27":{keyName="2-4";break;}
            case "28":{keyName="0-5";break;}
            case "29":{keyName="1-5";break;}
            case "30":{keyName="2-5";break;}
            case "31":{keyName="L+";break;}
        }
        return keyName;
    }


    /**
     * 半全场赔率的key转义
     * w=胜，l=负，d=平
     * @param key
     * @return
     */
    public String fqcKeyName(String key){
        switch (key){
            case "1":{keyName="ww";break;}
            case "2":{keyName="wd";break;}
            case "3":{keyName="wl";break;}
            case "4":{keyName="dw";break;}
            case "5":{keyName="dd";break;}
            case "6":{keyName="dl";break;}
            case "7":{keyName="lw";break;}
            case "8":{keyName="wd";break;}
            case "9":{keyName="ll";break;}
        }
        return keyName;
    }

    /**
     * 进球数赔率key的转义
     * @param key
     * @return
     */
    public String jqsKeyName(String key){
        switch (key){
            case "1":{keyName="0goals";break;}
            case "2":{keyName="1goals";break;}
            case "3":{keyName="2goals";break;}
            case "4":{keyName="3goals";break;}
            case "5":{keyName="4goals";break;}
            case "6":{keyName="5goals";break;}
            case "7":{keyName="6goals";break;}
            case "8":{keyName="7+goals";break;}
        }
        return keyName;
    }

    /**
     * id转义
     */
    public String idName(String key){
        key = "MatchID";
        return keyName;
    }
/**
 * 篮球转义
 *
 */
public String bbdxfKeyName(String key){
        switch (key) {
            case "1" :{keyName="small";break;}//小分
            case "2" :{keyName="large";break;}//大分
            case "preset_score" :{keyName="expect";break;}//预期
        }
        return keyName;
    }

    /**
     *篮球胜负/让分胜负转义
     */
    public String bbsfKeyName(String key,int index){
        if(index==0) {
            switch (key) {
                case "0": {
                    keyName = "loss";
                    break;
                }//负
                case "3": {
                    keyName = "win";
                    break;
                }//胜
            }
        }
        if(index==1) {
            switch (key) {
                case "0": {
                    keyName = "loss";
                    break;
                }//负
                case "3": {
                    keyName = "win";
                    break;
                }//胜
                case "handicap": {
                    keyName = "handicap";
                    break;
                }//让分
            }
        }
        return keyName;
    }

    /**
     * 篮球胜分差转义
     * @param key
     * @return
     */
    public String bbSfcKeyName(String key){
            switch (key){
                case "1":{keyName = "h1-5";break;}
                case "2":{keyName = "h6-10";break;}
                case "3":{keyName = "h11-15";break;}
                case "4":{keyName = "h16-20";break;}
                case "5":{keyName = "h21-25";break;}
                case "6":{keyName = "h26+";break;}
                case "7":{keyName = "v1-5";break;}
                case "8":{keyName = "v6-10";break;}
                case "9":{keyName = "v11-15";break;}
                case "10":{keyName = "v16-20";break;}
                case "11":{keyName = "v21-25";break;}
                case "12":{keyName = "v26+";break;}
            }
        return keyName;
    }
    /**
     * 传统足彩胜负赔率转义
     *
     */
    public String trSfKeyName(String key){
        switch (key){
            case "a" :{
                keyName="win";
                break;
            }
            case "d" :{
                keyName="draw";
                break;
            }
            case "h" :{
                keyName="loss";
               break;
            }
            default:break;
        }
        return keyName;
    }

}
