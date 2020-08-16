import request from '@/utils/request'

export default{

    //1.生成统计数据
    createStaDate(day){
      return request({
        url: `/staservice/statistics/registerCount/${day}`,
        method: 'post',
      })
    },

    //2.获取到统计的数据
    getDataSta(searchObj){
      return request({       
        url: `/staservice/statistics/registerCount/${searchObj.type}/${searchObj.begin}/${searchObj.end}`,
        method: 'get',
      })
    }

}