import request from '@/utils/request'

export default{
     //1 添加课程信息
     addCourseInfo(courseInfo) {
        return request({
            url: '/eduservice/course/addCourseInfo',
            method: 'post',
            data:courseInfo
          })
    },
    
    //查询所有讲师
    getListTeacher(){
        return request({
            url: `/eduservice/teacher/findAll`,
            method: 'get',
          })
    },

    //根据课程id查询课程基本信息
    getCourseInfo(id){
        return request({
            url: `/eduservice/course/getCourseInfo/${id}`,
            method: 'get',
          })
    },

    //根据课程id修改课程信息
    updateCourseInfo(courseInfo){
      return request({
          url: `/eduservice/course/updateCourseInfo`,
          method: 'post',
          data: courseInfo
        })
  },

  //课程确认信息的显示
  getPublishCourseInfo(id){
    return request({
        url: `/eduservice/course/getPublishCourseInfo/${id}`,
        method: 'get',
      })
  },

  //课程的最终发布
  publishCourse(id){
    return request({
      url: `/eduservice/course/publishCourse/${id}`,
      method: 'post',
    })
  },

  //课程列表
  getCourseList(id){
    return request({
      url: `/eduservice/course/getCourseList`,
      method: 'get',
    })
  },

}