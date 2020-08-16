package com.atguigu.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2020/7/17-20:49
 */
@Data
public class ChapterVO {
    private String id;
    private String title;
    private List<VideoVO> children = new ArrayList<>();
}
