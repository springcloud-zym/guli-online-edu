import request from '@/utils/request'

export default {
  //登陆方法
  submitLogin(userInfo) {
    return request({
      url: '/educenter/member/login',
      method: 'post',
      data: userInfo
    })
  },

  //获取用户信息
  getLoginUserInfo(){
    return request({
        url: '/educenter/member/getMemberInfo',
        method: 'get',
    })
  },

}