package com.wpy.monthlyrecyclerview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2017/3/4.
 */

public class Bean implements Serializable{



    private String message;
    private int status;
    private List<RsBeanHeadline> rs;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<RsBeanHeadline> getRs() {
        return rs;
    }

    public void setRs(List<RsBeanHeadline> rs) {
        this.rs = rs;
    }

    public static class RsBeanHeadline implements Serializable{


        private boolean check;
        private String dirName;
        private int id;
        private List<ChildrenBeanHeadlineX> children;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getDirName() {
            return dirName;
        }

        public void setDirName(String dirName) {
            this.dirName = dirName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<ChildrenBeanHeadlineX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanHeadlineX> children) {
            this.children = children;
        }

        public static class ChildrenBeanHeadlineX implements Serializable{

            private String dirName;
            private int id;
            private String imgApp;
            private boolean isHeader;
            private List<ChildrenBeanHeadline> children;

            public String getDirName() {
                return dirName;
            }

            public void setDirName(String dirName) {
                this.dirName = dirName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgApp() {
                return imgApp;
            }

            public void setImgApp(String imgApp) {
                this.imgApp = imgApp;
            }

            public boolean isIsHeader() {
                return isHeader;
            }

            public void setIsHeader(boolean isHeader) {
                this.isHeader = isHeader;
            }

            public List<ChildrenBeanHeadline> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanHeadline> children) {
                this.children = children;
            }

            public static class ChildrenBeanHeadline implements Serializable{


                private String dirName;
                private int id;
                private String imgApp;
                private boolean isHeader;
                private List<?> children;

                public String getDirName() {
                    return dirName;
                }

                public void setDirName(String dirName) {
                    this.dirName = dirName;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImgApp() {
                    return imgApp;
                }

                public void setImgApp(String imgApp) {
                    this.imgApp = imgApp;
                }

                public boolean isIsHeader() {
                    return isHeader;
                }

                public void setIsHeader(boolean isHeader) {
                    this.isHeader = isHeader;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }
    }
}
