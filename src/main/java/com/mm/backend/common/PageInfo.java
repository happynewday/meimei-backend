package com.mm.backend.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageSerializable;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName PageInfo
 * @Description TODO
 * @Date 2019/7/3 20:57
 */
public class PageInfo<T> extends PageSerializable<T> {
    //当前页
    @ApiModelProperty(value = "当前页")
    private int pageNum;
    //总页数
    @ApiModelProperty(value = "总页数")
    private int pages;

    @ApiModelProperty(value = "分页数据")
    private List<T> list;

    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageInfo(List<T> list) {
        this(list, 8);
    }

    /**
     * 包装Page对象
     *
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public PageInfo(List<T> list, int navigatePages) {
        super(list);
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();

            this.pages = page.getPages();

        } else {
            this.pageNum = 1;
        }
    }

    public static <T> com.github.pagehelper.PageInfo<T> of(List<T> list){
        return new com.github.pagehelper.PageInfo<T>(list);
    }

    public static <T> com.github.pagehelper.PageInfo<T> of(List<T> list, int navigatePages){
        return new com.github.pagehelper.PageInfo<T>(list, navigatePages);
    }




    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public List<T> getList() {
        return super.getList();
    }

    @Override
    public void setList(List<T> list) {
        this.list = list;
        super.setList(list);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
