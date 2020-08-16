import request from '@/utils/request'

export default{

    //添加小节
    addVideo(video){
      return request({
        url: `/eduservice/video/addVideo/`,
        method: 'post',
        data: video
      })
    },

    //修改章节
    // updateChapter(chapter){
    //   return request({
    //     url: `/eduservice/chapter/updateChapter/`,
    //     method: 'post',
    //     data: chapter
    //   })
    // },

    //删除小节
    deleteVideo(videoId){
      return request({
        url: `/eduservice/video/${videoId}`,
        method: 'delete'
      })
    },

    //删除阿里云中的视频
    deleteAlyideo(id){
      return request({
        url: `/eduvod/video/removeAlyVideo/${id}`,
        method: 'delete'
      })
    }
    
}