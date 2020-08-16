import request from '@/utils/request'

export default {
  //生成订单
  createOrders(courseId) {
    return request({
      url: '/eduorder/order/createOrder/'+courseId,
      method: 'post'
    })
  },
  //根据订单号获取订单信息
  getOrderInfo(id) {
    return request({
      url: '/eduorder/order/getOrderInfo/'+id,
      method: 'get'
    })
  },

  //生成二维码的方法
  createNative(orderNo){
    return request({
      url: '/eduorder/paylog/createNative/'+orderNo,
      method: 'get'
    })
  },

  //通过订单号查询订单状态
  queryPayStatus(orderNo){
    return request({
      url: '/eduorder/paylog/queryPayStatus/'+orderNo,
      method: 'get'
    })
  }
}