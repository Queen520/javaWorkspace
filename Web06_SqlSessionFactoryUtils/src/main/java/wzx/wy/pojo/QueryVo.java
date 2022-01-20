package wzx.wy.pojo;

public class QueryVo {
    private Long currentPage;//页数
    private Integer pageSize;//每页个数
    /**
     * 查询条件
     */
    private User queryCondition;
    private Long offset;//页码

    public QueryVo() {
    }

    public QueryVo(Long currentPage, Integer pageSize, User queryCondition) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.queryCondition = queryCondition;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public User getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(User queryCondition) {
        this.queryCondition = queryCondition;
    }

    public Long getOffset() {
        return (currentPage - 1)*pageSize;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", queryCondition=" + queryCondition +
                ", offset=" + offset +
                '}';
    }
}
