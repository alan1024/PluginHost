package com.alan.pluginhost.model.entity;

import java.util.List;

public class ShowApiPictures {
    private PageBean pagebean;
    private String ret_code;

    public static class PageBean {
        private String allNum;
        private String allPages;
        private String currentPage;
        private String maxResult;
        private List<PictureBody> contentlist;

        public String getAllNum() {
            return allNum;
        }

        public void setAllNum(String allNum) {
            this.allNum = allNum;
        }

        public String getAllPages() {
            return allPages;
        }

        public void setAllPages(String allPages) {
            this.allPages = allPages;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(String maxResult) {
            this.maxResult = maxResult;
        }

        public List<PictureBody> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<PictureBody> contentlist) {
            this.contentlist = contentlist;
        }
    }

    public PageBean getPagebean() {
        return pagebean;
    }

    public void setPagebean(PageBean pagebean) {
        this.pagebean = pagebean;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }
}
