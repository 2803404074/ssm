/**
 * CFR, 2018-08-18
 * 说明：servicepublic 包作用是，容纳 service 系列服务涉及到的全局变量、全局常量
 *      GlobalParams 类中容纳的是全局变量，
 *
 * */

package servicepublic;

public class GlobalParams {
    public int fbMaxGamesInOnePeriod = 100;          // 竞彩足球，每期受注场次的最大值，在采集数据时根据实际统计数调整。
                                                     // 小于原值时，不调整；大于原值时，调整为大于等于新值的整十数
    public int periodCountReturn = 3;                // 查询时，连续返回的期数

    // region 获取单实例，此方法为线程安全
    public static GlobalParams getInstance(){
        return SingletonHolder.instance;
    }


    private static class SingletonHolder{
        private static GlobalParams instance = new GlobalParams();
    }
    // endregion


}
