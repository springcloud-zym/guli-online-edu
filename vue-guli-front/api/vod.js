import request from '@/utils/request'

export default {
    //通过视频id获取视频凭证
    getPlayAuth(vid) {
    return request({
      url: `/eduvod/video/getPlayAuth/${vid}`,
      method: 'get'
    })
  }
}